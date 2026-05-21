/**
 * @Author : Jesús Farinango Villa
 */
package clases;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

//clase
public class Evento {
    private int codigoEvento;
    private String nombre;
    private String ubicacion;
    private LocalDate fecha;
    private double precio;
    private List<String> artistas;


    //constructor
    public Evento(int codigoEvento, String nombre, LocalDate fecha,  String ubicacion, double precio, List<String> artistas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.precio = precio;
        this.codigoEvento = codigoEvento;
        this.artistas = artistas;

    }
    //getters
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public List<String> getArtistas() {
        return artistas;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    //acción de mostrar información acerca de eventos

    public String mostrarInfo() {
        // Creo esta clase tendria que tener otro atributo llamado info, si no no tendría mucho sentido
        return this.nombre + " \n" + this.fecha + " \n" + this.artistas;
    }

    //accion de actualizar dicha info

    public void actualizarInfo() {
        File archivoOriginal = new File("baseDeDatos/eventos.txt");
        File archivoTemporal = new File("baseDeDatos/eventos_temp.txt");

        try {
            FileReader fr = new FileReader(archivoOriginal);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(archivoTemporal);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;
            // Corregido a getidEvento() según el diagrama UML
            String idBuscar = String.valueOf(this.getCodigoEvento());

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[0].equals(idBuscar)) {
                    bw.write(this.getCodigoEvento() + ";" + this.nombre + ";" + this.ubicacion + ";" + this.precio);
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }
            br.close();
            fr.close();
            bw.close();
            fw.close();

            if (archivoOriginal.delete()) {
                // Corregido: Controlamos el resultado de renameTo
                if (archivoTemporal.renameTo(archivoOriginal)) {
                    System.out.println("Información del evento actualizada.");
                } else {
                    System.out.println("Error al renombrar archivo temporal de eventos.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar evento: " + e.getMessage());
        }
    }
}


