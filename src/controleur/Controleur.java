/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.EvenementSportif;
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
    //private Vue vueCourante;
    private EvenementSportif evtS;
    
    private Vue vue;
    
    public Controleur(EvenementSportif e){
        evtS = e;
        //pour tester on remplie quelques données
        evtS.addListC(new Course(evtS,"Course 1",null, null, 2, 3,"beau", 8, "Tours"));
        evtS.addListC(new Course(evtS,"Course 2",null,null, 2, 3,"beau", 8, "Tours"));
  
        evtS.addListV(new Voiture(1, new Pilote("nomP1", "prenomP1","rouge"),"rouge", 5,true));
        evtS.addListV(new Voiture(2, new Pilote("nomP2", "prenomP2","bleu"),"bleue", 5,true));
        
        //System.out.println("nb elem = "+evtS.getListC().size());
       //System.out.println("control"+evtS.getListC().get(0).getNomCourse());
        
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
    
}
