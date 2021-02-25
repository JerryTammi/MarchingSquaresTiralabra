package msluola.marchingsquaresluola.luola;

import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import msluola.marchingsquaresluola.util.Soluautomaatti;
import msluola.marchingsquaresluola.util.MarchingSquares;
import msluola.marchingsquaresluola.util.LehmerRng;
import msluola.marchingsquaresluola.util.Mst;

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
    long omaSeed;
    int tyyppi;
    
    /**
     *
     * @param leveys Ikkunan leveys
     * @param korkeus Ikkunan korkeus
     * @param vali Jokaisen algoritmissa käytettävän pisteen välin etäisyyden toisiinsa.
     * @param seed Luolan oma seed
     */
    public Luola(int korkeus, int leveys, int vali, long seed, int tyyppi) {
        ikkuna = new Pane();
        ikkuna.setBackground(Background.EMPTY);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vali = vali;
        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
        omaSeed = seed;
        this.tyyppi = tyyppi;
    }
    
    /**
     * 
     * Metodi luo taulukon, jonka avulla se generoi luolan.
     */
    public void luoTaulukko() {
        LehmerRng rng = new LehmerRng(pisteet, omaSeed);
        pisteet = rng.luoTaulu();
        Soluautomaatti sa = new Soluautomaatti();
        for (int i = 0; i < 10; i++) {
            pisteet = sa.muunna(pisteet, tyyppi);
        }
        Mst m = new Mst(pisteet);
        pisteet = m.linkita();
        pisteet = sa.siivous(pisteet);
    }
    
    /**
     * Lisää pisteet paneen.Ohjelman valmistuttua tämä metodi ei tule olemaan käytössä.Tällä hetkellä
        auttaa visualisoimaan algoritmia.
     * @param a anchorpane jossa pisteet halutessa esitetään
     */
    public void lisaaPisteet(AnchorPane a) {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                Circle c = new Circle(j * vali, i * vali, 3);
                if (pisteet[i][j] == 1) {
                    c.setFill(Color.BLACK);
                } else {
                    c.setFill(Color.WHITE);
                }
                a.getChildren().add(c);
            }
        }
    }
    
    /**
     * 
     * Metodi käy läpi pisteet -taulukon, luo binäärinumeron tiedon mukaan ja muuntaa sen tavalliseksi
     * numeroksi.Tämän jälkeen se valitsee 16 mahdollisesta vaihtoehdosta ainoan sopivan, luo seinän ja 
        lopuksi lisää sen paneen.
     */
    public void lisaaSeinat() {
        MarchingSquares msv = new MarchingSquares();
        msv.lisaaSeinat(pisteet, ikkuna, vali);
    }
    
    /**
     * Palauttaa valmiiksi alustetun luolan näyttöö varten
     * @return scene luolan esitystä varten
     */
    public SubScene luoLuola() {
        luoTaulukko();
        lisaaSeinat();
        SubScene scene = new SubScene(ikkuna, haeLeveys(), haeKorkeus());
        scene.setFill(Color.TEAL);
        return scene;
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
     * Muistaa oman numeron
     * @param seed Luolan numero
     */
    public void asetaOmaSeed(long seed) {
        omaSeed = seed;
    }
    
    /**
     * 
     * @return Hakee oman numeron
     */
    public long haeOmaSeed() {
        return omaSeed;
    }
    
    /**
     * 
     * @return Palauttaa taulukon.
     */
    public int[][] haeTaulukko() {
        return pisteet;
    }
    
    /**
     * Asettaa taulukon.
     * @param taulu Luolan taulu
     */
    public void asetaTaulukko(int[][]taulu) {
        this.pisteet = taulu;
    }
}
