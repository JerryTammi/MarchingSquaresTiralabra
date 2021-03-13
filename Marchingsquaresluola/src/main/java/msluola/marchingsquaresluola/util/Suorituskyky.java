package msluola.marchingsquaresluola.util;

import javafx.scene.SubScene;
import msluola.marchingsquaresluola.luola.Luola;
import msluola.marchingsquaresluola.luola.Luolasto;

/**
 * Mitataan luolien generoimisen suorituskykyä.
 */
public class Suorituskyky {
    Luolasto l;
    
    /**
     * Testaa suorituskykyä.
     * @param n Luolien määrä.
     */
    public void testaaSuoritusKyky(int n) {
        l = new Luolasto(n);
        long aikaAlussa = System.nanoTime();
        l.luoLuolasto(1000, 1000, 20);
        for (int i = 0; i < n; i++) {
            Luola luola = l.uusiLuola(4);
            luola.luoTaulukko();
//            SubScene s = luola.luoLuola();
        }
        long aikaLopussa = System.nanoTime();
        System.out.println("Luolien määrä: " + n + ", aikaa kului: " + (aikaLopussa - aikaAlussa) / 1e9 + "s");
    }
    
}
