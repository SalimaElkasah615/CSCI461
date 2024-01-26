package DAO;



	import java.sql.*;

	public class DBConnection {
		private static DBConnection instance;
		private Connection connection;
		private String url = "jdbc:mysql://localhost:3306/clinic";
		private String username = "root";
		private String password = "";
		private DBConnection() throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.connection = DriverManager.getConnection(url,
						username, password);
				System.out.println("Connection etablie");
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println("Erreur du Driver : " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Erreur SQL : " + e.getMessage());
			}
		}
		public Connection getConnection() {
			return connection;
		}
		public static DBConnection getInstance() throws SQLException {
			if (instance == null) {
				instance = new DBConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DBConnection();
			}
			return instance;
		}
		
		public static void main(String[] args) throws SQLException {
//			DBConnection.getInstance().getConnection();
			
			// Chargement du Driver
			try {
				Class.forName("com.sql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
			}
			
		}
	}


