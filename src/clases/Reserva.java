/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

import java.io.*;

public class Reserva
{
    private int idReserva;
    private String asiento;
    private Usuario usuario;
    private Evento evento;
    public Reserva(){}
    public Reserva(int idReserva, String asiento, Usuario usuario, Evento evento)
    {
        this.idReserva = idReserva;
        this.asiento = asiento;
        this.usuario = usuario;
        this.evento = evento;
    }
    public int getIdReserva()
    {
        int idReserva = this.idReserva;
        return idReserva;
    }
    public void setIdReserva(int idReserva)
    {
        this.idReserva = idReserva;
    }
    public String getAsiento()
    {
        String asiento = this.asiento;
        return asiento;
    }
    public void setAsiento(String asiento)
    {
        this.asiento = asiento;
    }
    public Usuario getUsuario()
    {
        Usuario usuario = this.usuario;
        return usuario;
    }
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
    public Evento getEvento()
    {
        Evento evento = this.evento;
        return evento;
    }
    public void setEvento(Evento evento)
    {
        this.evento = evento;
    }
    public void confirmarReserva() {
        String rutaArchivo = "baseDeDatos/reservas.txt";
        try {
            FileWriter fw = new FileWriter(rutaArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.idReserva + ";" + this.asiento + ";" + this.usuario.getNombre() + ";" + this.evento.getCodigoEvento());
            bw.newLine();

            bw.close();
            fw.close();
            System.out.println("Reserva guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar reserva: " + e.getMessage());
        }
    }
    public void cancelarReserva() {
        File archivoOriginal = new File("baseDeDatos/reservas.txt");
        File archivoTemporal = new File("baseDeDatos/reservas_temp.txt");

        try {
            FileReader fr = new FileReader(archivoOriginal);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(archivoTemporal);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;
            String idBuscar = String.valueOf(this.idReserva);

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (!datos[0].equals(idBuscar)) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
            br.close();
            fr.close();
            bw.close();
            fw.close();

            if (archivoOriginal.delete()) {
                archivoTemporal.renameTo(archivoOriginal);
                System.out.println("Reserva eliminada con éxito.");
            }
        } catch (IOException e) {
            System.out.println("Error al cancelar reserva: " + e.getMessage());
        }
    }
}
