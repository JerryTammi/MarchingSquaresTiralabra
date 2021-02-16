package msluola.marchingsquaresluola.luola;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import msluola.marchingsquaresluola.util.LehmerRng;

public class Luolasto {
    ArrayList<Luola>luolat;
    int n;
    AnchorPane pane;
    boolean ensimmainen;
    
    /**
     * Pitää yllä luolien joukkoa
     * @param n montako luolaa luolastoon
     */
    public Luolasto(int n) {
        this.n = n;
        this.luolat = new ArrayList<>();
    }
    
    /**
     * Alustaa luolan näyttöä varten
     * @param korkeus jokaisen luolan korkeus
     * @param leveys jokaisen luolan leveys
     * @param vali algoritmeihin tarvittava luku, joka määrittää mm. kuinka tiheästi seinät ovat pakattu
     * @param p pane luolaston esittelyä varten
     */
    public void louLuolasto(int korkeus, int leveys, int vali, AnchorPane p) {
        this.pane = p;
        LehmerRng rand = new LehmerRng(System.nanoTime() % System.currentTimeMillis());
        long edellinen = 0;
        for (int i = 0; i < n; i++) {
            Long seed = rand.lehmer() % 100000;
            Luola l = new Luola(korkeus, leveys, vali, seed);
            if (i > 0) {
                l.asetaEdellinenSeed(edellinen);
            }
            luolat.add(l);
            int x = (vali * 5) + (int)(rand.lehmer() % (leveys - (vali * 10)));
            int y = (vali * 5) + (int)(rand.lehmer() % (korkeus - (vali * 10)));
            lisaaPisteLuola(y, x, i, p, l);
            edellinen = seed;
        }
        lisaaJokaiselleLuolalleSeuraavaLuola();
    }
    
    /**
     * Visualisoi luolien määrän. Tällä hetkellä satunnaisesti mutta tarkoituksena luoda parempi toteutus
     * @param y luolan sijainnin y
     * @param x luolan sijainnin x
     * @param i tarvitaan ensimmäisen ja vikan luolan erotteluun
     * @param p luolaston pane
     * @param l yksittäinen luola luolastossa
     */
    public void lisaaPisteLuola(int y, int x, int i, AnchorPane p, Luola l) {
        Circle c = new Circle(x, y, 8);
        if (i == 0) {
            c.setFill(Color.RED);
        }
        else if (i == (n - 1)) {
            c.setFill(Color.GREEN);
        }
        else {
            c.setFill(Color.BLACK);
        }
        p.getChildren().add(c);
    }
    
    /**
     * Lisää jokaiselle luolalle muistiin seuraavan luolan numeron, jotta voidaan kulkea luolasta toiseen
     */
    public void lisaaJokaiselleLuolalleSeuraavaLuola() {
        ArrayList<Luola> uusiLuolasto = new ArrayList<>();
        for (int i = 0; i < luolat.size() - 1; i++) {
            Luola l1 = luolat.get(i);
            Luola l2 = luolat.get(i+1);
            l1.asetaSeuraavaSeed(l2.haeOmaSeed());
            uusiLuolasto.add(l1);
        }
        uusiLuolasto.add(luolat.get(luolat.size()-1));
        luolat = uusiLuolasto;
    }
    
    public ArrayList<Luola> haeLuolasto() {
        return luolat;
    }
    
}
