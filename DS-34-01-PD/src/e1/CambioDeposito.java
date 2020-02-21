
package e1;

import java.util.ArrayList;
import java.util.List;


public class CambioDeposito implements Cambio {

    private List<EuroCoin> vuelta = new ArrayList<>();
    private List<EuroCoin> cajaMonedas = new ArrayList<>();

    @Override
    public List<EuroCoin> devolverCambio(VendingMachine maquina, int precio) {
        int valorTotalMonedas = maquina.valorTotalDeposito();
        int aux = valorTotalMonedas - precio;
        int j = 0;
      depositoMonedas_Crear();
        while (j <=cajaMonedas.size() - 1) {
            for (int i = 0; i <= cajaMonedas.size() - 1; i++) {
                if ((aux - cajaMonedas.get(i).getValor()) >= 0) {
                    aux -= cajaMonedas.get(i).getValor();
                    vuelta.add(cajaMonedas.get(i));
                    break;
                }
            }
            j++;
        }

        return vuelta;
    }

    private void depositoMonedas_Crear() {
        cajaMonedas.add(EuroCoin.Euro_200);
        cajaMonedas.add(EuroCoin.Euro_100);
        cajaMonedas.add(EuroCoin.Euro_50);
        cajaMonedas.add(EuroCoin.Euro_20);
        cajaMonedas.add(EuroCoin.Euro_10);
        cajaMonedas.add(EuroCoin.Euro_5);
        cajaMonedas.add(EuroCoin.Euro_2);
        cajaMonedas.add(EuroCoin.Euro_1);
   

    }


}
