/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author David
 */
public class Dependiente extends Empleado {
    
    private String especialidad;
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public Dependiente(String especialidad, int segSocial, int salario, Turno turno, String nombre, String apellidos, String direccion, String dni, int telefono) {
        super(segSocial, salario, turno, nombre, apellidos, direccion, dni, telefono);
        this.especialidad = especialidad;
        if (turno == Turno.N) {
            setSalario(salario + 150);
            
        }
    }
    
    @Override
    public String toString() {

        
        return "\nNombre: " + getNombre() + " \n"
                + "Apellidos: " + getApellidos() + " \n"
                + "Direccion: " + getDireccion() + " \n"
                + "Dni: " + getDni() + " \n"
                + "Telefono: " + getTelefono() + " \n"
                + "Seguridad Social: " + getSegSocial() + " \n"
                + "Turno: " + getTurno() + " \n"
                + "Especialidad: " + getEspecialidad() + " \n"
                + "Salario: " + getSalario() + " \n" + "****************\n";
    }
    
}
