package mr.liu.dao;

import mr.liu.dbb.DBConnection;
import mr.liu.metier.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class employeentrepriseDao implements Dao<employeentreprise> {
	private Connection conn;
	public employeentrepriseDao() {
		try {
			conn = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get
	public employeentreprise get(long id) {
		employeentreprise ementr = null;
		String requet = "SELECT * FROM employeentreprise WHERE numero = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int idEntreprise = rs.getInt("IDentreprise");
				int numero = rs.getInt("numero");
				String contrat = rs.getString("contrat");
				ementr = new employeentreprise(idEntreprise, numero, contrat);
				System.out.println(ementr.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return ementr;
	}
	//get all
	public List<employeentreprise> getAll() {
		employeentreprise ementr = null;
		ArrayList<employeentreprise> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM employeentreprise";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idEntreprise = rs.getInt("IDentreprise");
					int numero = rs.getInt("numero");
					String contrat = rs.getString("contrat");
					ementr = new employeentreprise(idEntreprise, numero, contrat);
					arrayList.add(ementr);
					System.out.println(ementr.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}
	//save 
	public void save(employeentreprise t) {
		String requet = "INSERT INTO employeentreprise(IDentreprise, numero, contrat) VALUES("+t.getIdEntreprise()+", "+t.getNumero()+", '"+t.getContrat()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\temployeentreprise enregistree !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
	}
	//update
	public void update(employeentreprise t, String[] params) {
		String requet = "UPDATE employeentreprise SET numero='"+params[0]+"', "
						+ "IDentreprise='"+params[1]+"' "
						+ "contrat='"+params[2]+"' "
						+ "WHERE idEntreprise = " + (int) t.getIdEntreprise()
						+ " and numero = " + (int) t.getNumero();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\temployeentreprise modifiee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification echouee");
			e.printStackTrace();
		}
	}
	//delet
	public void delete(employeentreprise t) {
		String requet = "DELETE FROM employeentreprise WHERE IDentreprise = " + (int) t.getIdEntreprise() 
						+ " and numero = " + (int) t.getNumero();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\temployeentreprise supprimee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
	}
	
	//main
	public static void main(String[] args) {
		
		System.out.println("Test de methode select by id");
		new employeentrepriseDao().get(124);// get by id
		System.out.println("Test de methode insertion");
		new employeentrepriseDao().save(new employeentreprise(13, 125, "ABD"));;// insert
		System.out.println("Test de methode select * all ");
		new employeentrepriseDao().getAll();// get all
		// update
		// delete
	}
	
}

