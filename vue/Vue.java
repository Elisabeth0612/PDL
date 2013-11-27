/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.Controleur;
import java.util.Observable;
import java.util.Observer;
import modele.EvenementSportif;

/**
 *
 * @author Co
 */
public class Vue implements Observer {
    //listing de toutes les fenetres
    private CreerChargerEvt cce;
    private NouvelEvt newEvt;
    private Controleur control;
    private Evenement evt;
    
    //autres variables
    private EvenementSportif evtS;
    
    //variable pour revenir aux fenetres precedentes
    private MaFenetre precedente;
    private MaFenetre courante;
    
    public Vue(){
        control = new Controleur(this);
        cce = new CreerChargerEvt(control);
        newEvt = new NouvelEvt(control,cce);
        evt = new Evenement(control,evtS);
        precedente = cce;
        courante = cce;
    }
    
    
    public void precedent(){
        courante.masquer();
        courante=precedente;
        System.out.println("objet dans courante = "+(Object)courante.getClass().toString());
        courante.afficher();
        precedente = courante.getPrecedent();
        //courante.afficher();
    }
    
    public void ouvrirNouvelEvt(){
        precedente = courante;
        precedente.masquer();
        courante = newEvt;
        courante.afficher();
    }
    
    public void ouvrirEvenement(){
        courante.vider();
        courante.masquer();
        precedente = cce; //creer charger evenement
        courante = evt; // choix
        //newEvt.setPrecedent(cce);
        courante.afficher();
        
    }
    
    public void lancer(){
        courante.afficher();
    }

    

    @Override
    public void update(Observable o, Object arg) {
        evtS = (EvenementSportif) arg;
    }
    
}
