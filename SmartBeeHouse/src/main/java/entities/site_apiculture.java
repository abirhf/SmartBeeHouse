package entities;
import java.util.*;


public class site_apiculture {



	    private int id;
	    private double latitude;
	    private double longitude;
	    private double altitude;
	    private Date dateCreation;
	    private Date dateCloture;
	    private int fermeId;


	    private List<ruche> ruches;



	    public site_apiculture(int id, double latitude, double longitude, double altitude,
	                          Date dateCreation, Date dateCloture, int fermeId) {
	        this.id = id;
	        this.latitude = latitude;
	        this.longitude = longitude;
	        this.altitude = altitude;
	        this.dateCreation = dateCreation;
	        this.dateCloture = dateCloture;
	        this.fermeId = fermeId;
	    }


	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public double getLatitude() { return latitude; }
	    public void setLatitude(double latitude) { this.latitude = latitude; }

	    public double getLongitude() { return longitude; }
	    public void setLongitude(double longitude) { this.longitude = longitude; }

	    public double getAltitude() { return altitude; }
	    public void setAltitude(double altitude) { this.altitude = altitude; }

	    public Date getDateCreation() { return dateCreation; }
	    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

	    public Date getDateCloture() { return dateCloture; }
	    public void setDateCloture(Date dateCloture) { this.dateCloture = dateCloture; }

	    public int getFermeId() { return fermeId; }
	    public void setFermeId(int fermeId) { this.fermeId = fermeId; }

	    public List<ruche> getRuches() { return ruches; }
	    public void setRuches(List<ruche> ruches) { this.ruches = ruches; }
	

	
}
