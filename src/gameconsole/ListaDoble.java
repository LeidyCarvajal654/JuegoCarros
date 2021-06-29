
package gameconsole;

public class ListaDoble {
    
    private Nodo cabeza, q;
    
    public ListaDoble(){
        cabeza= null;
    }
    
    public boolean isEmpty(){
        return cabeza == null;
    }
    
    public void add (Object dato){
        if (isEmpty()){
            q = cabeza = new Nodo(null,dato,null);
        }else{
            q.setSiguiente(new Nodo(q,dato,null));
        }
    }
    
    public Nodo getCabeza(){
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
}
