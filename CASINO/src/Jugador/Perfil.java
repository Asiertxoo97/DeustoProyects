package Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Perfil {
	
	///////////////////////////
	//Atributos de un Jugador//
	///////////////////////////
	
	private String Nombre;
	
	private String Nick;
	
	private int fecha_nacimiento;
	
	private String contrase�a;
	
	private String numero_tarjeta;
	
	
	
				/////////////////////////////////
				//  Constructor con par�metros //
				/////////////////////////////////
	/**
	 * 
	 * @param nombre --> Debe tener m�s de 5 letras
	 * @param fecha_nacimiento --> Debe ser mayor que la fecha actual +18
	 * @param numero_tarjeta --> Debe tener al menos 8 d�gitos
	 * @param nick --> Debe tener 4 letras la menos
	 */
	
	public Perfil(String nombre, int fecha_nacimiento, String numero_tarjeta,String nick,String contrase�a) {
		super();
		if(nombre.length()<5||fecha_nacimiento<fecha_actual()||numero_tarjeta.length()<8||nick.length()<4||contrase�a.length()==0){
			this.Nombre = "";
			this.fecha_nacimiento = 0;
			this.numero_tarjeta = "";
			this.Nick = "";
		}
		this.Nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.numero_tarjeta = numero_tarjeta;
		this.Nick = nick;
		this.contrase�a = contrase�a;
	}
	
				////////////////////////
				///	Constructor Vac�o///
				////////////////////////
	
	public Perfil() {
		super();
		this.Nombre = "";
		this.fecha_nacimiento = 0;
		this.numero_tarjeta = "";
		this.Nick= "";
		this.contrase�a = "";
	}
	
	
	
	
	
	
				///////////////////////////
				//	 Get	y	Set      //
				///////////////////////////	
	
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(int fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public String getNick() {
		return Nick;
	}
	
	public void setNick(String nick) {
		Nick = nick;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


				///////////////////////////////
				//M�todo para conseguir fecha//
				///////////////////////////////
	
	/**
	 * S�lo tenemos que conseguir el a�o 
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	private static int fecha_actual(){
		int anyio;
		java.util.Date fecha = new Date();
		anyio = (fecha.getYear()+1900);
	
		return anyio;
	}
	
	/**
	 * TODO: M�todo para a�adir perfil nuevo 
	 * Podr�amos meter los perfiles en una base de datos externa y los casino (junto a los juegos que se encuentren activos)
	 * en otro. Con lo para ver si el usuario existe deber�amos buscarlos en la base de datos de perfiles y para ver si 
	 * hay partidas en juego buscamos en la otra bases de datos.
	 */
	//////////////////////////////////////////////
	//M�todo para a�adir Jugador a base de datos//
	//////////////////////////////////////////////
	
	
	private static void a�adirPerfil(Connection con,int DNI,String Nombre,String Apellido, String Nick
			,int fecha_nacimiento,int cuenta_bancaria,String contrase�a)throws SQLException{
		
		
		try {
			PreparedStatement stm = con.prepareStatement("INSERT INTO JUGADOR (DNI,Nombre,Apellido,"
					+ "Nick,Fecha_nacimiento,Contrase�a,Cuenta_bancaria) VALUES (?,?,?,?,?,?,?)");
			
			stm.setInt(1, DNI);
			stm.setString(2, Nombre);
			stm.setString(3, Apellido);
			stm.setString(4, Nick);
			stm.setInt(5, fecha_nacimiento);
			stm.setString(6, contrase�a);
			stm.setInt(7, cuenta_bancaria);

			stm.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo de nuevo.");
			
		}
		
		
		
		
	}
	
	/**
	 * TODO: m�todo para actualizar informaci�n de Juador en caso de que este quiera cambiar algo de su perfil
	 * como la contrase�a o la cuenta bancaria.
	 * @param con
	 * 
	 * 		///////////////////////////////////
	 *		//M�todo para actualizar Jugador //
	 *		///////////////////////////////////
	 *
	 *	public void actualizarPerfil(Connection con,){
	 *	
	 *		try {
	 *			PreparedStatement stm = con.prepareStatement("UPDATE JUGADOR SET "+);
	 *		} catch (SQLException e) {
	 *			// TODO Auto-generated catch block
	 *			e.printStackTrace();
	 *		}
	 *	
	 *	}
     *
	 */
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

	

}
