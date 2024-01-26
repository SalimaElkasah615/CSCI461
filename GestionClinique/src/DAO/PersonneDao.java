package DAO;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
import java.util.Optional;

import metier.Personne;

	public class PersonneDao implements Dao<Personne> {
		private static final Optional<Personne> Personne = null;
		private Connection conn;
		public PersonneDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public Optional<Personne> get(long id) {
			Personne personne = null;
			String requet = "SELECT * FROM personne WHERE nni = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int nni = rs.getInt("nni");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					personne = new Personne(nni, nom, prenom);
					System.out.println(personne.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return Personne;
		}
		@Override
		public List<Personne> getAll() {
			// TODO Auto-generated method stub
			Personne personne = null;
			ArrayList<Personne> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM personne";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int nni = rs.getInt("nni");
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						personne = new Personne(nni, nom, prenom);
						arrayList.add(personne);
						System.out.println(personne.toString());
						System.out.println();
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		@Override
		public void save(Personne t) {
			String requet = "INSERT INTO Personne(nni, nom, prenom) VALUES("+t.getNNI()+", '"+t.getNom()+"', '"+t.getPrenom()+"')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tPersonne enregistr�e !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}
		}
		@Override
		public void update(Personne t, String[] params) {
			String requet = "UPDATE personne SET nom='"+params[0]+"', "
							+ "prenom='"+params[1]+"' "
							+ "WHERE nni = " + (int) t.getNNI();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tPersonne modifi�e !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}
		}
		@Override
		public void delete(Personne t) {
			String requet = "DELETE FROM personne WHERE nni = " + (int) t.getNNI();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tPersonne supprimee !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			PersonneDao pdao = new PersonneDao();
			Personne p = new Personne(65, "Salima", "elka");
			pdao.save(p);
			pdao.get(p.getNNI());
			pdao.update(p, new String[] {"Hala", "elkasa"});
			pdao.get(p.getNNI());
			pdao.delete(p);
		}
		
	
}
