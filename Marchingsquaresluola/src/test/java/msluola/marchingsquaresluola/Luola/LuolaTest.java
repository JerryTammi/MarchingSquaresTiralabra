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
    
    public LuolaTest() {
        this.korkeus = 1000;
        this.leveys = 1000;
        this.vali = 20;
        this.luola = new Luola(leveys, korkeus, vali);
    }
    
    @Before
    public void setUpClass() {
        
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testHaeLeveys() {
        assertEquals(1000, luola.haeLeveys());
    }

    @Test
    public void testHaeKorkeus() {
        assertEquals(1000, luola.haeKorkeus());
    }

    @Test
    public void testHaeVali() {
        assertEquals(20, luola.haeVali());
    }

//    @Test
//    public void testLuoTaulukko() {
//        System.out.println("luoTaulukko");
//        Luola instance = null;
//        instance.luoTaulukko();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of lisaaPisteet method, of class Luola.
//     */
//    @Test
//    public void testLisaaPisteet() {
//        System.out.println("lisaaPisteet");
//        Luola instance = null;
//        instance.lisaaPisteet();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
