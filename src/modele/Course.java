package modele;

import graphique.GrapheCourse;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class Course{
	
	private List<Top> listT;
	private List<Voiture> listV;
	private String nomCourse;
	private Date heureDeb;
	private Date heureFin;
	private int dureePilotageMaxParPilote;
	private int dureeConsecutivePilotageMaxParPilote;
	private String meteo;
	private String typeFin;
	private int nbToursMax;
        private GrapheCourse graphe=null;

    /**
     *Constructeur vide Course
     */
    public Course(){
            this.listT=new ArrayList<Top>();
            this.listV=new ArrayList<Voiture>();
        }

    /**
     *Constructeur course
     * @param nomCourse
     * @param heureDeb
     * @param heureFin
     * @param dureePilotageMaxParPilote
     * @param dureeConsecutivePilotageMaxParPilote
     * @param meteo
     * @param nbToursMax
     * @param typeFin
     */
    public Course(String nomCourse,Date heureDeb, Date heureFin, int dureePilotageMaxParPilote, int dureeConsecutivePilotageMaxParPilote, String meteo, int nbToursMax, String typeFin){
            this.nomCourse = nomCourse;
            this.heureDeb=heureDeb;
            this.heureFin=heureFin;
            this.dureePilotageMaxParPilote=dureePilotageMaxParPilote;
            this.dureeConsecutivePilotageMaxParPilote=dureeConsecutivePilotageMaxParPilote;
            this.meteo=meteo;
            this.nbToursMax=nbToursMax;
            this.listT=new ArrayList<Top>();
            this.listV=new ArrayList<Voiture>();
            this.typeFin=typeFin;
    }

    /**
     * Methode pour modifier la course
     * @param nomCourse
     * @param heureDeb
     * @param heureFin
     * @param dureePilotageMaxParPilote
     * @param dureeConsecutivePilotageMaxParPilote
     * @param meteo
     * @param nbToursMax
     * @param typeFin
     */
    public void modifierCourse(String nomCourse,Date heureDeb, Date heureFin, int dureePilotageMaxParPilote, int dureeConsecutivePilotageMaxParPilote, String meteo, int nbToursMax, String typeFin){
            setNomCourse(nomCourse);
            setHeureDeb(heureDeb);
            setHeureFin(heureFin);
            setDureePilotageMaxParPilote(dureePilotageMaxParPilote);
            setDureeConsecutivePilotageMaxParPilote(dureeConsecutivePilotageMaxParPilote);
            setMeteo(meteo);
            setTypeFin(typeFin);
            setNbToursMax(nbToursMax);
    }

    /**
     * Ajouter le top t a la liste
     * @param t
     */
    public void addListT(Top t){
            if (!listT.contains(t)){
                    listT.add(t);
            }
    }

    /**
     * Effacer le top t de la liste
     * @param t
     */
    public void removeListT(Top t){
            listT.remove(t);
    }

    /**
     * Ajouter la voiture v a la liste
     * @param v
     */
    public void addListV(Voiture v){
            if (!listV.contains(v)){
                    listV.add(v);
            }
    }

    /**
     * Effacer la voiture c de la liste
     * @param v
     */
    public void removeListV(Voiture v){
            listV.remove(v);
    }

    /**
     * Retourne le nom de la course
     * @return
     */
    public String getNomCourse() {
            return nomCourse;
    }

    /**
     * Modifie le nom de la course
     * @param nomCourse
     */
    public void setNomCourse(String nomCourse) {
            this.nomCourse = nomCourse;
    }

    /**
     * Retourne l heure de debut de la course
     * @return
     */
    public Date getHeureDeb() {
            return heureDeb;
    }

    /**
     * Modifie l heure de debut de la course
     * @param heureDeb
     */
    public void setHeureDeb(Date heureDeb) {
            this.heureDeb = heureDeb;
    }

    /**
     * Retourne l heure de fin de la course
     * @return
     */
    public Date getHeureFin() {
            return heureFin;
    }

    /**
     * Modifie l heure de fin de course
     * @param heureFin
     */
    public void setHeureFin(Date heureFin) {
            this.heureFin = heureFin;
    }

    /**
     * Retourne la duree max de pilotage par pilote
     * @return
     */
    public int getDureePilotageMaxParPilote() {
            return dureePilotageMaxParPilote;
    }

    /**
     * Modifie la duree max de pilotage par pilote
     * @param dureePilotageMaxParPilote
     */
    public void setDureePilotageMaxParPilote(int dureePilotageMaxParPilote) {
            this.dureePilotageMaxParPilote = dureePilotageMaxParPilote;
    }

    /**
     * Retourne la duree max consecutive de pilotage d un pilote
     * @return
     */
    public int getDureeConsecutivePilotageMaxParPilote() {
            return dureeConsecutivePilotageMaxParPilote;
    }

    /**
     * Modifie la duree max consecutive de pilotage d un pilote
     * @param dureeConsecutivePilotageMaxParPilote
     */
    public void setDureeConsecutivePilotageMaxParPilote(
                    int dureeConsecutivePilotageMaxParPilote) {
            this.dureeConsecutivePilotageMaxParPilote = dureeConsecutivePilotageMaxParPilote;
    }

    /**
     * Retourne la meteo
     * @return
     */
    public String getMeteo() {
            return meteo;
    }
    
    /**
     * Modifie la meteo
     * @param meteo
     */
    public void setMeteo(String meteo) {
            this.meteo = meteo;
    }

    /**
     * Renvoie le type de fin de la course
     * @return
     */
    public String getTypeFin() {
            return typeFin;
    }

    /**
     * Modifie le type de fin de la course
     * @param typeFin
     */
    public void setTypeFin(String typeFin) {
            this.typeFin = typeFin;
    }

    /**
     * Retourne le nombre maximum de tours de la course
     * @return
     */
    public int getNbToursMax() {
            return nbToursMax;
    }

    /**
     * Modifie le nombre maximum de tour de la course
     * @param nbToursMax
     */
    public void setNbToursMax(int nbToursMax) {
            this.nbToursMax = nbToursMax;
    }

    /**
     * Retourne la liste des tops
     * @return
     */
    public List<Top> getListT() {
            return listT;
    }

    /**
     * Retourne la liste des voitures
     * @return
     */
    public List<Voiture> getListV() {
            return listV;
    }

    /**
     * Retourne la voiture numero num
     * @param num
     * @return
     */
    public Voiture getUneVoiture(int num){
        for (Voiture v : listV){
            if(v.getNumVoiture()==num){
                return v;
            }
        }
        return null;
    }

    /**
     * Retourne le nombre de voitures inscrites
     * @return
     */
    public int getNbVoituresInscrites(){
        return this.listV.size();
    }

    /**
     * Methode qui genere un graphique
     * @param table
     */
    public void genererGaphique(DefaultTableModel table) {
        int[] voit = new int[listV.size()];
        for(int i=0;i<this.listV.size();i++){
            voit[i]=listV.get(i).getNumVoiture();
        }
        graphe = new GrapheCourse(this.nbToursMax,voit,table);
        graphe.genererGraphe(nomCourse);
    }
    
    /**
     * Retourne un graphique
     * @return
     */
    public ChartPanel getPanelGraphe(){
        return this.graphe.getPanelChart();
    }

    /**
     * Modifie la liste de voitures de la course
     * @param listV
     */
    public void setListV(List<Voiture> listV) {
        this.listV = listV;
    }
}
