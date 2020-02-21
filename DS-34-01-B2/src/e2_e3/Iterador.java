/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author David
 */
public class Iterador implements Iterator<EuroCoin> {

    int posicion = 0;
    int indice = 0;
    boolean mostrable = false;
    boolean precisionSimple = true;
    boolean borrable = false;
    String pais = "";

    ArrayList<EuroCoin> coleccion;

    @Override
    public boolean hasNext() {

        return posicion < coleccion.size();
    }

    @Override
    public EuroCoin next() throws NoSuchElementException {

        if (!hasNext()) {
            throw new NoSuchElementException("No hay mas elementos en la coleccion");

        }

        mostrable = true;
        EuroCoin coin = null;

        while (hasNext()) {
            coin = coleccion.get(posicion);
            if (coin.pais.equals(pais) || precisionSimple == false) {
                mostrable = true;
                borrable = true;
                posicion++;
                
                break;
            } else {
                mostrable = false;
                posicion++;

            }

        }
        
        if (mostrable == false) {
            coin = null;
        }

        return coin;

    }

    @Override
    public void remove() throws IllegalStateException {
        if (borrable) {

            coleccion.remove(coleccion.get(posicion));
        } else {

            throw new IllegalStateException("No se ha usado Next");
        }
        borrable = false;

    }

    public Iterador(EuroCoinCollection coleccion, String pais) {
        this.coleccion = coleccion.coleccion;
        this.pais = pais;
    }

    public Iterador(EuroCoinCollection coleccion) {
        this.coleccion = coleccion.coleccion;
        precisionSimple = false;
    }

}
