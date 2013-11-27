/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chrono;

import controleur.Controleur;
import javax.swing.JFrame;
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
    //private boolean fin=false;
    
    
    public Chrono(){
        //on charge les existants
        //GestionnaireExistant gExist = GestionnaireExistant.getInstance();
        
        
        //controleur = new Controleur();
        //cce = new CreerChargerEvt(controleur);
        //ne = new NouvelEvt(controleur,null);
        vue = new Vue();        
        
    }
    
    public void lancerAppli(){
        vue.lancer();
    }
    
    
    
    public static void main(String args[]) {
        Chrono chrono = new Chrono();
        chrono.lancerAppli();
        
        
         

    }
}

