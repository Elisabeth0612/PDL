package modele;

import java.util.List;


public class Pilote {

	private String nom, prenom, couleursCasque;
	
	public Pilote(String nom, String prenom, String couleursCasque){
		this.nom=nom;
		this.prenom=prenom;
		this.couleursCasque=couleursCasque;
	}

	public void removePilote(List<Pilote> listP){
		listP.remove(this);
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCouleursCasque() {
		return couleursCasque;
	}

	public void setCouleursCasque(String couleursCasque) {
		this.couleursCasque = couleursCasque;
	}
}
