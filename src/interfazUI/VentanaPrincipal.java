package interfazUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaPrincipal frame = new VentanaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaPrincipal() {
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

        JLabel lblAutores = new JLabel("Por: Naiara, Irene, Enrique y Jesús");
        lblAutores.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lblAutores.setBounds(10, 11, 200, 20);
        contentPane.add(lblAutores);

        JButton btnEventos = new JButton("Eventos");
        btnEventos.setBounds(330, 50, 100, 30);
        contentPane.add(btnEventos);

        JButton btnSugerencias = new JButton("Sugerencias");
        btnSugerencias.setBounds(440, 50, 110, 30);
        contentPane.add(btnSugerencias);

        JLabel lblAjustes = new JLabel("⚙ Ajustes");
        lblAjustes.setBounds(630, 55, 60, 20);
        contentPane.add(lblAjustes);

        JLabel lblNotificaciones = new JLabel("🔔 Notifs");
        lblNotificaciones.setBounds(700, 55, 60, 20);
        contentPane.add(lblNotificaciones);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setBounds(770, 50, 110, 30);
        contentPane.add(btnCerrarSesion);

        // Separador horizontal visual
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

        JLabel lblInfo1 = new JLabel("Información del Concierto 1");
        lblInfo1.setBounds(100, 15, 180, 20);
        panelEv1.add(lblInfo1);

        JButton btnComprar1 = new JButton("COMPRAR");
        btnComprar1.setBounds(190, 45, 100, 25);
        panelEv1.add(btnComprar1);


        JPanel panelEv2 = new JPanel();
        panelEv2.setBorder(new LineBorder(Color.GRAY));
        panelEv2.setBounds(20, 230, 300, 80);
        contentPane.add(panelEv2);
        panelEv2.setLayout(null);

        JLabel lblInfo2 = new JLabel("Información del Concierto 2");
        lblInfo2.setBounds(10, 15, 180, 20);
        panelEv2.add(lblInfo2);

        JLabel lblFoto2 = new JLabel("[Foto Grupo]");
        lblFoto2.setBounds(210, 30, 80, 20);
        panelEv2.add(lblFoto2);

        JButton btnComprar2 = new JButton("COMPRAR");
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

        JLabel lblInfo3 = new JLabel("Información del Concierto 3");
        lblInfo3.setBounds(100, 15, 180, 20);
        panelEv3.add(lblInfo3);

        JButton btnComprar3 = new JButton("COMPRAR");
        btnComprar3.setBounds(190, 45, 100, 25);
        panelEv3.add(btnComprar3);

        JButton btnVerMas = new JButton("VER MÁS");
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

        JLabel lblArt1 = new JLabel("Artista 1", SwingConstants.CENTER);
        lblArt1.setBounds(400, 175, 70, 20);
        contentPane.add(lblArt1);


        JLabel lblIconoArt2 = new JLabel("(👤)", SwingConstants.CENTER);
        lblIconoArt2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIconoArt2.setBounds(410, 215, 50, 40);
        contentPane.add(lblIconoArt2);

        JLabel lblArt2 = new JLabel("Artista 2", SwingConstants.CENTER);
        lblArt2.setBounds(400, 255, 70, 20);
        contentPane.add(lblArt2);


        JLabel lblIconoArt3 = new JLabel("(👤)", SwingConstants.CENTER);
        lblIconoArt3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIconoArt3.setBounds(410, 295, 50, 40);
        contentPane.add(lblIconoArt3);

        JLabel lblArt3 = new JLabel("Artista 3", SwingConstants.CENTER);
        lblArt3.setBounds(400, 335, 70, 20);
        contentPane.add(lblArt3);



        JLabel lblColExtras = new JLabel("Extras");
        lblColExtras.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblColExtras.setBounds(650, 105, 100, 20);
        contentPane.add(lblColExtras);

        JPanel panelExtra1 = new JPanel();
        panelExtra1.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelExtra1.setBounds(650, 135, 200, 80);
        contentPane.add(panelExtra1);
        panelExtra1.setLayout(null);
        JLabel lblEx1 = new JLabel("Info Extra 1", SwingConstants.CENTER);
        lblEx1.setBounds(10, 30, 180, 20);
        panelExtra1.add(lblEx1);

        JPanel panelExtra2 = new JPanel();
        panelExtra2.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelExtra2.setBounds(650, 230, 200, 80);
        contentPane.add(panelExtra2);
        panelExtra2.setLayout(null);
        JLabel lblEx2 = new JLabel("Info Extra 2", SwingConstants.CENTER);
        lblEx2.setBounds(10, 30, 180, 20);
        panelExtra2.add(lblEx2);

        JPanel panelExtra3 = new JPanel();
        panelExtra3.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelExtra3.setBounds(650, 325, 200, 80);
        contentPane.add(panelExtra3);
        panelExtra3.setLayout(null);
        JLabel lblEx3 = new JLabel("Info Extra 3", SwingConstants.CENTER);
        lblEx3.setBounds(10, 30, 180, 20);
        panelExtra3.add(lblEx3);
    }
}
