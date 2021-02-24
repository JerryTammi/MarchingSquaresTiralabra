package msluola.marchingsquaresluola.util;

public class Lista {
    int[][]lista;
    int n;
    int koko;
    int index;
    
    public Lista(int n) {
        this.n = n;
        index = 0;
        koko = 8;
        lista = new int[koko][n];
    }
    
    public void add(int[]t) {
        if (index == koko - 1) {
            koko = 2 * koko;
            int[][]uusiLista = new int[koko][n];
            for (int i = 0; i < lista.length; i++) {
                for (int j = 0; j < lista[0].length; j++) {
                    uusiLista[i][j] = lista[i][j];
                }
            }
            lista = uusiLista;
        }
        if (koko >= 65536) {
            System.out.println("Lista täynnä");
            return;
        }
        for (int i = 0; i < t.length; i++) {
            lista[index][i] = t[i];
        }
        index++;
    }
    
    public void jarjesta(int a, int b, int i) {
        if (i > n) {
            return;
        }
        if (a >= b) {
            return;
        }
        int k = jako(a, b, i);
        jarjesta(a, k - 1, i);
        jarjesta(k+1, b, i);
    }
    
    public int jako(int a, int b, int i) {
        int k = a;
        for (int missa = a + 1; missa <= b; missa++) {
            if (lista[missa][i] < lista[a][i]) {
                k += 1;
                int[] muutos = lista[missa];
                lista[missa] = lista[k];
                lista[k] = muutos;
            }
        }
        int[] muutos = lista[a];
        lista[a] = lista[k];
        lista[k] = muutos;
        return k;
    }
    
    public int[] palautaOsio(int i) {
        return lista[i];
    }
    
    public int[][] palauta() {
        return lista;
    }
    
    public int haeIndex() {
        return index - 1;
    }
    
    public void tulosta() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < lista[0].length; j++) {
                System.out.print(lista[i][j] + " ");
            }
            System.out.println();
        }
    }
}
