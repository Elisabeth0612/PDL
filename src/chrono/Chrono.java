/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chrono;
//
import controleur.Controleur;
import javax.swing.JFrame;
import modele.EvenementSportif;
import vue.*;
import xml.GestionnaireExistant;


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Chrono {
    //
    //private CreerChargerEvt cce;
    //private NouvelEvt ne;
    //private MaFenetre fenetreActive;
    private Controleur controleur;
    private Vue vue;
    private EvenementSportif evtS;
    //private boolean fin=false;
    
    
    public Chrono(){
        //on charge les existants
        GestionnaireExistant.getInstance().chargerExistants();
        
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

