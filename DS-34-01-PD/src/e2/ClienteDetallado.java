package e2;

import java.util.Observable;

public class ClienteDetallado extends Cliente {

    public ClienteDetallado(String nombre) {
        this.setNombre(nombre);
    }

    @Override
    public void update(Observable o, Object arg) {

        setTicket("Cliente: " + this.getNombre() + "\n"
                + "Simbolo: " + ((Accion) o).getSimbolo() + "\n"
                + "Cierre: " + ((Accion) o).getCierre() + "\n"
                + "Máximo: " + ((Accion) o).getMaximo() + "\n"
                + "Minimo: " + ((Accion) o).getMinimo() + "\n"
                + "Volumen: " + ((Accion) o).getVolumen() + "\n");

        System.out.println(getTicket().toString());

    }

}
