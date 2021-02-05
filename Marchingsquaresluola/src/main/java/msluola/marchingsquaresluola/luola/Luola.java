package msluola.marchingsquaresluola.luola;

import java.util.Random;
import javafx.scene.SubScene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import msluola.marchingsquaresluola.taulukkogeneraattorit.CellularAutomata;

/**
 *
 * Luokka generoi luolan annetusta taulukosta käyttäen Marching squares -algoritmia
 */
public class Luola {
    Pane ikkuna;
    int leveys;
    int korkeus;
    int vali;
    int[][]pisteet;
    boolean naytetaankoPisteet;
    
    /**
     *
     * @param leveys Ikkunan leveys
     * @param korkeus Ikkunan korkeus
     * @param vali Jokaisen algoritmissa käytettävän pisteen välin etäisyyden toisiinsa.
     */
    public Luola(int korkeus, int leveys, int vali) {
        ikkuna = new Pane();
        ikkuna.setBackground(Background.EMPTY);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vali = vali;
        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
        this.naytetaankoPisteet = false;
    }
    
    /**
     *
     * @return Palauttaa valmiin panen ohjelmaa varten.
     */
    public Pane haePane() {
        return ikkuna;
    }
    
    /**
     *
     * @return Palauttaa ikkunan leveyden.
     */
    public int haeLeveys() {
        return leveys;
    }
    
    /**
     *
     * @return Palauttaa ikkunan korkeuden.
     */
    public int haeKorkeus() {
        return korkeus;
    }
    
    /**
     *
     * @return Palauttaa pisteiden välin etäisyyden.
     */
    public int haeVali() {
        return vali;
    }
    
    /**
     * 
     * @param naytetaanko Halutaanko näyttää pisteet
     */
    public void maaritaNaytetaankoPisteet(boolean naytetaanko) {
        if (naytetaanko) {
            naytetaankoPisteet = true;
        }
        if (!naytetaanko) {
            naytetaankoPisteet = false;
        }
    } 
    
    /**
     * 
     * @return Palauttaa näytetäänkö pisteet vai ei.
     */
    public boolean haePisteetMaaritys() {
        return naytetaankoPisteet;
    }
    
