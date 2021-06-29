
package gameconsole;

import conectors.IdCarro;
import conectors.IdJuego;
import java.util.HashMap;
import java.util.Map;


public class Carro {
    
   Conductor conductor;
   int distancia;
   IdJuego idjuego;
   
   Map<IdCarro, Conductor> carros = new HashMap<>();
   
    public Carro() {
    }

    public Carro(Conductor conductor, int distancia, IdJuego idjuego) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.idjuego = idjuego;
    }
    
    public void addConductor (IdCarro idcarro, Conductor conductor){
        carros.put(idcarro, conductor);
    }

    public Map<IdCarro, Conductor> carros() {
        return carros;
    }
    
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

     public int numeroCarros() {
        return carros.size();
    }
     
    public Conductor conductor() {
        return conductor;

    }

    public int distancia() {
        return distancia;

    } 
    

    
    
}
