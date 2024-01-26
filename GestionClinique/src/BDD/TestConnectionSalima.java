package BDD;
import java.sql.*;
//Sans les fonctions
public class TestConnectionSalima {
	
		public static void main(String[] args) {
			String url = "jdbc:mysql://localhost:3306/Salimaclinic";
			String username = "root";
			String password = "";
			Connection connexion = null;
			try {
				//
				Class.forName("com.mysql.jdbc.Driver");
				//
				connexion = DriverManager.getConnection(url, username, password);
				System.out.println("Connection established");
				//
				Statement status = connexion.createStatement();
				//
				String requete = "INSERT INTO Personne(nni, nom, prenom) "
						+ "VALUES(1213, 'Salima', 'A')"
						+ ",(1415, 'Ahmed', 'B')"
						+ ",(1617, 'Fadel', 'C')"
						+ ",(1819, 'mohammed', 'D')"
						+ ",(1011, 'salem', 'E')";
				status.executeUpdate(requete);
				System.out.println("Successful personne insertion");
				//
				requete = "INSERT INTO Medecin(nni, idm, specialite) "
						+ "VALUES(1213, 01, 'surgeon')"
						+ ",(1415, 02, 'Orthopedic doctor')"
						+ ",(1617, 03, 'pediatrician')"
						+ ",(1819, 04, 'General Doctor')"
						+ ",(1011, 05, 'Anesthetist');";
				status.executeUpdate(requete);
				System.out.println("Successful Medecin insertion");
				//
				requete = "INSERT INTO Patient(nni, idp, canm) "
						+ "VALUES(1213, 001, 'Migraine')"
						+ ",(1415, 002, 'sensitive')"
						+ ",(1617, 003, 'sinuses')"
						+ ",(1819, 004, 'Belly pain')"
						+ ",(1011, 005, 'Weakness of view');";
				status.executeUpdate(requete);
				System.out.println("Successful patient insertion");
				//
				requete = "INSERT INTO Medicament(codeM, libellet) "
						+ "VALUES(456, 'Panadol')"
						+ ",(757, 'Panadol')"
						+ ",(568, 'Panadol')"
						+ ",(468, 'Panadol')"
						+ ",(864, 'Panadol');";
				status.executeUpdate(requete);
				System.out.println("Successful Medicament insertion");
				
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Error");
			} catch (SQLException e) {
				System.out.println("SQL error");
			}
		}
	}
	

