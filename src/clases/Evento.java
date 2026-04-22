/**
 * @Author : Jesús Farinango Villa
 */
package clases;
import java.time.LocalDate;
import java.util.List;

//clase
public class Evento {
    private int codigoEvento;
    private String nombre;
    private String Ubicacion;
    private LocalDate fecha;
    private double precio;
    private List<String> artistas;


    //constructor
    public Evento(int codigoEvento, String nombre, LocalDate fecha,  String ubicacion, double precio, List<String> artistas) {
        this.nombre = nombre;
        this.Ubicacion = ubicacion;
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
        return Ubicacion;
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
        Ubicacion = ubicacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    //acción de mostrar información acerca de eventos

    public String mostrarInfo() {

        return "";
    }

    //accion de actualizar dicha info

    public void actualizarInfo() {

    }
    //método para reservar

    public int Reserva() {

        return 0;
    }


}


