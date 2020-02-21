package e1;

import java.util.ArrayList;
import java.util.List;


public class CambioSimple implements Cambio {

    private List<EuroCoin> vuelta = new ArrayList<>();

    @Override
    public List<EuroCoin> devolverCambio(VendingMachine maquina, int precio) {
       // System.out.println("--------"+maquina.deposito.size());
        vuelta.clear();
        int valorTotalMonedas = maquina.valorTotalDeposito();
        int aux = valorTotalMonedas - precio;
        int j = 0;
        int i = 0;

        while (j <= maquina.deposito.size() - 1) {
            while ( i <= maquina.deposito.size() - 1) {
                if ((aux - maquina.deposito.get(i).getValor()) >= 0) {
                    aux -= maquina.deposito.get(i).getValor();
          
                    vuelta.add(maquina.deposito.get(i));
                   
                    i++;
                   break;
                }
                i++;
            }
            j++;
        }
     
        //System.out.println("*****"+vuelta.toString());
        return vuelta;

    }
    


}
