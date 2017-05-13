package CapaPresentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CapaAplicacio.ControladorBBDD;
import CapaAplicacio.ControladorJocDaus;

public class PantallaCredencialsBBDD extends JFrame {

	
	private JTextField userCrendencial;
	private JTextField passwordCredencial;
		
	private ControladorBBDD controladorBBDD;
	
	private JPanel contentPane;
	
	private static PantallaCredencialsBBDD PantallaCredencialsBBDDFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCredencialsBBDDFrame = new PantallaCredencialsBBDD();
					PantallaCredencialsBBDDFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaCredencialsBBDD() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setBounds(100, 100, 480, 345);
    	setResizable(false);
    	
    	getContentPane().setLayout(null);
		
		JLabel lblIniciDeSessi = new JLabel("Inici de sessi\u00F3 de Base de Dades");
		lblIniciDeSessi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIniciDeSessi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciDeSessi.setBounds(10, 11, 430, 91);
		
		getContentPane().add(lblIniciDeSessi);
		
		JLabel lblNomDusuari = new JLabel("Nom d'usuari:");	
		lblNomDusuari.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDusuari.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomDusuari.setBounds(10, 113, 134, 42);
		getContentPane().add(lblNomDusuari);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 184, 134, 42);
		getContentPane().add(lblPassword);
		
		userCrendencial = new JTextField();
		userCrendencial.setText("vcolomina");
		userCrendencial.setBounds(157, 124, 193, 20);
		
		getContentPane().add(userCrendencial);
		userCrendencial.setColumns(10);
		
		passwordCredencial = new JTextField();
		passwordCredencial.setText("s43575355");
		passwordCredencial.setBounds(154, 197, 196, 20);
	
		getContentPane().add(passwordCredencial);
		passwordCredencial.setColumns(10);
		
		JButton btnIniciaSessi = new JButton("Inicia Sessi\u00F3");
		btnIniciaSessi.setBounds(331, 252, 109, 37);
		btnIniciaSessi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnIniciaSessiActionPerformed(evt);
            }

        });
		
		getContentPane().add(btnIniciaSessi);
		
	}


	private void btnIniciaSessiActionPerformed(ActionEvent evt) {
		
		try {
			controladorBBDD = new ControladorBBDD(userCrendencial.getText(), passwordCredencial.getText());
			PantallaCredencialsBBDDFrame.setVisible(false);
			
			new PantallaJocDaus();
			

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(PantallaCredencialsBBDDFrame,
				    "Error: No s'han introduit correctament les credencials.",
				    "Error d'inicialització",
				    JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
