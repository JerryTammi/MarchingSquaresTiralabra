//package msluola.marchingsquaresluola.luola;
//
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Line;
//import static junit.framework.Assert.assertEquals;
//import org.junit.*;
//import org.junit.Test;
//
///**
// *
// * @author Jerry
// */
//public class LuolaTest {
//    Luola luola;
//    int leveys;
//    int korkeus;
//    int vali;
//    int[][]pisteet;
//    Pane ikkuna;
//        
//    @Before
//    public void setUp() {
//        this.korkeus = 1000;
//        this.leveys = 1000;
//        this.vali = 20;
//        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
//        this.ikkuna = new Pane();
//        this.luola = new Luola(leveys, korkeus, vali);
//    }
//    
//    @Test
//    public void testiHaeLeveys() {
//        assertEquals(1000, luola.haeLeveys());
//    }
//
//    @Test
//    public void testiHaeKorkeus() {
//        assertEquals(1000, luola.haeKorkeus());
//    }
//
//    @Test
//    public void testiHaeVali() {
//        assertEquals(20, luola.haeVali());
//    }
//
//    @Test
//    public void testiLuoTaulukko() {
//        luola.luoTaulukko();
//        boolean onkoYksiTaiNolla = true;
//        for (int i = 0; i < pisteet.length; i++) {
//            for (int j = 0; j < pisteet[0].length; j++) {
//                if (pisteet[i][j] < 0 || pisteet[i][j] > 1) {
//                    onkoYksiTaiNolla = false;
//                }
//            }
//        }
//        assertEquals(true,onkoYksiTaiNolla);
//    }
//    
//    @Test
//    public void testiEihanTaulukossaKaikkiArvotOleNollaa() {
//        luola.luoTaulukko();
//        boolean onkoYksi = false;
//        for (int i = 0; i < pisteet.length; i++) {
//            for (int j = 0; j < pisteet[0].length; j++) {
//                if (pisteet[i][j] == 1) {
//                    onkoYksi = true;
//                }
//            }
//        }
//        assertEquals(true,onkoYksi);
//    }
//    
//    @Test
//    public void testiEihanTaulukossaKaikkiArvotOleYhta() {
//        luola.luoTaulukko();
//        boolean onkoNolla = false;
//        for (int i = 0; i < pisteet.length; i++) {
//            for (int j = 0; j < pisteet[0].length; j++) {
//                if (pisteet[i][j] == 0) {
//                    onkoNolla = true;
//                }
//            }
//        }
//        assertEquals(true,onkoNolla);
//    }
//
//    @Test
//    public void testiLisaaPisteet() {
//        luola.luoTaulukko();
//        luola.lisaaPisteet(pisteet, ikkuna,vali);
//        boolean loytyykoPiste = true;
//        int missa = 0;
//        for (int i = 0; i < pisteet.length; i++) {
//            for (int j = 0; j < pisteet[0].length; j++) {
//                Circle c = new Circle(j * vali, i * vali, 3);
//                if (pisteet[i][j] == 1) {
//                    c.setFill(Color.BLACK);
//                } else {
//                    c.setFill(Color.WHITE);
//                }
//                Circle valmisPiste = (Circle)ikkuna.getChildren().get(missa);
//                if(valmisPiste.getCenterX() != j * vali) {
//                    loytyykoPiste = false;
//                }
//                if(valmisPiste.getCenterY() != i * vali) {
//                    loytyykoPiste = false;
//                }
//                if(valmisPiste.getFill() != c.getFill()) {
//                    loytyykoPiste = false;
//                }
//                missa++;
//            }
//        }
//        assertEquals(true, loytyykoPiste);
//    }
//    
//    
////    @Test
////    public void testiLuoViivaPienempiKuin1() {
////        int luku = 0;
////        luola.luoTaulukko();
////        int x = 4;
////        int y = 10;
////        Pane ikkuna = luola.haePane();
////        System.out.println(ikkuna.getChildren().size());
////        luola.luoViiva(luku, x, y, ikkuna, vali);
////        assertEquals(0, ikkuna.getChildren().size());
////    }
//    
////    @Test
////    public void testiLuo() {
////        luola.luoTaulukko();
////        Pane ikkuna = luola.haePane();
////        int x = 4;
////        int y = 10;
////        boolean onko = true;
////        Line[]viivat = new Line[15];
////        viivat[1] = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
////        viivat[2] = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
////        viivat[3] = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
////        viivat[4] = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
////        viivat[6] = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
////        viivat[7] = new Line(x + (vali / 2), y, x, y + (vali / 2));
////        viivat[8] = new Line(x + (vali / 2), y, x, y + (vali / 2));
////        viivat[9] = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
////        viivat[11] = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
////        viivat[12] = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
////        viivat[13] = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
////        viivat[14] = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
////        for (int i = 1; i < viivat.length; i++) {
////            if (i == 5 || i == 10) continue;
////            luola.luoViiva(i, x, y, ikkuna, vali);
////            Line luotuViiva = (Line)ikkuna.getChildren().get(0);
////            Line testattvaViiva = viivat[i];
////            if (luotuViiva.getStartX() != testattvaViiva.getStartX() || luotuViiva.getStartY() != testattvaViiva.getStartY()) {
////                onko = false;
////                System.out.println("Luvun: " + i + " kohdalla virhe");
////                break;
////            }
////            if (luotuViiva.getEndX() != testattvaViiva.getEndX() || luotuViiva.getEndY() != testattvaViiva.getEndY()) {
////                onko = false;
////                System.out.println("Luvun: " + i + " kohdalla virhe");
////                break;
////            }
////            ikkuna.getChildren().remove(0);
////        }
////        assertEquals(true, onko);
////    }
//    
//    
//    
////    @Test
////    public void testiLuo5() {
////        luola.luoTaulukko();
////        int luku = 5;
////        int x = 4;
////        int y = 10;
////        boolean onko =true;
////        Line testiViiva1 = new Line(x + (vali / 2), y, x, y + (vali / 2));
////        Line testiViiva2 = new Line(x + vali, y + (vali / 2), x + (vali / 2), y + vali);
////        Pane ikkuna = luola.haePane();
////        luola.luoViiva(luku, x, y, ikkuna, vali);
////        Line luotuViiva1 = (Line)ikkuna.getChildren().get(0);
////        Line luotuViiva2 = (Line)ikkuna.getChildren().get(1);
////        if (luotuViiva1.getStartX() != testiViiva1.getStartX() || luotuViiva1.getStartY() != testiViiva1.getStartY()) {
////            onko = false;
////        }
////        if (luotuViiva1.getEndX() != testiViiva1.getEndX() || luotuViiva1.getEndY() != testiViiva1.getEndY()) {
////            onko = false;
////        }
////        if (luotuViiva2.getStartX() != testiViiva2.getStartX() || luotuViiva2.getStartY() != testiViiva2.getStartY()) {
////            onko = false;
////        }
////        if (luotuViiva2.getEndX() != testiViiva2.getEndX() || luotuViiva2.getEndY() != testiViiva2.getEndY()) {
////            onko = false;
////        }
////        assertEquals(true, onko);
////    }
//    
////    @Test
////    public void testiLuo10() {
////        luola.luoTaulukko();
////        int luku = 10;
////        int x = 4;
////        int y = 10;
////        boolean onko =true;
////        Line testiViiva1 = new Line(x + (vali / 2), y, x + vali, y + (vali / 2));
////        Line testiViiva2 = new Line(x + (vali / 2), y + vali, x, y + (vali / 2));
////        Pane ikkuna = luola.haePane();
////        luola.luoViiva(luku, x, y, ikkuna, vali);
////        Line luotuViiva1 = (Line)ikkuna.getChildren().get(0);
////        Line luotuViiva2 = (Line)ikkuna.getChildren().get(1);
////        if (luotuViiva1.getStartX() != testiViiva1.getStartX() || luotuViiva1.getStartY() != testiViiva1.getStartY()) {
////            onko = false;
////        }
////        if (luotuViiva1.getEndX() != testiViiva1.getEndX() || luotuViiva1.getEndY() != testiViiva1.getEndY()) {
////            onko = false;
////        }
////        if (luotuViiva2.getStartX() != testiViiva2.getStartX() || luotuViiva2.getStartY() != testiViiva2.getStartY()) {
////            onko = false;
////        }
////        if (luotuViiva2.getEndX() != testiViiva2.getEndX() || luotuViiva2.getEndY() != testiViiva2.getEndY()) {
////            onko = false;
////        }
////        assertEquals(true, onko);
////    }
//    
////    @Test
////    public void testiLuoViivaSuurempiKuin15() {
////        int luku = 15;
////        luola.luoTaulukko();
////        int x = 4;
////        int y = 10;
////        Pane ikkuna = luola.haePane();
////        luola.luoViiva(luku, x, y, ikkuna, vali);
////        assertEquals(0, ikkuna.getChildren().size());
////    }
//    
//}
