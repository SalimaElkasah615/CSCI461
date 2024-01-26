package mr.liu.dao;
import mr.liu.dbb.DBConnection;
import mr.liu.metier.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseDao implements Dao<Entreprise> {
	private Connection conn;
	public EntrepriseDao() {
		try {
			conn = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Entreprise get(long id) {
		Entreprise entreprise = null;
		String requet = "SELECT * FROM entreprise WHERE IDentreprise = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int idEntreprise = rs.getInt("IDentreprise");
				String nom = rs.getString("nom");
				String siege = rs.getString("siege");
				entreprise = new Entreprise(idEntreprise, nom, siege);
				System.out.println(entreprise.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return entreprise;
	}
	@Override
	public List<Entreprise> getAll() {
		Entreprise entreprise = null;
		ArrayList<Entreprise> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM entreprise";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idEntreprise = rs.getInt("IDentreprise");
					String nom = rs.getString("nom");
					String siege = rs.getString("siege");
					entreprise = new Entreprise(idEntreprise, nom, siege);
					arrayList.add(entreprise);
					System.out.println(entreprise.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}
	@Override
	public void save(Entreprise t) {
		String requet = "INSERT INTO Entreprise(IDentreprise, nom, siege) VALUES("+t.getIDentreprise()+", '"+t.getNom()+"', '"+t.getSiege()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEntreprise enregistree !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
	}
	@Override
	public void update(Entreprise t, String[] params) {
		String requet = "UPDATE entreprise SET nom='"+params[0]+"', "
						+ "siege='"+params[1]+"' "
						+ "WHERE IDentreprise= " + (int) t.getIDentreprise();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEntreprise modifiee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification echouee");
			e.printStackTrace();
		}
	}
	@Override
	public void delete(Entreprise t) {
		String requet = "DELETE FROM entreprise WHERE IDentreprise = " + (int) t.getIDentreprise();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tEntreprise supprimee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression �chou�e");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("Test de methode select by id");
		new EntrepriseDao().get(12);// select get by id
		System.out.println("Test de methode insertion");
		new EntrepriseDao().save(new Entreprise(13, "fatima", "B"));;// insert
		System.out.println("Test de methode select * all ");
		new EntrepriseDao().getAll();// get qll
		// update
		// delete
		
		
	}
	

}
