
package conectors;

import java.util.UUID;


public class IdJugador {
    
    public IdJugador() {      
    }
    
    private UUID id;

    public IdJugador(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }

}
