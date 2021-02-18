package msluola.marchingsquaresluola.util;

import msluola.marchingsquaresluola.luola.Luola;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MstTest {
    Mst mst;
    int[][]pisteet;
    Long seed;
    boolean[][]kayty;
    LehmerRng rng;
    
    @Before
    public void setUp() {
        seed = System.nanoTime() % 1337;
        pisteet = new int[100][100];
        rng = new LehmerRng(pisteet, seed);
        pisteet = rng.luoTaulu();
        Soluautomaatti s = new Soluautomaatti();
        for (int i = 0; i < 15; i++) {
            pisteet = s.muunna(pisteet);
        }
        mst = new Mst(pisteet);
        kayty = new boolean[100][100];
    }
    
    
    @Test
    public void testiLuolanHuoneidenMaaraAlussa() {
        mst.laskeHuoneet();
        boolean onko = true;
        if (mst.haeHuoneet() < 4 || mst.haeHuoneet() > 100) {
            onko = false;
        }
        assertEquals(true, onko);
    }
    
    @Test
    public void testiOnkoYhtenainenLuola() {
        mst.linkita();
        int huoneet = 0;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 0 && !kayty[i][j]) {
                    huoneet++;
                    tarkistaSyvyys(i, j);
                }
            }
        }
        assertEquals(1, huoneet);
    }
    
    public void tarkistaSyvyys(int y, int x) {
        if (y > pisteet.length - 1 || x > pisteet[0].length - 1 || y < 1 || x < 1) {
            return;
        }
        if (pisteet[y][x] == 1 || kayty[y][x]) {
            return;
        }
        if (pisteet[y][x] == 0 && !kayty[y][x]) {
            kayty[y][x] = true;
            tarkistaSyvyys(y + 1, x);
            tarkistaSyvyys(y - 1, x);
            tarkistaSyvyys(y, x + 1);
            tarkistaSyvyys(y, x - 1);
        }
    }
}
