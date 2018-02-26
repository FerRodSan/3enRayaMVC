package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class TresNRayaUI extends JFrame {

	private JPanel contentPane;
	protected Botonera botonera;
	protected JTextField txtMensaje;
	
	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonera=new Botonera(100, 0);
		botonera.setBounds(146, 53, 150, 150);
		contentPane.add(botonera);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(10, 236, 89, 14);
		contentPane.add(lblMensaje);
		
		txtMensaje = new JTextField();
		txtMensaje.setBounds(109, 233, 289, 20);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JLabel lblTresEnRaya = new JLabel("TRES EN RAYA");
		lblTresEnRaya.setBackground(Color.RED);
		lblTresEnRaya.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblTresEnRaya.setBounds(163, 22, 120, 20);
		contentPane.add(lblTresEnRaya);
	}
}
