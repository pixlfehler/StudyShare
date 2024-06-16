package com.pixldev.studyshare;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;

public class UploadDialogFragment extends DialogFragment {

    private static final int FILE_SELECT_CODE = 101;
    private Uri fileUri;

    private ActivityResultLauncher<String> requestPermissionLauncher;
    private ActivityResultLauncher<Intent> filePickerLauncher;

    private static final String TAG = "UploadDialogFragment";

    private TextView selectedFileNameTextView;

    MaterialButton uploadButton;

    Button dismissButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_document_dialog, container, false);

        selectedFileNameTextView = view.findViewById(R.id.selectedFileName);

        uploadButton = view.findViewById(R.id.uploadButton);

        dismissButton=view.findViewById(R.id.dismissButton);

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Upload button clicked");
                if (checkPermission()) {
                    Log.d(TAG, "Permission already granted");
                    showFileChooser();
                } else {
                    Log.d(TAG, "Requesting permission");
                    requestPermission();
                }
            }
        });

        initializeActivityResultLaunchers();

        return view;
    }

    private void initializeActivityResultLaunchers() {
        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean isGranted) {
                Log.d(TAG, "Permission result: " + isGranted);
                if (isGranted) {
                    showFileChooser();
                } else {
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                fileUri = result.getData().getData();
                if (fileUri != null) {
                    String fileName = getFileName(fileUri);
                    uploadButton.setText(fileName);
                    Log.d(TAG, "Selected File Uri: " + fileUri.toString());
                }
            }
        });
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            int result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_MEDIA_IMAGES);
            return result == PackageManager.PERMISSION_GRANTED;
        } else {
            int result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            filePickerLauncher.launch(Intent.createChooser(intent, "Select a PDF"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "Please install a File Manager.", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "File picker activity not found: " + ex.getMessage());
        }
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            ContentResolver contentResolver = getContext().getContentResolver();
            try (Cursor cursor = contentResolver.query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if (nameIndex != -1) {
                        result = cursor.getString(nameIndex);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Error retrieving file name: " + e.getMessage());
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}
