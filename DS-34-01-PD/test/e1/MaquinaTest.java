package e1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MaquinaTest {

    VendingMachine maquinaSimple;
    VendingMachine maquinaDeposito;

    @Before
    public void setUp() {
        maquinaDeposito = new VendingMachine();
        maquinaDeposito.setCambio(new CambioDeposito());

        maquinaSimple = new VendingMachine();
 
    }

    @Test
    public void insertProductTest() {
        /*------------------------------------------------*/
        maquinaSimple.insertProduct("Kas", 100);
        maquinaSimple.insertProduct("Fanta", 120);
        maquinaSimple.insertProduct("Agua", 80);

        assertTrue(maquinaSimple.productos.containsKey("Kas"));
        assertTrue(maquinaSimple.productos.containsKey("Fanta"));
        assertTrue(maquinaSimple.productos.containsKey("Agua"));
        assertFalse(maquinaSimple.productos.containsKey("Nestea"));

        /*------------------------------------------------*/
        maquinaDeposito.insertProduct("Agua", 80);
        maquinaDeposito.insertProduct("Agua", 100);

        assertFalse(maquinaDeposito.productos.containsValue(80));
        assertTrue(maquinaDeposito.productos.containsValue(100));
    }

    @Test
    public void insertCoinTest() {
        /*------------------------------------------------*/
        maquinaSimple.insertCoin(EuroCoin.Euro_50);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);
        maquinaSimple.insertCoin(EuroCoin.Euro_10);
        maquinaSimple.insertCoin(EuroCoin.Euro_20);
        maquinaSimple.insertCoin(EuroCoin.Euro_200);
        maquinaSimple.insertCoin(EuroCoin.Euro_5);
        maquinaSimple.insertCoin(EuroCoin.Euro_2);
        maquinaSimple.insertCoin(EuroCoin.Euro_1);

        List<EuroCoin> listaDesordenada = new ArrayList<>();
        listaDesordenada.add(EuroCoin.Euro_50);
        listaDesordenada.add(EuroCoin.Euro_100);
        listaDesordenada.add(EuroCoin.Euro_10);
        listaDesordenada.add(EuroCoin.Euro_20);
        listaDesordenada.add(EuroCoin.Euro_200);
        listaDesordenada.add(EuroCoin.Euro_5);
        listaDesordenada.add(EuroCoin.Euro_2);
        listaDesordenada.add(EuroCoin.Euro_1);

        assertNotEquals(listaDesordenada, maquinaSimple.deposito);

        /*------------------------------------------------*/
        List<EuroCoin> lista = new ArrayList<>();
        lista.add(EuroCoin.Euro_200);
        lista.add(EuroCoin.Euro_100);
        lista.add(EuroCoin.Euro_50);
        lista.add(EuroCoin.Euro_20);
        lista.add(EuroCoin.Euro_10);
        lista.add(EuroCoin.Euro_5);
        lista.add(EuroCoin.Euro_2);
        lista.add(EuroCoin.Euro_1);

        assertEquals(lista, maquinaSimple.deposito);

    }

    @Test
    public void cancelTest() {
        maquinaSimple.insertCoin(EuroCoin.Euro_50);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);
        maquinaSimple.insertCoin(EuroCoin.Euro_10);

        List<EuroCoin> lista = new ArrayList<>();
        lista.add(EuroCoin.Euro_100);
        lista.add(EuroCoin.Euro_50);
        lista.add(EuroCoin.Euro_10);

        assertEquals(lista, maquinaSimple.cancel());

    }

    @Test
    public void buyCambioSimpleTest() {

        maquinaSimple.insertProduct("Kas", 100);
        maquinaSimple.insertProduct("Fanta", 140);
        maquinaSimple.insertProduct("Agua", 80);
        maquinaSimple.insertProduct("Lays", 200);

        maquinaSimple.insertCoin(EuroCoin.Euro_5);
        maquinaSimple.insertCoin(EuroCoin.Euro_5);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);
        maquinaSimple.insertCoin(EuroCoin.Euro_10);
        maquinaSimple.insertCoin(EuroCoin.Euro_20);

        List<EuroCoin> listavacia = new ArrayList<>();
        List<EuroCoin> lista = new ArrayList<>();
        List<EuroCoin> lista2 = new ArrayList<>();

        assertEquals(listavacia, maquinaSimple.buy("Fanta"));

        lista.add(EuroCoin.Euro_20);
        lista.add(EuroCoin.Euro_10);
        lista.add(EuroCoin.Euro_5);
        lista.add(EuroCoin.Euro_5);

        assertEquals(lista, maquinaSimple.buy("Kas"));

        lista2.add(EuroCoin.Euro_20);
        lista2.add(EuroCoin.Euro_10);
        lista2.add(EuroCoin.Euro_5);
        lista2.add(EuroCoin.Euro_5);
        assertEquals(lista2, maquinaSimple.buy("Agua"));

        assertEquals(maquinaSimple.deposito, maquinaSimple.buy("Lays"));

    }

    @Test
    public void buyCambioDeposito() {

        maquinaDeposito.insertProduct("KitKat", 120);
        maquinaDeposito.insertProduct("Chicle", 100);
        maquinaDeposito.insertProduct("Nestea", 50);

        maquinaDeposito.insertCoin(EuroCoin.Euro_5);
        maquinaDeposito.insertCoin(EuroCoin.Euro_50);
        maquinaDeposito.insertCoin(EuroCoin.Euro_20);
        maquinaDeposito.insertCoin(EuroCoin.Euro_10);
        maquinaDeposito.insertCoin(EuroCoin.Euro_5);
        maquinaDeposito.insertCoin(EuroCoin.Euro_10);

        List<EuroCoin> listavacia = new ArrayList<>();
        List<EuroCoin> lista = new ArrayList<>();
        List<EuroCoin> lista2 = new ArrayList<>();

        lista.add(EuroCoin.Euro_50);
        lista.add(EuroCoin.Euro_20);
        lista.add(EuroCoin.Euro_10);
        lista.add(EuroCoin.Euro_10);
        lista.add(EuroCoin.Euro_5);
        lista.add(EuroCoin.Euro_5);

        lista2.add(EuroCoin.Euro_50);

        assertEquals(listavacia, maquinaDeposito.buy("Chicle"));
        assertEquals(lista, maquinaDeposito.buy("KitKat"));
        assertEquals(lista2, maquinaDeposito.buy("Nestea"));

    }

    @Test
    public void buyTest() {

        maquinaSimple.insertProduct("Chocolate", 180);

        maquinaSimple.insertCoin(EuroCoin.Euro_50);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);
        maquinaSimple.insertCoin(EuroCoin.Euro_100);

        List<EuroCoin> lista = new ArrayList<>();
        lista.add(EuroCoin.Euro_100);
        lista.add(EuroCoin.Euro_50);

        assertEquals(lista, maquinaSimple.buy("Chocolate"));

        maquinaSimple.setCambio(new CambioDeposito());
        
        List<EuroCoin> lista2 = new ArrayList<>();
        lista2.add(EuroCoin.Euro_100);
        lista2.add(EuroCoin.Euro_50);
        lista2.add(EuroCoin.Euro_20);

        assertEquals(lista2, maquinaSimple.buy("Chocolate"));
      

    }

}
