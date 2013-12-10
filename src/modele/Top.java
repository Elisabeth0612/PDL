package modele;

import java.util.Date;



/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
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

    public Voiture getVoiture() {
        return this.voiture;
    }

    public long getTemps() {
        return this.temps;
    }

    /**
     * @return the numTour
     */
    public int getNumTour() {
        return numTour;
    }

    /**
     * @param numTour the numTour to set
     */
    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    /**
     * @return the typeTop
     */
    public String getTypeTop() {
        return typeTop;
    }

    /**
     * @param typeTop the typeTop to set
     */
    public void setTypeTop(String typeTop) {
        this.typeTop = typeTop;
    }

    /**
     * @param voiture the voiture to set
     */
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    /**
     * @return the pilote
     */
    public Pilote getPilote() {
        return pilote;
    }

    /**
     * @param pilote the pilote to set
     */
    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    /**
     * @return the relai
     */
    public int getRelai() {
        return relai;
    }

    /**
     * @param relai the relai to set
     */
    public void setRelai(int relai) {
        this.relai = relai;
    }

    /**
     * @return the heure
     */
    public Date getHeure() {
        return heure;
    }

    /**
     * @param heure the heure to set
     */
    public void setHeure(Date heure) {
        this.heure = heure;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * @param temps the temps to set
     */
    public void setTemps(long temps) {
        this.temps = temps;
    }
}

