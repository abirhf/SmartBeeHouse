package entities;

import java.util.List;

public class ferme {

	private int id;
	private String nom;
	private String localisation;
	private String proprietaire;

	private List<site_apiculture> sites;

	public ferme(int id, String nom, String localisation, String proprietaire) {
		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
		this.proprietaire = proprietaire;
	}

	   public ferme(String nom, String localisation, String proprietaire) {
	        this.nom = nom;
	        this.localisation = localisation;
	        this.proprietaire = proprietaire;
	    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<site_apiculture> getSites() {
		return sites;
	}

	public void setSites(List<site_apiculture> sites) {
		this.sites = sites;
	}

}
