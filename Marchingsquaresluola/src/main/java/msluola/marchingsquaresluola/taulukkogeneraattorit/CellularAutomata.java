package msluola.marchingsquaresluola.taulukkogeneraattorit;

public class CellularAutomata {
    
    /** 
     * Luodaan uusi taulukko, jota muokataan alkuperäisen taulukkon pohjalta ja lopuksi korvaa sen.
     * Uusi taulukko luodaan sitä varten että kun edetään taulukoss, muokatut pisteet eivät vaikuta
     * muokattaviin pisteisiin. Se käy läpi jokaisen pisteen, tarkistaa montako vieruspisteistä on seinä
     * ja muokkaa sen seinäksi, jos se on suurempi kuin aste. Mitä suurempi aste, sitä avonnaisempi luola.
     * Tällä hetkellä asteet 2-4 ovat käytännölliset. 
     * 
     * @param pisteet Luolan alkuperäinen taulukko.
     * @param aste Kuinka voimakas muutos taulukkoon.
     * @return Palauttaa muokatun taulukon.
     */
    public int[][] muunna(int[][]pisteet, int aste) {
        int[][]uudetPisteet = new int[pisteet.length][pisteet[0].length];
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                uudetPisteet[i][j] = pisteet[i][j];
            }
        }
        
        for (int i = 0; i < uudetPisteet.length - 1; i++) {
            for (int j = 0; j < uudetPisteet[0].length - 1; j++) {
                int seinat = vierusSeinat(i, j, pisteet);
                if (seinat > aste) {
                    uudetPisteet[i][j] = 1;
                } else if (seinat < aste) {
                    uudetPisteet[i][j] = 0;
                }
            }
        }
        siivoaTaulukko(uudetPisteet);
        siivoaTaulukko(uudetPisteet);
        return uudetPisteet;
    }
    
    /**
     * Poistaa yhden pisteen seinät ja varmistaa, että taulukon reunat ovat seiniä.
     * 
     * @param pisteet Muokattava taulukko.
     */
    public void siivoaTaulukko(int[][]pisteet) {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (i < 1 || i == pisteet.length - 1 || j < 1 || j == pisteet[0].length - 1) {
                    pisteet[i][j] = 1;
                } else if (pisteet[i][j] == 1) {
                    if (vierusSeinat(i, j, pisteet) == 0) {
                        pisteet[i][j] = 0;
                    }
                } else if (pisteet[i][j] == 0) {
                    if (vierusSeinat(i, j, pisteet) == 8) {
                        pisteet[i][j] = 1;
                    }
                }
            }
        }
    }
    
    /**
     * Laskee montako pistettä pisteen x,y ympärillä on.
     * 
     * @param y Pisteen y taulukossa.
     * @param x Pisteen x taulukossa.
     * @param pisteet Taristeltava taulukko
     * @return Palauttaa montako pistettä pisteen x,y ympärillä on.
     */
    public int vierusSeinat(int y, int x, int[][]pisteet) {
        int seinat = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x; j <= x + 1; j++) {
                if (i >= 0 && i < pisteet.length && j >= 0 && j < pisteet[0].length) {
                    if (i != y || j != x) {
                        seinat += pisteet[i][j];
                    }
                }
            }
        } 
        return seinat;
    }
}
