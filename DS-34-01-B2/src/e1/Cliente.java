package e1;

import java.util.Objects;

public final class Cliente extends Persona {

    private int codigoCliente, compras, descuento;

    public Cliente(int codigoCliente, int compras, String nombre, String apellidos, String direccion, String dni, int telefono) {
        super(nombre, apellidos, direccion, dni, telefono);
        setCodigoCliente(codigoCliente);
        setCompras(compras);
        setDescuento();
        controlDeErrores();
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento() {
        if (this.compras >= 100) {
            this.descuento = 1;
        } else {
            this.descuento = 0;
        }
    }

    
    @Override
    public int getCodigoCliente() {

        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {

        this.codigoCliente = codigoCliente;

    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    private void controlDeErrores() {

        if (getCodigoCliente() < 0) {
            throw new IllegalArgumentException("El codigo de cliente no debe ser negativo");

        }
        if (getCompras() < 0) {
            throw new IllegalArgumentException("El codigo de cliente no debe ser negativo");

        }

    }

    @Override
    public String toString() {
  

       return "\nNombre: " + getNombre() + "\n"
                + "Apellidos: " + getApellidos() + "\n"
                + "Direccion: " + getDireccion() + "\n"
                + "Dni: " + getDni() + "\n"
                + "Telefono: " + getTelefono() + "\n"
                + "Codigo del cliente: " + getCodigoCliente() + "\n"
                + "Numero de compras: " + getCompras() + "\n"
                + "Descuento: " + getDescuento() + "\n" + "****************\n";

       
    }

    @Override
    public boolean equals(Object c1) {

        if (c1 instanceof Cliente) {
            Cliente c2 = (Cliente) c1;
            if (this.getCodigoCliente() == c2.getCodigoCliente() || this.getDni().equals(c2.getDni()) || this.getTelefono() == c2.getTelefono()) {
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
        int hash = 0;

        hash = 83 * hash + this.getCodigoCliente();
        hash = 83 * hash + this.getTelefono();
        hash = 83 * hash + Objects.hashCode(this.getDni());

        return hash;
    }

}
