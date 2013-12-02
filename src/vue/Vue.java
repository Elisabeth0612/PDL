/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import vue_defaut.ChronoCourse;
import controleur.Controleur;
import java.util.Observable;
import java.util.Observer;
import modele.*;


/**
 *
 * @author Co
 */
public class Vue implements Observer {
    //listing de toutes les fenetres
    private CreerChargerEvt cce;
    private NouvelEvt newEvt;
    private ChargerEvtBis chargE;
    private EvenementBis evt;
    //private ChronoCourseBis chrono;
    
    private AjouterEnleverPiloteBis aePilote;
    private CreerModifierVoitureBis cmVoiture;
    private AjouterEnleverVoitureBis aeVoiture;
    private CreerModifierPiloteBis cmPilote;
    
    //private CreerModifierCourse cmCourse;
    
    //autres variables
    private Controleur control;
    
    //variable pour revenir aux fenetres precedentes
    private MaFenetre precedente;
    private MaFenetre courante;
    private MaFenetre optionnelle;
    
    private ChronometreCourseBis chrono;
    
    public Vue(Controleur c){
        control = c;
        //evtS = new EvenementSportif();
        cce = new CreerChargerEvt(control);
        newEvt = new NouvelEvt(control,cce);
        chargE = new ChargerEvtBis(control,cce);
        evt = new EvenementBis(control);
        evt.dispose();
        //chrono = new ChronoCourseBis(control);
       
        
        aePilote = new AjouterEnleverPiloteBis(control);
        cmVoiture = new CreerModifierVoitureBis(control);
        aeVoiture = new AjouterEnleverVoitureBis(control);
        cmPilote = new CreerModifierPiloteBis(control);
        
        //cmCourse=new CreerModifierCourse(control,evt,null);
        
        precedente = cce;
        courante = cce;
        
        
        
    }
    
    
    public void precedent(){
        courante.fermer();
        courante=precedente;
        System.out.println("objet dans courante = "+(Object)courante.getClass().toString());
        //courante.afficher();
        if(courante.getPrecedent()!=null){
            precedente = courante.getPrecedent();
        }
        courante.afficher();
    }
    
    public void ouvrirNouvelEvt(){
        precedente = courante;
        precedente.fermer();
        courante = newEvt;
        courante.afficher();
    }
    
    public void ouvrirEvenement(){
        evt = new EvenementBis(control);
        courante.fermer();
        precedente = cce; //creer charger evenement
        courante = evt; // choix
        courante.raffraichir();
        courante.afficher();
        
    }
    
    public void ouvrirChrono(){
        chrono = new ChronometreCourseBis(control);
        //chrono = new ChronoCourseBis(control);
        courante.masquer();
        precedente = evt; //creer charger evenement
        courante = chrono; // choix
        courante.afficher();
        optionnelle = new TableurChronoBis(control);
        optionnelle.afficher();
    }
    
    public void ajouterLigneTableurCourse(String[] ligneTable){//la taille est de 8
        String temps = ((ChronometreCourseBis)courante).getTemps();
        ligneTable[3] = temps;
        //optionnelle.ajouterLigne();
    }
    
    public void ouvrirAjouterEnleverPilote(){
        courante.masquer();
        precedente = cmVoiture;
        courante = aePilote;
        courante.afficher();
    }
    
    public void ouvrirAjouterEnleverVoiture(){
        courante.masquer();
        precedente = evt;
        courante = aeVoiture;
        courante.afficher();
    }
    //Pb ici !!! il faut jouer avec le Observer/observable il me semble vu que le modele est mis à jour, la fenetre devrait être notifée du changement
    public void ouvrirCreerModifierVoiture(Voiture v){
            System.out.println(v.toString());
        courante.masquer();
        precedente = evt;
        courante = cmVoiture;
        courante.afficher();
        if(v != null){
            cmVoiture.miseAJour(v);
        }
    }
    
    public void ouvrirCreerModifierPilote(){
        courante.masquer();
        precedente = cmVoiture;
        courante = cmPilote;
        courante.afficher();
    }
    
    public void lancer(){
        courante.afficher();
    }
    
    public void ouvrirCreerModifierCourse(Course c){
        courante.masquer();
        precedente=evt;
       // courante=cmCourse;
        courante.afficher();
        //cmCourse.setcModifier(c);
    }

    @Override
    public void update(Observable o, Object arg) {
        //System.out.println("On update");
        courante.raffraichir();
        //courante.afficher();
    }

    public void ouvrirChargerEvenement() {
        precedente = courante;
        precedente.fermer();
        chargE = new ChargerEvtBis(control,cce);
        courante = chargE;
        courante.afficher();
        
    }
    
}
