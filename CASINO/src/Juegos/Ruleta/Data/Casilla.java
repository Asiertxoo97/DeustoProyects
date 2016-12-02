package Juegos.Ruleta;
import java.awt.Color;

//Clase Abstracta de Casillas
public abstract class Casilla {
protected Color color;
protected int numero;
protected int contador;
protected int numeroveces;
public Casilla(int numero) {
	this.color = Color.WHITE;
	this.numero = numero;
	this.contador =0;
	this.numeroveces =0;
}

public Casilla(){
	this.color = Color.WHITE;
	this.numero = 0;
	this.contador = 0;
	this.numeroveces =0;
}

public int getNumeroveces() {
	return numeroveces;
}

public void setNumeroveces(int numeroveces) {
	this.numeroveces = numeroveces;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public int getContador() {
	return contador;
}

public void setContador(int contador) {
	this.contador = contador;
}

@Override
public String toString() {
	return "Casilla " + numero;
}






}
