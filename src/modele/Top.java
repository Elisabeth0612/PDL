package modele;

import java.util.Date;



public class Top {
	private int numTour;
        private String typeTop;
        private Voiture voiture;
        //private Course course;
        private Pilote pilote;
        private int relai;
        private Date heure;
        private String commentaire;
        private long temps;
        
        public Top(int tour,String type, Voiture v, Pilote p,int relai,Date h,String comment, long temps){
            this.commentaire=comment;
            this.heure=h;
            this.numTour=tour;
            this.relai=relai;
            this.pilote=p;
            this.typeTop=type;
            this.voiture=v;
            this.temps=temps;
        }
               
}
