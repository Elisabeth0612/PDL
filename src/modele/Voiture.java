package modele;

import java.util.*;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Voiture {

    private List<Pilote> listP;
    private int numVoiture;
    private Pilote piloteActuel;
    private String couleur;
    private int nbToursParRelai; //nb de tours avant changement de pilote
    private boolean voitureActive;

    /**
     * Instanciation d'une voiture
     *
     * @param numVoiture int
     * @param piloteActuel Pilote
     * @param couleur String
     * @param nbToursParRelai int
     * @param voitureActive boolean
     */
    public Voiture(int numVoiture, Pilote piloteActuel, String couleur, int nbToursParRelai, boolean voitureActive) {
        this.numVoiture = numVoiture;
        this.piloteActuel = piloteActuel;
        this.listP = new ArrayList<Pilote>();
        this.couleur = couleur;
        this.nbToursParRelai = nbToursParRelai;
        this.voitureActive = voitureActive;
    }

    /**
     * Deuième possibilité d'instanciation le Pilote Actuel
     *
     * @param numVoiture int
     * @param couleur String
     * @param nbToursParRelai int
     * @param voitureActive boolean
     */
    public Voiture(int numVoiture, String couleur, int nbToursParRelai, boolean voitureActive) {
        this.numVoiture = numVoiture;
        this.listP = new ArrayList<Pilote>();
        this.couleur = couleur;
        this.nbToursParRelai = nbToursParRelai;
        this.voitureActive = voitureActive;
    }

    /**
     * Méthode permettant de modifier rapidement les paramètres d'une Voiture
     *
     * @param piloteActuel Pilote
     * @param couleur String
     * @param nbToursParRelai int
     * @param voitureActive boolean
     */
    public void modifierVoiture(Pilote piloteActuel, String couleur, int nbToursParRelai, boolean voitureActive) {
        setPiloteActuel(piloteActuel);
        setCouleur(couleur);
        setNbToursParRelai(nbToursParRelai);
        setVoitureActive(voitureActive);
    }

    /**
     * Méthode permettant l'ajout d'un Pilote à la liste des Pilotes de la
     * Voiture
     *
     * @param p Pilote
     */
    public void addListP(Pilote p) {
        if (!listP.contains(p)) {
            listP.add(p);
        }
    }

    /**
     * Méthode permettant d'enlever un Pilote à la liste des Pilotes de la Voiture
     *
     * @param p Pilote
     */
    public void removeListP(Pilote p) {
        listP.remove(p);
    }

    /**
     * Méthode permettant d'écraser cette voiture d'une liste passé en paramère
     * @param listV Liste de Voiture
     */
    public void removeVoiture(List<Voiture> listV) {
        listV.remove(this);
    }

    /**
     * Méthode permettant de retourner le numéro de la Voiture
     * @return int - numero de la Voiture
     */
    public int getNumVoiture() {
        return numVoiture;
    }

    /**
     * Méthode permettant de modifier le numéro de la Voiture
     * @param numVoiture int
     */
    public void setNumVoiture(int numVoiture) {
        this.numVoiture = numVoiture;
    }

    /**
     *  Méthode permettant de retourner le Pilote Actuel de la voiture
     * @return Pilote - le Pilote Actuel
     */
    public Pilote getPiloteActuel() {
        return piloteActuel;
    }

    /**
     * Méthode permettant de modifier le Pilote Actuel de la voiture
     * @param piloteActuel Pilote
     */
    public void setPiloteActuel(Pilote piloteActuel) {
        this.piloteActuel = piloteActuel;
    }

    /**
     * Méthode permettant de retourner la couleur de la voiture
     * @return String - couleur de la voiture
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Méthode permettant de modifier la couleur de la voiture
     * @param couleur String
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Méthode permettant de retourner le nombre de Tours par relai de la voiture
     * @return int - NbToursParRelai
     */
    public int getNbToursParRelai() {
        return nbToursParRelai;
    }

    /**
     * Méthode permettant de modifier le nombre de Tours par relai de la voiture
     * @param nbToursParRelai
     */
    public void setNbToursParRelai(int nbToursParRelai) {
        this.nbToursParRelai = nbToursParRelai;
    }

    /**
     * Méthode permettant de retourner si la voiture est active pour la course de la voiture
     * @return boolean - voitureActive
     */
    public boolean getVoitureActive() {
        return voitureActive;
    }

    /**
     * Méthode permettant de modifier si la voiture est active pour la course de la voiture
     * @param voitureActive boolean
     */
    public void setVoitureActive(boolean voitureActive) {
        this.voitureActive = voitureActive;
    }

    /**
     * Méthode permettant de retourner la liste des Pilotes de la voiture
     * @return liste de Pilote
     */
    public List<Pilote> getListP() {
        return listP;
    }

    /**
     * Méthode permettant de remplir une nouvelle liste des Pilotes de la voiture avec une liste passée en paramètre
     * @param lesPTemp liste de Pilote
     */
    public void setListP(List<Pilote> lesPTemp) {
        listP = new ArrayList<Pilote>();
        for (Pilote p : lesPTemp) {
            listP.add(new Pilote(p.getNom(), p.getPrenom(), p.getCouleursCasque()));
        }
    }

    /**
     * Méthode permettant de savoir si la Liste des Pilotes est vide ou non
     * @return boolean
     */
    public boolean existListP() {
        return listP.size() != 0;
    }

    /**
     * Méthode permettant de trouver rapidement un pilote de la liste
     * 
     * @param nom String
     * @param prenom String
     * @return Pilote
     */
    public Pilote trouverUnPilote(String nom, String prenom) {
        for (Pilote p : listP) {
            if (p.getNom().compareTo(nom) == 0 && p.getPrenom().compareTo(prenom) == 0) {
                return p;
            }
        }
        return null;
    }
}
