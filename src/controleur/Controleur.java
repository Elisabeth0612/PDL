/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import xml.GestionnaireExistant;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modele.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import vue.MaFenetre;
import vue.Vue;


/**
 *
 * @author 13008360
 */
public class Controleur {
    private EvenementSportif evtS;
    
    private Vue vue;
    
    private Course courseEnCours;
    
    public Controleur(EvenementSportif e){
        evtS = e;
        courseEnCours = new Course();
      
        
        /*
        * pour tester on remplie quelques données
        */
        /*Course c1 = new Course("Course 1",null, null, 2, 3,"beau", 8, "Tours");
        Course c2 = new Course("Course 2",null,null, 2, 3,"beau", 8, "Tours");
        //ajout des courses
        evtS.addListC(c1);
        evtS.addListC(c2);
        Pilote v1p1 = new Pilote("nomV1P1", "prenomV1P1","rouge");
        Pilote v1p2 = new Pilote("nomV1P2", "prenomV1P2","rouge");
        Pilote v2p1 = new Pilote("nomV2P1", "prenomV2P1","bleu");
        Pilote v2p2 = new Pilote("nomV2P2", "prenomV2P2","bleu");
        
        Voiture v1 = new Voiture(1, v1p1,"rouge", 5,true);
        v1.addListP(v1p2);
        Voiture v2 = new Voiture(2, v2p1,"bleue", 5,true);
        v2.addListP(v2p2);
        //Ajout des voiture à l'evenement
        evtS.addListV(v1);
        evtS.addListV(v2);
        
        //ajout des voiture à une course
        c1.addListV(v1);
        c1.addListV(v2);
        
        //ajout des courses
        evtS.addListC(c1);
        evtS.addListC(c2);*/
        
        /*GestionnaireExistant.getInstance().creerNouveauPilote(v2p2);
        GestionnaireExistant.getInstance().creerNouveauPilote(v1p2);
        GestionnaireExistant.getInstance().creerNouveauPilote(v2p1);
        GestionnaireExistant.getInstance().creerNouveauPilote(v1p1);
        GestionnaireExistant.getInstance().creerNouvelleVoiture(v2);
        GestionnaireExistant.getInstance().creerNouvelleVoiture(v1);*/
        
        
    }
   
    /*
    getters et setters
    */
    public void setVue(Vue v){
        vue = v;
    }
    
    /*
    *Gestion du modele
    */
    public void creerEvt(String nomE,Date d,String nomC,int longueur){
        evtS.modifierEvenement(nomE,d,nomC,longueur);
         /*
        * pour tester on remplie quelques données 
        * A ENLEVER !!!!
        */
        Course c1 = new Course("Course 1",null, null, 2, 3,"beau", 8, "Tours");
        Course c2 = new Course("Course 2",null,null, 2, 3,"beau", 8, "Tours");
        //ajout des courses
        evtS.addListC(c1);
        evtS.addListC(c2);
        Pilote v1p1 = new Pilote("nomV1P1", "prenomV1P1","rouge");
        Pilote v1p2 = new Pilote("nomV1P2", "prenomV1P2","rouge");
        Pilote v2p1 = new Pilote("nomV2P1", "prenomV2P1","bleu");
        Pilote v2p2 = new Pilote("nomV2P2", "prenomV2P2","bleu");
        
        Voiture v1 = new Voiture(1, v1p1,"rouge", 5,true);
        v1.addListP(v1p2);
        v1.addListP(v1p1);
        
        Voiture v2 = new Voiture(2, v2p1,"bleue", 5,true);
        v2.addListP(v2p1);
        //Ajout des voiture à l'evenement
        evtS.addListV(v1);
        evtS.addListV(v2);
        
        //ajout des voiture à une course
        c1.addListV(v1);
        c1.addListV(v2);
        
        //ajout des courses
        evtS.addListC(c1);
        evtS.addListC(c2);
        /*
        * fin ajout test
        */
        
        vue.ouvrirEvenement();
    }  
    
   public void creerChargerEvt(String nomEvt){
       evtS = GestionnaireExistant.getInstance().chargerUnEvenementExistant(nomEvt);
       vue.ouvrirEvenement();
       //vue.
   }
    
    public String getNomEvt(){
        //System.out.println("=="+evtS.getNomEvt());
        return evtS.getNomEvt();
    }
    
    public Date getDateEvt(){
        return evtS.getDateEvt();
    }
    
    public int getLongueurCircuit(){
        return evtS.getLongueurCircuit();
    }
    
    public String getNomCircuit(){
        return evtS.getNomCircuit();
    }
    
    public List getCoursesEvenement(){
        return evtS.getListC();
    }
    
    public List getVoituresEvenement(){
        return evtS.getListV();
    }   
    
    public boolean supprimerVoituresEvenement(int numV){
        List<Voiture> lesV = evtS.getListV();
        for(Voiture v:lesV){
            if(v.getNumVoiture()==numV){
                evtS.remove(v);
                return true;
            }
        }
        return false;
    }
    
