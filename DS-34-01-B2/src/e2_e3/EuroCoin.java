/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

import java.util.Objects;

public class EuroCoin implements Comparable<EuroCoin> {

    private int valor;

    private int fecha;

    public String color, diseño, pais;

    public boolean valided = true;

    public int getFecha() {
        return fecha;
    }

    public int getValor() {
        return valor;
    }

    private void setValor(int valor) {
        this.valor = valor;
    }

    private void setFecha(int fecha) {

        if (fecha >= 2002) {
            this.fecha = fecha;
        } else {

            System.out.println("VALOR DE LA FECHA DEMASIADO PEQUEÑO, SE CAMBIARÁ A 2002");
            this.fecha = 2002;
        }
        if (fecha >= 2019) {
            System.out.println("VALOR DE LA FECHA DEMASIADO ALTO, SE CAMBIARÁ A 2019");
            this.fecha = 2019;
        }

    }

    public String getPais() {
        return pais;
    }

    private void setPais(String pais) {
        this.pais = pais;
    }

    public String getDiseño() {
        return diseño;
    }

    private void setDiseño(String diseño) {
        this.diseño = diseño;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object c1) {
        if (c1 instanceof EuroCoin) {
            EuroCoin c2 = (EuroCoin) c1;
            if (this.valor == c2.valor && this.pais == c2.pais && this.diseño == c2.diseño) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.valor;
        hash = 83 * hash + Objects.hashCode(this.diseño);
        hash = 83 * hash + Objects.hashCode(this.pais);
        return hash;
    }

    public EuroCoin(Valor valor, int fecha, Pais pais, String diseño) {
        setValor(valor.getValores());
        setColor(valor.getColor());
        setPais(pais.getpais());
        setDiseño(diseño);
        setFecha(fecha);

    }

    @Override
    public int compareTo(EuroCoin o) {
        int resultado = 0;

        if (this.valor == o.valor) {

            if (this.pais.compareToIgnoreCase(o.pais) == 0) {

                if (this.diseño.compareToIgnoreCase(o.getDiseño()) == 0) {
                    resultado = 0;
                } else if (this.diseño.compareToIgnoreCase(o.getDiseño()) < 0) {
                    resultado = -1;
                } else if (this.diseño.compareToIgnoreCase(o.getDiseño()) > 0) {
                    resultado = 1;
                }

            } else if (this.pais.compareToIgnoreCase(o.pais) < 0) {
                resultado = -1;
            } else if (this.pais.compareToIgnoreCase(o.pais) > 0) {
                resultado = 1;
            }

        } else if (this.valor < o.valor) {

            resultado = 1;
        } else if (this.valor > o.valor) {

            resultado = -1;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Valor: " + getValor() + "\n"
                + "Color: " + getColor() + "\n"
                + "Pais: " + getPais() + "\n"
                + "Fecha: " + getFecha()+ "\n"
                + "Diseño: " + getDiseño()+ "\n";
              

    }

}
