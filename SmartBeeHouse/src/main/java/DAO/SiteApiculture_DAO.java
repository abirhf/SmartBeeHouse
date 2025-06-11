package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.site_apiculture;
public class SiteApiculture_DAO {




	    // CREATE
	    public void addSite(site_apiculture site) {
	        String sql = "INSERT INTO site_apiculture (latitude, longitude, altitude, date_creation, date_cloture, ferme_id) VALUES (?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setDouble(1, site.getLatitude());
	            ps.setDouble(2, site.getLongitude());
	            ps.setDouble(3, site.getAltitude());
	            ps.setDate(4, new java.sql.Date(site.getDateCreation().getTime()));
				System.out.println("Insertion réussie en base !");

	            if (site.getDateCloture() != null) {
	                ps.setDate(5, new java.sql.Date(site.getDateCloture().getTime()));
	            } else {
	                ps.setNull(5, Types.DATE);
	            }

	            ps.setInt(6, site.getFermeId());
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // READ BY ID
	    public site_apiculture getSiteById(int id) {
	        String sql = "SELECT * FROM site_apiculture WHERE id = ?";
	        site_apiculture site = null;

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                site = new site_apiculture(rs.getInt("id"),rs.getDouble("latitude"),rs.getDouble("longitude"),rs.getDouble("altitude"),rs.getDate("date_creation"),rs.getDate("date_cloture"),rs.getInt("ferme_id"));
	
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return site;
	    }

	    // READ ALL
	    public List<site_apiculture> getAllSites() {
	        List<site_apiculture> sites = new ArrayList<>();
	        String sql = "SELECT * FROM site_apiculture";

	        try (Connection conn = DAO_connection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	               site_apiculture site = new site_apiculture(rs.getInt("id"),rs.getDouble("latitude"),rs.getDouble("longitude"),rs.getDouble("altitude"),rs.getDate("date_creation"),rs.getDate("date_cloture"),rs.getInt("ferme_id"));


	                sites.add(site);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return sites;
	    }

	    // READ BY FERME_ID
	    public List<site_apiculture> getSitesByFermeId(int fermeId) {
	        List<site_apiculture> sites = new ArrayList<>();
	        String sql = "SELECT * FROM site_apiculture WHERE ferme_id = ?";

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, fermeId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	               site_apiculture site = new site_apiculture(rs.getInt("id"),rs.getDouble("latitude"),rs.getDouble("longitude"),rs.getDouble("altitude"),rs.getDate("date_creation"),rs.getDate("date_cloture"),rs.getInt("ferme_id"));

	      

	                sites.add(site);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return sites;
	    }

	    public int getNombreSitesParFermeId(int fermeId) {
	        String sql = "SELECT COUNT(*) AS total FROM site_apiculture WHERE ferme_id = ?";
	        int count = 0;

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, fermeId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                count = rs.getInt("total");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return count;
	    }

	    
	    // UPDATE
	    public void updateSite(site_apiculture site) {
	        String sql = "UPDATE site_apiculture SET latitude = ?, longitude = ?, altitude = ?, date_creation = ?, date_cloture = ?, ferme_id = ? WHERE id = ?";

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setDouble(1, site.getLatitude());
	            ps.setDouble(2, site.getLongitude());
	            ps.setDouble(3, site.getAltitude());
	            ps.setDate(4, new java.sql.Date(site.getDateCreation().getTime()));

	            if (site.getDateCloture() != null) {
	                ps.setDate(5, new java.sql.Date(site.getDateCloture().getTime()));
	            } else {
	                ps.setNull(5, Types.DATE);
	            }

	            ps.setInt(6, site.getFermeId());
	            ps.setInt(7, site.getId());

	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // DELETE
	    public void deleteSite(int id) {
	        String sql = "DELETE FROM site_apiculture WHERE id = ?";

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public Map<Integer, Integer> getNombreSitesParFerme() {
	        Map<Integer, Integer> resultats = new HashMap<>();
	        String sql = "SELECT ferme_id, COUNT(*) AS total FROM site_apiculture GROUP BY ferme_id";

	        try (Connection conn = DAO_connection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                int fermeId = rs.getInt("ferme_id");
	                int total = rs.getInt("total");
	                resultats.put(fermeId, total);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return resultats;
	    }


}
