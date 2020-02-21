package e2;

import java.util.Observer;

public abstract class Cliente implements Observer {

    private String nombre;
    private String ticket = "";

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
