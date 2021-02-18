package msluola.marchingsquaresluola.luola;

import java.util.ArrayList;
import msluola.marchingsquaresluola.util.LehmerRng;

public class Luolasto {
    ArrayList<Luola>luolat;
    int n;
    
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
     */
    public void louLuolasto(int korkeus, int leveys, int vali) {
        LehmerRng rand = new LehmerRng(System.nanoTime() % 1337);
        long edellinen = 0;
        for (int i = 0; i < n; i++) {
            Long seed = rand.lehmer() % 100000;
            Luola l = new Luola(korkeus, leveys, vali, seed);
            if (i > 0) {
                l.asetaEdellinenSeed(edellinen);
            }
            luolat.add(l);
            edellinen = seed;
        }
        lisaaJokaiselleLuolalleSeuraavaLuola();
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
    
    public int luolastonKoko() {
        return luolat.size();
    }
    
}
