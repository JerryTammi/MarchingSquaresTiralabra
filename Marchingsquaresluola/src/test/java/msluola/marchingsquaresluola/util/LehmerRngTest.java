package msluola.marchingsquaresluola.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LehmerRngTest {
    int[][]pisteet;
    long seed;
    LehmerRng rng1;
    LehmerRng rng2;
    
    @Before
    public void setUp() {
        pisteet = new int[100][100];
        seed = System.nanoTime() % 1337;
        rng1 = new LehmerRng(pisteet, seed);
        rng2 = new LehmerRng(seed);
    }
    
    @Test
    public void testiPalautaRandomNumero() {
        assertEquals(false, rng2.lehmer() == seed);
    }
    
    @Test
    public void testiLuoTaulu() {
        int[][]testitaulu = new int[100][100];
        boolean onkoSama = true;
        pisteet = rng1.luoTaulu();
        for (int i = 0; i < testitaulu.length; i++) {
            for (int j = 0; j < testitaulu[0].length; j++) {
                if (pisteet[i][j] != testitaulu[i][j]) {
                    onkoSama = false;
                    break;
                }
            }
        }
        assertEquals(false, onkoSama);
    }
    
    @Test
    public void testiLoytyykoKiellettyjaNumeroita() {
        boolean onkoYksiTaiNolla = true;
        pisteet = rng1.luoTaulu();
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] < 0 || pisteet[i][j] > 1) {
                    onkoYksiTaiNolla = false;
                }
            }
        }
        assertEquals(true, onkoYksiTaiNolla);
    }
    
}
