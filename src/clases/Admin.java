/**
 * @Author : Enrique Fernández Sanz
 */
package clases;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Usuario
{
    public Admin(){}
    public Admin(int id, String nombre, String email, String password)
    {
        super(id,nombre,email,password);
    }
    public void modificarEvento(Evento evento)
    {
        // TO-DO: hacerlo
    }
    public void gestionarContenido()
    {
        // TO-DO: hacerlo
    }
    public List<String> verConsultas()
    {
        // TO-DO: crear un documento, append cada vez que estas dos funciones de arriba ^^ y escribir que hicieron
        List<String> consultas = new ArrayList<>();
        return consultas;
    }
}
