package e1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author David
 */
public class MercadoTest {

    Cliente c1, c2, c3, c4, c5, c6, c8, c9, c10, c11, c12, copia, cl_1, cl_2, cl_3;
    Empleado e1, e2, e3, e4, e5, e6, e7, e8, copiaEmpleado, el_1, el_2, el_3;
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    Mercado mercado;

    @Before
    public void setUp() {
        mercado = new Mercado();
        iniciadorClientesCorrectos();
        iniciadorEmpleadosCorrectos();
        iniciadorListas();

    }

    @Test
    public void iniciadorListas() {
        copia = new Cliente(1, 100, "Juan", "Alvarez Pineda", "Avenida Colón", "39477575P", 660849512);//Todo bien
        cl_1 = new Cliente(47, 50, "Luis", "Mendizabal", "Valencia", "39485121j", 660457891);
        cl_2 = new Cliente(23, 1400, "Nuno", "Solo", "Sevilla", "48582431k", 667123254);
        cl_3 = new Cliente(51, 70, "ALvaro", "Carrasco", "Valladolid", "39485124h", 555213487);

        listaClientes.add(copia);
        listaClientes.add(cl_1);
        listaClientes.add(cl_2);
        listaClientes.add(cl_3);

        copiaEmpleado = new Dependiente("Carnicero", 123456789, 1500, Turno.T, "Diego", "Alvarez", "Calle Alfonso Molina", "39452174g", 660457270);
        el_1 = new Dependiente("Pescadero", 123456987, 1500, Turno.N, "Daniel", "Alvarez", "Calle Alfonso Molina", "39452174A", 880457270);
        el_2 = new Reponedor("Google", 213456987, 1000, Turno.T, "Julian", "Alvarez", "Calle Alfonso Molina", "55552174A", 724457270);
        el_3 = new Reponedor("Spacex", 555456987, 1500, Turno.T, "Gabriel", "Alvarez", "Calle Alfonso Molina", "39452144U", 999457270);

        listaEmpleados.add(copiaEmpleado);
        listaEmpleados.add(el_1);
        listaEmpleados.add(el_2);
        listaEmpleados.add(el_3);
    }

    private void añadirLista() {

        mercado.agregarCliente(c1);
        mercado.agregarCliente(c3);
        mercado.agregarCliente(c5);
    }

    @Test
    public void iniciadorClientesCorrectos() {

        c1 = new Cliente(1, 100, "Juan", "Alvarez Pineda", "Avenida Colón", "39477575P", 660849512);//Todo bien
        copia = new Cliente(1, 100, "Juan", "Alvarez Pineda", "Avenida Colón", "39477575P", 660849512);//Todo bien
        c3 = new Cliente(2, 0, "Alba", "Martinez", "Riazor", "39992575P", 660849912);//compras a 0
        c5 = new Cliente(4, 800, "Claudio", "Rivas", "Calle Alfonso Molina", "49492575a", 770849512); // dni letra minuscula

    }

    @Test
    public void iniciadorEmpleadosCorrectos() {
        e1 = new Dependiente("Carnicero", 123456789, 1500, Turno.T, "Diego", "Alvarez", "Calle Alfonso Molina", "39452174g", 660457270);
        e2 = new Reponedor("IBM", 987654321, 1000, Turno.T, "David", "Alonso", "Plaza Independencia", "45642175k", 777485126);
        e3 = new Dependiente("Charcutero", 152364789, 2000, Turno.T, "Oscar", "Casado", "Plaza españa", "51247855o", 660759421);
    }

    @Test(expected = IllegalArgumentException.class)
    public void iniciadorClientesError() {

        c2 = new Cliente(-5, 100, "Xavi", "Fernadez Pineda", "Avenida Cibeles", "11111111P", 660855512);//codigo cliente negativo     
        c4 = new Cliente(3, -5, "Teodoro", "De la Fuente", "Españita", "22222222P", 660669512);//num compras negativo y dni mal
        c6 = new Cliente(5, 100, "Xavi", "Alvarez Pineda", "Avenida Colón", "33333333P", 660889);//telefono demasido pequeño      
        c8 = new Cliente(7, 2, null, "Alvarez Pineda", "Avenida Colón", "55555555P", 770849512);
        c9 = new Cliente(8, 42, "Xavi", null, "Avenida Colón", "66666666P", 660849412);
        c10 = new Cliente(9, 80, "Xavi", "Alvarez Pineda", null, "77777777P", 660000512);
        c11 = new Cliente(10, 40, "Juan", "Alvarez Pineda", "Avenida Colón", "394P", 660002212);//dni corto
        c12 = new Cliente(11, 110, "Juan", "Alvarez Pineda", "Avenida Colón", "394555555555P", 660849588);//dni largo

    }