    public Voiture getVoitureEvenementByNum(int numV){
        List<Voiture> lesV = evtS.getListV();
        for(Voiture v: lesV){
            if(v.getNumVoiture()==numV){
                return v;
            }
        }
        return null;
    }
    
    public List getVoituresCourse(){
        return courseEnCours.getListV();
    }
    
    /*
    *Gestion de la vue
    */
    public void ouvrirNouvelEvt(){
        vue.ouvrirNouvelEvt();
    }
    
    public void ouvrirEvenement(){
        vue.ouvrirEvenement();
    }
    
    public void retour(){
        vue.precedent();
    }
    
    public void demarrerCourse(String nomCourse){
        Course c = evtS.chercherCourse(nomCourse);
        if(c != null){
            this.courseEnCours = c;
            System.out.println("course courante "+courseEnCours.getNomCourse());
            System.out.println("nb voitures = "+courseEnCours.getListV().size());
            //on lance l'affichage de la fenetre de chrono
            vue.ouvrirChrono();
            
        }
        else{
            ouvrirEvenement();
        }
    }
    
    public boolean supprimerVoiture(int numVoiture){
        if(evtS.supprimerVoiture(numVoiture)){
            // voiture supprimé
            return true;
        }else{
            // voiture non supprimé
            return false;
        }
    }
    
    public void ouvrirAjouterEnleverPilote(Voiture v){
        vue.ouvrirAjouterEnleverPilote(v);
    }
    
    public void ouvrirAjouterEnleverPilote(){
        vue.ouvrirAjouterEnleverPilote();
    }
    
    public void ouvrirAjouterEnleverVoiture(){
        vue.ouvrirAjouterEnleverVoiture();
    }
    
    public void ouvrirCreerModifierVoiture(Voiture v){
        vue.ouvrirCreerModifierVoiture(v);
    }
    
    public void ouvrirCreerModifierPilote(){
        vue.ouvrirCreerModifierVoiture();
    }
    
    public Voiture getVoitureCourseByNum(int num){
        return courseEnCours.getUneVoiture(num);
    }
    
    public List<Pilote> getPilotesVoiture(int num){
        System.out.println(num);
         Voiture v = getVoitureEvenementByNum(num);
        if(v.existListP()){
            List<Pilote> lesP = v.getListP();
            return v.getListP();
        }else{
            return new ArrayList<Pilote>();
        }
    }
    
    public int getNbToursMaxCourse(){
        return courseEnCours.getNbToursMax();
    }
    
    public void ouvrirCreerModifierCourse(Course c){
        vue.ouvrirCreerModifierCourse(c);
    }
    
    public void enregistrer(){
        //GestionnaireExistant.getInstance().genererFichierEvenements(evtS);
        GestionnaireExistant.getInstance().enregistrementFermeture(evtS);
        //EvenementSportifXML eXML = new EvenementSportifXML(evtS);
        //eXML.executer();
    }

    public void chargerExistant() {
        GestionnaireExistant.getInstance().chargerExistants();
    }

    public void chargerEvenement() {
        vue.ouvrirChargerEvenement();
    }

    public List<String> getEvenementsExistants() {
        return GestionnaireExistant.getInstance().getEvenementsExistants();
    }
    
    public List<Voiture> getListVoituresExistantes(){
        return GestionnaireExistant.getInstance().getVoituresExistantes();
    }
    
    public List<Pilote> getListPilotesExistants(){
        return GestionnaireExistant.getInstance().getPilotesExistants();
    }
    
    public Voiture getVoitureExistante(int numV){
        List<Voiture> lesVE = GestionnaireExistant.getInstance().getVoituresExistantes();
        for(Voiture v:lesVE){
            if(v.getNumVoiture()==numV){
                return v;
            }
        }
        return null;
    }

    public void creerUnTop(String[] ligneTable) {
        vue.ajouterLigneTableurCourse(ligneTable);
    }

    public void fermerChronoCourse() {
        vue.fermerChronoCourse();
    }

    public int nbVoituresInscritesCourses(String course) {
        Course c = evtS.chercherCourse(course);
        if(c != null && c.getNbVoituresInscrites()!=0){
            return c.getNbVoituresInscrites();
        }
        else{
            return 0;
        }
    }

    public void genererGraphiqueCourse(DefaultTableModel table) {
       courseEnCours.genererGaphique(table); 
    }
    
    public void compareListEvenement(List<Voiture> lesVtemp){
        List<Voiture> lesVEvenement = evtS.getListV();
        int i=0;
        for(Voiture vtemp: lesVtemp){
            while(i==lesVEvenement.size() || lesVEvenement.get(i).getNumVoiture()==vtemp.getNumVoiture()){
                i++;
            }
            if(i!=lesVEvenement.size()){
                evtS.addListV(vtemp);
            }
        }
    }
    
    public Course getCourseEnCours(){
        return courseEnCours;
    }
    
    public int getNbTourRelaiVoiture(int numV){
        Voiture v = courseEnCours.getUneVoiture(numV);
        return v.getNbToursParRelai();
    }

}