    /**
     * 
     * Metodi luo taulukon, jonka avulla se generoi luolan.
     */
    public void luoTaulukko(int[][]pisteet) {
        Random r = new Random();
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (i < 1 || i == pisteet.length || j < 1 || j == pisteet[0].length) {
                    pisteet[i][j] = 1;
                } else {
                    int randomnumero = r.nextInt(2);
                    pisteet[i][j] = randomnumero;
                }
            }
        }
        CellularAutomata ca = new CellularAutomata();
        int aste = 3;
        this.pisteet = ca.muunna(pisteet, aste);
    }
    
    /**
     * Metodi, joka palauttaa taulukon.
     * @return 
     */
    public int[][] haeTaulukko() {
        return pisteet;
    }
    
    /**
     * Lisää pisteet paneen.Ohjelman valmistuttua tämä metodi ei tule olemaan käytössä.Tällä hetkellä
        auttaa visualisoimaan algoritmia.
     * @param pisteet pisteiden taulukko
     * @param ikkuna ikkuna johon kaikki piirretään
     */
    public void lisaaPisteet(int[][]pisteet, Pane ikkuna, int vali) {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                Circle c = new Circle(j * vali, i * vali, 3);
                if (pisteet[i][j] == 1) {
                    c.setFill(Color.BLACK);
                } else {
                    c.setFill(Color.WHITE);
                }
                ikkuna.getChildren().add(c);
            }
        }
    }
    
    /**
     * 
     * Metodi käy läpi pisteet -taulukon, luo binäärinumeron tiedon mukaan ja muuntaa sen tavalliseksi
     * numeroksi.Tämän jälkeen se valitsee 16 mahdollisesta vaihtoehdosta ainoan sopivan, luo viivan ja 
        lopuksi lisää sen paneen.
     * @param pisteet pisteiden taulukko
     * @param ikkuna ikkuna johon kaikki piirretään
     * @param vali pisteiden väli
     */
    public void lisaaViivat(int[][]pisteet, Pane ikkuna, int vali) {
        for (int i = 0; i < pisteet.length - 1; i++) {
            for (int j = 0; j < pisteet[0].length - 1; j++) {
                String binaariNumero = "";
                binaariNumero += pisteet[i][j];
                binaariNumero += pisteet[i][j + 1];
                binaariNumero += pisteet[i + 1][j + 1];
                binaariNumero += pisteet[i + 1][j];
                
                int x = j * vali;
                int y = i * vali;
                
                luoViiva(binaariMuuntaminen(binaariNumero), x, y, ikkuna, vali);
            }
        }
    }
    
    /** Erottaa luolan seinät ja tilan. Ei ole paras toteutus, toinen vaihtoehto harkinnassa.      
     * @param pisteet pisteiden taulukko
     * @param ikkuna ikkuna johon kaikki piirretään
     * @param vali pisteiden väli
     */
    public void lisaaSeinaVari(int[][]pisteet, Pane ikkuna, int vali) {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 1) {
                    int aloitusX = j * vali;
                    int aloitusY = i * vali;
                    Line viivaX = new Line(aloitusX - (vali / 2), aloitusY, aloitusX + (vali / 2), aloitusY);
                    Line viivaY = new Line(aloitusX, aloitusY  - (vali / 2), aloitusX, aloitusY  + (vali / 2));
                    ikkuna.getChildren().addAll(viivaX, viivaY);
                }
            }
        }
    }
    
    /**
     * 
     * Metodi muuntaa binäärinumeron tavalliseksi numeroksi 0 - 15 väliltä. 
     * 
     * @param luku Binaarinumero, joka on generoitu pisteet -taulukon sisällöstä riippuen missä kohtaa
     * ollaan. Esimerkiksi "1111" tai "1011"
     * @return Tavallinen numero, joka vastaa binäärinumeroa. Esimerkiksi "1111" muuttuu 15.
     */
    public int binaariMuuntaminen(String luku) {
        return (luku.charAt(0) - '0') * 8 + (luku.charAt(1) - '0') * 4 
               + (luku.charAt(2) - '0') * 2 + (luku.charAt(3) - '0');
    }
    
    /**
     * 
     * Metodi luo viivan annetun tiedon perusteella ja lisää sen paneen. 
     * 
     * @param luku Muutettu binäärinumero, jotta saadaan tieto mihin vaihtoehtoon päädytään vektorin
     * generoimisessa.
     * @param x Piste x ikkunassa.
     * @param y Piste y ikkunassa.
     * @param p Pane johon viivat sijoitetaan.
     */
    public void luoViiva(int luku, int x, int y, Pane p, int vali) {
        if (luku < 1) {
            return;
        } else if (luku == 1) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 2) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 3) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 4) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 5) {
            Line viiva1 = new Line(x + (vali / 2), y, x, y + (vali / 2));
            Line viiva2 = new Line(x + vali, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
            
        } else if (luku == 6) {
            Line viiva = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 7) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 8) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 9) {
            Line viiva = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 10) {
            Line viiva1 = new Line(x + (vali / 2), y, x + vali, y + (vali / 2));
            Line viiva2 = new Line(x + (vali / 2), y + vali, x, y + (vali / 2));
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
            
        } else if (luku == 11) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 12) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 13) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 14) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku > 14) {
            return;
        }
    }
    
    /**
     *  Alustaa ohjelman
     * @return Palauttaa scenen, jotta saadaan ohjelma pyörimään.
     */
    public SubScene luoLuola() {
        luoTaulukko(pisteet);
        if (naytetaankoPisteet) {
            lisaaPisteet(pisteet, ikkuna, vali);
        }
        lisaaViivat(pisteet, ikkuna, vali);
        lisaaSeinaVari(pisteet, ikkuna, vali);
        SubScene scene = new SubScene(ikkuna, haeLeveys(), haeKorkeus());
        scene.setFill(Color.TEAL);
        return scene;
    }
    
}
