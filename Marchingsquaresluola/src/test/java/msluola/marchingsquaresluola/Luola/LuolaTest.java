/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msluola.marchingsquaresluola.Luola;

import javafx.scene.layout.Pane;
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
                if(pisteet[i][j] == 1) {
                    onkoNolla = true;
                }
            }
        }
        assertEquals(true,onkoNolla);
    }

//    @Test
//    public void testiLisaaPisteet() {
//        luola.lisaaPisteet(pisteet);
//        
//    }
//
//    /**
//     * Test of lisaaViivat method, of class Luola.
//     */
//    @Test
//    public void testLisaaViivat() {
//        System.out.println("lisaaViivat");
//        Luola instance = null;
//        instance.lisaaViivat();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of binaariMuuntaminen method, of class Luola.
//     */
//    @Test
//    public void testBinaariMuuntaminen() {
//        System.out.println("binaariMuuntaminen");
//        String luku = "";
//        Luola instance = null;
//        int expResult = 0;
//        int result = instance.binaariMuuntaminen(luku);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of luoViiva method, of class Luola.
//     */
//    @Test
//    public void testLuoViiva() {
//        System.out.println("luoViiva");
//        int luku = 0;
//        int x = 0;
//        int y = 0;
//        Pane p = null;
//        Luola instance = null;
//        instance.luoViiva(luku, x, y, p);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
