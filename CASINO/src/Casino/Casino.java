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
	
	public int Codigo;
	
	private String Nombre;
	
	private boolean Ruleta;
	
	private boolean BlackJack;
	
	private boolean Tragaperras;
	
	private int Max_Jugadores;
	
	
	
	/////////////////////////
	//Método sin parámetros//
	/////////////////////////
	public Casino() {
		super();
		Codigo = 0;
		Nombre = "";
		Ruleta = false;
		BlackJack = false;
		Tragaperras = false;
		Max_Jugadores = 0;
	}
	
	/////////////////////////
	//Método con párametros//
	/////////////////////////
	public Casino(int codigo, String nombre, boolean ruleta, boolean blackJack, boolean tragaperras,
			int max_Jugadores) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Ruleta = ruleta;
		BlackJack = blackJack;
		Tragaperras = tragaperras;
		Max_Jugadores = max_Jugadores;
	}
	
	
	

	
	/**
	 * CREACION DE CASINO EN BASE DE DATOS Y AÑADIR CASINO (CREAR REALMENTE ES AÑADIR)
	 * 
	 */
	
	private void crearCasino(Connection con,int Codigo, String Nombre, boolean Ruleta,boolean BlackJack
			,boolean Tragaperras,int maxJugadores)throws SQLException{
		try {
			//TODO: Hay que comprobar que el código que se asigne no exista 
			/**
			 * TODO: ¿Cómo se puede autoasignar un número a cada Casino que se cree ?
			 * 
			 */
			PreparedStatement stm = con.prepareStatement("INSERT INTO CASINO (Codigo,Nombre"
					+ ",Ruleta,BlackJack,Tragaperras,max_Jugadores) VALUES (?,?,?,?,?,?)");
			
		
			stm.setInt(1, Codigo);
			stm.setString(2, Nombre);
			stm.setBoolean(3, Ruleta);
			stm.setBoolean(4, BlackJack);
			stm.setBoolean(5, Tragaperras);
			stm.setInt(6, maxJugadores);
			

			stm.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo de nuevo.");
			
		}
	}
	
	/////////////////////////////
	//Método para buscar Casino//
	/////////////////////////////
	
	public void buscarCasino(Connection con, int Codigo){
		
		try{
			PreparedStatement stm = con.prepareStatement("SELECT * FROM CASINO WHERE Codigo like "+Codigo);
			stm.executeUpdate();
			con.close();
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog(null,"Error.Vuelva a intentarlo de nuevo.");
			
		}
		
	}

	
	
	
	
	
	
}

