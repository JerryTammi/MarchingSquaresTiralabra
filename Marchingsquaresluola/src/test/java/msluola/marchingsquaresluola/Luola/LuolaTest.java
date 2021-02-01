/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msluola.marchingsquaresluola.Luola;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static junit.framework.Assert.assertEquals;
import org.junit.*;
import org.junit.Test;

/**
 *
 * @author Jerry
 */
public class LuolaTest {
    Luola luola;
    int leveys;
    int korkeus;
    int vali;
    int[][]pisteet;
    Pane ikkuna;
        
    @Before
    public void setUp() {
        this.korkeus = 1000;
        this.leveys = 1000;
        this.vali = 20;
        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
        this.ikkuna = new Pane();
        this.luola = new Luola(leveys, korkeus, vali);
    }
    
    @Test
    public void testiHaeLeveys() {
        assertEquals(1000, luola.haeLeveys());
    }

    @Test
    public void testiHaeKorkeus() {
        assertEquals(1000, luola.haeKorkeus());
    }

    @Test
    public void testiHaeVali() {
        assertEquals(20, luola.haeVali());
    }

    @Test
    public void testiLuoTaulukko() {
        luola.luoTaulukko(pisteet);
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
        luola.luoTaulukko(pisteet);
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
        luola.luoTaulukko(pisteet);
        boolean onkoNolla = false;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 1) {
                    onkoNolla = true;
                }
            }
        }
        assertEquals(true,onkoNolla);
    }

    @Test
    public void testiLisaaPisteet() {
        luola.luoTaulukko(pisteet);
        luola.lisaaPisteet(pisteet, ikkuna,vali);
        boolean loytyykoPiste = true;
        int missa = 0;
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                Circle c = new Circle(j * vali, i * vali, 3);
                if (pisteet[i][j] == 0) {
                    c.setFill(Color.BLACK);
                } else {
                    c.setFill(Color.WHITE);
                }
                Circle valmisPiste = (Circle)ikkuna.getChildren().get(missa);
                if(valmisPiste.getCenterX() != j * vali) {
                    loytyykoPiste = false;
                }
                if(valmisPiste.getCenterY() != i * vali) {
                    loytyykoPiste = false;
                }
                if(valmisPiste.getFill() != c.getFill()) {
                    loytyykoPiste = false;
                }
                missa++;
            }
        }
        assertEquals(true, loytyykoPiste);
    }

//    @Test
//    public void testiLisaaViivat() {
//        luola.luoTaulukko(pisteet);
//        luola.lisaaViivat(pisteet, ikkuna, vali);
//        boolean loytyykoViiva = true;
//        for(int i = 0; i < pisteet.length; i++) {
//            for(int j = 0; j < pisteet[0].length; j++) {
//                
//            }
//        }
//    }
    
    @Test
    public void testiBinaariMuuntaminenTapaus1() {
        String luku = "1111";
        int tulos = luola.binaariMuuntaminen(luku);
        assertEquals(15, tulos);
    }
    
    @Test
    public void testiBinaariMuuntaminenTapaus2() {
        String luku = "0000";
        int tulos = luola.binaariMuuntaminen(luku);
        assertEquals(0, tulos);
    }
    
    @Test
    public void testLuoViiva() {
        
    }
    
}
