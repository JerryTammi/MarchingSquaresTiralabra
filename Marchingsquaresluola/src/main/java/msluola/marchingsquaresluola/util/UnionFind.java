package msluola.marchingsquaresluola.util;

/**
 * Tarvitaan kruskalin algoritmissa yhdistämään luolan huoneita.
 */
public class UnionFind {
    int n;
    int[]vanhempi;
    int[]koko;
    int maara;
    
    /**
     * @param n Luolan huoeneiden määrä.
     */
    public UnionFind(int n) {
        this.n = n;
        maara = n;
        vanhempi = new int[n];
        koko = new int[n];
        for (int i = 0; i < n; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
    }
    
    /**
     * Yhdistää kaksi huonetta.
     * @param a Huone a.
     * @param b Huone b.
     */
    public void yhdista(int a, int b) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) {
            return;
        }
        if (koko[a] < koko[b]) {
            int t = a;
            a = b;
            b = t;
        }
        vanhempi[b] = a;
        koko[a] += koko[b];
        maara--;
    }
    
    /**
     * @param x Tutkittava huone
     * @return Palauttaa alkuperäisen tarkistettavan huoneen edustajan.
     */
    public int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }
    
    /**
     * @return Palauttaa komponenttien määrän.
     */
    public int kompMaara() {
        return maara;
    }
}
