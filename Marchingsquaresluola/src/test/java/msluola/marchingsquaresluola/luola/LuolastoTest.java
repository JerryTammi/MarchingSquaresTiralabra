package msluola.marchingsquaresluola.luola;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LuolastoTest {
    Luolasto l;
    int koko;

    @Before
    public void setUp() {
        koko = 50;
        l = new Luolasto(koko);
    }
    
    @Test
    public void testiTarkistaEttaLuolatLuodaan() {
        l.louLuolasto(1000, 1000, 20);
        assertEquals(koko, l.luolastonKoko());
    }
}
