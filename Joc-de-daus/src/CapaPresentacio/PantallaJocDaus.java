package CapaPresentacio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import CapaAplicacio.ControladorBBDD;
import CapaAplicacio.ControladorJocDaus;
import CapaAplicacio.DTO.PartidaDTO;

public class PantallaJocDaus extends javax.swing.JFrame {

    private ControladorJocDaus controladorJocDaus;
    private javax.swing.JTextField dau1;
    private javax.swing.JTextField dau2;
    private javax.swing.JTextField guanyades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jugadesLlista;
    private javax.swing.JButton jugar;
    private javax.swing.JButton llistaJugades;
    private javax.swing.JTextField resultat;
    private javax.swing.JTextField textJugador;
    
    private JTextField userCrendencial;
	private JTextField passwordCredencial;
	
	private ControladorBBDD controladorBBDD;
    
	private static PantallaJocDaus frame;
	
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PantallaJocDaus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public PantallaJocDaus() {
    	
    	initPantallaCredencials();
    	
    }
   
    private void initPantallaCredencials() {
    	
    	setBounds(100, 100, 480, 345);
    	setResizable(false);
    	
    	setLayout(null);
		
		JLabel lblIniciDeSessi = new JLabel("Inici de sessi\u00F3 de Base de Dades");
		lblIniciDeSessi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIniciDeSessi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciDeSessi.setBounds(10, 11, 430, 91);
		
		add(lblIniciDeSessi);
		
		JLabel lblNomDusuari = new JLabel("Nom d'usuari:");	
		lblNomDusuari.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDusuari.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomDusuari.setBounds(10, 113, 134, 42);
		add(lblNomDusuari);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 184, 134, 42);
		add(lblPassword);
		
		userCrendencial = new JTextField();
		userCrendencial.setBounds(157, 124, 193, 20);
		
		add(userCrendencial);
		userCrendencial.setColumns(10);
		
		passwordCredencial = new JTextField();
		passwordCredencial.setBounds(154, 197, 196, 20);
	
		add(passwordCredencial);
		passwordCredencial.setColumns(10);
		
		JButton btnIniciaSessi = new JButton("Inicia Sessi\u00F3");
		btnIniciaSessi.setBounds(331, 252, 109, 37);
		btnIniciaSessi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnIniciaSessiActionPerformed(evt);
            }

        });
		
		add(btnIniciaSessi);
		
	}


	private void btnIniciaSessiActionPerformed(ActionEvent evt) {
		
		try {
			controladorBBDD = new ControladorBBDD(userCrendencial.getText(), passwordCredencial.getText());
			
	    	getContentPane().removeAll();
			
			initComponents();
			this.controladorJocDaus = new ControladorJocDaus();
			textJugador.setText(controladorJocDaus.getNomJugador());
			int i = textJugador.getText().length();
			textJugador.setSelectionStart(0);
			textJugador.setSelectionEnd(i);
			this.setVisible(true);
						
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
				    "Error: No s'han introduit correctament les credencials.",
				    "Error d'inicialització",
				    JOptionPane.ERROR_MESSAGE);
		}
		
	}
    
	private void initComponents() {

		setResizable(true);
		
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(39, 38, 88, 17);
        textJugador = new javax.swing.JTextField();
        textJugador.setBounds(131, 35, 114, 23);
        jugar = new javax.swing.JButton();
        jugar.setBounds(87, 77, 88, 25);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(39, 145, 42, 17);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(91, 120, 0, 0);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(147, 145, 42, 17);
        resultat = new javax.swing.JTextField();
        resultat.setBounds(39, 183, 206, 34);
        llistaJugades = new javax.swing.JButton();
        llistaJugades.setBounds(370, 34, 151, 25);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(308, 85, 246, 240);
        jugadesLlista = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(39, 280, 68, 17);
        guanyades = new javax.swing.JTextField();
        guanyades.setBounds(121, 277, 74, 23);
        dau1 = new javax.swing.JTextField();
        dau1.setBounds(82, 142, 55, 23);
        dau2 = new javax.swing.JTextField();
        dau2.setBounds(193, 142, 52, 23);
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setBounds(199, 280, 14, 17);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Joc Daus");      

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Nom Jugador:");

        textJugador.setFont(new java.awt.Font("Tahoma", 0, 14));
        textJugador.setText("AnÃ²nim");
        textJugador.setName("nomJugador");
        textJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomJugadorActionPerformed(evt);
            }
        });

        jugar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jugar.setText("Jugar");
        jugar.setEnabled(false);
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Dau 1:");

        jLabel3.setName("dau1"); 

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Dau 2:");

        resultat.setEditable(false);
        resultat.setFont(new java.awt.Font("Tahoma", 0, 14));
        resultat.setForeground(new java.awt.Color(204, 0, 0));

        llistaJugades.setFont(new java.awt.Font("Tahoma", 0, 14));
        llistaJugades.setText("Llistar Jugades");
        llistaJugades.setEnabled(false);
        llistaJugades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llistaJugadesActionPerformed(evt);
            }
        });

        jugadesLlista.setColumns(20);
        jugadesLlista.setEditable(false);
        jugadesLlista.setFont(new java.awt.Font("Tahoma", 0, 14));
        jugadesLlista.setRows(5);
        jScrollPane1.setViewportView(jugadesLlista);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Guanyades");

        guanyades.setEditable(false);
        guanyades.setFont(new java.awt.Font("Tahoma", 0, 14));
        guanyades.setText("            ");

        dau1.setEditable(false);
        dau1.setFont(new java.awt.Font("Tahoma", 0, 14));

        dau2.setEditable(false);
        dau2.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("%");

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-598)/2, (screenSize.height-429)/2, 598, 429);
        
        getContentPane().setLayout(null);
        getContentPane().add(jLabel3);
        getContentPane().add(jLabel1);
        getContentPane().add(textJugador);
        getContentPane().add(resultat);
        getContentPane().add(jLabel7);
        getContentPane().add(guanyades);
        getContentPane().add(jLabel8);
        getContentPane().add(jLabel2);
        getContentPane().add(dau1);
        getContentPane().add(jLabel5);
        getContentPane().add(dau2);
        getContentPane().add(jugar);
        getContentPane().add(llistaJugades);
        getContentPane().add(jScrollPane1);
    }
    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {
    	PartidaDTO partida;
        String jugada;
        controladorJocDaus.jugar();
        partida = controladorJocDaus.getPartidaEnCurs();
        dau1.setText(partida.getDau1());
        dau2.setText(partida.getDau2());
        resultat.setText(partida.getResultat());
        String s = String.format("%3.2f", controladorJocDaus.guanyadesPercent());
        guanyades.setText(s);

    }

    private void nomJugadorActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            textJugador.setEnabled(false);
            controladorJocDaus.nouJugador(textJugador.getText());
            jugar.setEnabled(true);
            llistaJugades.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llistaJugadesActionPerformed(java.awt.event.ActionEvent evt) {
        List <PartidaDTO> partides = controladorJocDaus.getPartides();
        String result = "";
        for(PartidaDTO p: partides){
        	result += p.getResultat();
        }
        
        jugadesLlista.setText(result);
    }
}
