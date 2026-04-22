/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

public class Cliente extends Invitado
{
    private int id;
    private String nombre;
    private String email;
    public Cliente(){}
    public Cliente(int id, String nombre, String email)
    {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    public int getId()
    {
        int id = this.id;
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getNombre()
    {
        String nombre = this.nombre;
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getEmail()
    {
        String email = this.email;
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
