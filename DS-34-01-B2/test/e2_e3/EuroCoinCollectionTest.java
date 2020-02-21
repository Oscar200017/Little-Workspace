package e2_e3;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class EuroCoinCollectionTest {

    EuroCoin e1_sp1, // Juan Carlos I coin
            e1_sp2, // Felipe VI coin
            e2_sp_2002, // Juan Carlos I coin of 2002
            e2_sp_2005, // Juan Carlos I coin of 2005
            c50_it,
            c20_fr,
            c1_pt,
            c1_fr,
            e2_sp_2002_prueba,
            copia;
    EuroCoinCollection collection;
    EuroCoinCollection colecionVacia;

    @Before
    public void setUp() {
        collection = new EuroCoinCollection();
        colecionVacia = new EuroCoinCollection();
        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        e1_sp1 = new EuroCoin(Valor.CENTIMO_100, 2008, Pais.ESPAÑA, "Rey Felipe");
        copia = new EuroCoin(Valor.CENTIMO_100, 2008, Pais.ESPAÑA, "Rey Felipe");
        e1_sp2 = new EuroCoin(Valor.CENTIMO_100, 2009, Pais.ESPAÑA, "Rey Juancar");
        e2_sp_2002 = new EuroCoin(Valor.CENTIMO_200, 2002, Pais.ESPAÑA, "Rey Juancar");
        e2_sp_2002_prueba = new EuroCoin(Valor.CENTIMO_200, 2002, Pais.ESPAÑA, "Rey Juancarlos");
        e2_sp_2005 = new EuroCoin(Valor.CENTIMO_200, 2005, Pais.ESPAÑA, "Rey Juancar");
        c50_it = new EuroCoin(Valor.CENTIMO_50, 2010, Pais.ITALIA, "Italia1");
        c20_fr = new EuroCoin(Valor.CENTIMO_20, 2011, Pais.FRANCIA, "francia1");
        c1_pt = new EuroCoin(Valor.CENTIMO_1, 2009, Pais.PORTUGAL, "Porto");
        c1_fr = new EuroCoin(Valor.CENTIMO_1, 2009, Pais.FRANCIA, "Paris");

        assertTrue(collection.insertCoin(e1_sp1));
        assertTrue(collection.insertCoin(e1_sp2));
        assertTrue(collection.insertCoin(e2_sp_2002));
        assertFalse(collection.insertCoin(e2_sp_2005)); // Not inserted
        assertTrue(collection.insertCoin(c50_it));
        assertTrue(collection.insertCoin(c20_fr));
        assertFalse(collection.insertCoin(c50_it)); // Not inserted        
        assertFalse(collection.insertCoin(copia));
    }

    @Test
    public void testNumCoins() {
        assertEquals(5, collection.numCoins());
    }

    @Test
    public void testHasCoin() {
        assertTrue(collection.hasCoin(e1_sp1));
        assertTrue(collection.hasCoin(e2_sp_2005));
        assertFalse(collection.hasCoin(c1_pt));
    }

    @Test
    public void testCollectionValue() {
        assertEquals(470, collection.value());
    }

    @Test
    public void testRemoveCoin() {
        collection.removeCoin(c50_it);
        assertEquals(4, collection.numCoins());
        assertEquals(420, collection.value());

        collection.removeCoin(e2_sp_2005); // removes the 2002 coin
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());

        collection.removeCoin(c1_pt); // No coin removed
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
    }

    //**************************************************************
    @Test
    public void testCompareTo() {

        assertEquals(1, c1_pt.compareTo(c20_fr));
        assertEquals(-1, c1_fr.compareTo(c1_pt));
         assertEquals(1, c1_pt.compareTo(c1_fr));
        assertEquals(-1, c20_fr.compareTo(c1_pt));
        assertEquals(-1, e1_sp1.compareTo(e1_sp2));
        assertEquals(0, e2_sp_2002.compareTo(e2_sp_2005));
        assertEquals(1, e2_sp_2002_prueba.compareTo(e2_sp_2002));
        assertEquals(-1, e2_sp_2002.compareTo(e2_sp_2002_prueba));
    }

    private ArrayList<EuroCoin> iniciadorLista() {
        ArrayList<EuroCoin> lista = new ArrayList<EuroCoin>();
        lista.add(e1_sp1);
        lista.add(e1_sp2);
        lista.add(e2_sp_2002);
        lista.add(c50_it);
        lista.add(c20_fr);


        return lista;
    }

    @Test
    public void testCompare() {
        ArrayList lista = iniciadorLista();

        collection.ordenarNatural();
        assertEquals(lista.get(0), collection.coleccion.get(1));
        assertEquals(lista.get(1), collection.coleccion.get(2));
        assertEquals(lista.get(2), collection.coleccion.get(0));
        assertEquals(lista.get(3), collection.coleccion.get(3));
        assertEquals(lista.get(4), collection.coleccion.get(4));

    }

    @Test
    public void testCompareComparator() {
        ArrayList lista = iniciadorLista();

        Comparador c = new Comparador();
        collection.ordenarComparator(c);

        assertEquals(lista.get(0), collection.coleccion.get(1));
        assertEquals(lista.get(1), collection.coleccion.get(2));
        assertEquals(lista.get(2), collection.coleccion.get(0));
        assertEquals(lista.get(3), collection.coleccion.get(4));
        assertEquals(lista.get(4), collection.coleccion.get(3));
    }

    @Test
    public void iterador_hasNext() {
        Iterador it = new Iterador(collection);
        Iterador vacio = new Iterador(colecionVacia);

        assertTrue(it.hasNext());
        assertFalse(vacio.hasNext());
    }

    @Test
    public void iterador_next_prueba1() {
        Iterador it = new Iterador(collection);

        assertEquals(collection.coleccion.get(0), it.next());
        assertEquals(collection.coleccion.get(1), it.next());
        assertEquals(collection.coleccion.get(2), it.next());
        assertEquals(collection.coleccion.get(3), it.next());
        assertEquals(collection.coleccion.get(4), it.next());

    }

    @Test(expected = NoSuchElementException.class)
    public void iterador_next_Error() {
        Iterador it = new Iterador(collection);

        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();//La excepcion tiene que saltar aquí

    }

    @Test
    public void iterador_remove() {
        Iterador it = new Iterador(collection);

        it.next();
        it.next();
        it.remove();
        it.next();
        it.remove();

    }

    @Test
    public void iterador_next_prueba2() {
        Iterador conpais = new Iterador(collection, "España");

        assertEquals("España", conpais.next().pais);
        assertEquals("España", conpais.next().pais);
        assertEquals("España", conpais.next().pais);

        Iterador sinPais = new Iterador(collection);
        assertEquals("España", sinPais.next().pais);
        assertEquals("España", sinPais.next().pais);
        assertEquals("España", sinPais.next().pais);
        assertEquals("Italia", sinPais.next().pais);
        assertEquals("Francia", sinPais.next().pais);

    }

    @Test(expected = NullPointerException.class)
    public void iterador_next_prueba3() {

        Iterador conpais = new Iterador(collection, "España");

        assertEquals("España", conpais.next().pais);
        assertEquals("España", conpais.next().pais);
        assertEquals("España", conpais.next().pais);
        assertEquals("España", conpais.next().pais);

    }

    @Test(expected = NoSuchElementException.class)
    public void iterador_next_prueba4() {
        Iterador conpais = new Iterador(collection, "España");
        conpais.next();
        conpais.next();
        conpais.next();
        conpais.next();
        conpais.next();

    }
    @Test
    public void testMostrarEuroCoin(){
    String cadena;
    Iterador it = new Iterador(collection, "España");
    cadena = e1_sp1.toString().concat(e1_sp2.toString()).concat(e2_sp_2002.toString());
    
        assertEquals(cadena, collection.mostrarEurocoin(it));
    }
    
    @Test
    public void testHashCode(){
    
        assertNotEquals(e1_sp1.hashCode(), e1_sp2.hashCode());
        
        assertEquals(e1_sp1.hashCode(),copia.hashCode());
    }
}
