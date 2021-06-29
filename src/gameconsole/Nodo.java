
package gameconsole;


public class Nodo {
    
    private Object dato;  // para almacenar cualquier tipo de dato
    private Nodo siguiente, anterior;

    /*    
    //Para trabajar con cola e imprimir el podio 
    public Nodo (Object dato){
        this.dato = dato;
        this.siguiente = null;
    }*/
    
    //trabajar con listas dobles
    public Nodo (Nodo anterior, Object dato, Nodo siguiente){
        this.anterior= anterior;
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

}
