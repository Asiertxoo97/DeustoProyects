package Juegos.Ruleta;
import java.awt.Color;

public class CasillaNegra extends Casilla {
	public CasillaNegra(int numero) {
		super(numero);
		this.color = Color.BLACK;
		this.contador =0;
		this.numeroveces =0;
		
	}
	public CasillaNegra() {
		this.color = Color.BLACK;
		this.contador =0;
		
		
	}
}
