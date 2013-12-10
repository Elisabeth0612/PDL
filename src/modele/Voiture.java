package modele;

import java.util.*;


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE grpe 1A
 */
public class Voiture{

	private List<Pilote> listP;
	private int numVoiture;
	private Pilote piloteActuel;
	private String couleur;
	private int nbToursParRelai; //nb de tours avant changement de pilote
	private boolean voitureActive;
        
	
    /**
     * Instanciation d'une voiture
     * 
     * @param numVoiture int
     * @param piloteActuel Pilote
     * @param couleur String
     * @param nbToursParRelai int
     * @param voitureActive Voiture
     */
    public Voiture(int numVoiture, Pilote piloteActuel, String couleur, int nbToursParRelai, boolean voitureActive){
		this.numVoiture=numVoiture;
		this.piloteActuel=piloteActuel;
		this.listP=new ArrayList<Pilote>();
		this.couleur=couleur;
		this.nbToursParRelai=nbToursParRelai;
		this.voitureActive=voitureActive;
	}
        
        public Voiture(int numVoiture, String couleur, int nbToursParRelai, boolean voitureActive){
		this.numVoiture=numVoiture;
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
            listP = new ArrayList<Pilote>();
            for(Pilote p:lesPTemp){
                listP.add(new Pilote(p.getNom(),p.getPrenom(),p.getCouleursCasque()));
            }
        }
        
        public boolean existListP(){
            return listP.size()!=0;
        }

	public void modifierVoiture(){

	}

    public Pilote trouverUnPilote(String nom, String prenom) {
        for(Pilote p : listP){
            if(p.getNom().compareTo(nom)==0 && p.getPrenom().compareTo(prenom)==0)return p;
        }
        return null;
    }
}
