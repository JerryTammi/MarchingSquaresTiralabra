package msluola.marchingsquaresluola.util;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import msluola.marchingsquaresluola.luola.Luola;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MarchingSquaresTest {
    MarchingSquares msv;
    String[]binLuvut;
    Luola l;
    int vali;
    
    @Before
    public void setUp() {
        msv = new MarchingSquares();
        binLuvut = new String[]{"0000", "0001", "0010", "0100", "1000", "1100", "1010", "1001", 
                                              "0110", "0101", "0011", "0111", "1011", "1101", "1110", "1111"};
        l = new Luola(1000, 1000, 20, System.nanoTime(), 2);
        vali = 20;
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
    
    @Test
    public void testiLuo() {
        l.luoTaulukko();
        Pane ikkuna = l.haePane();
        int x = 4;
        int y = 10;
        boolean onko = true;
        Line[]viivat = new Line[15];
        viivat[1] = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
        viivat[2] = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
        viivat[3] = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
        viivat[4] = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
        viivat[6] = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
        viivat[7] = new Line(x + (vali / 2), y, x, y + (vali / 2));
        viivat[8] = new Line(x + (vali / 2), y, x, y + (vali / 2));
        viivat[9] = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
        viivat[11] = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
        viivat[12] = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
        viivat[13] = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
        viivat[14] = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
        for (int i = 1; i < viivat.length; i++) {
            if (i == 5 || i == 10) continue;
            msv.luoViiva(i, x, y, ikkuna, vali);
            Line luotuViiva = (Line)ikkuna.getChildren().get(0);
            Line testattvaViiva = viivat[i];
            if (luotuViiva.getStartX() != testattvaViiva.getStartX() || luotuViiva.getStartY() != testattvaViiva.getStartY()) {
                onko = false;
                System.out.println("Luvun: " + i + " kohdalla virhe");
                break;
            }
            if (luotuViiva.getEndX() != testattvaViiva.getEndX() || luotuViiva.getEndY() != testattvaViiva.getEndY()) {
                onko = false;
                System.out.println("Luvun: " + i + " kohdalla virhe");
                break;
            }
            ikkuna.getChildren().remove(0);
        }
        assertEquals(true, onko);
    }
    
    @Test
    public void testiLuo5() {
        l.luoTaulukko();
        int luku = 5;
        int x = 4;
        int y = 10;
        boolean onko =true;
        Line testiViiva1 = new Line(x + (vali / 2), y, x, y + (vali / 2));
        Line testiViiva2 = new Line(x + vali, y + (vali / 2), x + (vali / 2), y + vali);
        Pane ikkuna = l.haePane();
        msv.luoViiva(luku, x, y, ikkuna, vali);
        Line luotuViiva1 = (Line)ikkuna.getChildren().get(0);
        Line luotuViiva2 = (Line)ikkuna.getChildren().get(1);
        if (luotuViiva1.getStartX() != testiViiva1.getStartX() || luotuViiva1.getStartY() != testiViiva1.getStartY()) {
            onko = false;
        }
        if (luotuViiva1.getEndX() != testiViiva1.getEndX() || luotuViiva1.getEndY() != testiViiva1.getEndY()) {
            onko = false;
        }
        if (luotuViiva2.getStartX() != testiViiva2.getStartX() || luotuViiva2.getStartY() != testiViiva2.getStartY()) {
            onko = false;
        }
        if (luotuViiva2.getEndX() != testiViiva2.getEndX() || luotuViiva2.getEndY() != testiViiva2.getEndY()) {
            onko = false;
        }
        assertEquals(true, onko);
    }
    
    @Test
    public void testiLuo10() {
        l.luoTaulukko();
        int luku = 10;
        int x = 4;
        int y = 10;
        boolean onko =true;
        Line testiViiva1 = new Line(x + (vali / 2), y, x + vali, y + (vali / 2));
        Line testiViiva2 = new Line(x + (vali / 2), y + vali, x, y + (vali / 2));
        Pane ikkuna = l.haePane();
        msv.luoViiva(luku, x, y, ikkuna, vali);
        Line luotuViiva1 = (Line)ikkuna.getChildren().get(0);
        Line luotuViiva2 = (Line)ikkuna.getChildren().get(1);
        if (luotuViiva1.getStartX() != testiViiva1.getStartX() || luotuViiva1.getStartY() != testiViiva1.getStartY()) {
            onko = false;
        }
        if (luotuViiva1.getEndX() != testiViiva1.getEndX() || luotuViiva1.getEndY() != testiViiva1.getEndY()) {
            onko = false;
        }
        if (luotuViiva2.getStartX() != testiViiva2.getStartX() || luotuViiva2.getStartY() != testiViiva2.getStartY()) {
            onko = false;
        }
        if (luotuViiva2.getEndX() != testiViiva2.getEndX() || luotuViiva2.getEndY() != testiViiva2.getEndY()) {
            onko = false;
        }
        assertEquals(true, onko);
    }
    
    @Test
    public void testiLuoViivaSuurempiKuin15() {
        int luku = 15;
        l.luoTaulukko();
        int x = 4;
        int y = 10;
        Pane ikkuna = l.haePane();
        msv.luoViiva(luku, x, y, ikkuna, vali);
        assertEquals(0, ikkuna.getChildren().size());
    }
}
