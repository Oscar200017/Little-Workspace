
package e1;


public abstract class Persona {

    private String nombre,apellidos,direccion,dni;
    private int telefono;
    
  public int getCodigoCliente(){
  
  return 0;
  }
  
  public int  getSegSocial(){
  
  return 0;
  }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellidos, String direccion, String dni, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        
        controlErrores();
        
        
        
    }
    
   
    //Metodo encargado de asegurarse que no se puedan introducir clientes no validos
    private void controlErrores() {
       
        int longitudTelefono = Long.toString(getTelefono()).length();

       
        if (longitudTelefono != 9) {
            throw new IllegalArgumentException("EL numero de telefono debe tener 9 números");
        }
        if (getNombre() == null || getApellidos() == null || getDireccion() == null) {
            throw  new IllegalArgumentException("No se han introducido algun elemento");
        }
        if (!controlDni()) {
            throw new IllegalArgumentException("Formato de dni no valido");
        }

       
       
    }

    //Metodo que se asegura que el formato del dni sea el correcto
    private boolean controlDni() {
        boolean control = true;
        String dniCorregido;
        char digitos[] = getDni().toCharArray();

        if (getDni().length() != 9) {
            control = false;
        } else {

            for (int i = 0; i <= 7; i++) {
                if (Character.isDigit(digitos[i]) && i <= 7) {
                } else {
                    control = false;
                    break;
                }
            }
            if (Character.isAlphabetic(digitos[8])) {
             digitos[8] =  Character.toUpperCase(digitos[8]);
                dniCorregido = new String(digitos);
                setDni(dniCorregido);
            } else {
                control = false;
            }
        }
        return control;
    }
    
     
   
    
}
