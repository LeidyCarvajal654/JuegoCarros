
package gameconsole;


public class Podio {
    
    Jugador primerLugar;
    Jugador segundoLugar;
    Jugador tercerLugar;
    
    public Podio() {
    }
    
    public void asignarPrimerLugar(Jugador jugador) {
        primerLugar = jugador;
    }

    public void asignarSegundoLugar(Jugador jugador) {
        segundoLugar = jugador;
    }

    public void asignarTercerLugar(Jugador jugador) {
        tercerLugar = jugador;
    }
    
    public Jugador primerLugar() {
        return primerLugar;
    }
    
    public Jugador segundoLugar(){
        return segundoLugar;
    }
    
    public Jugador tercerLugar(){
        return tercerLugar;
    }
    
    public Boolean Lleno() {
        Boolean lleno = false;
        if (primerLugar != null && segundoLugar != null && tercerLugar != null) {
            lleno = true;
        }
        return lleno;
    }
    
}
