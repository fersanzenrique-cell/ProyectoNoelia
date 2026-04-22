/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

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
    public void confirmarReserva()
    {

    }
    public void cancelarReserva()
    {

    }
    // TO-DO: hacer estas dos ultimas funciones
}
