package interfazUI;

import clases.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class VentanaPrincipal extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private static Usuario usuarioActivo; 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    if (usuarioActivo == null) {
                        usuarioActivo = new Usuario(1, "Invitado", "invitado@email.com", "");
                    }
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaPrincipal(Usuario usuarioLogueado) {
        usuarioActivo = usuarioLogueado;
        initialize();
    }

    public VentanaPrincipal() {
        if (usuarioActivo == null) {
            usuarioActivo = new Usuario(1, "Invitado", "invitado@email.com", "");
        }
        initialize();
    }

    private void initialize() {
        setTitle("Concertly - Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogo = new JLabel("Concertly");
        lblLogo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblLogo.setBounds(380, 11, 130, 30);
        contentPane.add(lblLogo);

        JLabel lblAutores = new JLabel("Sesión activa: " + usuarioActivo.getNombre());
        lblAutores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblAutores.setForeground(new Color(0, 102, 204));
        lblAutores.setBounds(10, 11, 250, 20);
        contentPane.add(lblAutores);

        JButton btnEventos = new JButton("Eventos");
        btnEventos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (usuarioActivo instanceof Admin) {
                    Admin administrador = (Admin) usuarioActivo;
                    administrador.gestionarContenido();
                    JOptionPane.showMessageDialog(null, "Consola del sistema: Contenido listado.", "Gestión de Contenido", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado.", "Permisos Insuficientes", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnEventos.setBounds(330, 50, 100, 30);
        contentPane.add(btnEventos);

        JButton btnSugerencias = new JButton("Sugerencias");
        btnSugerencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opciones = {"Votar en Encuesta", "Proponer Nuevo Artista", "Ver Consultas (Admin)"};
                int seleccion = JOptionPane.showOptionDialog(null, "Acción de feedback", "Buzón de Sugerencias",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                
                if (seleccion == 0) {
                    usuarioActivo.votarEncuesta();
                    JOptionPane.showMessageDialog(null, "Voto añadido.", "Encuesta Guardada", JOptionPane.INFORMATION_MESSAGE);
                } else if (seleccion == 1) {
                    String artista = JOptionPane.showInputDialog(null, "Nombre del artista:", "Proponer Artista", JOptionPane.PLAIN_MESSAGE);
                    if (artista != null && !artista.trim().isEmpty()) {
                        usuarioActivo.proponerArtista(artista.trim());
                        JOptionPane.showMessageDialog(null, "Registrado.", "Propuesta Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (seleccion == 2) {
                    if (usuarioActivo instanceof Admin) {
                        Admin administrador = (Admin) usuarioActivo;
                        List<String> consultas = administrador.verConsultas();
                        String listaVisual = "--- Consultas ---\n";
                        for (int i = 0; i < consultas.size(); i++) {
                            listaVisual += (i + 1) + ". " + consultas.get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaVisual, "Consultas", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Acceso restringido.", "Acceso Restringido", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        btnSugerencias.setBounds(440, 50, 110, 30);
        contentPane.add(btnSugerencias);

        JLabel lblAjustes = new JLabel("⚙ Ajustes");
        lblAjustes.setBounds(630, 55, 60, 20);
        contentPane.add(lblAjustes);

        JLabel lblNotificaciones = new JLabel("🔔 Notifs");
        lblNotificaciones.setBounds(700, 55, 60, 20);
        contentPane.add(lblNotificaciones);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmar = JOptionPane.showConfirmDialog(null, "¿Salir?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    usuarioActivo = null;
                    VentanaLogin login = new VentanaLogin();
                    login.setVisible(true);
                    dispose(); 
                }
            }
        });
        btnCerrarSesion.setBounds(770, 50, 110, 30);
        contentPane.add(btnCerrarSesion);

        JPanel panelLineaHorizontal = new JPanel();
        panelLineaHorizontal.setBackground(Color.BLACK);
        panelLineaHorizontal.setBounds(10, 90, 864, 2);
        contentPane.add(panelLineaHorizontal);

        JLabel lblColConciertos = new JLabel("Conciertos disponibles");
        lblColConciertos.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblColConciertos.setBounds(20, 105, 200, 20);
        contentPane.add(lblColConciertos);

        JPanel panelEv1 = new JPanel();
        panelEv1.setBorder(new LineBorder(Color.GRAY));
        panelEv1.setBounds(20, 135, 300, 80);
        contentPane.add(panelEv1);
        panelEv1.setLayout(null);
        
        JLabel lblFoto1 = new JLabel("[Foto Grupo]");
        lblFoto1.setBounds(10, 30, 80, 20);
        panelEv1.add(lblFoto1);
        
        JLabel lblInfo1 = new JLabel("Festival Primavera Techno - 45.50€");
        lblInfo1.setBounds(100, 15, 190, 20);
        panelEv1.add(lblInfo1);
        
        JButton btnComprar1 = new JButton("COMPRAR");
        btnComprar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Evento eventoAsociado = new Evento(501, "Festival Primavera Techno", LocalDate.now(), "Auditorio Central Móstoles", 45.50, new ArrayList<String>());
                Reserva nuevaReserva = new Reserva(901, "Butaca-A12", usuarioActivo, eventoAsociado);
                nuevaReserva.confirmarReserva(); 
                JOptionPane.showMessageDialog(null, "Compra completada.", "Compra Completada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnComprar1.setBounds(190, 45, 100, 25);
        panelEv1.add(btnComprar1);

        JPanel panelEv2 = new JPanel();
        panelEv2.setBorder(new LineBorder(Color.GRAY));
        panelEv2.setBounds(20, 230, 300, 80);
        contentPane.add(panelEv2);
        panelEv2.setLayout(null);
        
        JLabel lblInfo2 = new JLabel("Concierto Rock Urbano - 25.00€");
        lblInfo2.setBounds(10, 15, 190, 20);
        panelEv2.add(lblInfo2);
        
        JLabel lblFoto2 = new JLabel("[Foto Grupo]");
        lblFoto2.setBounds(210, 30, 80, 20);
        panelEv2.add(lblFoto2);
        
        JButton btnComprar2 = new JButton("COMPRAR");
        btnComprar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Evento eventoAsociado = new Evento(502, "Concierto Rock Urbano", LocalDate.now(), "Plaza de Toros", 25.00, new ArrayList<String>());
                Reserva nuevaReserva = new Reserva(903, "Grada-B23", usuarioActivo, eventoAsociado);
                nuevaReserva.confirmarReserva();
                JOptionPane.showMessageDialog(null, "Compra completada.", "Compra Completada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnComprar2.setBounds(10, 45, 100, 25);
        panelEv2.add(btnComprar2);

        JPanel panelEv3 = new JPanel();
        panelEv3.setBorder(new LineBorder(Color.GRAY));
        panelEv3.setBounds(20, 325, 300, 80);
        contentPane.add(panelEv3);
        panelEv3.setLayout(null);
        
        JLabel lblFoto3 = new JLabel("[Foto Grupo]");
        lblFoto3.setBounds(10, 30, 80, 20);
        panelEv3.add(lblFoto3);
        
        JLabel lblInfo3 = new JLabel("Gala Pop Stars - 60.00€");
        lblInfo3.setBounds(100, 15, 190, 20);
        panelEv3.add(lblInfo3);
        
        JButton btnComprar3 = new JButton("COMPRAR");
        btnComprar3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Evento eventoAsociado = new Evento(503, "Gala Pop Stars", LocalDate.now(), "Estadio Municipal", 60.00, new ArrayList<String>());
                Reserva nuevaReserva = new Reserva(904, "Pista-VIP", usuarioActivo, eventoAsociado);
                nuevaReserva.confirmarReserva();
                JOptionPane.showMessageDialog(null, "Compra completada.", "Compra Completada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnComprar3.setBounds(190, 45, 100, 25);
        panelEv3.add(btnComprar3);

        JButton btnVerMas = new JButton("VER MÁS CONCIERTOS");
        btnVerMas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Informativo.", "Cartelera", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnVerMas.setBounds(20, 420, 300, 30);
        contentPane.add(btnVerMas);

        JLabel lblColPerfiles = new JLabel("Perfiles");
        lblColPerfiles.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblColPerfiles.setBounds(400, 105, 100, 20);
        contentPane.add(lblColPerfiles);

        JLabel lblIconoArt1 = new JLabel("(👤)", SwingConstants.CENTER);
        lblIconoArt1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIconoArt1.setBounds(410, 135, 50, 40);
        contentPane.add(lblIconoArt1);

        JLabel lblArt1 = new JLabel("DJ Sombra", SwingConstants.CENTER);
        lblArt1.setBounds(400, 175, 70, 20);
        contentPane.add(lblArt1);

        JLabel lblIconoArt2 = new JLabel("(👤)", SwingConstants.CENTER);
        lblIconoArt2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIconoArt2.setBounds(410, 215, 50, 40);
        contentPane.add(lblIconoArt2);

        JLabel lblArt2 = new JLabel("Rock Band", SwingConstants.CENTER);
        lblArt2.setBounds(400, 255, 70, 20);
        contentPane.add(lblArt2);

        JLabel lblColExtras = new JLabel("Extras");
        lblColExtras.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblColExtras.setBounds(650, 105, 100, 20);
        contentPane.add(lblColExtras);

        JPanel panelExtra1 = new JPanel();
        panelExtra1.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelExtra1.setBounds(650, 135, 200, 80);
        contentPane.add(panelExtra1);
        panelExtra1.setLayout(null);
        JLabel lblEx1 = new JLabel("Merchandising Oficial 👕", SwingConstants.CENTER);
        lblEx1.setBounds(10, 30, 180, 20);
        panelExtra1.add(lblEx1);

        JPanel panelExtra2 = new JPanel();
        panelExtra2.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelExtra2.setBounds(650, 230, 200, 80);
        contentPane.add(panelExtra2);
        panelExtra2.setLayout(null);
        JLabel lblEx2 = new JLabel("Pases de Parking 🚗", SwingConstants.CENTER);
        lblEx2.setBounds(10, 30, 180, 20);
        panelExtra2.add(lblEx2);
    }
}