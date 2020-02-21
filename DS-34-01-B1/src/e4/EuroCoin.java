/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

import java.util.Objects;

/**
 *
 * @author David
 */
public class EuroCoin {

    private String paisIso[] = {"AT", "BE", "CY", "NL", "EE", "FI", "FR", "DE", "GR", "IE", "IT",
        "LV", "LT", "LU", "MT", "MC", "PT", "SM", "SK", "SI", "ES", "VA"};
    private String paisLista[] = {"Austria", "Belgica", "Chipre", "Holanda", "Estonia", "Finlandia", "Francia", "Alemania",
        "Grecia", "Irlanda", "Italia", "Latvia", "Lituania", "Luxemburgo", "Malta", "Monaco",
        "Portugal", "San Marino", "Eslovaquia", "Eslovenia", "España", "Ciudad del Vaticano"};
    public int valor;
    private int fecha;
    public String color, diseño, pais;

    private Valor valores;

    public boolean valided = true;

    public int getFecha() {
        return fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setFecha(int fecha) {

        if (fecha > 2002) {
            this.fecha = fecha;
        } else {

            System.out.println("VALOR DE LA FECHA DEMASIADO PEQUEÑO, SE CAMBIARÁ A 2002");
            this.fecha = 2002;
        }
        if (fecha > 2019) {
            System.out.println("VALOR DE LA FECHA DEMASIADO ALTO, SE CAMBIARÁ A 2019");
            this.fecha = 2019;
        }

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDiseño() {
        return diseño;
    }

    public void setDiseño(String diseño) {
        this.diseño = diseño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void asignadorPais(String pais_param) {
        boolean valided = false;
        for (int i = 0; i < paisLista.length; i++) {
            if (pais_param == paisLista[i] || pais_param == paisIso[i]) {

                valided = true;
                setPais(paisIso[i]);
            }

        }

        if (valided == false) {
            System.out.println("ERROR, PAIS DENEGADO: NO SE RECONOCE EL PAIS, COMPRUEBE QUE LO HA INTRODUCIDO EN UN FORMATO VÁLIDO");
        } else {
            System.out.println("Pais aceptado");

        }
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

    public EuroCoin(Valor valor, int fecha, String pais, String diseño) {
        setValor(valor.getValores());
        setColor(valor.getColor());
        asignadorPais(pais);
        setDiseño(diseño);
        setFecha(fecha);
    }

}
