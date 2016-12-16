package Casino.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexión_BD {
	    
	   
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
