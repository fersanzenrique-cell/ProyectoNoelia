/**
 * @Author : Enrique Fernández
 */
package clases;

public class Usuario extends Cliente
{
    private String contraseña;
    public Usuario(){}
    public Usuario(int id, String nombre, String email, String contraseña)
    {
        super(id,nombre,email);
        this.contraseña = contraseña;
    }
    public String getContraseña()
    {
        String contraseña = this.contraseña;
        return contraseña;
    }
    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }
    public Reserva comprarEntrada(Evento evento)
    {
        // TO-DO: hacerlo
        return new Reserva();
    }

    public void recibirNotificaciones()
    {
        // TO-DO: hacer un fichero que tenga muchas notificaciones y ponerlas en la ventana
    }
    public void votarEncuesta()
    {
        // TO-DO: no tendria que haber un objeto llamado encuesta?, ya vere que hacer aqui
    }
    public void proponerArtista(String nombreArtista)
    {
        // TO-DO: HACERLO
    }

}
