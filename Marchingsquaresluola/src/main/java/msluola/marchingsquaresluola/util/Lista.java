package msluola.marchingsquaresluola.util;

/**
 * Lista, jota käytetään luolien generoimisessa. Sopii ainoastaan numeroiden säilytykseen.
 */
public class Lista {
    int[][]lista;
    int n;
    int koko;
    int index;
    
    /**
     * Listan koko on alussa 8.
     * @param n Listalle lisättävän numerosarjan koko. 
     */
    public Lista(int n) {
        this.n = n;
        index = 0;
        koko = 8;
        lista = new int[koko][n];
    }
    
    /**
     * Lisätään listalle numerosarjoja. Jos lista on täynnä eikä maksimikokoa ole ylitetty, listan koko tuplataan.
     * @param t Listalle lisättävä numerosarja. 
     */
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
        // Lista täynnä
        if (koko > 131072) {
            return;
        }
        if (t.length != n) {
            return;
        }
        for (int i = 0; i < t.length; i++) {
            lista[index][i] = t[i];
        }
        index++;
    }
    
    /**
     * Lista järjestetään halutessa pikajärjestysalgoritmilla.
     * @param a Järjestettävän listan ensimmäinen alkio.
     * @param b Järjestettävän listan viimeinen alkio.
     * @param i Listaan tallenetun numerosarjan järjestettävä osio.
     */
    public void jarjesta(int a, int b, int i) {
        if (i > n) {
            return;
        }
        if (a >= b) {
            return;
        }
        int k = jako(a, b, i);
        jarjesta(a, k - 1, i);
        jarjesta(k + 1, b, i);
    }
    
    /**
     * Hoitaa pikajärjestämisessä alkioiden siirtämisen oikeaan järjestykseen. 
     * @param a Järjestettävän listan ensimmäinen alkio.
     * @param b Järjestettävän listan viimeinen alkio.
     * @param i Listaan tallenetun numerosarjan järjestettävä osio.
     * @return Jakoalkio.
     */
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
    
    /**
     * @param i Halutun numerosarjan indeksi.
     * @return Palauttaa halutun numerosarjan.
     */
    public int[] palautaOsio(int i) {
        return lista[i];
    }
        
    /**
     * @return Palauttaa listan viimeisimmän alkion indeksin.
     */
    public int haeIndex() {
        if (index == 0) {
            return 0;
        }
        return index - 1;
    }
    
    /**
     * Tulostaa listan.
     */
    public void tulosta() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < lista[0].length; j++) {
                System.out.print(lista[i][j] + " ");
            }
            System.out.println();
        }
    }
}
