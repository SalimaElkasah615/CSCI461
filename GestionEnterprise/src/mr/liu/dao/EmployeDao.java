package mr.liu.dao;

import mr.liu.dbb.DBConnection;
import mr.liu.metier.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class EmployeDao implements Dao<Employe> {
	private Connection conn= null;
	
	public EmployeDao() {
		try {
			conn = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//methode get
	public Employe get(long id) {
		Employe employe = null;
		String requet = "SELECT * FROM employee WHERE numero = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int numero = rs.getInt("numero");
				String nom = rs.getString("nom");
				String grade = rs.getString("grade");
				String nomDepartment = rs.getString("nomDepartment");
				employe = new Employe(numero, nom, grade, nomDepartment);
				System.out.println(employe.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return employe;	
	}
	
//get all
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		Employe employe = null;
		ArrayList<Employe> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM employee";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int numero = rs.getInt("numero");
					String nom = rs.getString("nom");
					String grade = rs.getString("grade");
					String nomDepartment = rs.getString("nomDepartment");
					employe = new Employe(numero, nom, grade, nomDepartment);
					arrayList.add(employe);
					System.out.println(employe.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}
	@Override
	public void save(Employe t) {
		String requet = "INSERT INTO employee(numero, nom, grade, nomDepartment) VALUES('"+t.getNumero()+"', '"+t.getNom()+"', '"+t.getGrade()+"', '"+t.getnomDepartment()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEmploye enregistre !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
	}
	@Override
	public void update(Employe t, String[] params) {
		String requet = "UPDATE employee SET nom='"+params[0]+"', "
						+ "grade='"+params[1]+"' "
						+ "nomDepartment='"+params[1]+"' "
						+ "WHERE numero = " + (int) t.getNumero();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEmploye modifie !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification echouee");
			e.printStackTrace();
		}
	}
//
	public void delete(Employe t) {
		String requet = "DELETE FROM employee WHERE numero = " + (int) t.getNumero();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEmploye supprime !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
	}
//
		public static void main(String[] args) {
			System.out.println("Test de methode select by id");
			new EmployeDao().get(123);// get by id
			System.out.println("Test de methode insertion");
			new EmployeDao().save(new Employe(125, "fatima", "2", "info"));;// insert
			System.out.println("Test de methode select * all ");
			new EmployeDao().getAll();// get qll
			// update
			// delete
	}
}
