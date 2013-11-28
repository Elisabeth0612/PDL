/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chrono;
//allooo
import controleur.Controleur;
import javax.swing.JFrame;
import modele.EvenementSportif;
import vue.*;


/**
 *
 * @author 13008360
 */
public class Chrono {
    
    //private CreerChargerEvt cce;
    //private NouvelEvt ne;
    //private MaFenetre fenetreActive;
    private Controleur controleur;
    private Vue vue;
    private EvenementSportif evtS;
    //private boolean fin=false;
    
    
    public Chrono(){
        //on charge les existants
        //GestionnaireExistant gExist = GestionnaireExistant.getInstance();
        
        evtS = new EvenementSportif();
        controleur = new Controleur(evtS);
        vue = new Vue(controleur);
        controleur.setVue(vue);
        evtS.addObserver(vue);
        
    }
    
    public void lancerAppli(){
        vue.lancer();
    }
    
    
    
    public static void main(String args[]) {
        Chrono chrono = new Chrono();
        chrono.lancerAppli();
        
        
         

    }
}

