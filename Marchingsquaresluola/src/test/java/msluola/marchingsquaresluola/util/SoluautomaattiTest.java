package msluola.marchingsquaresluola.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SoluautomaattiTest {
    int[][]pisteet;
    Long seed;
    LehmerRng rng;
    Soluautomaatti s;
    
    @Before
    public void setUp() {
        this.pisteet = new int[100][100];
        seed = System.nanoTime() % 1337;
        rng = new LehmerRng(pisteet, seed);
        pisteet = rng.luoTaulu();
        this.s = new Soluautomaatti();
    }
    
    @Test
    public void testiVierusSeinat() {
        boolean onko = true;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                int luku = s.vierusSeinat(i, j, pisteet);
                if (luku < 0 || luku > 8) {
                    onko = false;
                    break;
                }
            }
        }
        assertEquals(true, onko);
    }
    
    @Test
    public void testiMuuntaako() {
        int[][]uusiT = new int[100][100];
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                uusiT[i][j] = pisteet[i][j];
            }
        }
        for (int i = 0; i < 15; i++) {
            pisteet = s.muunna(pisteet, 2);
        }
        
        boolean onkoErilainen = false;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] != uusiT[i][j]) {
                    onkoErilainen = true;
                }
            }
        }
        assertEquals(true, onkoErilainen);
    }
    
}
