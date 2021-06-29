
package gameconsole;

import conectors.IdJugador;
import conectors.Nombre;
import java.util.UUID;
import javax.swing.JOptionPane;


public class GameConsole {

    public static void main(String[] args) {
        
        UUID id;
        int cantJugadores;
        String nomJugador;
        
        Juego juego = new Juego();
        
       cantJugadores = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos jugadores desea crear?"));
        
       for (int i = 0; i <cantJugadores; i++){
        id = UUID.randomUUID();
        IdJugador idjugador = new IdJugador(id);
        nomJugador = "jugador" + (i + 1);
        Nombre nombre = new Nombre(nomJugador);
        juego.addJugador(idjugador, nombre);        
        }
        
       juego.addPista();
       juego.Jugar();
    }
    
}
