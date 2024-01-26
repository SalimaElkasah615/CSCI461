package BDD;

import java.sql.*;


public class TestConnection {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		Connection connexion = null;
		try {
		// Chargement du Driver
		Class.forName("com.mysql.jdbc.Driver");
		// Connexion a la base de donnees
		connexion = DriverManager.getConnection(url, username, password);
		System.out.println("Connexion établie");
		// Créer un conteneur de requete
		Statement status = connexion.createStatement();
		String requete = "INSERT INTO personne(nni, nom, prenom) VALUES(12130006, 'fatima', 'salem');";
		// Execution de la requete
		status.executeUpdate(requete);
		System.out.println("Requete réussie");
		} catch (ClassNotFoundException e) {
		System.out.println("Erreur de Driver");
		} catch (SQLException e) {
		System.out.println("Erreur SQL");
		}
	}
}

   