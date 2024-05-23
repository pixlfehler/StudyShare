package com.pixldev.studyshare;

public class Dokumentmodel {
        private String dokument_name;
        private String dokument_fach;
        private int course_image;

        // Constructor
        public void CourseModel(String dokument_name, String dokument_fach, int course_image) {
            this.dokument_name = dokument_name;
            this.dokument_fach = dokument_fach;
            this.course_image = course_image;
        }

        // Getter and Setter
        public String getdokument_name() {
            return dokument_name;
        }

        public void setCourse_name(String course_name) {
            this.dokument_name = course_name;
        }

        public String getCourse_rating() {
            return dokument_fach;
        }

        public void setCourse_rating(String dokument_fach) {
            this.dokument_fach = dokument_fach;
        }

        public int getCourse_image() {
            return course_image;
        }

        public void setCourse_image(int course_image) {
            this.course_image = course_image;
        }
    }

