
package e1;


public class Reponedor extends Empleado{
    String empresa;
    public Reponedor(String empresa,int segSocial, int salario, Turno turno, String nombre, String apellidos, String direccion, String dni, int telefono) throws IllegalArgumentException{
        super(segSocial, salario, turno, nombre, apellidos, direccion, dni, telefono);
        this.empresa = empresa;
        if(turno == Turno.N){
        throw new IllegalArgumentException();
        }
        
    }
   

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
                + "Empresa: " + getEmpresa() + " \n"
                + "Salario: " + getSalario()+ " \n" + "****************\n";
    }
}
