package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.ruche;
public class ruche_DAO {




	    public void addRuche(ruche ruche) {
	        String sql = "INSERT INTO ruche (nb_etages, nb_cadres, etat, productivite, site_id) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn =  DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, ruche.getNbEtages());
	            ps.setInt(2, ruche.getNbCadres());
	            ps.setString(3, ruche.getEtat());
	            ps.setInt(4, ruche.getProductivite());
	            ps.setInt(5, ruche.getSiteId());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erreur SQL : " + e.getMessage());

	        }
	    }


	    public ruche getRucheById(int id) {
	        String sql = "SELECT * FROM ruche WHERE id = ?";
	        ruche ruche = null;

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                ruche = new ruche(rs.getInt("id"),rs.getInt("nb_etages"),rs.getInt("nb_cadres"),rs.getString("etat"),rs.getInt("productivite"),rs.getInt("site_id"));

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ruche;
	    }


	    public List<ruche> getAllRuches() {
	        List<ruche> ruches = new ArrayList<>();
	        String sql = "SELECT * FROM ruche";

	        try (Connection conn =  DAO_connection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                ruche ruche = new ruche(rs.getInt("id"),rs.getInt("nb_etages"),rs.getInt("nb_cadres"),rs.getString("etat"),rs.getInt("productivite"),rs.getInt("site_id"));


	                ruches.add(ruche);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ruches;
	    }




	    public void updateRuche(ruche ruche) {
	        String sql = "UPDATE ruche SET nb_etages = ?, nb_cadres = ?, etat = ?, productivite = ?, site_id = ? WHERE id = ?";

	        try (Connection conn =  DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, ruche.getNbEtages());
	            ps.setInt(2, ruche.getNbCadres());
	            ps.setString(3, ruche.getEtat());
	            ps.setInt(4, ruche.getProductivite());
	            ps.setInt(5, ruche.getSiteId());
	            ps.setInt(6, ruche.getId());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void deleteRuche(int id) {
	        String sql = "DELETE FROM ruche WHERE id = ?";

	        try (Connection conn = DAO_connection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public Map<Integer, Integer> getNombreRuchesParSite() {
	        Map<Integer, Integer> resultats = new HashMap<>();
	        String sql = "SELECT site_id, COUNT(*) as total FROM ruche GROUP BY site_id";

	        try (Connection conn = DAO_connection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                int siteId = rs.getInt("site_id");
	                int total = rs.getInt("total");
	                resultats.put(siteId, total);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return resultats;
	    }

}
