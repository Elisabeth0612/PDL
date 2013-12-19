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
import javax.swing.table.DefaultTableModel;
import modele.*;
import vue.Vue;


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Controleur {
    private EvenementSportif evtS;
    
    private Vue vue;
    
    private Course courseEnCours;
    
    /**
     * Instanciation du controleur
     * @param e EvenementSportif
     */
    public Controleur(EvenementSportif e){
        evtS = e;
        courseEnCours = new Course();
      
        
    }
    
    /*************************************  Gestion du model    **************************************/

    public void creerEvt(String nomE,Date d,String nomC,int longueur){
        try {
            evtS.modifierEvenement(nomE,d,nomC,longueur);
            /*
            * pour tester on remplie quelques données
            * A ENLEVER !!!!
            */
            Date deb = (Date) new SimpleDateFormat("HH:mm").parse("12:00");
            Date fin = (Date) new SimpleDateFormat("HH:mm").parse("14:30");
            Course c1 = new Course("Course 1",deb, fin, 2, 3,"beau", 8, "Tours");
            Course c2 = new Course("Course 2",deb,fin, 2, 3,"beau", 8, "Tours");
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
        } catch (ParseException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
   /*************************************   Evenement *************************************/ 
    
   public void creerChargerEvt(String nomEvt){
       evtS = GestionnaireExistant.getInstance().chargerUnEvenementExistant(nomEvt);
       vue.ouvrirEvenement();
       //vue.
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
    
     /**
     * Appel la vue pour ouvrir la fenetre NouvelEvt
     */
     public void ouvrirNouvelEvt(){
        vue.ouvrirNouvelEvt();
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre Evenement
     */
    public void ouvrirEvenement(){
        vue.ouvrirEvenement();
    }
    
    /**
     * Retourne à la fenetre precedente
     */
    public void retour(){
        vue.precedent();
    }
    
    /**
     * Modifier la vue associé au controleur
     * @param v Vue
     */
    public void setVue(Vue v){
        vue = v;
    }
    
    /*************************************  Ouverture/Fermeture des fenetres *************************************/
    
    /**
     * Appel la vue pour ouvrir la fenetre AjouterEnleverPilote 
     * @param v Voiture courante de la fenetre
     */
    public void ouvrirAjouterEnleverPilote(Voiture v){
        vue.ouvrirAjouterEnleverPilote(v);
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre AjouterEnleverVoiture 
     */
    public void ouvrirAjouterEnleverVoiture(){
        vue.ouvrirAjouterEnleverVoiture();
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre ModifierVoiture 
     * @param v Voiture courante de la fenetre
     */
    public void ouvrirModifierVoiture(Voiture v){
        vue.ouvrirModifierVoiture(v);
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre CreerVoiture 
     * @param v Voiture courante de la fenetre
     */
    public void ouvrirCreerVoiture(Voiture v){
        vue.ouvrirCreerVoiture(v);
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre AjouterEnleverPilote 
     * @param v Voiture courante de la fenetre precedente
     */
    public void ouvrirCreerPilote(Voiture v){
        vue.ouvrirCreerPilote(v);
    }
    
    /**
     * Appel la vue pour ouvrir la fenetre ModifierPilote 
     * @param v Voiture courante de la fenetre precedente
     * @param p Pilote courant à modifier
     */
    public void ouvrirModifierPilote(Voiture v, Pilote p){
        vue.ouvrirModifierPilote(v, p);
    }
    
     /**
     * Appel la vue pour ouvrir la fenetre CreerModifierCourse 
     * @param c Course courante de la fenetre
     */
    public void ouvrirCreerModifierCourse(Course c){
        vue.ouvrirCreerModifierCourse(c);
    }
     
     
    /**
     * Appel la vue pour fermer les fenetres liées au démarrage de la course
     */
    public void fermerChronoCourse() {
        vue.fermerChronoCourse();
    }
    
    
    /**
     * Appel la vue pour ouvrir la fenetre resultat
     * @param course String - nom de la Course courante de la fenetre
     */
    public void ouvrirResultats(String course) {
        vue.ouvrirResultats(course);
    }    
    
    /**
     * Appel la vue afin de retourner a la fenetre precendente
     */
    public void fermerResultatsCourse() {
        vue.precedent();
    }

    /**
     * Appel la vue afin de quitter l'application
     */
    public void quitter(){
        vue.quitter();
    }
    
    /*************************************  Voiture *************************************/
    
    /**
     * Méthode retournant une voiture de l'évènement à partir de son numero
     * @param numV int
     * @return Voiture
     */
    public Voiture getVoitureEvenementByNum(int numV){
        List<Voiture> lesV = evtS.getListV();
        for(Voiture v: lesV){
            if(v.getNumVoiture()==numV){
                return v;
            }
        }
        return null;
    }
    
    /**
     * Supprime une voiture de l'evenement à partir d'un numero de voiture
     * @param numVoiture int
     * @return
     */
    public boolean supprimerVoiture(int numVoiture){
        if(evtS.supprimerVoiture(numVoiture)){
            // voiture supprimé
            return true;
        }else{
            // voiture non supprimé
            return false;
        }
    }
    
    /**
     * Retourne la liste des pilotes de la voiture existante à partir d'un numero de voiture
     * @param num int
     * @return Liste de Pilotes
     */
    public List<Pilote> getPilotesVoitureExistante(int num){
        
         Voiture v = getVoitureExistante(num);
        if(v.existListP()){
            List<Pilote> lesP = v.getListP();
            return v.getListP();
        }else{
            return new ArrayList<Pilote>();
        }
    }
    
    /**
     * Retourne la liste des pilotes d'une voiture de l'evenement à partir d'un numero de voiture
     * @param num int
     * @return Liste de Pilote
     */
    public List<Pilote> getPilotesVoitureCourante(int num){
        
         Voiture v = getVoitureEvenementByNum(num);
        if(v.existListP()){
            List<Pilote> lesP = v.getListP();
            return v.getListP();
        }else{
            return new ArrayList<Pilote>();
        }
    }
    
    /**
     * Retourne un Pilote a partir d'une voiture, du nom et du prenom du pilote
     * @param v Voiture
     * @param nomPilote String
     * @param prenomPilote String
     * @return Pilote
     */
    public Pilote getPiloteVoiture(Voiture v, String nomPilote, String prenomPilote){
        List<Pilote> lesPVoiture = v.getListP();
        for(Pilote p:lesPVoiture){
            if(p.getNom().equals(nomPilote) && p.getPrenom().equals(prenomPilote)){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Modifier la voiture de l'evenement à partir des informations de la voiture en parametre
     * @param v Voiture
     */
    public void modifierVoitureEvenement(Voiture v){
        List<Voiture> lesV = evtS.getListV();
        for(Voiture vtemp : lesV){
            if(v.getNumVoiture()==vtemp.getNumVoiture()){
                vtemp.setCouleur(v.getCouleur());
                vtemp.setNbToursParRelai(v.getNbToursParRelai());
                vtemp.setVoitureActive(v.getVoitureActive());
                vtemp.setPiloteActuel(v.getPiloteActuel());
                vtemp.setListP(v.getListP());
            }
        }
    }
    
    /**
     * Modifier la voiture existante à partir des informations de la voiture en paramètre puis appel la méthode modifierVoitureEvenement(Voiture v)
     * @param v Voiture
     */
    public void modifierVoitureExistante(Voiture v){
        List<Voiture> lesV = GestionnaireExistant.getInstance().getVoituresExistantes();
        int numV =-1;
        for(Voiture vtemp : lesV){
            if(v.getNumVoiture()==vtemp.getNumVoiture()){
                vtemp.setCouleur(v.getCouleur());
                vtemp.setNbToursParRelai(v.getNbToursParRelai());
                vtemp.setVoitureActive(v.getVoitureActive());
                vtemp.setPiloteActuel(v.getPiloteActuel());
                vtemp.setListP(v.getListP());
                numV = vtemp.getNumVoiture();
            }
        }
        if(numV==-1){
            enregistrerVoiture(v);
        }
        modifierVoitureEvenement(v);
    }
    
     /**
     * Enregistrement d'une nouvelle voiture existante
     * 
     * @param v Voiture
     * @return boolean
     */
    public boolean enregistrerVoiture(Voiture v){
        Boolean b = true;
        List<Voiture> lesV = GestionnaireExistant.getInstance().getVoituresExistantes();
        for(Voiture vlist : lesV){
            if(vlist.getNumVoiture()==v.getNumVoiture()){
                b=false;
            }
        }
        if(b){
            GestionnaireExistant.getInstance().creerNouvelleVoiture(v);
        }
        return b;
    }
    
    /************************************* Top *************************************/
    
    /**
     * Top
     * @param nomCourse String
     */
    public void demarrerCourse(String nomCourse){
        Course c = evtS.chercherCourse(nomCourse);
        if(c != null){
            this.courseEnCours = c;
            /*System.out.println("course courante "+courseEnCours.getNomCourse());
            System.out.println("nb voitures = "+courseEnCours.getListV().size());*/
            //on lance l'affichage de la fenetre de chrono
            vue.ouvrirChrono();
            
        }
        else{
            ouvrirEvenement();
        }
    }
    
    /**
     * Permet d'envoyer les données liées à un top à la vue
     * @param ligneTable
     */
    public void creerUnTop(String[] ligneTable) {
        vue.ajouterLigneTableurCourse(ligneTable);
    }

    /**
     * Permet d'enregistrer le top dans la course en cours
     * @param table DefaultTableModel
     */
    public void enregistrerLesTops(DefaultTableModel table){
        //parcour du tableau
        int n = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            //parse du resultat
            int tour = Integer.parseInt((String)table.getValueAt(i, 0));
            Voiture v = this.getVoitureEvenementByNum(Integer.parseInt((String)table.getValueAt(i, 1)));
            String nom = ((String)table.getValueAt(i, 2)).split(" - ")[0];
            String prenom = ((String)table.getValueAt(i, 2)).split(" - ")[1];
            Pilote p = v.trouverUnPilote(nom,prenom);
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
    
    /**
     * Retourne la voiture qui se déroule
     * @return Course
     */
    public Course getCourseEnCours(){
        return courseEnCours;
    }
    
    /**
     * Génère le graphique de résultat de la course qui vient de se terminer
     * @param table
     */
    public void genererGraphiqueCourse(DefaultTableModel table) {
       courseEnCours.genererGaphique(table); 
    }
    
    /**
     * Retourne le nombre de tour par relai d'une voiture
     * @param numV int
     * @return int
     */
    public int getNbTourRelaiVoiture(int numV){
        Voiture v = courseEnCours.getUneVoiture(numV);
        return v.getNbToursParRelai();
    }

    /**
     * Indique si une course est terminée
     * @param course String
     * @return boolean
     */
    public boolean courseTerminee(String course) {
        Course c = evtS.chercherCourse(course);
        if(c!=null){
            if(c.getListT().size()!=0){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param nomC String
     * @return List
     */
    public List getLesTopsCourse(String nomC) {
        return evtS.chercherCourse(nomC).getListT();
    }

    /**
     * Retourne les voitures inscrites à une course
     * @param nomC String
     * @return Liste
     */
    public List getVoituresCourse(String nomC) {
        return evtS.chercherCourse(nomC).getListV();
    }
    
    /*************************************  Pilote *************************************/
    
    /**
     * Modifie le Pilote d'une voiture à partir des informations en paramètre
     * 
     * @param v Voiture
     * @param p Pilote
     * @param nom String nom du Pilote
     * @param prenom String prenom du Pilote
     * @param couleurCasque String couleur du casque
     */
    public void modifierPiloteVoiture(Voiture v, Pilote p, String nom, String prenom, String couleurCasque){
        List<Pilote> lesP = v.getListP();
        for(Pilote ptemp : lesP){
            if(ptemp.getNom().equals(p.getNom()) && ptemp.getPrenom().equals(p.getPrenom())){
                ptemp.setCouleursCasque(couleurCasque);
                ptemp.setNom(nom);
                ptemp.setPrenom(prenom);
            }
        }
    }
    
    /**
     * Modifie un Pilote existant à partir des informations en paramètre et appel la méthode modifierPiloteVoiture utilisant le paramètre v
     * 
     * @param v Voiture
     * @param p Pilote
     * @param nom String nom du Pilote
     * @param prenom String prenom du Pilote
     * @param couleurCasque String couleur du casque
     */
    public void modifierPiloteExistant(Voiture v, Pilote p, String nom, String prenom, String couleurCasque){
        List<Pilote> lesP = GestionnaireExistant.getInstance().getPilotesExistants();
        Boolean b=false;
        for(Pilote ptemp : lesP){
            if(ptemp.getNom().equals(p.getNom()) && ptemp.getPrenom().equals(p.getPrenom())){
                ptemp.setCouleursCasque(couleurCasque);
                ptemp.setNom(nom);
                ptemp.setPrenom(prenom);
                b=true;
            }
        }
        if(b){
            if(v!=null){
                modifierPiloteVoiture(v, p,nom,prenom,couleurCasque);
            }
        }else{
            enregistrerVoiture(v);
        }
    }
    
    /**
     * Enregistre un nouveau Pilote existant avec les paramètres du pilote passé en parametre
     * @param p Pilote
     */
    public void enregistrerPiloteExistant(Pilote p){
        Boolean b = true;
        List<Pilote> lesP = GestionnaireExistant.getInstance().getPilotesExistants();
        for(Pilote plist : lesP){
            if(plist.getNom().equals(p.getNom()) && plist.getPrenom().equals(p.getPrenom())){
                b=false;
            }
        }
        if(b){
            GestionnaireExistant.getInstance().creerNouveauPilote(p);
        }
    }
   
    /************************************* Gestion de l'Existant *************************************/
    
    public void enregistrer(){
       GestionnaireExistant.getInstance().enregistrementFermeture(evtS); 
    }

    /**
     * Initialise les données existantes
     */
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

}
