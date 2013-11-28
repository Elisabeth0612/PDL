package modele;

import java.util.*;


public class Course {
	
	private EvenementSportif evt;
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

	public Course(EvenementSportif evt,String nomCourse,Date heureDeb, Date heureFin, int dureePilotageMaxParPilote, int dureeConsecutivePilotageMaxParPilote, String meteo, int nbToursMax, String typeFin){
		this.evt=evt;
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
	
	public void modifierCourse(EvenementSportif evt,String nomCourse,Date heureDeb, Date heureFin, int dureePilotageMaxParPilote, int dureeConsecutivePilotageMaxParPilote, String meteo, int nbToursMax, String typeFin){
		setEvt(evt);
		setNomCourse(nomCourse);
		setHeureDeb(heureDeb);
		setHeureFin(heureFin);
		setDureePilotageMaxParPilote(dureePilotageMaxParPilote);
		setDureeConsecutivePilotageMaxParPilote(dureeConsecutivePilotageMaxParPilote);
		setMeteo(meteo);
		setTypeFin(typeFin);
		setNbToursMax(nbToursMax);
	}
	
	public void addListT(Top t){
		if (!listT.contains(t)){
			listT.add(t);
		}
	}
	
	public void removeListT(Top t){
		listT.remove(t);
	}
	
	public void addListV(Voiture v){
		if (!listV.contains(v)){
			listV.add(v);
		}
	}
	
	public void removeListV(Voiture v){
		listV.remove(v);
	}

	public EvenementSportif getEvt() {
		return evt;
	}

	public void setEvt(EvenementSportif evt) {
		this.evt = evt;
	}

	public String getNomCourse() {
		return nomCourse;
	}

	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}

	public Date getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public int getDureePilotageMaxParPilote() {
		return dureePilotageMaxParPilote;
	}

	public void setDureePilotageMaxParPilote(int dureePilotageMaxParPilote) {
		this.dureePilotageMaxParPilote = dureePilotageMaxParPilote;
	}

	public int getDureeConsecutivePilotageMaxParPilote() {
		return dureeConsecutivePilotageMaxParPilote;
	}

	public void setDureeConsecutivePilotageMaxParPilote(
			int dureeConsecutivePilotageMaxParPilote) {
		this.dureeConsecutivePilotageMaxParPilote = dureeConsecutivePilotageMaxParPilote;
	}

	public String getMeteo() {
		return meteo;
	}

	public void setMeteo(String meteo) {
		this.meteo = meteo;
	}

	public String getTypeFin() {
		return typeFin;
	}

	public void setTypeFin(String typeFin) {
		this.typeFin = typeFin;
	}

	public int getNbToursMax() {
		return nbToursMax;
	}

	public void setNbToursMax(int nbToursMax) {
		this.nbToursMax = nbToursMax;
	}

	public List<Top> getListT() {
		return listT;
	}

	public List<Voiture> getListV() {
		return listV;
	}
}
