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
    public void testiOikeaKoko() {
        l.luoLuolasto(1000 , 1920, 20);
        assertEquals(50, l.haeLista().haeIndex() + 1);
    }
    
    @Test
    public void testiTarkistaLuola() {
        l.luoLuolasto(1000 , 1920, 20);
        Luola uusiLuola = l.uusiLuola(2);
        boolean kaikkiKunnossa = true;
        if (uusiLuola.haeKorkeus() != 1000 || uusiLuola.haeLeveys() != 1920 || uusiLuola.haeVali() != 20) {
            kaikkiKunnossa = false;
        }
        assertEquals(true, kaikkiKunnossa);
    }
}
