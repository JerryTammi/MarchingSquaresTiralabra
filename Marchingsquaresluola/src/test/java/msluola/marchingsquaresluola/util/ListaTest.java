package msluola.marchingsquaresluola.util;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ListaTest {
    Lista l;
    
    @Before
    public void setUp() {
        l = new Lista(3);
    }
    
    @Test
    public void testiLisaaVaaraArvo() {
        int[]testi = new int[]{1, 2, 3, 4, 5};
        l.add(testi);
        assertEquals(0, l.haeIndex());
    }
    
    @Test
    public void testiOikeaMaaraListassa() {
        int[]testi = new int[]{1, 2, 3};
        for (int i = 0; i < 5; i++) {
            l.add(testi);
        }
        assertEquals(5, l.haeIndex() + 1);
    }
    
    @Test
    public void testiOikeaOsio() {
        int[]testi1 = new int[]{1, 1, 1};
        int[]testi2 = new int[]{2, 2, 2};
        int[]testi3 = new int[]{3, 3, 3};
        
        l.add(testi1);
        l.add(testi2);
        l.add(testi3);
        
        int[]tulos = l.palautaOsio(1);
        boolean sama = true;
        for (int i = 0; i < 3; i++) {
            if (tulos[i] != testi2[i]) {
                sama = false;
            }
        }
        assertEquals(true, sama);
    }
    
    @Test
    public void testiOikeaJarjestys() {
        int[]testi1 = new int[]{1, 1, 99};
        int[]testi2 = new int[]{1, 22, 4};
        int[]testi3 = new int[]{3, 3, 4};
        int[]testi4 = new int[]{11, 1, 6};
        int[]testi5 = new int[]{2, 32, 7};
        int[]testi6 = new int[]{3, 3, 100};
        int[]testi7 = new int[]{41, 1, 12};
        int[]testi8 = new int[]{2, 2, 10000};
        int[]testi9 = new int[]{3, 113, 35};
        
        l.add(testi1);
        l.add(testi2);
        l.add(testi3);
        l.add(testi4);
        l.add(testi5);
        l.add(testi6);
        l.add(testi7);
        l.add(testi8);
        l.add(testi9);
        
        //Halutaan järjestää testitaulukoiden i = 2 arvon
        l.jarjesta(0, l.haeIndex(), 2);
        boolean pienempi = true;
        for (int i = 0; i < l.haeIndex(); i++) {
            int[]eka = l.palautaOsio(i);
            int[]toka = l.palautaOsio(i+1);
            if (eka[2] > toka[2]) {
                pienempi = false;
            }
        }
        assertEquals(true, pienempi);
    }
    
    @Test
    public void testiLiikaaArvojaListaan() {
        int[]testi1 = new int[]{1, 1, 1};
        for (int i = 0; i < 100000; i++) {
            l.add(testi1);
        }
        assertEquals(65535, l.haeIndex() + 1);
    }
}
