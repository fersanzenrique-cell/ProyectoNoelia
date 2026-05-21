package interfazUI;

import clases.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VentanaLogin extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaLogin frame = new VentanaLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaLogin() {
        setTitle("Concertly - Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 150, 25);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 80, 80, 20);
        contentPane.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 80, 180, 20);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 130, 80, 20);
        contentPane.add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(140, 130, 180, 20);
        contentPane.add(txtContrasena);

        JButton btnLogin = getJButton();
        contentPane.add(btnLogin);
    }

    private JButton getJButton() {
        JButton btnLogin = new JButton("Ingresar");
        btnLogin.addActionListener(e -> {
            String usuarioIntroducido = txtUsuario.getText().trim();
            String contrasenaIntroducida = new String(txtContrasena.getPassword()).trim();

            Usuario usuarioLogueado;
            Admin adminLogueado = null;
            Jefe jefeLogueado = null;

            usuarioLogueado = Usuario.buscarEnArchivo(usuarioIntroducido, contrasenaIntroducida);

            if (usuarioLogueado == null) {
                adminLogueado = Admin.buscarEnArchivo(usuarioIntroducido, contrasenaIntroducida);
            }

            if (usuarioLogueado == null && adminLogueado == null) {
                jefeLogueado = Jefe.buscarEnArchivo(usuarioIntroducido, contrasenaIntroducida);
            }

            if (usuarioLogueado != null || adminLogueado != null || jefeLogueado != null) {
                VentanaPrincipal principal = new VentanaPrincipal();
                principal.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No está disponible esa cuenta", "Error de Login", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnLogin.setBounds(140, 180, 110, 30);
        return btnLogin;
    }
}