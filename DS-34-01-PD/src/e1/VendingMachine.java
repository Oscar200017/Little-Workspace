package e1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VendingMachine{

    public Map<String, Integer> productos = new HashMap<>();
    public List<EuroCoin> deposito = new ArrayList<>();
    private Cambio cambio;
    
    VendingMachine(){
        setCambio(new CambioSimple());
    }

    public Cambio getCambio() {
        return cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

  
    public void insertProduct(String product, int price) {
        productos.put(product, price);
    }

    
    public void insertCoin(EuroCoin e) {
        deposito.add(e);
        ordenador(deposito);
    }


    public List<EuroCoin> buy(String product) {
        List<EuroCoin> vuelta = new ArrayList<>();
       

        if (productos.containsKey(product)) {
            
            if (productos.get(product) != valorTotalDeposito()) {

                if (productos.get(product) > valorTotalDeposito()) {
                    System.out.println("Importe insuficiente");
                    vuelta = cancel();

                } else {
                    setCambio(cambio);
                  
                  vuelta.addAll(devolver(product));
                     
                }
                
            }else{
            vuelta.clear();
            }

        } else {
            System.out.println("No existe le producto");
            vuelta = cancel();

        }
     
  
        return vuelta;
    }

    public int valorTotalDeposito() {
        int valor = 0;
        for (int i = 0; i <= deposito.size() - 1; i++) {
            valor += deposito.get(i).getValor();
        }
        return valor;
    }

    private List<EuroCoin> devolver(String producto) {
        List<EuroCoin> vuelta = new ArrayList<>();

        vuelta.addAll(cambio.devolverCambio(this, productos.get(producto)));
       
        return vuelta;
    }

    
    public List<EuroCoin> cancel() {
        return deposito;
    }

    
     private void ordenador(List<EuroCoin> monedas) {
        Collections.sort(monedas, new Comparator<EuroCoin>() {
            @Override
            public int compare(EuroCoin o1, EuroCoin o2) {
                return new Integer(o2.getValor()).compareTo(o1.getValor());
            }
        });

    }

}
