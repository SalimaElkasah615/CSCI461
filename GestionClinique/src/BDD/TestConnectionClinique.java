package BDD;
	import java.sql.*;
public class TestConnectionClinique {
	
		static String url = "jdbc:mysql://localhost:3306/clinic";
		static String username = "root";
		static String password = "";
		static Connection connexion = null;
		
		public static void main(String[] args) {
			try {
				//
				Class.forName("com.mysql.jdbc.Driver");
				//
				connexion = DriverManager.getConnection(url, username, password);
				System.out.println("Connection established");
				//
				insertion();
				System.out.println("Insertions completed successfully");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Error");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL error");
				e.printStackTrace();
			}
		}
		
		private static void insertion() throws SQLException {
			//
			setPersonne(0101, "Salima", "elka");
			setPersonne(0202, "Fadel", "salem");
			setPersonne(0303, "Mahmoud", "fadel");
			setPersonne(0404, "Ahmed", "omar");
			setPersonne(0505, "Salem", "ahmed");
			
			//
			setMedecin(0101, 01, "surgeon");
			setMedecin(0202, 02, "Orthopedic doctor");
			setMedecin(0303, 03, "pediatrician");
			setMedecin(0404, 04, "General Doctor");
			setMedecin(0505, 05, "Anesthetist");
			//
			setPatient(0101, 001, "Migraine");
			setPatient(0202, 002, "sensitive");
			setPatient(0303, 003, "sinuses");
			setPatient(0404, 004, "Belly pain");
			setPatient(0505, 005, "Weakness of view");
			//
			setMedicament(456, "Panadol");
			setMedicament(757, "Panadol");
			setMedicament(568, "Panadol");
			setMedicament(468, "Panadol");
			setMedicament(864, "Panadol");
		}
		
		public static void setPersonne(int nni, String nom, String prenom) throws SQLException {
			Statement status = connexion.createStatement();
			String requete = "INSERT INTO Personne(NNI, Nom, Prenom) VALUES("+nni+", '"+nom+"', '"+prenom+"');";
			status.executeUpdate(requete);
			System.out.println("Personne "+nni+" inserted");
			status.close();
		}
		
		public static void setMedecin(int nni, int idm, String specialite) throws SQLException {
			Statement status = connexion.createStatement();
			String requete = "INSERT INTO Medecin(NNI, IDm, specialite) "
					+ "VALUES("+nni+", "+idm+", '"+specialite+"');";
			status.executeUpdate(requete);
			System.out.println("Medecin "+idm+"inserted");
			status.close();
		}

		public static void setPatient(int nni, int idp, String canm) throws SQLException {
			Statement status = connexion.createStatement();
			String requete = "INSERT INTO Patient(NNI,IDP, CANM) "
					+ "VALUES("+nni+", "+idp+", '"+canm+"');";
			status.executeUpdate(requete);
			System.out.println("Patient "+idp+"inserted");
			status.close();
		}

		public static void setMedicament(int codeM, String libellet) throws SQLException {
			Statement status = connexion.createStatement();
			String requete = "INSERT INTO Medicament(codeM, libellet) "
					+ "VALUES("+codeM+", '"+libellet+"');";
			status.executeUpdate(requete);
			System.out.println("Medicament "+codeM+"inserted");
			status.close();
		}
	}

