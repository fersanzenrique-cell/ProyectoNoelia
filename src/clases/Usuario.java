/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Usuario extends Cliente
{
    private String password;
    public Usuario(){}
    public Usuario(int id, String nombre, String email, String password)
    {
        super(id,nombre,email);
        this.password = password;
    }
    public String getPassword()
    {
        String contraseña = this.password;
        return contraseña;
    }
    public void setPassword(String password)
    {
        this.password = password;
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
            File archivo = new File("baseDeDatos/reservas.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(
                    id + ";" +
                    asientoRandom + ";" +
                    this.getId() + ";" +
                    evento
                    );
        }
        catch (IOException e) { throw new RuntimeException(e); }

        return reserva;
    }

    public String recibirNotificaciones()
    {
        // TO-DO: hacer un fichero que tenga muchas notificaciones y ponerlas en la ventana
        try
        {
            File archivo = new File("baseDeDatos/notificacionUsuario.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            ArrayList<String> notificaciones = new ArrayList<>();
            String linea = lector.readLine();
            while (linea != null)
            {
                notificaciones.add(linea);
                linea = lector.readLine();
            }
            Random rd = new Random();
            return notificaciones.get(rd.nextInt(0, notificaciones.size()));
        }
        catch (IOException e) { throw new RuntimeException(e); }

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
