package Juegos.Black_Jack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Casino.Casino;;

public class Black_Jack {
	
	/**
	 * Atributos de Black Jack :
	 * 
	 *-Carta_banca_1 --> La primera carta que recibe la banca
	 *-Carta_banca_2 --> La segunda carta que recibe la banca
	 *-Carta_banca_3 --> La tercera carta que recibe la banca
	 *-Carta_banca_4 --> La cuarta carta que recibe la  banca
	 *-Carta_banca_5 --> La quinta carta que recibe la banca
	 *-Carta_banca_6--> La sexta carta que recibe la banca
	 *
	 *En nuestro juego cada jugador (incluida da la banca) solo podrá pedir 6 cartas. 
	 *Cada carta que reciba la banca se guardará en una base de datos para que varios jugadores
	 *puedan jugar con la misma banca al mismo tiempo. Pero para cada jugador se usará una baraja diferente, es decir,
	 *la carta que reciba cada jugador corresponderá con una baraja que únicamente se le repatira a dico jugador. 
	 *De esta manera no debemos guardar en ninguna base de datos la carta que reciba el jugador que compita contra la banca.
	 * 
	 * @param args
	 */
	
	
	
	////////////////////////////////////////////////
	//Método para guardar información de BlackJack//
	////////////////////////////////////////////////
	
	/**
	 * Este método guardará en la base de datos de la Black Jack cada carta que la banca del Casino correspondiente
	 * @param args
	 */
	public void guardar_Carta_BlackJack(Connection con, int cod_casino){
	
		try{
			PreparedStatement stm = con.prepareStatement("INSERT VALUES (?,?,?,?,?,?) INTO BLACKJACK ()"
					+ " WHERE COD_CASINO = "+ cod_casino);
			
			
			
			stm.executeUpdate();
			con.close();
			
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"Error.Vuelva a intentarlo.");
			
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
