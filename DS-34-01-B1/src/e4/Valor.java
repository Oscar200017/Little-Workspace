/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

/**
 *
 * @author David
 */
public enum Valor {

    CENTIMO_1("Bronce", 1),
    CENTIMO_2("Bronce", 2),
    CENTIMO_5("Bronce", 5),
    CENTIMO_10("Oro", 10),
    CENTIMO_20("Oro", 20),
    CENTIMO_50("Oro", 50),
    CENTIMO_100("Oro_Plata", 100),
    CENTIMO_200("Oro_Plata", 200);

    private int valores;
    private String color;

    public int getValores() {
        return valores;
    }

    public String getColor() {
        return color;
    }

    Valor(String color, int valor) {
        this.color = color;
        this.valores = valor;

    }

}
