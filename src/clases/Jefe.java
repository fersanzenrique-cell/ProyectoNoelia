/**
 * @Author : Enrique Fernández Sanz
 */
package clases;

import java.io.*;

public class Jefe extends Admin
{
    public Jefe(){}
    public Jefe(int id, String nombre, String email, String password)
    {
        super(id,nombre,email,password);
    }
    public void crearAdmin(Admin admin) {
        try
        {
            boolean alreadyExists = false;
            File archivo = new File("baseDeDatos/listaAdmins.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null)
            {
                String[] atributos = linea.split(";");
                if (
                        Integer.parseInt(atributos[0]) == admin.getId()
                                && atributos[1].equals(admin.getNombre())
                                && atributos[2].equals(admin.getEmail())
                                && atributos[3].equals(admin.getPassword())
                )
                    alreadyExists = true;
                linea = lector.readLine();
            }
            if (!alreadyExists)
            {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true));
                escritor.write(admin.getId() + ";" + admin.getNombre() + ";" + admin.getEmail() + ";" + admin.getPassword() + "\n");
                escritor.close();
            }
            else {
                System.out.println("admin ya añadido");
            }
            lector.close();
        }
        catch (IOException e) { throw new RuntimeException(e); }
    }
    public void eliminarAdmin(Admin admin) {
        try
        {
            File archivo = new File("baseDeDatos/listaAdmins.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
            String linea = lector.readLine();
            while (linea != null)
            {
                String[] atributos = linea.split(";");
                if (
                        Integer.parseInt(atributos[0]) == admin.getId()
                        && atributos[1].equals(admin.getNombre())
                        && atributos[2].equals(admin.getEmail())
                        && atributos[3].equals(admin.getPassword())
                )
                    escritor.write("");
                linea = lector.readLine();
            }
            lector.close();
            escritor.close();
        }
        catch (FileNotFoundException e) { throw new RuntimeException(e); }
        catch (IOException e) { throw new RuntimeException(e); }
    }
    // TO-DO falta terminar eliminarAdmin
}
