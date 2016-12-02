package src.Juegos.Ruleta.Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Contenedor.Apuesta;
import Contenedor.Perfil;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import java.awt.Color;

public class VentanaApuestas extends JFrame {

	public static JLabel lblSeleccioneSuApuesta, lblApuestas;
	public JButton btnApostar, btnVolver;
	private JButton btnNumeros, btnColor, btnDocenas, btnParidar, btnMitades,btnRojo,btnNegro,btnDocena_1,btnDocena_2,btnDocena_3,btnPar,btnImpar,btnMitad_1,btnMitad_2;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private Apuesta e1;
	private JComboBox Numeros;
	

	public VentanaApuestas(Perfil comprobacion) {
		setResizable(false);
		setTitle("SELECCIONE SU APUESTA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lblSeleccioneSuApuesta = new JLabel("SELECCIONE SU APUESTA");
		lblSeleccioneSuApuesta.setBounds(249, 11, 141, 40);

		lblApuestas = new JLabel("APUESTAS");
		lblApuestas.setBounds(290, 106, 51, 14);

		btnApostar = new JButton("VALIDAR APUESTA");
		btnApostar.setBounds(457, 316, 179, 23);

		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = textArea.getText();
				int Dinero =0;
				//Comprobamos que sea un numero válido
				boolean validado = true;
				for (int i =0; i <aux.length(); i++){
					if ((aux.charAt(i) >= 'a' && aux.charAt(i) <= 'z') || (aux.charAt(i) >= 'A' && aux.charAt(i) <= 'Z')){
						
						validado = false;
					}
			
				}
					if (!validado){
						JOptionPane.showMessageDialog(null, "Has introducido un valor de dinero no valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					}
					else{
						if (aux.length() ==0){
							validado = false;
						}else{
						Dinero = Integer.parseInt(aux);
						if (Dinero <=0 || Dinero >500){
							JOptionPane.showMessageDialog(null, "Ha introducido un valor de dinero no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
							validado = false;
						}
						else if (Dinero > comprobacion.getDinero()){
							JOptionPane.showMessageDialog(null, "No tienes tanto dinero!", "ERROR", JOptionPane.ERROR_MESSAGE);
							validado = false;
						}
						else
							validado = true;
						}
					
					}
				
				if (validado){	
				//Buscamos el tipo de apuesta realizada
				//Numeros
				if (btnNumeros.isEnabled() ==true){
					 int numeroelegido = (int) Numeros.getSelectedIndex();
	
					e1 = new Apuesta(1, Dinero, numeroelegido, false, false, 0, false, false, false, false);
					btnVolver.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
					
					
				}
				//Colores
				else if (btnColor.isEnabled() ==true){
					if (btnRojo.isEnabled() ==true){
						//
						e1 = new Apuesta(2, Dinero, -1, true, false, 0, false, false, false, false);
						btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
					else{
						e1 = new Apuesta(2, Dinero, -1, false, true, 0, false, false, false, false);
						btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
					
				}
				//Docenas
				else if (btnDocenas.isEnabled() ==true){
					if (btnDocena_1.isEnabled() ==true){
						 e1 = new Apuesta(3, Dinero, -1, false, false, 1, false, false, false, false);
						 btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
						
					}
					else if (btnDocena_2.isEnabled() ==true){
						e1 = new Apuesta(3, Dinero, -1, false, true, 2, false, false, false, false);
						btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
					}
					else{
						e1 = new Apuesta(3, Dinero, -1, false, true, 3, false, false, false, false);
						btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
						
						
					}
					
				}
				//Par-Impar
				else if (btnParidar.isEnabled() ==true){
					
					if (btnPar.isEnabled() ==true){
						 e1 = new Apuesta(4, Dinero, -1, false, false, 0, true, false, false, false);
						 btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
					else{
						 e1 = new Apuesta(4, Dinero, -1, false, false, 0, false, true, false, false);
						 btnVolver.setEnabled(true);
							btnApostar.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
					
					
				}
				//Mitades
				else if (btnMitades.isEnabled() ==true){
					if (btnMitad_1.isEnabled() ==true){
						 e1 = new Apuesta(5, Dinero, -1, false, false, 0, false, false, true, false);
						 btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
					else{
						 e1 = new Apuesta(5, Dinero, -1, false, false, 0, false, false, false, true);
						 btnVolver.setEnabled(true);
						btnApostar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Su Apuesta es valida. Se guardará¡ al pulsar el botón Volver", "Apuesta OK", JOptionPane.OK_OPTION);
						
					}
				}
					
						
					
				
					
				}
			}
		
		});
		btnApostar.setEnabled(false);

		btnNumeros = new JButton("NUMEROS");
		btnNumeros.setBounds(30, 64, 93, 23);
		btnNumeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numeros.setEnabled(true);
				btnApostar.setEnabled(true);
			}
		});
		
		btnColor = new JButton("COLOR");
		btnColor.setBounds(144, 64, 77, 23);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			btnRojo.setEnabled(true);
			btnNegro.setEnabled(true);
			}
		});

		btnDocenas = new JButton("DOCENAS");
		btnDocenas.setBounds(249, 64, 141, 23);
		btnDocenas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDocena_1.setEnabled(true);
				btnDocena_2.setEnabled(true);
				btnDocena_3.setEnabled(true);
				
			}
		});
	

		btnParidar = new JButton("PARIDAD");
		btnParidar.setBounds(414, 64, 95, 23);
		btnParidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPar.setEnabled(true);
				btnImpar.setEnabled(true);
			}
		});

		btnMitades = new JButton("MITADES");
		btnMitades.setBounds(536, 64, 100, 23);
		btnMitades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMitad_1.setEnabled(true);
				btnMitad_2.setEnabled(true);
			}
		});

		btnRojo = new JButton("ROJO");
		btnRojo.setBounds(144, 131, 77, 23);
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitades.setEnabled(false);
				btnNegro.setEnabled(false);
				
				
			}
		});
		btnRojo.setEnabled(false);

		btnNegro = new JButton("NEGRO");
		btnNegro.setBounds(144, 172, 77, 23);
		btnNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitades.setEnabled(false);
				btnRojo.setEnabled(false);
				
			}
		});
		btnNegro.setEnabled(false);

		btnDocena_1 = new JButton("1-12");
		btnDocena_1.setBounds(249, 131, 141, 23);
		btnDocena_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnNumeros.setEnabled(false);
				btnColor.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitades.setEnabled(false);
				btnDocena_2.setEnabled(false);
				btnDocena_3.setEnabled(false);
			}
		});
		btnDocena_1.setEnabled(false);

		btnDocena_2 = new JButton("13-24");
		btnDocena_2.setBounds(249, 172, 141, 23);
		btnDocena_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnNumeros.setEnabled(false);
				btnColor.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitades.setEnabled(false);
				btnDocena_1.setEnabled(false);
				btnDocena_3.setEnabled(false);
			}
		});
		btnDocena_2.setEnabled(false);

		btnDocena_3 = new JButton("25-36");
		btnDocena_3.setBounds(249, 213, 141, 23);
		btnDocena_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnNumeros.setEnabled(false);
				btnColor.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitades.setEnabled(false);
				btnDocena_1.setEnabled(false);
				btnDocena_2.setEnabled(false);
			}
		});
		btnDocena_3.setEnabled(false);

		btnPar = new JButton("PAR");
		btnPar.setBounds(414, 131, 95, 23);
		btnPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnColor.setEnabled(false);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnMitades.setEnabled(false);
				btnImpar.setEnabled(false);
			
			}
		});
		btnPar.setEnabled(false);

		btnImpar = new JButton("IMPAR");
		btnImpar.setBounds(414, 172, 95, 23);
		btnImpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Importe = textArea.getText();
				btnApostar.setEnabled(true);
				btnColor.setEnabled(false);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnMitades.setEnabled(false);
				btnPar.setEnabled(false);
			}
		});
		btnImpar.setEnabled(false);

		btnMitad_1 = new JButton("1-18");
		btnMitad_1.setBounds(536, 131, 100, 23);
		btnMitad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnColor.setEnabled(false);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitad_2.setEnabled(false);
			}
		});
		btnMitad_1.setEnabled(false);

		btnMitad_2 = new JButton("19-36");
		btnMitad_2.setBounds(536, 172, 100, 23);
		btnMitad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApostar.setEnabled(true);
				btnColor.setEnabled(false);
				btnNumeros.setEnabled(false);
				btnDocenas.setEnabled(false);
				btnParidar.setEnabled(false);
				btnMitad_1.setEnabled(false);
				
			}
		});
		btnMitad_2.setEnabled(false);
		btnMitad_2.setToolTipText("");
		
		textArea = new JTextArea();
		textArea.setBounds(157, 286, 169, 22);
		textArea.setToolTipText("Importe");
		
		lblNewLabel = new JLabel("INTRODUZCA EL IMPORTE QUE QUIERE APOSTAR");
		lblNewLabel.setBounds(157, 266, 403, 14);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 316, 93, 23);
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		 Numeros = new JComboBox();
		 Numeros.setBounds(30, 132, 93, 20);
		 Numeros.setEnabled(false);
		Numeros.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"}));
		
		JLabel lblNewLabel_1 = new JLabel("Maxima Apuesta 500");
		lblNewLabel_1.setBounds(157, 314, 169, 23);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(Numeros);
		getContentPane().add(btnNumeros);
		getContentPane().add(btnRojo);
		getContentPane().add(btnNegro);
		getContentPane().add(btnDocenas);
		getContentPane().add(btnDocena_1);
		getContentPane().add(btnDocena_2);
		getContentPane().add(btnDocena_3);
		getContentPane().add(lblSeleccioneSuApuesta);
		getContentPane().add(btnColor);
		getContentPane().add(btnImpar);
		getContentPane().add(btnPar);
		getContentPane().add(btnParidar);
		getContentPane().add(btnMitad_2);
		getContentPane().add(btnMitad_1);
		getContentPane().add(btnMitades);
		getContentPane().add(lblApuestas);
		getContentPane().add(btnVolver);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(btnApostar);
		getContentPane().add(lblNewLabel);
		getContentPane().add(textArea);

	}

	public Apuesta getE1() {
		return e1;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil e = new Perfil();
					VentanaApuestas frame = new VentanaApuestas(e);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}


		
		
