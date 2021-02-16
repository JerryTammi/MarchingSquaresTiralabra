package msluola.marchingsquaresluola.util;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MarchingSquaresViivatTest {
    MarchingSquaresViivat msv;
    String[]binLuvut;
    
    @Before
    public void setUp() {
        msv = new MarchingSquaresViivat();
        binLuvut = new String[]{"0000", "0001", "0010", "0100", "1000", "1100", "1010", "1001", 
                                              "0110", "0101", "0011", "0111", "1011", "1101", "1110", "1111"};
        
    }
    
    @Test
    public void testiBinNumerot() {
        boolean tarkistaNumerot = true;
        for (int i = 0; i < binLuvut.length; i++) {
            if (msv.binaariMuuntaminen(binLuvut[i]) < 0 || msv.binaariMuuntaminen(binLuvut[i]) > 15) {
                tarkistaNumerot = false;
            }
        }
        assertEquals(true, tarkistaNumerot);
    }
}
