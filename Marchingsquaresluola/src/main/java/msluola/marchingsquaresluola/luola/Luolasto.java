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
    
    /**
     * Pitää yllä luolien joukkoa.
     * @param n Montako luolaa luolastoon.
     */
    public Luolasto(int n) {
        this.n = n;
        lista = new Lista(1);
        index = 0;
    }
    
    /**
     * Alustaa luolan näyttöä varten.
     * @param korkeus Jokaisen luolan korkeus.
     * @param leveys Jokaisen luolan leveys.
     * @param vali Algoritmeihin tarvittava luku, joka määrittää mm. kuinka tiheästi seinät ovat pakattu.
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
     * @param tyyppi valitaan luolan tyyppi
     * @return Uusi luola.
     */
    public Luola uusiLuola(int tyyppi) {
        int[]seed = lista.palautaOsio(index);
        long luku = (long) seed[0];
        Luola luola = new Luola(korkeus, leveys, vali, luku, tyyppi);
        index++;
        return luola;
    }
    
    /**
     * @return Paluttaa listan täynnä luolia.
     */
    public Lista haeLista() {
        return lista;
    }
    
    /**
     * @return Paluttaa luolaston indexin.
     */
    public int haeIndex() {
        return index;
    }
}