    @Test(expected = IllegalArgumentException.class)
    public void iniciadorEmpleadosError() {

        e4 = new Dependiente("Cajero", 512463987, 500, Turno.T, "Alvaro", "Trujillo", "Madrid", "4b", 760451278);//dni mal formado
        e5 = new Reponedor("MSI", 951623487, 400, Turno.N, "Ana", "Perez", "Vigo", "49512175n", 660495124);//el reponedor no puede trabajar de noche
        e6 = new Dependiente(null, 132546879, 1000, Turno.T, "Aldara", "Matinez", "Barcelona", "49512175d", 846123741);//Sin especialidad
        e7 = new Reponedor(null, 123456798, 1400, Turno.T, "Bruno", "Garrido", "Coruña", "15243212a", 756489421);//sin empresa
        e8 = new Reponedor("Tesla", 0, 1400, Turno.T, "Mario", "Bros", "Reino champiñon", "45612114h", 660487275);
    }

    @Test
    public void AgregarClieneUnicoTest() {
        assertTrue(mercado.agregarCliente(c1)); //Cliente correcto
        assertTrue(mercado.agregarCliente(c3));// Cliente correcto
        assertTrue(mercado.agregarCliente(c5));// Cliente correcto
    }

    public void ClientesAgregarIgualTest() {

        assertFalse(mercado.agregarCliente(copia));
    }

    @Test
    public void agregarEmpleadoUnicoCorrectosTest() {

        assertTrue(mercado.agregarEmpleado(e1));
        assertTrue(mercado.agregarEmpleado(e2));
        assertTrue(mercado.agregarEmpleado(e3));

    }

    @Test
    public void agregarListaTest() {
        añadirLista();

        assertTrue(mercado.agregarClientes(listaClientes));
        assertTrue(mercado.agregarEmpleados(listaEmpleados));

    }

    @Test
    public void salariosTest() {
        mercado.agregarEmpleados(listaEmpleados);
        assertEquals(5650, mercado.salariosMercado());

    }

    @Test
    public void personasMercadoTest() {

        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Persona> personasmal = new ArrayList<>();

        mercado.agregarClientes(listaClientes);
        mercado.agregarEmpleados(listaEmpleados);

        personas.addAll(listaClientes);
        personas.addAll(listaEmpleados);

        assertArrayEquals(personas.toArray(), mercado.personasMercado().toArray());

        assertNotEquals(personasmal.toArray(), mercado.personasMercado().toArray());

    }
    
    @Test
public void clienteToStringTest(){
    String cadena = ("\nNombre: Juan\n"
                + "Apellidos: Alvarez Pineda\n"
                + "Direccion: Avenida Colón\n"
                + "Dni: 39477575P\n"
                + "Telefono: 660849512\n"
                + "Codigo del cliente: 1\n"
                + "Numero de compras: 100\n"
                + "Descuento: 1\n" + "****************\n");
assertEquals(cadena,c1.toString());
}
    @Test
public void dependienteToStringTest(){
    String cadena = ("\nNombre: Diego \n"
                + "Apellidos: Alvarez \n"
                + "Direccion: Calle Alfonso Molina \n"
                + "Dni: 39452174G \n"
                + "Telefono: 660457270 \n"
                + "Seguridad Social: 123456789 \n"
                + "Turno: Tarde \n"
                + "Especialidad: Carnicero \n"
                + "Salario: 1500 \n" + "****************\n");
assertEquals(cadena,e1.toString());
}

  @Test
public void reponedorToStringTest(){
    String cadena = ("\nNombre: David \n"
                + "Apellidos: Alonso \n"
                + "Direccion: Plaza Independencia \n"
                + "Dni: 45642175K \n"
                + "Telefono: 777485126 \n"
                + "Seguridad Social: 987654321 \n"
                + "Turno: Tarde \n"
                + "Empresa: IBM \n"
                + "Salario: 1000 \n" + "****************\n");
assertEquals(cadena,e2.toString());
}
@Test
public void equalsEmpleadoTest(){
assertTrue(e1.equals(copiaEmpleado));
assertFalse(e1.equals(e2));
}


@Test
public void testHashCode(){

    
    assertNotEquals(e1.hashCode(), e2.hashCode());
       assertNotEquals(c1.hashCode(), c3.hashCode());
    
    assertEquals(c1.hashCode(), copia.hashCode());
    assertEquals(e1.hashCode(), copiaEmpleado.hashCode());

}
}
