
	////
package BDD;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DbConnection {

	private static DbConnection instance; 
	private Connection connection; 
	private String url = "jdbc:mysql://localhost:3306/test"; 
	private String username = "root"; 
	private String password = ""; 
	private DbConnection() throws SQLException { 
	 try { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 this.connection = DriverManager.getConnection(url, 
	username, password); 
	 System.out.println("Connection etablie"); 
	 } catch (ClassNotFoundException ex) { 
	 System.out.println("Something is wrong with the DB connection String : " + ex.getMessage()); 
	 } 
	
	 } 
	public Connection getConnection() { 
	 return connection; 
	 } 
	public static DbConnection getInstance() throws SQLException { 
	 if (instance == null) { 
	 instance = new DbConnection(); 
	 } else if (instance.getConnection().isClosed()) { 
	 instance = new DbConnection(); 
	 } 
	 return instance; 
	 } 
	
	public static void main(String[] args) throws SQLException { 

		try { 
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			} catch ( ClassNotFoundException e ) {
			}}}
	
