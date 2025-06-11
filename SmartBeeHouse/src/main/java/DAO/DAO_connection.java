package DAO;

import java.sql.*;

public class DAO_connection {
    private static final String URL = "jdbc:mysql://localhost:3306/smart_bee_house";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(" Le driver JDBC est introuvable !");
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connexion = getConnection();
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println(" Échec de la connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
