//////package msluola.marchingsquaresluola.taulukkogeneraattorit;
//
//import msluola.marchingsquaresluola.generaattorit.Soluautomaatti;
//import javafx.scene.layout.Pane;
//import static junit.framework.Assert.assertEquals;
//import msluola.marchingsquaresluola.luola.Luola;
//import org.junit.Before;
//import org.junit.Test;
//
//public class CellularAutomataTest {
//    Luola luola;
//    Soluautomaatti ca;
//    int leveys;
//    int korkeus;
//    int vali;
//    int[][]pisteet;
//    Pane ikkuna;
//    int aste;
//    
//    @Before
//    public void setUp() {
//        this.korkeus = 1000;
//        this.leveys = 1000;
//        this.vali = 20;
//        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
//        this.ikkuna = new Pane();
//        this.luola = new Luola(leveys, korkeus, vali);
//        this.ca = new Soluautomaatti();
//        this.aste = 3;
//    }
//    
//    @Test
//    public void testiMuunna() {
//        luola.luoTaulukko();
//        int[][] testitaulukko = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
//        for (int i = 0; i < pisteet.length; i++) {
//            for (int j = 0; j < pisteet[0].length; j++) {
//                testitaulukko[i][j] = pisteet[i][j];
//            }
//        }
//        
//        this.pisteet = ca.muunna(luola.haeTaulukko(), aste);
//        
//        boolean muutos = false;
//        for (int i = 0; i < testitaulukko.length; i++) {
//            for (int j = 0; j < testitaulukko[0].length; j++) {
//                if (testitaulukko[i][j] != pisteet[i][j]) muutos = true;
//            }
//        }
//        assertEquals(true, muutos);
//    }
//
////    @Test
////    public void testiSiivoaTaulukko() {
////    }
////
////    @Test
////    public void testiVierusSeinat() {
////    }
//}
