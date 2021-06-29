
package gameconsole;

public class Posicion {
    
    private int actual;
    private int meta;
    
    public Posicion(int actual, int meta) {
        this.actual = actual;
        this.meta = meta;
    }
    
    
    public int actual() {
        return actual;
    }

  
    public int meta() {
        return meta;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

  
}
