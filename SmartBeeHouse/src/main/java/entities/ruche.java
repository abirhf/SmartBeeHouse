package entities;

public class ruche {

	private int id;
	private int nbEtages;
	private int nbCadres;
	private String etat;
	private int productivite;
	private int siteId;

	public ruche(int id, int nbEtages, int nbCadres, String etat, int productivite, int siteId) {
		this.id = id;
		this.nbEtages = nbEtages;
		this.nbCadres = nbCadres;
		this.etat = etat;
		this.productivite = productivite;
		this.siteId = siteId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbEtages() {
		return nbEtages;
	}

	public void setNbEtages(int nbEtages) {
		this.nbEtages = nbEtages;
	}

	public int getNbCadres() {
		return nbCadres;
	}

	public void setNbCadres(int nbCadres) {
		this.nbCadres = nbCadres;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getProductivite() {
		return productivite;
	}

	public void setProductivite(int productivite) {
		this.productivite = productivite;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

}
