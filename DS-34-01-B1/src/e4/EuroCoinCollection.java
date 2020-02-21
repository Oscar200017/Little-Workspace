package e4;

import java.util.ArrayList;
import java.util.Objects;


// Represents a Euro coin collection
public class EuroCoinCollection {

    ArrayList<EuroCoin> coleccion = new ArrayList<>();
    
    private boolean comparadorEuros(EuroCoin c1, EuroCoin c2) {
        boolean igual = true;
        if (c1.equals(c2)) {
            igual = true;
        } else {
            igual = false;
        }
        return igual;
    }

// Inserts a coin in the collection . If the coin is already in the
// collection ( there is an equal coin inserted ) then the coin is not inserted .
// Returns true only if a new coin has been inserted in the collection .   
    public boolean insertCoin(EuroCoin coin) {
        boolean insertado = false;
        if (coleccion.size() == 0 && coin.valided) {
            coleccion.add(coin);
            System.out.println("SE HA INSERTADO CORRECTAMENTE LA PRIMERA MONEDA EN LA COLECCIÓN ");
            insertado = true;
        } else {
            for (int i = 0; i < coleccion.size(); i++) {
                if (!hasCoin(coin) && coin.valided) {
                    insertado = true;
                    coleccion.add(coin);
                }
            }
        }
        return insertado;
    }
// Checks if a coin has been already inserted in the collection

    public boolean hasCoin(EuroCoin coin) {
        boolean existe = false;

        for (int i = 0; i < coleccion.size(); i++) {
            if (comparadorEuros(coin, coleccion.get(i))) {
                existe = true;
                break;
            }
        }

        return existe;
    }
// Returns the nominal value of the entire collection in euro cents .

    public int value() {
        int valor = 0;
        for (int i = 0; i < coleccion.size(); i++) {

            valor = valor + coleccion.get(i).getValor();

        }

        return valor;
    }
// Counts the number of coins in the collection .

    public int numCoins() {

        return coleccion.size();
    }

// Removes the specified coin from the collection
    public void removeCoin(EuroCoin coin) {

        for (int i = 0; i < coleccion.size(); i++) {
            if (comparadorEuros(coin, coleccion.get(i))) {
                coleccion.remove(i);
                break;
            }
        }

    }

    public static void main(String[] args) {

        EuroCoinCollection coleccion = new EuroCoinCollection();

        EuroCoin c1 = new EuroCoin(Valor.CENTIMO_1, 2009, "España", "Juan Carlos");
        EuroCoin c2 = new EuroCoin(Valor.CENTIMO_200, 2008, "España", "Felipe vi");
        coleccion.insertCoin(c1);
        coleccion.insertCoin(c2);
        System.out.println("Numero de monedas: " + coleccion.numCoins());
        System.out.println("Valor total de la coleccion: " + coleccion.value());
        System.out.println("Tiene la moneda?: " + coleccion.hasCoin(c1));

        coleccion.removeCoin(c1);
        System.out.println("Se ha eliminado la moneda");

        System.out.println("Numero de monedas: " + coleccion.numCoins());
        System.out.println("Valor total de la coleccion: " + coleccion.value());

    }
}
