package Casino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bases_de_datos {
	
	/**
	 * Crear Tabla para Usuarios, Casinos y Ruleta
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
	    	Connection connection = getConnection();
	        Statement stmt = connection.createStatement();
	        // stmt.executeUpdate("DROP TABLE IF EXISTS ticks");  // Si se quiere iniciar la tabla desde 0
	        try {
	        	stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
	        } catch (SQLException e) {
	        	System.out.println( "La tabla ya existe" );
	        }
	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
	        while (rs.next()) {
	            System.out.println("Read from DB: " + rs.getTimestamp("tick"));
	        }
	    }
	    
	    private static Connection getConnection() {
	    	Connection conn = null;
	    	try {
	    		Class.forName("org.postgresql.Driver");
	        	String username = "lutlguupyxaacs";
	        	String password = "1lHe5gdoxB5tw0--Uc7JhREVRO";
	        	String urldB = "lutlguupyxaacs:1lHe5gdoxB5tw0--Uc7JhREVRO@ec2-54-247-189-141.eu-west-1.compute.amazonaws.com:5432/d8gjna03783fk7";
	        	String dbUrl = "jdbc:postgresql://" + urldB + "?sslmode=require";
	    		conn = DriverManager.getConnection( dbUrl, username, password );
	    	} catch (Exception e) { e.printStackTrace(); }        
	    	return conn;
	    }

}
