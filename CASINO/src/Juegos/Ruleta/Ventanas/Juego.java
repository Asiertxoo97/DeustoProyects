package src.Juegos.Ruleta.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Contenedor.Apuesta;
import Contenedor.Casilla;
import Contenedor.Perfil;
import Contenedor.Ruleta;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class Juego extends JFrame {
	public Image Fondo;
	public static Fondo panelfondo;
	private JPanel contentPane;
	public JLabel Casilla, MostrarMayorPremio, MostrarSaldo, Bola, MostrarApuestas, UltimaCasilla,
			lblMayorPremioRepartido, lblUltimaCasilla, Saldo, NumeroApuestas;
	public int mayorpremio, contador;
	private JButton btnVolver, btnRecargarSaldo, Apostar, Lanzar;

	public Juego(Perfil comprobacion) {
		setResizable(false);
		setTitle("JUEGO");
		// Creamos la Ruleta
		Ruleta ruleta = new Ruleta();
		// Creamos un ArrayList con las Casillas que van saliendo, mï¿½s tarde
		// lo
		// usaremos para obtener porcentajes.
		ArrayList<Casilla> Casillas = new ArrayList<Casilla>();

		// Creamos el Array con el que guardaremos las apuestas que se realizen
		ArrayList<Apuesta> ListaDeApuestas = new ArrayList<Apuesta>();
		// Creamos un contador para llevar la cuenta del numero de apuesta
		// realizadas

		contador = 0;
		mayorpremio = 0;
		// Ventana
		panelfondo = new Fondo();
		panelfondo.setForeground(Color.WHITE);
		panelfondo.setBounds(0, 0, 884, 861);
		Container contenedor = getContentPane();
		getContentPane().setLayout(null);
		contenedor.add(panelfondo);
		panelfondo.setLayout(null);

		// Lanzamos la bola
		Lanzar = new JButton("LANZAR BOLA");
		Lanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (contador == 0) {
					JOptionPane.showMessageDialog(null, "NO HAS APOSTADO!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					int premio = 0;
					Casillas.add(ruleta.Tirada());
					ColocarBola(Casillas.get(Casillas.size() - 1));
					Casilla.setText((String.valueOf(Casillas.get(Casillas.size() - 1).getNumero())));
					ruleta.HaTocado(Casillas.get(Casillas.size() - 1));

					// Calculamos el premio
					for (int i = 0; i < ListaDeApuestas.size(); i++) {
						premio = CalcularPremio(ListaDeApuestas.get(i), Casillas.get(Casillas.size() - 1));
						if (premio > 0) {
							JOptionPane.showMessageDialog(null, "ENHORABUENA", "HAS GANADO " + premio + " Euros",
									JOptionPane.INFORMATION_MESSAGE);

							comprobacion.setDinero(comprobacion.getDinero() + premio);
							ruleta.setDinero(ruleta.getDinero() - premio);
						} else {
							JOptionPane.showMessageDialog(null, "Lamentablemente, no has acertado, sigue probando",
									"ApuestaFallida", JOptionPane.OK_OPTION);

						}
					}
					if (premio > mayorpremio) {
						MostrarMayorPremio.setText(String.valueOf(premio));
					}
					premio = 0;
					MostrarSaldo.setText(String.valueOf(comprobacion.getDinero()));
					// Borramos las apuestas
					for (int i = 0; i < ListaDeApuestas.size(); i++) {
						if (ListaDeApuestas.get(i) != null)
							ListaDeApuestas.remove(i);

					}

					// Actualizamos el contador y cambiamos el label
					contador = 0;
					MostrarApuestas.setText(String.valueOf(contador));
				}
			}
		});
		Lanzar.setBackground(Color.WHITE);
		Lanzar.setForeground(Color.BLACK);
		Lanzar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Lanzar.setBounds(645, 794, 229, 60);
		panelfondo.add(Lanzar);

		Apostar = new JButton("APOSTAR");
		Apostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent j) {
				if (ruleta.HayDineroRuleta()) {

					if (comprobacion.getDinero() > 0) {
						VentanaApuestas apuestas = new VentanaApuestas(comprobacion);
						apuestas.setVisible(true);
						apuestas.setBounds(0, 0, 682, 412);

						apuestas.btnVolver.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								// Almacenamos la apuesta realizada
								ListaDeApuestas.add(apuestas.getE1());

								// le restamos al saldo del usuario el valor de
								// la apuesta
								comprobacion.setDinero(
										comprobacion.getDinero() - ListaDeApuestas.get(contador).getDineroapostado());
								ruleta.setDinero(
										ruleta.getDinero() + ListaDeApuestas.get(contador).getDineroapostado());
								contador++;
								MostrarSaldo.setText(String.valueOf(comprobacion.getDinero()));
								MostrarApuestas.setText(String.valueOf(contador));
							}

						});
					} else {
						JOptionPane.showMessageDialog(null, "No tienes suficiente dinero", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null, "La Ruleta no tiene dinero. Reinicia el juego.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
			}

		});
		Apostar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Apostar.setBounds(0, 799, 200, 51);
		panelfondo.add(Apostar);

		lblUltimaCasilla = new JLabel("Ultima Casilla:");
		lblUltimaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUltimaCasilla.setForeground(Color.BLACK);
		lblUltimaCasilla.setBounds(266, 296, 176, 51);
		panelfondo.add(lblUltimaCasilla);

		Casilla = new JLabel("");
		Casilla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Casilla.setForeground(Color.RED);
		Casilla.setBounds(542, 296, 82, 51);
		panelfondo.add(Casilla);

		lblMayorPremioRepartido = new JLabel("Mayor Premio Repartido:");
		lblMayorPremioRepartido.setForeground(Color.RED);
		lblMayorPremioRepartido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMayorPremioRepartido.setBounds(229, 358, 298, 31);
		panelfondo.add(lblMayorPremioRepartido);

		MostrarMayorPremio = new JLabel("");
		MostrarMayorPremio.setForeground(new Color(0, 0, 0));
		MostrarMayorPremio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MostrarMayorPremio.setBounds(521, 358, 78, 31);
		panelfondo.add(MostrarMayorPremio);

		btnRecargarSaldo = new JButton("RECARGAR SALDO");
		btnRecargarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecargarSaldo ventana = new RecargarSaldo();
				ventana.setVisible(true);
				ventana.btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comprobacion.setDinero(comprobacion.getDinero() + ventana.saldonuevo);
						JOptionPane.showMessageDialog(null,
								"SE HA RECARGADO SU SALDO CON  " + ventana.saldonuevo + " Euros", "SALDO RECARGADO",
								JOptionPane.INFORMATION_MESSAGE);
						MostrarSaldo.setText(String.valueOf(comprobacion.getDinero()));
					}

				});
			}

		});
		btnRecargarSaldo.setBounds(10, 28, 176, 36);
		panelfondo.add(btnRecargarSaldo);

		Saldo = new JLabel("Saldo:");
		Saldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Saldo.setBounds(266, 400, 100, 31);
		panelfondo.add(Saldo);

		MostrarSaldo = new JLabel("");
		MostrarSaldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MostrarSaldo.setBounds(370, 401, 298, 28);
		panelfondo.add(MostrarSaldo);
		MostrarSaldo.setText(String.valueOf(comprobacion.getDinero()));

		Bola = new JLabel("");
		Bola.setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/Bola.png")));
		Bola.setBounds(477, 133, 28, 16);
		panelfondo.add(Bola);

		NumeroApuestas = new JLabel("Número de Apuestas:");
		NumeroApuestas.setForeground(Color.RED);
		NumeroApuestas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NumeroApuestas.setBounds(229, 467, 190, 31);
		panelfondo.add(NumeroApuestas);

		MostrarApuestas = new JLabel("");
		MostrarApuestas.setForeground(Color.RED);
		MostrarApuestas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MostrarApuestas.setBounds(429, 467, 68, 31);
		panelfondo.add(MostrarApuestas);
		MostrarApuestas.setText(String.valueOf(contador));

		// BOTON VOLVER ( VUELVE A CASINO)
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				JOptionPane.showMessageDialog(null, "GRACIAS POR JUGAR A LA RULETA. ESPEREMOS VERLE PRONTO.", "VOLVER",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		btnVolver.setBounds(673, 28, 157, 36);
		panelfondo.add(btnVolver);

		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 893);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

	}

	public int CalcularPremio(Apuesta e, Casilla x) {
		int premio = 0;
		switch (e.getTipoApuesta()) {

		// En caso de haber apostado a numeros
		case 1:
			if (e.getNumeroelegido() == x.getNumero())

				premio = 36 * e.getDineroapostado();
			break;
		case 2:
			if (e.isColorRojo() == true && x.getColor() == Color.RED) {
				premio = 2 * e.getDineroapostado();
			} else if (e.isColorNegro() == true && x.getColor() == Color.BLACK) {
				premio = 2 * e.getDineroapostado();
			}
			break;
		// Docena
		case 3:
			if (e.getDocena() == 1) {
				if (x.getNumero() >= 0 && x.getNumero() <= 12)
					premio = 3 * e.getDineroapostado();

			} else if (e.getDocena() == 2) {
				if (x.getNumero() >= 13 && x.getNumero() <= 24)
					premio = 3 * e.getDineroapostado();

			} else if (e.getDocena() == 3) {
				if (x.getNumero() >= 25 && x.getNumero() <= 36)
					premio = 3 * e.getDineroapostado();
			}
			break;
		// Paridad
		case 4:
			if (e.isPar() == true && x.getNumero() % 2 == 0) {
				premio = 2 * e.getDineroapostado();
			} else if (e.isPar() == false && x.getNumero() % 2 != 0) {
				premio = 2 * e.getDineroapostado();

			}
			break;
		case 5:
			if (e.isPrimeraMitad() == true && x.getNumero() < 19) {
				premio = 2 * e.getDineroapostado();
			} else if (e.isPrimeraMitad() == false && x.getNumero() >= 19) {
				premio = 2 * e.getDineroapostado();
			}
			break;

		}

		return premio;

	}

	public JPanel panel = new JPanel() {
		public void paintComponent(Graphics e) {
			e.drawImage(Fondo, 0, 0, getWidth(), getHeight(), this);
		}
	};

	// Metodo para colocar la Bolita
	public void ColocarBola(Casilla e) {

		switch (e.getNumero()) {
		case 0:
			Bola.setBounds(477, 133, 28, 16);
			break;
		case 1:
			Bola.setBounds(180, 591, 28, 16);
			break;
		case 2:
			Bola.setBounds(707, 312, 28, 16);
			break;
		case 3:
			Bola.setBounds(376, 133, 28, 16);
			break;
		case 4:
			Bola.setBounds(656, 233, 28, 16);
			break;
		case 5:
			Bola.setBounds(353, 701, 28, 16);
			break;
		case 6:
			Bola.setBounds(709, 510, 28, 16);
			break;
		case 7:
			Bola.setBounds(199, 226, 28, 16);
			break;
		case 8:
			Bola.setBounds(502, 707, 28, 16);
			break;
		case 9:
			Bola.setBounds(123, 410, 28, 16);
			break;
		case 10:
			Bola.setBounds(402, 716, 28, 16);
			break;
		case 11:
			Bola.setBounds(596, 663, 28, 16);
			break;
		case 12:
			Bola.setBounds(279, 163, 28, 16);
			break;
		case 13:
			Bola.setBounds(668, 596, 28, 16);
			break;
		case 14:
			Bola.setBounds(136, 507, 28, 16);
			break;
		case 15:
			Bola.setBounds(574, 164, 28, 16);
			break;
		case 16:
			Bola.setBounds(257, 659, 28, 16);
			break;
		case 17:
			Bola.setBounds(727, 419, 28, 16);
			break;
		case 18:
			Bola.setBounds(146, 310, 28, 16);
			break;
		case 19:
			Bola.setBounds(617, 196, 28, 16);
			break;
		case 20:
			Bola.setBounds(156, 554, 28, 16);
			break;
		case 21:
			Bola.setBounds(687, 268, 28, 16);
			break;
		case 22:
			Bola.setBounds(128, 357, 28, 16);
			break;
		case 23:
			Bola.setBounds(449, 718, 28, 16);
			break;
		case 24:
			Bola.setBounds(300, 688, 28, 16);
			break;
		case 25:
			Bola.setBounds(718, 364, 28, 16);
			break;
		case 26:
			Bola.setBounds(429, 130, 28, 16);
			break;
		case 27:
			Bola.setBounds(696, 552, 28, 16);
			break;
		case 28:
			Bola.setBounds(241, 192, 28, 16);
			break;
		case 29:
			Bola.setBounds(167, 269, 28, 16);
			break;
		case 30:
			Bola.setBounds(549, 687, 28, 16);
			break;
		case 31:
			Bola.setBounds(123, 462, 28, 16);
			break;
		case 32:
			Bola.setBounds(528, 143, 28, 16);
			break;
		case 33:
			Bola.setBounds(218, 630, 28, 16);
			break;
		case 34:
			Bola.setBounds(724, 458, 28, 16);
			break;
		case 35:
			Bola.setBounds(328, 146, 28, 16);
			break;
		case 36:
			Bola.setBounds(632, 633, 28, 16);
			break;

		}

	}
}
