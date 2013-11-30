/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import modele.*;
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
        Voiture v2 = new Voiture(2, v2p1,"bleue", 5,true);
        v2.addListP(v2p2);
        //Ajout des voiture à l'evenement
        evtS.addListV(v1);
        evtS.addListV(v2);
        //ajout des voiture à une course
        c1.addListV(v1);
        c1.addListV(v2);
        
        
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
        vue.ouvrirEvenement();
    }  
    
    
    public String getNomEvt(){
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
    
    public void ouvrirAjouterEnleverPilote(){
        vue.ouvrirAjouterEnleverPilote();
    }
    
    public void ouvrirAjouterEnleverVoiture(){
        vue.ouvrirAjouterEnleverVoiture();
    }
    
    public void ouvrirCreerModifierVoiture(int numV){
        vue.ouvrirCreerModifierVoiture(numV);
    }
    
    public void ouvrirCreerModifierPilote(){
        vue.ouvrirCreerModifierVoiture(-1);
    }
    
    public String getCouleurVoiture(int numVoiture){
        return evtS.chercherVoiture(numVoiture).getCouleur();
    }
    
    public int getNbToursRelaiVoiture(int numVoiture){
        return evtS.chercherVoiture(numVoiture).getNbToursParRelai();
    }
    
    public boolean getVoitureActive(int numVoiture){
        return evtS.chercherVoiture(numVoiture).getVoitureActive();
    }
    
    public List<Pilote> getListP(int numVoiture){
        return null;//evtS.chercherVoiture(numVoiture).getListP();
    }
    
    public Pilote getPiloteActuel(int numVoiture){
        return evtS.chercherVoiture(numVoiture).getPiloteActuel();
    }
    
    public Voiture getVoitureCourseByNum(int num){
        return courseEnCours.getUneVoiture(num);
    }
    
    public List<Pilote> getPilotesVoiture(int num){
        Voiture v = getVoitureCourseByNum(num);
        return v.getListP();
    }
    
    public int getNbToursMaxCourse(){
        return courseEnCours.getNbToursMax();
    }

    public void ouvrirCreerModifierCourse() {
        vue.ouvrirCreerModifierCourse(null);
    }
    
    public void ouvrirCreerModifierCourse(Course c){
        vue.ouvrirCreerModifierCourse(c);
    }
}
