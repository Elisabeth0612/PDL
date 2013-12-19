package modele;

import java.util.*;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class EvenementSportif extends Observable {

    private List<Course> listC;
    private List<Voiture> listV;
    private String nomEvt;
    private Date dateEvt;
    private String nomCircuit;
    private int longueurCircuit;

    //liste des observeurs
    private ArrayList<Observer> lesObserveurs = new ArrayList<Observer>();

    /**
     * Instanciation sans paramètre
     */
    public EvenementSportif() {
        listC = new ArrayList<Course>();
        listV = new ArrayList<Voiture>();
        nomEvt = "";
        dateEvt = null;
        nomCircuit = "";
        longueurCircuit = 0;
    }

    /**
     * Instanciation avec paramètre
     * @param nomEvt String
     * @param dateEvt Date
     * @param nomCircuit String
     * @param longueurCircuit int
     */
    public EvenementSportif(String nomEvt, Date dateEvt, String nomCircuit, int longueurCircuit) {
        this.listC = new ArrayList<Course>();
        this.listV = new ArrayList<Voiture>();
        this.nomEvt = nomEvt;
        this.dateEvt = dateEvt;
        this.nomCircuit = nomCircuit;
        this.longueurCircuit = longueurCircuit;
    }

    /**
     * Méthode pour changer les paramètres d'évènement
     * @param nomEvt String
     * @param dateEvt Date
     * @param nomCircuit String
     * @param longueurCircuit int
     */
    public void modifierEvenement(String nomEvt, Date dateEvt, String nomCircuit, int longueurCircuit) {
        setNomEvt(nomEvt);
        setDateEvt(dateEvt);
        setNomCircuit(nomCircuit);
        setLongueurCircuit(longueurCircuit);
        notifyObserver();
    }

    /**
     * Méthode ajoutant une course à la liste des Courses de l'évènement
     * @param c Course
     */
    public void addListC(Course c) {
        if (!listC.contains(c)) {
            this.listC.add(c);
        }
    }

    /**
     * Méthode suprimant la course à la liste des Courses de l'évènement
     * @param c Course
     */
    public void remove(Course c) {
        this.listC.remove(c);
    }

    /**
     * Méthode ajoutant une voiture à la liste des Voitures de l'évènement
     * @param v Voiture
     */
    public void addListV(Voiture v) {
        if (!listV.contains(v)) {
            this.listV.add(v);
        }
    }

    /**
     * Méthode supprimant une voiture à la liste des Voitures de l'évènement
     * @param v
     */
    public void remove(Voiture v) {
        this.listV.remove(v);
    }

    /**
     * Retourne le nom de l'évènement
     * @return String - le nom de l'évènement
     */
    public String getNomEvt() {
        return nomEvt;
    }

    /**
     * Méthode qui change le nom de l'évènement
     * @param nomEvt String
     */
    public void setNomEvt(String nomEvt) {
        this.nomEvt = nomEvt;
    }

    /**
     * Retourne la date de l'évènement
     * @return Date - date de l'évènement
     */
    public Date getDateEvt() {
        return dateEvt;
    }

    /**
     * Méthode qui change la date de l'évènement
     * @param dateEvt Date
     */
    public void setDateEvt(Date dateEvt) {
        this.dateEvt = dateEvt;
    }

    /**
     * Retourne le nom du circuit
     * @return String - nom du circuit
     */
    public String getNomCircuit() {
        return nomCircuit;
    }

    /**
     * Méthode qui change le nom du circuit
     * @param nomCircuit String
     */
    public void setNomCircuit(String nomCircuit) {
        this.nomCircuit = nomCircuit;
    }

    /**
     * Retourne la longueur du circuit
     * @return int - longueur du circuit
     */
    public int getLongueurCircuit() {
        return longueurCircuit;
    }

    /**
     * Méthode qui change la longueur du circuit
     * @param longueurCircuit int
     */
    public void setLongueurCircuit(int longueurCircuit) {
        this.longueurCircuit = longueurCircuit;
    }

    /**
     * Retourne la liste des Courses de l'évènement
     * @return la liste des Courses
     */
    public List<Course> getListC() {
        return listC;
    }

    /**
     * Retourne la liste des Voitures de l'évènement
     * @return la liste des Voitures
     */
    public List<Voiture> getListV() {
        return listV;
    }
    
    /**
     * Méthode qui change la liste des Voitures en évitant les problèmes de référence
     * @param lesVTemp Liste de Voitures
     */
    public void setListV(List<Voiture> lesVTemp){
        listV = new ArrayList<Voiture>();
        for(Voiture vtemp:lesVTemp){
            Voiture v = new Voiture(vtemp.getNumVoiture(),vtemp.getPiloteActuel(),vtemp.getCouleur(),vtemp.getNbToursParRelai(),vtemp.getVoitureActive());
            v.setListP(vtemp.getListP());
            listV.add(v);
        }
        
    }
    
    /**
     * Méthode qui retourne une Course à partir de son nom
     * @param nomC String
     * @return Course
     */
    public Course chercherCourse(String nomC){
        for(Course c : listC){
            if(c.getNomCourse()==nomC){
                return c;
            }
        }
        return null;
    }
    
    /**
     * Méthode qui retourne une Voiture à partir de son numéro
     * @param numVoiture int
     * @return Voiture
     */
    public Voiture chercherVoiture(int numVoiture){
        for(Voiture v : listV){
            if(v.getNumVoiture()==numVoiture){
                return v;
            }
        }
        return null;
    }
    
    /**
     * Méthode qui supprime une voiture de la liste des Voitures de l'évènement
     * @param numVoiture int
     * @return boolean - vrai si la voiture a été supprimé
     */
    public boolean supprimerVoiture(int numVoiture){
        for(Voiture v : listV){
            if(v.getNumVoiture()==numVoiture){
                listV.remove(v);
                return true;
            }
        }
        return false;
    }

    //Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.lesObserveurs.add(obs);
    }

    public void notifyObserver() {
        for (Observer obs : lesObserveurs) {
            obs.update(this,this);
        }
    }

    public void removeObserver() {
        lesObserveurs = new ArrayList<Observer>();
    }

}
