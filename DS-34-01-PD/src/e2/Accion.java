package e2;

import java.util.Observable;

public class Accion extends Observable {

    private final String simbolo;
    private double maximo, minimo, cierre;
    private int volumen;

    public Accion(String simbolo, double maximo, double minimo, double cierre, int volumen) {
        this.cierre = cierre;
        this.maximo = maximo;
        this.simbolo = simbolo;
        this.minimo = minimo;
        this.volumen = volumen;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getCierre() {
        return cierre;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
        setChanged();
        notifyObservers(Info.maximo);
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
        setChanged();
        notifyObservers(Info.minimo);
    }

    public void setCierre(float cierre) {
        this.cierre = cierre;
        setChanged();
        notifyObservers(Info.cierre);
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
        setChanged();
        notifyObservers(Info.volumen);
    }

}
