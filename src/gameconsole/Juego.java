
package gameconsole;

import conectors.IdCarro;
import conectors.IdJuego;
import conectors.IdJugador;
import conectors.Nombre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;



public class Juego {
    
    private ListaDoble listaConductor,listaCarro;
    
    public Juego(){      
    }
    
    Map<IdJugador, Jugador> players = new HashMap<>();
    Carro carro = new Carro();
    Podio podio = new Podio();
    ArrayList<Pista> pistas = new ArrayList<>();
    ArrayList<Carro> carrosjugando = new ArrayList<>();
    ArrayList<Carril> carrilesActivos = new ArrayList<>();
    Boolean juegoEnCurso;
    
    public void addJugador(IdJugador idjugador,Nombre nombre){
        Jugador jugador = new Jugador(nombre, 0);
        players.put(idjugador, jugador);
        addConductor(nombre);
    }
  
    public void addConductor (Nombre nombre){
        UUID id; 
        JOptionPane.showConfirmDialog(null, "Desea que el jugador con nombre: " +nombre.getNombre()+ " Sea conductor ?");
        
        while(true){
        Conductor conductor = new Conductor();
        id = UUID.randomUUID();
        IdCarro idcarro = new IdCarro(id);
        carro.addConductor(idcarro, conductor);
        }
        
    }
    
    public void addPista(){
        int kmAleat;
        int cantCarriles = carro.numeroCarros();
        for(int i =0; i<carro.numeroCarros();i++){
            kmAleat = (int)(Math.random()*100 +1);
            Pista pista = new Pista (kmAleat,cantCarriles);
            pistas.add(pista);
        }
        
    }

    public void Jugar(){
        UUID id;
        id = UUID.randomUUID();
        IdJuego idjuego = new IdJuego ();
        
        int opcPista, cont = 1;
              
        opcPista= Integer.parseInt(JOptionPane.showInputDialog("Elige el número de la pista en que deseas juegar"));
        for (Pista p: pistas){
            System.out.println(cont+"." + "kilometros: " + p.km() + "Cantidad de carriles: "+p.cantCarriles());
            cont ++;
        }
        // Crear lista de carros en juego
        
        carro.carros().forEach((key,value) ->{
        Carro juegocarros = new Carro (value,0,idjuego);
        carrosjugando.add(juegocarros);        
            //añadir carros a los Carriles para jugar
             int kmMts = pistas.get(opcPista -1).km()*1000;
             Posicion posicion = new Posicion (0,kmMts);
             Carril carriles = new Carril (key,idjuego,posicion,kmMts,false);
             carrilesActivos.add(carriles);
    });
        //Iniciar JUEGO
        juegoEnCurso = true;
        Conductor conductor = new Conductor();
        
        //Mientras no hayan 3 ganadores el juego continua
        while (juegoEnCurso) {
            int contJuego = 0;
            System.out.println("--------Avance----- " + "--------- Meta: " + carrilesActivos.get(contJuego).metros() + " metros");
            for (Carro carros : carrosjugando) {
                //Si el carro no ha ganado sigue jugando
                if (!hayGanador(carros.conductor().nombre())) {
                    int mover = conductor.lanzarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesActivos.get(contJuego).moverCarro(carrilesActivos.get(contJuego).posicion(), mover);
                    System.out.println(carros.conductor().nombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());
                    //Si el jugador llego a la final, asignarle la posición y el podio
                    if (carrilesActivos.get(contJuego).movFinal()) {
                        if (podio.primerLugar() == null) {
                            addPrimerLugar(idjugador(carros.conductor().nombre()));
                        } else if (podio.segundoLugar() == null) {
                            addSegundoLugar(idjugador(carros.conductor().nombre()));
                        } else if (podio.tercerLugar() == null) {
                            addTercerLugar(idjugador(carros.conductor().nombre()));
                        }
                    }

                }
                contJuego++;
            }
            if (podio.Lleno()) {
                break;
            }

        }
        mostrarPodio();
    }
    
    // Retorna el id del jugador dando el nombre del jugador
    public IdJugador idjugador(String nombre) {
        IdJugador verId = null;
        for (IdJugador keys : players.keySet()) {
            if (players.get(keys).nombre().getNombre().equals(nombre)) {
                verId = keys;
            }
        }
        return verId;
    }
    
    public void addPrimerLugar(IdJugador idjugador) {
        podio.asignarPrimerLugar(players.get(idjugador));
        System.out.println("El primer lugar es: " + players.get(idjugador).nombre().getNombre());
    }

    public void addSegundoLugar(IdJugador idjugador) {
        podio.asignarSegundoLugar(players.get(idjugador));
        System.out.println("El segundo lugar es: " + players.get(idjugador).nombre().getNombre());
    }

    public void addTercerLugar(IdJugador idjugador) {
        podio.asignarTercerLugar(players.get(idjugador));
        System.out.println("El tercer lugar es: " + players.get(idjugador).nombre().getNombre());
    }
       
    //Retorna True  si el carro en la carrera ya ganó
    public Boolean hayGanador(String nombre) {
        boolean hayGanador = false;
        if (podio.tercerLugar() == players.get(idjugador(nombre))
                || podio.primerLugar() == players.get(idjugador(nombre))
                || podio.segundoLugar() == players.get(idjugador(nombre))) {
            hayGanador = true;
        }
        return hayGanador;
    }
    
    public void mostrarPodio(){
        System.out.println("Primer Lugar:  " + podio.primerLugar().nombre().getNombre());
        System.out.println("Segundo Lugar:  " + podio.segundoLugar().nombre().getNombre());
        System.out.println("Tercer Lugar:  " + podio.tercerLugar().nombre().getNombre());
        repetirJuego();
    }
    
    public void repetirJuego(){
        JOptionPane.showConfirmDialog(null, "¿Desea jugar de nuevo?", "Alerta!", JOptionPane.YES_NO_OPTION);
        while(true){
            carrosjugando.clear();
            carrilesActivos.clear();
            Podio nuevoPodio = new Podio();
            podio = nuevoPodio;
            Jugar();
        }
    }
    
    }
    

    
