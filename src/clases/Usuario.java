/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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

        Random random = new Random();
        String asientoRandom = String.valueOf(random.nextInt(1,1001));
        int id = random.nextInt(10000,20000);
        Reserva reserva = new Reserva(
                id,
                asientoRandom,
                this,
                evento
        );
        try
        {
            File archivo = new File("baseDeDatos/reservas");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(
                    id + ";" +
                    asientoRandom + ";" +
                    this.getId() + ";" +
                    evento
                    );
            escritor.close();
        }
        catch (IOException e) { throw new RuntimeException(e); }

        return reserva;
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
