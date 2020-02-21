package e2_e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Represents a Euro coin collection
public class EuroCoinCollection implements Iterable<EuroCoin> {

    ArrayList<EuroCoin> coleccion = new ArrayList<EuroCoin>();

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
        if (coleccion.isEmpty() && coin.valided) {
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

    public void ordenarNatural() {

        Collections.sort(this.coleccion);

    }

    public void ordenarComparator(Comparador c) {

        Collections.sort(this.coleccion, c);

    }

    @Override
    public Iterator<EuroCoin> iterator() {
        return new Iterador(this);

    }

    public String mostrarEurocoin(Iterador it) {
        String cadena ="";
        while (it.hasNext()) {
            try {
                cadena += it.next().toString();
               // System.out.println(it.next().toString());
            } catch (NullPointerException e) {
                
            }
        }
return cadena;
    }

   
}
