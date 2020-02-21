package e1;

import java.util.Objects;

public abstract class Empleado extends Persona {

    private int segSocial, salario;
    private Turno turno;

    public Empleado(int segSocial, int salario, Turno turno, String nombre, String apellidos, String direccion, String dni, int telefono) {
        super(nombre, apellidos, direccion, dni, telefono);
        this.segSocial = segSocial;
        this.salario = salario;
        this.turno = turno;
        seguridadSocial();
    }

  
    @Override
    public int getSegSocial() {
        return segSocial;
    }


    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getTurno() {

        return turno.getTurno();
    }



    private void seguridadSocial() {
        if (String.valueOf(getSegSocial()).length() != 9) {
            throw new IllegalArgumentException("Numero de seguridad social incorrecto");
        }

    }

    @Override
    public boolean equals(Object e1) {

        if (e1 instanceof Empleado) {
            Empleado e2 = (Empleado) e1;
            if (this.getSegSocial() == e2.getSegSocial() && this.getDni().equals(e2.getDni()) && this.getTelefono() == e2.getTelefono()) {
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

        hash = 83 * hash + this.getSegSocial();
        hash = 83 * hash + Objects.hashCode((this.getDni()));
        hash = 83 * hash + this.getTelefono();
        return hash;
    }

}
