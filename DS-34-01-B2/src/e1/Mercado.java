package e1;

import java.util.ArrayList;

public class Mercado {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();

    public ArrayList<Persona> personasMercado() {
        ArrayList<Persona> personas = new ArrayList<>();

        personas.addAll(clientes);
        personas.addAll(empleados);

        return personas;
    }

    public int salariosMercado() {
        int resultado = 0;
        for (int i = 0; i < empleados.size(); i++) {
            resultado += empleados.get(i).getSalario();

        }

        return resultado;
    }

    public boolean agregarClientes(ArrayList<? extends Cliente> c) {
        boolean valided = false;
        boolean control;
    
            for (int i = 0; i < c.size(); i++) {
                try {
                    controlIgualdad(clientes, c.get(i));
                    control = true;
                } catch (IllegalArgumentException e) {
                    control = false;
                }
                if (control) {
                    clientes.add(c.get(i));
                    valided = true;
                }
            }

      

        return valided;
    }

    public boolean agregarEmpleados(ArrayList<? extends Empleado> e) {
        boolean valided = false;
        boolean control;

            for (int i = 0; i < e.size(); i++) {
                try {
                    controlIgualdad(empleados, e.get(i));
                    control = true;
                } catch (IllegalArgumentException k) {
                    control = false;
                }
                if (control == true) {
                    empleados.add(e.get(i));
                    valided = true;
                }
            }

        

        return valided;
    }

    //Metod que añade un cliente al arraylist
    public boolean agregarCliente(Cliente c) {
        boolean valided = true;
        try {
            controlIgualdad(clientes, c);
            clientes.add(c);
        } catch (IllegalArgumentException e) {
            valided = false;
        }

        return valided;
    }

    public boolean agregarEmpleado(Empleado e) {
        boolean valido = true;

        try {
            controlIgualdad(empleados, e);
            empleados.add(e);
        } catch (IllegalArgumentException k) {
            valido = false;
        }

        return valido;
    }

    //metodo que se encarga de comprobar que los clientes no compartan datos que son unicos(codigo,dni y telefono)
    private void controlIgualdad(ArrayList<? extends Persona> p, Persona c) {
        for (int i = 0; i < p.size(); i++) {

            if (p.get(i).equals(c)) {
                throw new IllegalArgumentException("El elemento ya existe o se han introducido valores no disponibles");
            }

        }

    }

}
