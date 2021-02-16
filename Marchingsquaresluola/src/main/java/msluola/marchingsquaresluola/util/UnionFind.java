
package msluola.marchingsquaresluola.util;

public class UnionFind {
    int n;
    int[]vanhempi;
    int[]koko;
    int maara;
    
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
        koko[a]+= koko[b];
        maara--;
    }
    
    public int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }
    
    public int kompMaara() {
        return maara;
    }
}
