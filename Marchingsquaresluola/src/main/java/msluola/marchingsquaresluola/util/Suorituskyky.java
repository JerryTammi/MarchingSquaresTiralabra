package msluola.marchingsquaresluola.util;

import msluola.marchingsquaresluola.luola.Luola;
import msluola.marchingsquaresluola.luola.Luolasto;

public class Suorituskyky {
    Luolasto l;
    
    public void testaaSuoritusKyky(int n) {
        l = new Luolasto(n);
        long aikaAlussa = System.nanoTime();
        l.luoLuolasto(1000, 1000, 20);
        for (int i = 0; i < n; i++) {
            Luola luola = l.uusiLuola(4);
            luola.luoTaulukko();
//            luola.tulostaLuola();
        }
        long aikaLopussa = System.nanoTime();
        System.out.println("Luolien määrä: " + n + ", aikaa kului: " + (aikaLopussa - aikaAlussa) / 1e9 + "s");
    }
    
}
