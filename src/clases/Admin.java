/**
 * @Author : Enrique Fernández Sanz
 */
package clases;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Usuario {

    public Admin() { super(); }
    public Admin(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
    }

    public void modificarEvento(Evento evento) {
        evento.actualizarInfo();
    }

    public void gestionarContenido() {
        try (BufferedReader br = new BufferedReader(new FileReader("baseDeDatos/eventos.txt"))) {
            String linea;
            System.out.println("=== CONTENIDO ACTUAL ===");
            while ((linea = br.readLine()) != null) {
                System.out.println("- " + linea);
            }
        } catch (IOException e) {
            System.out.println("Error al gestionar contenido: " + e.getMessage());
        }
    }

    public List<String> verConsultas() {
        List<String> listaConsultas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("baseDeDatos/consultas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                listaConsultas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer consultas: " + e.getMessage());
        }
        return listaConsultas;
    }


    public static Admin buscarEnArchivo(String nombreBuscar, String contraBuscar) {
        Admin adminEncontrado = null;
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("baseDeDatos/listaAdmins.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null && !encontrado) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) { // id;nombre;email;contraseña
                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    String email = datos[2].trim();
                    String contra = datos[3].trim();

                    if (nombre.equalsIgnoreCase(nombreBuscar) && contra.equals(contraBuscar)) {
                        adminEncontrado = new Admin(id, nombre, email, contra);
                        encontrado = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Nota: listaAdmins.txt no disponible.");
        }
        return adminEncontrado;
    }
}
