package clases;

import java.util.Random;

class pruebas
{
    public static void main(String[] args)
    {
        Random random = new Random();

        String frase = "";
        for (int i = 0; i < 3; i++) {
           frase += "" + ((char) (random.nextInt( 65,91)));
        }
        System.out.println(frase);
        Invitado invitado = new Invitado();
        for (Evento evento : invitado.verEventos())
        {
            System.out.println(evento.getNombre() + " " + evento.getUbicacion());
        }
        Jefe jefesupremo = new Jefe(302,"Enrique", "enriquefernadezsanz@gmail.com", "6767");
        jefesupremo.crearAdmin(new Admin(3245,"Maria", "maria@gmail.com", "4141"));
        jefesupremo.crearAdmin(new Admin(3245, "Maria", "maria@gmail.com", "4141"));
        jefesupremo.crearAdmin(new Admin(1872, "Carlos", "carlos.admin@gmail.com", "8291"));
        jefesupremo.crearAdmin(new Admin(4510, "Lucia", "lucia.staff@gmail.com", "5523"));
        jefesupremo.crearAdmin(new Admin(9087, "David", "david.manager@gmail.com", "7310"));
        jefesupremo.crearAdmin(new Admin(2764, "Elena", "elena.control@gmail.com", "1945"));
        jefesupremo.crearAdmin(new Admin(6138, "Javier", "javier.admin@gmail.com", "6672"));
        jefesupremo.crearAdmin(new Admin(7451, "Paula", "paula.events@gmail.com", "8080"));
        jefesupremo.crearAdmin(new Admin(3926, "Sergio", "sergio.staff@gmail.com", "1357"));
        jefesupremo.crearAdmin(new Admin(5843, "Andrea", "andrea.manager@gmail.com", "2468"));
        jefesupremo.crearAdmin(new Admin(8119, "Raul", "raul.control@gmail.com", "9090"));
        //jefesupremo.eliminarAdmin(new Admin(3245,"Maria", "maria@gmail.com", "4141"));
    }
}
