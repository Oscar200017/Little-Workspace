
package e1;

import java.util.List;

public interface Cambio {
    
    List<EuroCoin> devolverCambio(VendingMachine maquina,int precio);
    
}
