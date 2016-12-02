package Juegos.Ruleta;
import java.util.Random;

public class Ruleta {
	private Casilla [] Tablero = new Casilla [37];
	private int dinero = 1000000;
	//Creamos la ruleta
	public Ruleta(){
		//Declaramos la casilla 0.
		Tablero[0] = new CasillaVerde();
		//Vamos alternando entre casillas Rojas y Negras
		Tablero[1] = new CasillaRoja(1);
		Tablero[2] = new CasillaNegra(2);
		Tablero[3] = new CasillaRoja(3);
		Tablero[4] = new CasillaNegra(4);
		Tablero[5] = new CasillaRoja(5);
		Tablero[6] = new CasillaNegra(6);
		Tablero[7] = new CasillaRoja(7);
		Tablero[8] = new CasillaNegra(8);
		Tablero[9] = new CasillaRoja(9);
		Tablero[10] = new CasillaNegra(10);
		Tablero[11] = new CasillaNegra(11);
		Tablero[12] = new CasillaRoja(12);
		Tablero[13] = new CasillaNegra(13);
		Tablero[14] = new CasillaRoja(14);
		Tablero[15] = new CasillaNegra(15);
		Tablero[16] = new CasillaRoja(16);
		Tablero[17] = new CasillaNegra(17);
		Tablero[18] = new CasillaNegra(18);
		Tablero[19] = new CasillaRoja(19);
		Tablero[20] = new CasillaNegra(20);
		Tablero[21] = new CasillaRoja(21);
		Tablero[22] = new CasillaNegra(22);
		Tablero[23] = new CasillaRoja(23);
		Tablero[24] = new CasillaNegra(24);
		Tablero[25] = new CasillaRoja(25);
		Tablero[26] = new CasillaNegra(26);
		Tablero[27] = new CasillaRoja(27);
		Tablero[28] = new CasillaNegra(28);
		Tablero[29] = new CasillaNegra(29);
		Tablero[30] = new CasillaRoja(30);
		Tablero[31] = new CasillaNegra(31);
		Tablero[32] = new CasillaRoja(32);
		Tablero[33] = new CasillaNegra(33);
		Tablero[34] = new CasillaRoja(34);
		Tablero[35] = new CasillaNegra(35);
		Tablero[36] = new CasillaRoja(36);
		
	}
	
	//Generamos un numero al azar
	public Casilla Tirada(){
		int numero;
		Random r = new Random();
		numero = r.nextInt(37);
		 Casilla CasillaSeleccionada = Tablero[numero];
		 return CasillaSeleccionada;
		
	}
	
	
	
	
	
		
	
	
	//Main para hacer pruebas
	public static void main(String[] args) {
		Ruleta e = new Ruleta();
		e.Tirada();
		
	}
	
	public boolean HayDineroRuleta(){
		if (this.dinero ==0)
			return false;
		return true;
		
	}
	public void setDinero(int dinero){
		this.dinero = dinero;
	}
	public int getDinero(){
		return dinero;
	}
	//Subimos en 1 el numero de veces que ha tocado la casilla.
	public void HaTocado(Casilla e){
		
		Tablero[e.getNumero()].setNumeroveces(Tablero[e.getNumero()].getNumeroveces() +1);
		System.out.println(Tablero[e.getNumero()].getNumeroveces());
		
	}

}
