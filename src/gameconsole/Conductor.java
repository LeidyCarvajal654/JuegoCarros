
package gameconsole;

public class Conductor {
    
    private String nombre;

    public Conductor() {      
    }

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

     public String nombre() {
        return nombre;
    }
    
     public int lanzarDado(){
         int aleatorioDado = (int) (Math.random() * 6) +1;
         return aleatorioDado;
     }
    
    
}
