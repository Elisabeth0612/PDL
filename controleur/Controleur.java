/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.EvenementSportif;
import java.util.Date;
import javax.swing.JFrame;
import vue.MaFenetre;
import vue.Vue;

/**
 *
 * @author 13008360
 */
public class Controleur {
    //private Vue vueCourante;
    private EvenementSportif evt;
    private Vue vue;
    
    public Controleur(Vue laVue){
        evt = new EvenementSportif();
        vue = laVue;
        //vueCourante = new JFrame();
    }
    
    public void creerEvt(String nomE,Date d,String nomC,int longueur){
        evt = new EvenementSportif(nomE,d,nomC,longueur);
        vue.ouvrirEvenement();
    }  
    
    
    public String getNomEvt(){
        return evt.getNomEvt();
    }
    
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
