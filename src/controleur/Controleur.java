/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import xml.GestionnaireExistant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
        
    }
    
    /*************************************  Gestion du model    **************************************/

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
        
        Voiture v2 = new Voiture(3, v2p1,"bleue", 5,true);
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
    
    
   /*************************************   Evenement *************************************/ 
    
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
    
     public void setListEvenement(List<Voiture> lesVtemp){
        evtS.setListV(lesVtemp);
    }
    /*************************************  Gestion de la vue *************************************/
    public void ouvrirNouvelEvt(){
        vue.ouvrirNouvelEvt();
    }
    
    public void ouvrirEvenement(){
        vue.ouvrirEvenement();
    }
    
    public void retour(){
        vue.precedent();
    }
    
    public void setVue(Vue v){
        vue = v;
    }
    /*************************************  Ouverture/Fermeture des fenetres *************************************/
    
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
    
    public void ouvrirCreerModifierPilote(Pilote p){
        vue.ouvrirCreerModifierPilote(p);
    }
    
    public void ouvrirCreerModifierPilote(){
        vue.ouvrirCreerModifierPilote();
    }
    
     public void ouvrirCreerModifierCourse(Course c){
        vue.ouvrirCreerModifierCourse(c);
    }
     
     
    public void fermerChronoCourse() {
        vue.fermerChronoCourse();
    }
    
    /*************************************  Voiture *************************************/
    
    public Voiture getVoitureEvenementByNum(int numV){
        List<Voiture> lesV = evtS.getListV();
        for(Voiture v: lesV){
            if(v.getNumVoiture()==numV){
                return v;
            }
        }
        return null;
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
    
    public Pilote getPiloteVoiture(Voiture v, String nomPilote, String prenomPilote){
        List<Pilote> lesPVoiture = v.getListP(); // erreur si créer nouvelle voiture = ajouter/enlever voiture
        for(Pilote p:lesPVoiture){
            if(p.getNom().equals(nomPilote) && p.getPrenom().equals(prenomPilote)){
                return p;
            }
        }
        return null;
    }
    
    public void setListVoiture(Voiture v, List<Pilote> lesPVoitureTemp){
        v.setListP(lesPVoitureTemp);
    }
    
    public void setPiloteActuel(Voiture v, Pilote p){
        v.setPiloteActuel(p);
    }
    
    public void modifierVoiture(Voiture v,String couleur,int NbToursRelai,Boolean voitureEnCourse, Pilote p){
        v.setCouleur(couleur);
        v.setNbToursParRelai(NbToursRelai);
        v.setVoitureActive(voitureEnCourse);
        v.setPiloteActuel(p);
    }
    
    /************************************* Top *************************************/
    
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
    
    public void creerUnTop(String[] ligneTable) {
        vue.ajouterLigneTableurCourse(ligneTable);
    }
    
    
    public void enregistrerLesTops(DefaultTableModel table){
        //parcour du tableau
        int n = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            //parse du resultat
            int tour = Integer.parseInt((String)table.getValueAt(i, 0));
            Voiture v = this.getVoitureEvenementByNum(Integer.parseInt((String)table.getValueAt(i, 1)));
            Pilote p = v.getPiloteActuel();
            String res = (String) table.getValueAt(i, 3);
            String[] tempsSplit = res.split(":");
            long tempsT = (Integer.parseInt(tempsSplit[3]))+(Integer.parseInt(tempsSplit[2])*1000)+(Integer.parseInt(tempsSplit[1])*1000*60)+(Integer.parseInt(tempsSplit[0])*1000*60*60);
            int relai = Integer.parseInt((String)table.getValueAt(i, 4));
            String type = (String)table.getValueAt(i, 5);
            SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm");
            Date h = null;
            try {
                h = formatter2.parse((String)table.getValueAt(i,6));
            } catch (ParseException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
            String comment = (String)table.getValueAt(i,7);
            this.courseEnCours.addListT(new Top(tour,type,v,p,relai,h,comment,tempsT));
        }  
       
    }

    
    /*************************************  Course *************************************/    
    public List getVoituresCourse(){
        return courseEnCours.getListV();
    }
    
    public Voiture getVoitureCourseByNum(int num){
        return courseEnCours.getUneVoiture(num);
    }
    
    public int getNbToursMaxCourse(){
        return courseEnCours.getNbToursMax();
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
    
    public Course getCourseEnCours(){
        return courseEnCours;
    }
    
    public void genererGraphiqueCourse(DefaultTableModel table) {
       courseEnCours.genererGaphique(table); 
    }
    
    public int getNbTourRelaiVoiture(int numV){
        Voiture v = courseEnCours.getUneVoiture(numV);
        return v.getNbToursParRelai();
    }
    
    /*************************************  Pilote *************************************/
    public void modifierPilote(Pilote p, String nom, String prenom, String couleurCasque){
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setCouleursCasque(couleurCasque);
    }
   
    /************************************* Gestion de l'Existant *************************************/
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
    
    public Pilote getPiloteExistant(String nomPilote, String prenomPilote){
        List<Pilote> lesPVoitures = GestionnaireExistant.getInstance().getPilotesExistants();
        
        for(Pilote p : lesPVoitures){
            if(p.getNom().equals(nomPilote) && p.getPrenom().equals(prenomPilote)){
                return p;
            }
        }
        return null;
    }

    
    public boolean courseTerminee(String course) {
        Course c = evtS.chercherCourse(course);
        if(c!=null){
            if(c.getListT().size()!=0){
                return true;
            }
        }
        return false;
    }

    public void ouvrirResultats(String course) {
        vue.ouvrirResultats(course);
    }

    public List getLesTopsCourse(String nomC) {
        return evtS.chercherCourse(nomC).getListT();
    }

    public List getVoituresCourse(String nomC) {
        return evtS.chercherCourse(nomC).getListV();
    }

}
