
package gameconsole;

import conectors.IdJugador;
import conectors.Nombre;
import java.awt.Color;
import java.util.Scanner;
import java.util.UUID;



public class GameConsole {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);  
        UUID id;
        int cantJugadores;
        String nomJugador;
        
        Juego juego = new Juego();
        
       System.out.println("¿Cuántos jugadores desea crear?");
        while(!in.hasNextInt()) in.next();         
        cantJugadores = in.nextInt();
        
       for (int i = 0; i <cantJugadores; i++){
        id = UUID.randomUUID();
        IdJugador idjugador = new IdJugador(id);
        nomJugador = "jugador " + (i + 1);
        Nombre nombre = new Nombre(nomJugador);
        juego.addJugador(idjugador, nombre);        
        }
        
       juego.addPista();
       juego.Jugar();
    }
    
}
