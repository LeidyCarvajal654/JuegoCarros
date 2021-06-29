
package gameconsole;

import conectors.Nombre;


public class Jugador {
    
    private Nombre nombre;
    private int puntos;

    public Jugador(Nombre nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }
    
     public Nombre nombre() {
        return nombre;
    }
     
      public void addPuntos(int puntos) {
        puntos = puntos;
    }
    
    
}
