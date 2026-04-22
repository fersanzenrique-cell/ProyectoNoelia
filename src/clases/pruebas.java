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
    }
}
