package com.pixldev.studyshare;

import java.util.ArrayList;

public class Dokumentmodel {
        private String dokument_name;
        private String dokument_fach;

        private String dokument_typ;
        private String dokument_klasse;

        private String dokumentBeschreibung;
        private int dokument_thumbnail;

        private boolean inbesitz = false;

        public ArrayList<KommentarModel> comments= new ArrayList<KommentarModel>();

        // Constructor
        public Dokumentmodel(String dokument_name, String dokument_fach, String dokument_typ, String dokument_klasse, int dokument_thumbnail,boolean inbesitz) {
            this.dokument_name = dokument_name;
            this.dokument_fach = dokument_fach;
            this.dokument_typ = dokument_typ;
            this.dokument_klasse = dokument_klasse;
            this.dokument_thumbnail = dokument_thumbnail;
            this.inbesitz = inbesitz;

            addComments();
        }

        // Getter and Setter
        public String getdokument_name() {
            return dokument_name;
        }

        public void setdokument_name(String course_name) {
            this.dokument_name = course_name;
        }

        public String getdokument_fach() {
            return dokument_fach;
        }

        public void setdokument_fach(String dokument_fach) {
            this.dokument_fach = dokument_fach;
        }

        public int getdokument_image() {
            return dokument_thumbnail;
        }

        public void setdokument_image(int dokument_thumbnail) {
            this.dokument_thumbnail = dokument_thumbnail;
        }


        public void addComments(){
            comments.add(new KommentarModel("Benutzer123", "Das Produkt ist großartig und hat meine Erwartungen übertroffen.", 5));
            comments.add(new KommentarModel("AnnaM", "Guter Kundenservice, aber das Produkt ist durchschnittlich.", 3));
            comments.add(new KommentarModel("MaxPower", "Sehr enttäuscht, die Qualität ist schlecht.", 1));
            comments.add(new KommentarModel("Sarah89", "Solides Produkt, würde es wieder kaufen.", 4));
            comments.add(new KommentarModel("Tommy76", "Preis-Leistungs-Verhältnis stimmt, bin zufrieden.", 4));
            comments.add(new KommentarModel("LenaLoves", "Nicht schlecht, aber auch nicht herausragend.", 3));
            comments.add(new KommentarModel("JonasS", "Schnelle Lieferung und gute Qualität.", 5));
            comments.add(new KommentarModel("ClaudiaB", "Produkt kam beschädigt an, musste es zurückschicken.", 2));
            comments.add(new KommentarModel("Mike92", "Alles wie beschrieben, bin zufrieden.", 4));
            comments.add(new KommentarModel("EllaZ", "Top-Produkt, kann ich nur weiterempfehlen.", 5));
        }

        public ArrayList<KommentarModel> getComments(){
            return comments;
        }

    public String getDokument_typ() {
        return dokument_typ;
    }

    public void setDokument_typ(String dokument_typ) {
        this.dokument_typ = dokument_typ;
    }

    public String getDokument_klasse() {
        return dokument_klasse;
    }

    public void setDokument_klasse(String dokument_klasse) {
        this.dokument_klasse = dokument_klasse;
    }

    public boolean getinbesitz(){return inbesitz;}

    public void setinbesitz(boolean inbesitz){inbesitz=this.inbesitz;}
}

