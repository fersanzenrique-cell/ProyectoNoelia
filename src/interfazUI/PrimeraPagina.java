package interfazUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class PrimeraPagina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txF1;
	private JTextField txF2;
	private final ButtonGroup bgRedes = new ButtonGroup();
	private JTextField txF3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraPagina frame = new PrimeraPagina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeraPagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton login = new JButton("Inicar sesion");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		login.setBounds(38, 12, 130, 25);
		contentPane.add(login);
		
		JButton btnSugerencias = new JButton("Mi perfil");
		btnSugerencias.setBounds(792, 12, 130, 25);
		contentPane.add(btnSugerencias);
		
		JLabel lblExtras = new JLabel("Formulario");
		lblExtras.setBounds(373, 47, 82, 15);
		contentPane.add(lblExtras);
		
		JLabel lblSugerenciaDeArtista = new JLabel("Sugerencia de artista:");
		lblSugerenciaDeArtista.setBounds(38, 92, 159, 15);
		contentPane.add(lblSugerenciaDeArtista);
		
		txF1 = new JTextField();
		txF1.setBounds(220, 90, 114, 19);
		contentPane.add(txF1);
		txF1.setColumns(10);
		
		JLabel lblNivelDeSatisfaccion = new JLabel("Nivel de satisfaccion:");
		lblNivelDeSatisfaccion.setBounds(38, 134, 159, 15);
		contentPane.add(lblNivelDeSatisfaccion);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"---", "Genial", "Bueno", "Regular", "Malo"}));
		cb.setBounds(220, 129, 95, 24);
		contentPane.add(cb);
		
		JLabel lblQueCambiarias = new JLabel("Que cambiarias:");
		lblQueCambiarias.setBounds(38, 181, 130, 15);
		contentPane.add(lblQueCambiarias);
		
		txF2 = new JTextField();
		txF2.setColumns(10);
		txF2.setBounds(186, 179, 114, 19);
		contentPane.add(txF2);
		
		JRadioButton rdbtnInstagram = new JRadioButton("Instagram");
		bgRedes.add(rdbtnInstagram);
		rdbtnInstagram.setBounds(198, 231, 102, 23);
		contentPane.add(rdbtnInstagram);
		
		JRadioButton rdbtnTiktok = new JRadioButton("Tiktok");
		bgRedes.add(rdbtnTiktok);
		rdbtnTiktok.setBounds(310, 231, 82, 23);
		contentPane.add(rdbtnTiktok);
		
		JRadioButton rdbtnGoogle = new JRadioButton("Google");
		bgRedes.add(rdbtnGoogle);
		rdbtnGoogle.setBounds(198, 258, 88, 23);
		contentPane.add(rdbtnGoogle);
		
		JRadioButton rdbtnConocidos = new JRadioButton("Conocidos");
		bgRedes.add(rdbtnConocidos);
		rdbtnConocidos.setBounds(290, 258, 102, 23);
		contentPane.add(rdbtnConocidos);
		
		JLabel lblDondeNosConociste = new JLabel("Donde nos conociste:");
		lblDondeNosConociste.setBounds(23, 249, 159, 15);
		contentPane.add(lblDondeNosConociste);
		
		JLabel lblGenerosQueQuieras = new JLabel("Generos que quieras escuchar:");
		lblGenerosQueQuieras.setBounds(23, 315, 228, 15);
		contentPane.add(lblGenerosQueQuieras);
		
		JCheckBox chbRock = new JCheckBox("Rock");
		chbRock.setBounds(38, 349, 82, 23);
		contentPane.add(chbRock);
		
		JCheckBox chbPop = new JCheckBox("Pop");
		chbPop.setBounds(138, 349, 74, 23);
		contentPane.add(chbPop);
		
		JCheckBox chbTechno = new JCheckBox("Techno");
		chbTechno.setBounds(38, 390, 82, 23);
		contentPane.add(chbTechno);
		
		JCheckBox chbRap = new JCheckBox("Rap");
		chbRap.setBounds(138, 390, 82, 23);
		contentPane.add(chbRap);
		
		JCheckBox chbOtro = new JCheckBox("Otro");
		chbOtro.setBounds(220, 372, 66, 23);
		contentPane.add(chbOtro);
		
		txF3 = new JTextField();
		txF3.setColumns(10);
		txF3.setBounds(290, 374, 114, 19);
		contentPane.add(txF3);
		
		JButton Enviar = new JButton("Enviar");
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sugerenciaA = txF1.getText();
				
				String nivelS = cb.getSelectedItem().toString();
				
				String cambios = txF2.getText();
				
				String generoS;
				if(chbOtro.isSelected() && !(txF3.getText().equals(""))) {
					generoS = txF3.getText();
				}
		}
		});
		
		Enviar.setBounds(38, 454, 130, 25);
		contentPane.add(Enviar);

	}
}
