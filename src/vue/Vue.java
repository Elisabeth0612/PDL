/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.Controleur;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import modele.*;


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Vue implements Observer {
    //listing de toutes les fenetres
    private CreerChargerEvt cce;
    private NouvelEvt newEvt;
    private ChargerEvtBis chargE;
    private EvenementBis evt;
    //private ChronoCourseBis chrono;
    
    private AjouterEnleverPiloteBis aePilote;
    private ModifierVoitureBis mVoiture;
    private CreerVoitureBis cVoiture;
    private AjouterEnleverVoitureBis aeVoiture;
    private CreerPiloteBis cPilote;
    private ModifierPiloteBis mPilote;
    
    private CreerModifierCourseBis cmCourse;
    
    //autres variables
    private Controleur control;
    
    //variable pour revenir aux fenetres precedentes
    private MaFenetre precedente;
    private MaFenetre courante;
    private MaFenetre optionnelle;
    
    private ChronometreCourseBis chrono;
    private MaFenetre resultats;
    
    /**
     * Instanciation de la vue : instancie également toutes les fenetres et le controleur
     * @param c Controleur
     */
    public Vue(Controleur c){
        control = c;
        cce = new CreerChargerEvt(control);
        newEvt = new NouvelEvt(control,cce);
        chargE = new ChargerEvtBis(control,cce);
        evt = new EvenementBis(control);
        evt.dispose();
          
        aePilote = new AjouterEnleverPiloteBis(control);
        mVoiture = new ModifierVoitureBis(control);
        cVoiture = new CreerVoitureBis(control);
        aeVoiture = new AjouterEnleverVoitureBis(control);
        cPilote = new CreerPiloteBis(control);
        mPilote = new ModifierPiloteBis(control);
        
        cmCourse=new CreerModifierCourseBis(control,evt,null);
        
        precedente = cce;
        courante = cce;
    }
    
    
    /**
     * Ouvre la fenetre precedente
     */
    public void precedent(){
        courante.fermer();
        courante=precedente;
        //System.out.println("objet dans courante = "+(Object)courante.getClass().toString());
        //courante.afficher();
        if(courante.getPrecedent()!=null){
            precedente = courante.getPrecedent();
        }
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre courante
     */
    public void lancer(){
        courante.afficher();
    }

    @Override
    public void update(Observable o, Object arg) {
        //System.out.println("On update");
        courante.raffraichir();
        //courante.afficher();
    }
    
    /**
     * Ouvre la fenetre NouvelEvt (creation d'un nouvel evenement sportif)
     */
    public void ouvrirNouvelEvt(){
        precedente = courante;
        precedente.fermer();
        courante = newEvt;
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre Evenement (fenetre principale de l'application)
     */
    public void ouvrirEvenement(){
        evt = new EvenementBis(control);
        courante.fermer();
        precedente = cce; //creer charger evenement
        courante = evt; // choix
        courante.raffraichir();
        courante.afficher();
        
    }
    
    /**
     * Ouvre la fenetre Chrono
     */
    public void ouvrirChrono(){
        chrono = new ChronometreCourseBis(control);
        //chrono = new ChronoCourseBis(control);
        courante.fermer();
        precedente = evt; //creer charger evenement
        courante = chrono; // choix
        courante.afficher();
        optionnelle = new TableurChronoBis(control);
        optionnelle.afficher();
    }
    
    /**
     * 
     * @param ligneTable String[]
     */
    public void ajouterLigneTableurCourse(String[] ligneTable){//la taille est de 8
        String temps = ((ChronometreCourseBis)courante).getTemps();
        ligneTable[3] = temps;
        ((TableurChronoBis)optionnelle).ajouterLigne(ligneTable);
    }
    
    /**
     * Ouvre la fenetre AjouterEnleverPilote
     * @param v Voiture courante de la fenetre auquel on ajoute/enleve des pilotes
     */
    public void ouvrirAjouterEnleverPilote(Voiture v){
        courante.fermer();
        precedente = mVoiture;
        courante = aePilote;
        if(v != null){
            System.out.println("oaePilote ="+v.getNumVoiture());
            aePilote.miseAJour(v);
        }
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre AjouterEnleverVoiture
     */
    public void ouvrirAjouterEnleverVoiture(){
        courante.fermer();
        precedente = evt;
        courante = aeVoiture;
        courante.afficher();
    }
    
    //Pb ici !!! il faut jouer avec le Observer/observable il me semble vu que le modele est mis à jour, la fenetre devrait être notifée du changement
    /**
     * Ouvre la fenetre ModifierVoiture
     * @param v Voiture courante qui va etre modifier
     */
    public void ouvrirModifierVoiture(Voiture v){
        courante.fermer();
        precedente = evt;
        courante = mVoiture;
        if(v != null){
            mVoiture.miseAJour(v);
        }
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre CreerVoiture
     * @param v Voiture courante qui va etre creer
     */
    public void ouvrirCreerVoiture(Voiture v){
        courante.fermer();
        precedente = aeVoiture; // marche pas à revoir
        courante = cVoiture;
        if(v != null){
            cVoiture.miseAJour(v);
        }
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre CreerPilote
     * @param v Voiture courante de le fenetre precedente (aePilote)
     */
    public void ouvrirCreerPilote(Voiture v){
        courante.fermer();
        precedente = aePilote;
        courante = cPilote;
        if(v != null){
            cPilote.miseAJour(v);
        }
        courante.afficher();
    }
    
    /**
     * Ouvre la fenetre ModifierPilote
     * 
     * @param v Voiture courante de la fenetre precedente (mVoiture)
     * @param p Pilote courant qui va etre modifié
     */
    public void ouvrirModifierPilote(Voiture v,Pilote p){
        courante.fermer();
        precedente = mVoiture;
        courante = mPilote;
        if(p != null){
            mPilote.miseAJour(v,p);
        }
        courante.afficher();
    }
    
    
    /**
     * Ouvre la fenetre CreerModifierCourse
     * 
     * @param c Course courante qui va etre modifié
     */
    public void ouvrirCreerModifierCourse(Course c){
        courante.fermer();
        precedente=evt;
        courante=cmCourse;
        cmCourse.setcModifier(c);
        courante.afficher();
    }

    /**
     * Ouvre la fenetre ChargerEvenement
     */
    public void ouvrirChargerEvenement() {
        precedente = courante;
        precedente.fermer();
        chargE = new ChargerEvtBis(control,cce);
        courante = chargE;
        courante.afficher();
        
    }
    
    /**
     * Ouvre la fenetre Resultats
     * @param course Striing nom de la Course courante
     */
    public void ouvrirResultats(String course) {
        resultats = new ResultatsCourseBis(control,course);
        //chrono = new ChronoCourseBis(control);
        courante.fermer();
        precedente = evt; //fenetre EvtBis
        courante = resultats;
        courante.afficher();
    }

    /**
     * Permet de fermer les fenetres liés au lancement d'une course
     */
    public void fermerChronoCourse() {
        DefaultTableModel table = ((TableurChronoBis)optionnelle).getTable();
        control.genererGraphiqueCourse(table);
        control.enregistrerLesTops(table);
        optionnelle.fermer();
        fenetreGraphiqueCourse();
        //courante.fermer();
        this.ouvrirEvenement();
    }
    
    /**
     * Permet de fermer la fenetre contenant le graphique de la course
     */
    public void fenetreGraphiqueCourse(){
        JDialog fgraphe = new JDialog();
	fgraphe.setTitle("Ratio Temps/Tours");
        fgraphe.getContentPane().add(control.getCourseEnCours().getPanelGraphe());

	fgraphe.pack();
	fgraphe.setVisible(true);
    }

    
    
    /**
     * Ferme l'ensemble des fenetres
     */
    public void quitter(){
        cce.fermer();
        newEvt.fermer();
        chargE.fermer();
        evt.fermer();
        aePilote.fermer();
        mVoiture.fermer();
        cVoiture.fermer();
        aeVoiture.fermer();
        cPilote.fermer();
        mPilote.fermer();

        cmCourse.fermer();

        precedente.fermer();
        courante.fermer();
        if(optionnelle!=null){
            optionnelle.fermer();
        }
        if(chrono!=null)chrono.fermer();
        if(resultats!=null)resultats.fermer();
    
    }
}
