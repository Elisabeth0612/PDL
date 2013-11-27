package modele;

import java.util.*;


public class Voiture {

	private List<Pilote> listP;
	private int numVoiture;
	private Pilote piloteActuel;
	private String couleur;
	private int nbToursParRelai; //nb de tours avant changement de pilote
	private Voiture voitureActive;
	
	public Voiture(int numVoiture, Pilote piloteActuel, String couleur, int nbToursParRelai, Voiture voitureActive){
		this.numVoiture=numVoiture;
		this.piloteActuel=piloteActuel;
		this.listP=new ArrayList<Pilote>();
		this.couleur=couleur;
		this.nbToursParRelai=nbToursParRelai;
		this.voitureActive=voitureActive;
	}
	
	public void modifierVoiture(Pilote piloteActuel, String couleur, int nbToursParRelai, Voiture voitureActive){
		setPiloteActuel(piloteActuel);
		setCouleur(couleur);
		setNbToursParRelai(nbToursParRelai);
		setVoitureActive(voitureActive);
	}
	
	public void addListT(Pilote p){
		if (!listP.contains(p)){
			listP.add(p);
		}
	}
	
	public void removeListT(Voiture p){
		listP.remove(p);
	}
	
	public void removeVoiture(List<Voiture> listV){
		listV.remove(this);
	}
	
	public int getNumVoiture() {
		return numVoiture;
	}

	public void setNumVoiture(int numVoiture) {
		this.numVoiture = numVoiture;
	}

	public Pilote getPiloteActuel() {
		return piloteActuel;
	}

	public void setPiloteActuel(Pilote piloteActuel) {
		this.piloteActuel = piloteActuel;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNbToursParRelai() {
		return nbToursParRelai;
	}

	public void setNbToursParRelai(int nbToursParRelai) {
		this.nbToursParRelai = nbToursParRelai;
	}

	public Voiture getVoitureActive() {
		return voitureActive;
	}

	public void setVoitureActive(Voiture voitureActive) {
		this.voitureActive = voitureActive;
	}

	public List<Pilote> getListP() {
		return listP;
	}

	public void modifierVoiture(){

	}
}
