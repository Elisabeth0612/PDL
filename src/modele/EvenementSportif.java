package modele;

import java.util.*;

public class EvenementSportif extends Observable {

    private List<Course> listC;
    private List<Voiture> listV;
    private String nomEvt;
    private Date dateEvt;
    private String nomCircuit;
    private int longueurCircuit;

    //liste des observeurs
    private ArrayList<Observer> lesObserveurs = new ArrayList<Observer>();

    public EvenementSportif() {
        listC = new ArrayList<Course>();
        listV = new ArrayList<Voiture>();
        nomEvt = "";
        dateEvt = null;
        nomCircuit = "";
        longueurCircuit = 0;
    }

    public EvenementSportif(String nomEvt, Date dateEvt, String nomCircuit, int longueurCircuit) {
        this.listC = new ArrayList<Course>();
        this.listV = new ArrayList<Voiture>();
        this.nomEvt = nomEvt;
        this.dateEvt = dateEvt;
        this.nomCircuit = nomCircuit;
        this.longueurCircuit = longueurCircuit;
    }

    public void modifierEvenement(String nomEvt, Date dateEvt, String nomCircuit, int longueurCircuit) {
        setNomEvt(nomEvt);
        setDateEvt(dateEvt);
        setNomCircuit(nomCircuit);
        setLongueurCircuit(longueurCircuit);
        System.out.println("evt = "+this.nomEvt);
        notifyObserver();
    }

    public void addListC(Course c) {
        if (!listC.contains(c)) {
            this.listC.add(c);
        }
    }

    public void remove(Course c) {
        this.listC.remove(c);
    }

    public void addListV(Voiture v) {
        if (!listV.contains(v)) {
            this.listV.add(v);
        }
    }

    public void remove(Voiture v) {
        this.listV.remove(v);
    }

    public String getNomEvt() {
        return nomEvt;
    }

    public void setNomEvt(String nomEvt) {
        this.nomEvt = nomEvt;
    }

    public Date getDateEvt() {
        return dateEvt;
    }

    public void setDateEvt(Date dateEvt) {
        this.dateEvt = dateEvt;
    }

    public String getNomCircuit() {
        return nomCircuit;
    }

    public void setNomCircuit(String nomCircuit) {
        this.nomCircuit = nomCircuit;
    }

    public int getLongueurCircuit() {
        return longueurCircuit;
    }

    public void setLongueurCircuit(int longueurCircuit) {
        this.longueurCircuit = longueurCircuit;
    }

    public List<Course> getListC() {
        return listC;
    }

    public List<Voiture> getListV() {
        return listV;
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
