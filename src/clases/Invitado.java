/**
 * @Author : Enrique Fernández Sanz
 */
package clases;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invitado
{
    public Invitado(){}
    public List<Evento> verEventos()
    {
        List<Evento> listaEventos = new ArrayList<>();
        try
        {
            File archivo = new File("baseDeDatos/eventos.txt");
            if (archivo.exists())
            {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String linea = lector.readLine();
                while (linea != null)
                {
                    String[] splitLinea = linea.split(";");
                    String[] fecha = splitLinea[2].split("-");
                    List<String> artistas = new ArrayList<>(Arrays.asList(splitLinea[5].split(",")));
                    listaEventos.add(new Evento(
                            Integer.parseInt(splitLinea[0]),
                            splitLinea[1],
                            LocalDate.of(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2])),
                            splitLinea[3],
                            Float.parseFloat(splitLinea[4]),
                            artistas));
                    linea = lector.readLine();
                }
                lector.close();
            }
            else
            {
                System.err.println("El archivo de eventos no existe.");
            }
        }
        catch (FileNotFoundException e) { throw new RuntimeException(e); }
        catch (IOException e) { throw new RuntimeException(e);}
        return listaEventos;
    }
}
