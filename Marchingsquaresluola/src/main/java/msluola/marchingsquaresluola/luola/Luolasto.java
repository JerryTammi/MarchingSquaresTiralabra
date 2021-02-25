package msluola.marchingsquaresluola.luola;

import msluola.marchingsquaresluola.util.LehmerRng;
import msluola.marchingsquaresluola.util.Lista;

public class Luolasto {
    Lista lista;
    int n;
    int index;
    int korkeus;
    int leveys;
    int vali;
    boolean onnistuuko;
    
    /**
     * Pitää yllä luolien joukkoa.
     * @param n montako luolaa luolastoon
     */
    public Luolasto(int n) {
        this.n = n;
        lista = new Lista(1);
        index = 0;
        onnistuuko = true;
    }
    
    /**
     * Alustaa luolan näyttöä varten
     * @param korkeus jokaisen luolan korkeus
     * @param leveys jokaisen luolan leveys
     * @param vali algoritmeihin tarvittava luku, joka määrittää mm. kuinka tiheästi seinät ovat pakattu
     */
    public void luoLuolasto(int korkeus, int leveys, int vali) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.vali = vali;
        LehmerRng rand = new LehmerRng(System.nanoTime() % 1337);
        long edellinen = 0;
        for (int i = 0; i < n; i++) {
            Long seed = rand.lehmer() % 10000;
            int luku = seed.intValue();
            lista.add(new int[]{luku});
        }
    }
    
    /**
     * Generoi uuden luolan.
     * @param kumpi valitaan luolan tyyppi
     * @return uusi luola
     */
    public Luola uusiLuola(int tyyppi) {
        int[]seed = lista.palautaOsio(index);
        long luku = (long)seed[0];
        Luola luola = new Luola(korkeus, leveys, vali, luku, tyyppi);
        index++;
        return luola;
    }
        
    public Lista haeLista() {
        return lista;
    }
    
    public int haeIndex() {
        return index;
    }
}
