package mr.liu.dao;

import mr.liu.dbb.DBConnection;
import mr.liu.metier.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//

public class DepartementDao implements Dao<Departement> {
	private Connection conn = null;

	public DepartementDao() {
		try {
			conn = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Departement get(String nomDepartment) {
		Departement departement = null;
		String requet = "SELECT * FROM Departement WHERE nomDepartment = '" + nomDepartment + "'";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				String nomDep = rs.getString("nomDepartment");
				String localisation = rs.getString("localisation");
				departement = new Departement(nomDep, localisation);
				System.out.println(departement.toString());
				System.out.println();
			} else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return departement;
	}

	@Override
	public Departement get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Departement departement) {
		String requet = "INSERT INTO Departement(nomDepartment, localisation) VALUES('" + departement.getNomDepartment()
				+ "', '" + departement.getLocalisation() + "')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tDepartement enregistre !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Departement departement, String[] params) {
		String requet = "UPDATE Departement SET " + "localisation='" + params[0] + "' " + "WHERE nomDepartement = '"
				+ departement.getNomDepartment() + "'";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tDepartement modifie !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification echouee");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Departement departement) {
		String requet = "DELETE FROM Departement WHERE nomDepartment = '" + departement.getNomDepartment() + "'";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tDepartement supprime !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}

	}

//get string

//get all
	@Override
	public List<Departement> getAll() {
		Departement departement = null;
		ArrayList<Departement> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Departement";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					String nomDepartment = rs.getString("nomDepartment");
					String localisation = rs.getString("localisation");
					departement = new Departement(nomDepartment, localisation);
					arrayList.add(departement);
					System.out.println(departement.toString());
				} while (rs.next());
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

//test main
	public static void main(String[] args) {
		System.out.println("Test de methode select by id");
		new DepartementDao().get("info");// get by id
		System.out.println("Test de methode insertion");
		new DepartementDao().save(new Departement("computer scince", "FST"));
		;// insert
		System.out.println("Test de methode select * all ");
		new DepartementDao().getAll();// get qll
		// update
		// delete

	}
}
