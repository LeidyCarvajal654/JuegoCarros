
package gameconsole;

import conectors.IdCarro;
import conectors.IdJuego;


public class Carril {
    
   IdCarro idcarro;
   IdJuego idjuego;
   Posicion posicion;
   int metros;
   boolean movFinal;

    public Carril(IdCarro idcarro, IdJuego idjuego, Posicion posicion, int metros, boolean movFinal) {
        this.idcarro = idcarro;
        this.idjuego = idjuego;
        this.posicion = posicion;
        this.metros = metros;
        this.movFinal = movFinal;
    }
   
  public Integer metros() {
        return metros;
    }
  
   public Posicion posicion() {
        return posicion;
    }
   
   public int posActual() {
        return posicion.actual();
    }
   
   public Integer meta() {
        return posicion.meta();
    }
   
   public boolean movFinal(){
       return movFinal;
   }
   
    public void alcanzarLaMeta() {
        if (posActual() >= meta()) {
            movFinal = true;
        }

    }
    public void moverCarro(Posicion posicion, int cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.actual() + cantidad);
        alcanzarLaMeta();
    }

}
