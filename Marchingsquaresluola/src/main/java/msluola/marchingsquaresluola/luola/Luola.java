package msluola.marchingsquaresluola.luola;

import java.io.FileNotFoundException;
import javafx.scene.SubScene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import msluola.marchingsquaresluola.generaattorit.Soluautomaatti;
import msluola.marchingsquaresluola.generaattorit.MarchingSquaresViivat;
import msluola.marchingsquaresluola.generaattorit.LehmerRng;

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
    Hahmo hahmo;
    int alkuAloituspiste;
    int loppuAloituspiste;
    long omaSeed;
    long edellinenSeed;
    long seuraavaSeed;
    
    /**
     *
     * @param leveys Ikkunan leveys
     * @param korkeus Ikkunan korkeus
     * @param vali Jokaisen algoritmissa käytettävän pisteen välin etäisyyden toisiinsa.
     */
    public Luola(int korkeus, int leveys, int vali, long seed) {
        ikkuna = new Pane();
        ikkuna.setBackground(Background.EMPTY);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vali = vali;
        this.pisteet = new int[(korkeus / vali) + 1][(leveys / vali) + 1];
        omaSeed = seed;
        edellinenSeed = 0;
        seuraavaSeed = 0;
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
     * Metodi luo taulukon, jonka avulla se generoi luolan.
     */
    public void luoTaulukko() {
        LehmerRng l = new LehmerRng(pisteet, omaSeed);
        pisteet = l.luoTaulu();
        
        Soluautomaatti sa = new Soluautomaatti();
        for (int i = 0; i < 10; i++) {
            this.pisteet = sa.muunna(pisteet);
        } 
    }
    
    /**
     * Muistaa oman numeron
     * @param seed 
     */
    public void asetaOmaSeed(long seed) {
        omaSeed = seed;
    }
    
    /**
     * Hakee oman numeron
     * @return 
     */
    public long haeOmaSeed() {
        return omaSeed;
    }
    
    /**
     * Muistaa edellisen luolan numeron
     * @param seed 
     */
    public void asetaEdellinenSeed(long seed) {
        edellinenSeed = seed;
    }
    
    /**
     * Hakee edellisen numeron
     * @return 
     */
    public long haeEdellinenSeed() {
        return edellinenSeed;
    }
    
    /**
     * Muistaa seuraavan numeron
     * @param seed 
     */
    public void asetaSeuraavaSeed(long seed) {
        seuraavaSeed = seed;
    }
    
    /**
     * Hakee seuraavan numeron
     * @return 
     */
    public long haeSeuraavaSeed() {
        return seuraavaSeed;
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
    public void lisaaSeinat() {
        MarchingSquaresViivat msv = new MarchingSquaresViivat();
        msv.lisaaSeinat(pisteet, ikkuna, vali);
    }
    
    /**
     * 
     * @return 
     */
    public SubScene luoLuola() {
        luoTaulukko();
        lisaaSeinat();
        SubScene scene = new SubScene(ikkuna, haeLeveys(), haeKorkeus());
        scene.setFill(Color.TEAL);
        return scene;
    }
    
}
