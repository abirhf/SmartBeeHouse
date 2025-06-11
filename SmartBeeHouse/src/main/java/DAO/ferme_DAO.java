package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.ferme;

public class ferme_DAO {

	public void addFerme(ferme ferme) {
		String sql = "INSERT INTO ferme (nom, localisation, proprietaire) VALUES (?, ?, ?)";
		try (Connection conn = DAO_connection.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, ferme.getNom());
			ps.setString(2, ferme.getLocalisation());
			ps.setString(3, ferme.getProprietaire());
			ps.executeUpdate();
			System.out.println("Insertion réussie en base !");

		} catch (SQLException e) {
		    System.out.println(" Erreur SQL pendant insertion : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public ferme getFermeById(int id) {
		String sql = "SELECT * FROM ferme WHERE id = ?";
		ferme ferme = null;
		try (Connection conn = DAO_connection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ferme = new ferme(rs.getInt("id"), rs.getString("nom"), rs.getString("localisation"),rs.getString("proprietaire"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ferme;
	}

	public List<ferme> getAllFermes() {
		List<ferme> fermes = new ArrayList<>();
		String sql = "SELECT * FROM ferme";
		try (Connection conn = DAO_connection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				ferme ferme = new ferme(rs.getInt("id"), rs.getString("nom"), rs.getString("localisation"),
						rs.getString("proprietaire"));

				fermes.add(ferme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fermes;
	}

	public void updateFerme(ferme ferme) {
		String sql = "UPDATE ferme SET nom = ?, localisation = ?, proprietaire = ? WHERE id = ?";
		try (Connection conn = DAO_connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, ferme.getNom());
			ps.setString(2, ferme.getLocalisation());
			ps.setString(3, ferme.getProprietaire());
			ps.setInt(4, ferme.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFerme(int id) {
		String sql = "DELETE FROM ferme WHERE id = ?";
		try (Connection conn = DAO_connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
