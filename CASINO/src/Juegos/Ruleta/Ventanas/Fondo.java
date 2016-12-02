package src.Juegos.Ruleta.Ventanas;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fondo extends javax.swing.JPanel {
	
	public Fondo(){
		this.setSize(1300,1300);
		
	}
	
	public void paintComponent (Graphics e){
		Dimension medidas = getSize();
		ImageIcon Fondo = new ImageIcon(getClass().getResource("/Imágenes/Ruleta.jpg"));
		e.drawImage(Fondo.getImage(), 0, 0, medidas.width, medidas.height, null);
		setOpaque(false);
		super.paintComponent(e);
		
	}

	public static void main(String[] args) {
		Fondo e = new Fondo();
	}
}
