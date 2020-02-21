package e2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AccionesTest {

    Accion zara, renault, ibm, amd;
    Cliente ana, marcos, juan, daniel;

    @Before
    public void setUp() {
        //-----Clientes Simples-----//
        ana = new ClienteSimple("Ana");
        marcos = new ClienteSimple("Marcos");

        //-------Clientes complejos--------//
        juan = new ClienteDetallado("Juan");
        daniel = new ClienteDetallado("Daniel");

        //----------Acciones---------------//
        zara = new Accion("Zara", 80.5, 50.4, 75, 120);
        renault = new Accion("Rn", 40, 20, 35, 100);
        ibm = new Accion("IBM", 25, 10, 20, 45);
        amd = new Accion("AMD", 150, 100, 145, 520);

    }

    @Test
    public void addObservadoresTest() {
        zara.addObserver(ana);
        zara.addObserver(juan);

    }

    @Test(expected = NullPointerException.class)
    public void addObservadoresTestFail() {
        zara.addObserver(null);
    }

    @Test
    public void removeObserverTest() {
        zara.addObserver(ana);
        assertEquals(1, zara.countObservers());
        zara.deleteObserver(ana);
        assertEquals(0, zara.countObservers());
    }

    @Test
    public void notifyTest() {
        String T_ana, T_juan;

        zara.addObserver(ana);
        zara.addObserver(juan);
        amd.addObserver(ana);

        zara.setCierre(10);

        T_ana = "Cliente: " + "Ana" + "\n"
                + "Simbolo: " + "Zara" + "\n"
                + "Cierre: " + (double) 10 + "\n";

        assertEquals(T_ana, ana.getTicket());

        T_juan = "Cliente: " + "Juan" + "\n"
                + "Simbolo: " + "Zara" + "\n"
                + "Cierre: " + (double) 10 + "\n"
                + "Máximo: " + (double) 80.5 + "\n"
                + "Minimo: " + (double) 50.4 + "\n"
                + "Volumen: " + 120 + "\n";

        assertEquals(T_juan, juan.getTicket());

        //--------------------------///
        zara.setMaximo(0);
        assertEquals(T_ana, ana.getTicket());

    }
    
}
