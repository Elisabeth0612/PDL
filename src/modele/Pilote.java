package modele;

import java.util.List;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Pilote {

    private String nom, prenom, couleursCasque;

    /**
     * Instanciation de Pilote
     * 
     * @param nom
     * @param prenom
     * @param couleursCasque
     */
    public Pilote(String nom, String prenom, String couleursCasque) {
        this.nom = nom;
        this.prenom = prenom;
        this.couleursCasque = couleursCasque;
    }

    /**
     * Méthode permettant de supprimer le pilote actuel d'une liste passée en paramètre
     * @param listP Liste de Pilote
     */
    public void removePilote(List<Pilote> listP) {
        listP.remove(this);
    }

    /**
     * Méthode permettant de récupérer le nom du pilote
     * @return String - nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de modifier le nom du pilote
     * @param nom String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant de récupérer le prénom du pilote
     * @return String - prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode permettant de modifier le prénom du pilote
     * @param prenom String
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode permettant de récupérer la couleur du casque du pilote
     * @return String - couleur du casque
     */
    public String getCouleursCasque() {
        return couleursCasque;
    }

    /**
     * Méthode permettant de modifier la couleur du casque du pilote
     * @param couleursCasque String
     */
    public void setCouleursCasque(String couleursCasque) {
        this.couleursCasque = couleursCasque;
    }
}
