package com.pixldev.studyshare.ui;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.pixldev.studyshare.KommentarAdapter;
import com.pixldev.studyshare.KommentarModel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;

public class detailFragment extends Fragment {

    private String web_url = "https://www.bundesamtsozialesicherung.de/fileadmin/media/test__pdfs/Test_PDF.pdf"; // Beispiel URL für den Download
    private static final String TAG = "detailFragment"; // Tag für Log-Nachrichten

    public ArrayList<KommentarModel> commentArrayList; // Liste der Kommentare

    public detailFragment() {
        // Erforderlicher leerer öffentlicher Konstruktor
    }

    // Aktivitäts-Result-Launcher zur Verwaltung der Berechtigungsanfrage
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Log.d(TAG, "Permission granted, starting download"); // Berechtigung erteilt
                    startDownloading(); // Download starten
                } else {
                    Log.d(TAG, "Permission denied"); // Berechtigung verweigert
                    Toast.makeText(getContext(), "Permission denied.....", Toast.LENGTH_SHORT).show(); // Benutzer benachrichtigen
                }
            });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Referenzen zu den UI-Elementen
        Button commentButton = view.findViewById(R.id.commentButton);
        Button kauf_downloadbutton = view.findViewById(R.id.buyButton);

        // Initialisierung der Kommentarliste
        commentArrayList = new ArrayList<>();

        // TextView-Elemente für Dokumentdetails
        TextView docTitle = view.findViewById(R.id.DocumentTitle);
        TextView docFach = view.findViewById(R.id.Fach);
        TextView docTyp = view.findViewById(R.id.Typ);
        TextView docStufe = view.findViewById(R.id.Stufe);

        // ImageView für das Dokument-Thumbnail
        ImageView thumbnailIV = view.findViewById(R.id.thumbnailIV);

        // Überprüfen, ob Argumente an das Fragment übergeben wurden
        if (getArguments() != null) {
            Bundle args = getArguments(); // Argumente abrufen
            boolean inbesitz = args.getBoolean("inbesitz"); // Besitzstatus des Dokuments

            // Setzen der Dokumentdetails in die TextViews
            docTitle.setText(getArguments().getString("title"));
            docFach.setText(getArguments().getString("fach"));
            docTyp.setText(getArguments().getString("typ"));
            docStufe.setText(getArguments().getString("stufe"));
            thumbnailIV.setImageResource(getArguments().getInt("image"));

            // Kommentare abrufen
            commentArrayList = getArguments().getParcelableArrayList("comments");

            // Button-Text je nach Besitzstatus ändern
            if (inbesitz) {
                kauf_downloadbutton.setText("Jetzt Herunterladen");
            } else {
                kauf_downloadbutton.setText("Kaufen für" + "Wert Preis");
            }

            // OnClickListener für den Kauf-/Download-Button
            kauf_downloadbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inbesitz) {
                        Log.d(TAG, "Download button clicked");
                        // Überprüfen der Berechtigungen
                        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                            Log.d(TAG, "Requesting permissions");
                            // Überprüfen der Android-Version
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                                if (!Environment.isExternalStorageManager()) {
                                    // Öffnen der Einstellungen zur Verwaltung aller Dateien
                                    Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                                    startActivity(intent);
                                } else {
                                    startDownloading(); // Download starten
                                }
                            } else {
                                // Berechtigungsanfrage starten
                                requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                            }
                        } else {
                            Log.d(TAG, "Permissions already granted, starting download");
                            startDownloading(); // Download starten
                        }
                    }
                }
            });
        }

        // OnClickListener für den Kommentar-Button
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BottomSheetDialog für Kommentare anzeigen
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.comment_bottom_sheet, null);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();

                // RecyclerView für Kommentare
                RecyclerView commentRV = view1.findViewById(R.id.commentRV);

                // Beispiel-Kommentare hinzufügen
                commentArrayList.add(new KommentarModel("pixlfehler", "Was ist das denn für ein Müll! Was ist das denn für ein Müll! Was ist das denn für ein Müll! Was ist das denn für ein Müll!", 1));
                commentArrayList.add(new KommentarModel("jappez", "Super!", 4));
                commentArrayList.add(new KommentarModel("AnonymerNutzer123", "yoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyo"));
                commentArrayList.add(new KommentarModel("Bot77", "Ich mags!", 5));
                commentArrayList.add(new KommentarModel("Boris Meltzow", "Diese Kommentare sind ja so cool!👁️👁️", 4));

                // Adapter für Kommentare
                KommentarAdapter commentAdapter = new KommentarAdapter(getContext(), commentArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                // LayoutManager und Adapter für RecyclerView setzen
                commentRV.setLayoutManager(linearLayoutManager);
                commentRV.setAdapter(commentAdapter);
            }
        });

        return view; // Rückgabe des View
    }

    // Methode zum Starten des Downloads
    private void startDownloading() {
        String url = web_url; // URL des Downloads

        // Konfiguration der Download-Anfrage
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Downloading file.....");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Test_PDF.pdf");

        // DownloadManager für den Download verwenden
        DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        if (manager != null) {
            Log.d(TAG, "Enqueue download request");
            manager.enqueue(request); // Download-Anfrage in die Warteschlange stellen
        } else {
            Log.e(TAG, "Download manager is null"); // Fehler, falls DownloadManager null ist
        }
    }
}
