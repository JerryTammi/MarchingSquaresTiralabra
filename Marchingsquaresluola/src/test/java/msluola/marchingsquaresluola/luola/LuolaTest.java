package msluola.marchingsquaresluola.luola;

import javafx.scene.layout.Pane;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class LuolaTest {
    Luola l;
    int leveys;
    int korkeus;
    int vali;
    int[][]pisteet;
    Pane ikkuna;
        
    @Before
    public void setUp() {
        korkeus = 1000;
        leveys = 1000;
        vali = 20;
        pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
        ikkuna = new Pane();
        l = new Luola(leveys, korkeus, vali, System.nanoTime());
    }
    
    @Test
    public void testiLuoTaulukko() {
        l.luoTaulukko();
        boolean onkoYksiTaiNolla = true;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] < 0 || pisteet[i][j] > 1) {
                    onkoYksiTaiNolla = false;
                }
            }
        }
        assertEquals(true,onkoYksiTaiNolla);
    }
    
    @Test
    public void testiEihanTaulukossaKaikkiArvotOleNollaa() {
        l.luoTaulukko();
        pisteet = l.haeTaulukko();
        boolean onkoYksi = false;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 1) {
                    onkoYksi = true;
                }
            }
        }
        assertEquals(true,onkoYksi);
    }
    
    @Test
    public void testiEihanTaulukossaKaikkiArvotOleYhta() {
        l.luoTaulukko();
        pisteet = l.haeTaulukko();
        boolean onkoNolla = false;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 0) {
                    onkoNolla = true;
                }
            }
        }
        assertEquals(true,onkoNolla);
    }
    
    @Test
    public void testiTarkistaEttaSeinatLisataan() {
        l.luoTaulukko();
        int kokoAlussa = l.haePane().getChildren().size();
        l.lisaaSeinat();
        int kokoLopussa = l.haePane().getChildren().size();
        assertEquals(false, kokoAlussa == kokoLopussa);
    }
}
