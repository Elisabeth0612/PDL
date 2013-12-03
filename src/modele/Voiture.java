package modele;

import java.util.*;


public class Voiture {

	private List<Pilote> listP;
	private int numVoiture;
	private Pilote piloteActuel;
	private String couleur;
	private int nbToursParRelai; //nb de tours avant changement de pilote
	private boolean voitureActive;
	
	public Voiture(int numVoiture, Pilote piloteActuel, String couleur, int nbToursParRelai, boolean voitureActive){
		this.numVoiture=numVoiture;
		this.piloteActuel=piloteActuel;
		this.listP=new ArrayList<Pilote>();
		this.couleur=couleur;
		this.nbToursParRelai=nbToursParRelai;
		this.voitureActive=voitureActive;
	}
	
	public void modifierVoiture(Pilote piloteActuel, String couleur, int nbToursParRelai, boolean voitureActive){
		setPiloteActuel(piloteActuel);
		setCouleur(couleur);
		setNbToursParRelai(nbToursParRelai);
		setVoitureActive(voitureActive);
	}
	
	public void addListP(Pilote p){
		if (!listP.contains(p)){
			listP.add(p);
		}
	}
	
	public void removeListP(Pilote p){
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

	public boolean getVoitureActive() {
		return voitureActive;
	}

	public void setVoitureActive(boolean voitureActive) {
		this.voitureActive = voitureActive;
	}

	public List<Pilote> getListP() {
		return listP;
	}
        
        public void setListP(List<Pilote> lesPTemp){
            listP=lesPTemp;
        }
        
        public boolean existListP(){
            System.out.println("ok");
            return listP.size()!=0;
        }

	public void modifierVoiture(){

	}
}
