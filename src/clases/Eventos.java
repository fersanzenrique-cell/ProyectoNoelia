/**
 * @Author : Jesús Farinango Villa
 */
package clases;
import java.time.LocalDate;

//clase
    public abstract class Eventos {
    private int codigoEvento;
    private String nombre;
    private String Ubicacion;
    private LocalDate fecha;
    private double precio;
    private String artistas;


    //constructor
    public Eventos(String nombre, String ubicacion, LocalDate fecha, double precio, String artistas, int codigoEvento) {
        this.nombre = nombre;
        this.Ubicacion = ubicacion;
        this.fecha = fecha;
        this.precio = precio;
        this.codigoEvento = codigoEvento;
        this.artistas = artistas;

        //getters
    }

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

    public String getArtistas() {
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

    public void setArtistas(String artistas) {
        this.artistas = artistas;
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


