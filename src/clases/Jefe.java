/**
 * @Author : Enrique Fernández
 */
package clases;

public class Jefe extends Admin
{
    public Jefe(){}
    public Jefe(int id, String nombre, String email, String contraseña)
    {
        super(id,nombre,email,contraseña);
    }
    public void crearAdmin(Admin admin) {

    }
    public void eliminarAdmin(Admin admin) {

    }
    // TO-DO estas dos funciones, escribiran/eliminaran en un archivo un admin para que se pueda iniciar sesion
}
