package Jugador;

import java.util.Calendar;
import java.util.Date;

public class Perfil {
	
	///////////////////////////
	//Atributos de un Jugador//
	///////////////////////////
	
	private String Nombre;
	
	private int fecha_nacimiento;
	
	private String numero_tarjeta;
	
	
	
				/////////////////////////////////
				//  Constructor con parámetros //
				/////////////////////////////////
	/**
	 * 
	 * @param nombre --> Debe tener más de 5 letras
	 * @param fecha_nacimiento --> Debe ser mayor que la fecha actual +18
	 * @param numero_tarjeta --> Debe tener al menos 8 dígitos
	 */
	
	public Perfil(String nombre, int fecha_nacimiento, String numero_tarjeta) {
		super();
		if(nombre.length()<5||fecha_nacimiento<fecha_actual()||numero_tarjeta.length()<8){
			Nombre = "";
			this.fecha_nacimiento = 0;
			this.numero_tarjeta = "";
		}
		Nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.numero_tarjeta = numero_tarjeta;
	}
	
				////////////////////////
				///	Constructor Vacío///
				////////////////////////
	
	public Perfil() {
		super();
		Nombre = "";
		this.fecha_nacimiento = 0;
		this.numero_tarjeta = "";
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


				///////////////////////////////
				//Método para conseguir fecha//
				///////////////////////////////
	
	/**
	 * Sólo tenemos que conseguir el año 
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	private static int fecha_actual(){
		int anyio;
		java.util.Date fecha = new Date();
		anyio = (fecha.getYear()+1900);
	
		return anyio;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}
