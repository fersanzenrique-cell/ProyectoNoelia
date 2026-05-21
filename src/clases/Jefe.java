/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

import java.io.*;

public class Jefe extends Admin {

    public Jefe() { super(); }
    public Jefe(int id, String nombre, String email, String contraseña) {
        super(id, nombre, email, contraseña);
    }

    // --- MÉTODOS ADICIONALES (Para integrarse con el formato listaAdmins.txt) ---

    public void crearAdmin(Admin admin) {
        // Añade un nuevo administrador al archivo dedicado listaAdmins.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("baseDeDatos/listaAdmins.txt", true))) {
            bw.write(admin.getId() + ";" + admin.getNombre() + ";" + admin.getEmail() + ";" + admin.getPassword());
            bw.newLine();
            System.out.println("Administrador guardado en listaAdmins.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar admin: " + e.getMessage());
        }
    }

    public void eliminarAdmin(Admin admin) {
        File archivoOriginal = new File("baseDeDatos/listaAdmins.txt");
        File archivoTemporal = new File("baseDeDatos/listaAdmins_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            String idBuscar = String.valueOf(admin.getId());
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length > 0 && datos[0].trim().equals(idBuscar)) {
                    encontrado = true; // Nos saltamos la línea para eliminarlo
                } else {
                    bw.write(linea);
                    bw.newLine();
                }
            }

            if (encontrado && archivoOriginal.delete()) {
                if (!archivoTemporal.renameTo(archivoOriginal)) {
                    System.out.println("Error crítico al renombrar el archivo de administradores.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar administrador: " + e.getMessage());
        }
    }

    public static Jefe buscarEnArchivo(String nombreBuscar, String contraBuscar) {
        Jefe jefeEncontrado = null;
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("baseDeDatos/listaJefes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null && !encontrado) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) {
                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    String email = datos[2].trim();
                    String contra = datos[3].trim();

                    if (nombre.equalsIgnoreCase(nombreBuscar) && contra.equals(contraBuscar)) {
                        jefeEncontrado = new Jefe(id, nombre, email, contra);
                        encontrado = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Nota: listaJefes.txt no disponible.");
        }
        return jefeEncontrado;
    }
}
