package e2;

import java.util.Observable;

public class ClienteSimple extends Cliente {

    public ClienteSimple(String nombre) {
        this.setNombre(nombre);
    }

    @Override
    public void update(Observable o, Object arg) {

        if ((Info) arg == Info.cierre) {

            setTicket("Cliente: " + this.getNombre() + "\n"
                    + "Simbolo: " + ((Accion) o).getSimbolo() + "\n"
                    + "Cierre: " + ((Accion) o).getCierre() + "\n");

            System.out.println(getTicket().toString());
        }

    }

}
