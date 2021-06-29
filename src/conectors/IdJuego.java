
package conectors;

import java.util.UUID;


public class IdJuego {
    
    
    public IdJuego() {       
    }
    
    private UUID id;

    public IdJuego(UUID id) {
        this.id = id;
    }

    

    public String getId() {
        return id.toString();
    }

  
    
    
    
}
