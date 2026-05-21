package clases;

import java.io.*;

public class Usuario extends Cliente {
    private String password;

    // Constructores según vuestro UML
    public Usuario() { super(); }
    public Usuario(int id, String nombre, String email, String password) {
        super(id, nombre, email);
        this.password = password;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }



    public void votarEncuesta() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("baseDeDatos/encuestas.txt", true))) {
            bw.write("Voto de usuario: " + this.getNombre());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error en encuesta: " + e.getMessage());
        }
    }

    public void proponerArtista(String nombreArtista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("baseDeDatos/propuestas.txt", true))) {
            bw.write(nombreArtista);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al proponer artista: " + e.getMessage());
        }
    }


    public static Usuario buscarEnArchivo(String nombreBuscar, String contraBuscar) {
        Usuario usuarioEncontrado = null;
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("baseDeDatos/listaUsuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null && !encontrado) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) { // id;nombre;email;contraseña
                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    String email = datos[2].trim();
                    String contra = datos[3].trim();

                    if (nombre.equalsIgnoreCase(nombreBuscar) && contra.equals(contraBuscar)) {
                        usuarioEncontrado = new Usuario(id, nombre, email, contra);
                        encontrado = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Nota: listaUsuarios.txt no disponible.");
        }
        return usuarioEncontrado;
    }
}
