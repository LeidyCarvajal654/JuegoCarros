
package conectors;

import java.util.UUID;


public class IdCarro {
    
     private UUID id;

    public IdCarro(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }

}
