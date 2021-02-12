package msluola.marchingsquaresluola.luola;

import java.io.FileNotFoundException;
import javafx.scene.SubScene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
        int aste = 3;
        this.pisteet = sa.muunna(pisteet, aste);
        
        Long aukotSeed = System.nanoTime() % System.currentTimeMillis();
        LehmerRng aukot = new LehmerRng(aukotSeed);
        alkuAloituspiste = (int) (aukot.lehmer() % (korkeus / vali) - (vali / 4));;
        loppuAloituspiste = (int) (aukot.lehmer() % (korkeus / vali) - (vali / 4));
        if (alkuAloituspiste < 0) {
            alkuAloituspiste = 0;
        }
        if (loppuAloituspiste < 0) {
            loppuAloituspiste = 0;
        }
        
        for (int i = alkuAloituspiste; i < alkuAloituspiste + (vali / 4); i++) {
            for (int j = 0; j < (vali / 4); j++) {
                pisteet[i][j] = 0;
            }
        }
        
        for (int i = loppuAloituspiste; i < loppuAloituspiste + (vali / 4); i++) {
            for (int j = ((leveys / vali) - 1) - (vali / 4); j <= (leveys / vali); j++) {
                pisteet[i][j] = 0;
            }
        }
    }
    
    public void asetaOmaSeed(long seed) {
        omaSeed = seed;
    }
    
    public long haeOmaSeed() {
        return omaSeed;
    }
    
    public void asetaEdellinenSeed(long seed) {
        edellinenSeed = seed;
    }
    
    public long haeEdellinenSeed() {
        return edellinenSeed;
    }
    
    public void asetaSeuraavaSeed(long seed) {
        seuraavaSeed = seed;
    }
    
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
    public void lisaaViivat() {
        MarchingSquaresViivat msv = new MarchingSquaresViivat();
        msv.lisaaViivat(pisteet, ikkuna, vali);
        lisaaSeinaVari();
    }
    
    /** 
     * Erottaa luolan seinät ja tilan. Ei ole paras toteutus, toinen vaihtoehto harkinnassa.      
     */
    public void lisaaSeinaVari() {
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
    
    
//    public Hahmo haeHahmo() {
//        return hahmo;
//    }
    
    /**
     *  Alustaa ohjelman
     * @return Palauttaa scenen, jotta saadaan ohjelma pyörimään.
     */
//    public Pane luoLuola() throws FileNotFoundException {
//        luoTaulukko();
//        lisaaViivat();
//        hahmo = new Hahmo(vali / 2, (alkuAloituspiste * vali) + 10);
//        ikkuna.getChildren().add(hahmo.haeHahmo());
//        return ikkuna;
//    }
    
    public SubScene luoLuola() {
        luoTaulukko();
        lisaaViivat();
        
//        hahmo = new Hahmo(vali / 2, (alkuAloituspiste * vali) + 10);
//        
//        ikkuna.getChildren().add(hahmo.haeHahmo());
        
        SubScene scene = new SubScene(ikkuna, haeLeveys(), haeKorkeus());
        scene.setFill(Color.DARKSLATEGRAY);
        return scene;
    }
    
}
