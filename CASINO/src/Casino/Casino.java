package Casino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Casino {

	//Atributos que tiene un Casino
		/**
	 * TODO:EXPLICAR CADA ATRIBUTO
	 * 
	 */
	
	private int Codigo;
	
	private String Nombre;
	
	private boolean Ruleta;
	
	private boolean BlackJack;
	
	private boolean Tragaperras;
	
	private int Max_Jugadores;
	
	

	
	/**
	 * TODO: CREACION DE CASINO EN BASE DE DATOS Y AÑADIR CASINO (CREAR REALMENTE ES AÑADIR)
	 * 
	 */
	
	private static void crearCasino(Connection con)throws SQLException{
		try {
			PreparedStatement stm = con.prepareStatement("INSERT INTO CASINO () VALUES ()");
			
			//TODO
			stm.setInt(1, 0);
			

			stm.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo de nuevo.");
			
		}
		
		
		
	}
}
