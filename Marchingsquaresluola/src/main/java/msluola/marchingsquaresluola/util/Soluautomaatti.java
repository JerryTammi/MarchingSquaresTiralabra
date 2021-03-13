package msluola.marchingsquaresluola.util;

/**
 * Käy läpi jokaisen pisteen, tarkistaa kuinka moni vieruspisteistä on seinä
        ja muokkaa sen seinäksi, jos se on suurempi kuin aste. Mitä suurempi aste, sitä avonnaisempi luola.
        Tällä hetkellä asteet 3-5 ovat käytännölliset. 
 */
public class Soluautomaatti {
    LehmerRng rng;
    
    /** 
     * Luodaan uusi taulukko, jota muokataan alkuperäisen taulukkon pohjalta ja lopuksi korvaa sen.Uusi taulukko luodaan sitä varten että kun edetään taulukossa, muokatut pisteet eivät vaikuta
        muokattaviin pisteisiin.
     * @param pisteet Luolan alkuperäinen taulukko.
     * @param tyyppi Luolan ulkonäköön vaikuttava parametri.
     * @return Palauttaa muokatun taulukon.
     */
    public int[][] muunna(int[][]pisteet, int tyyppi) {
        rng = new LehmerRng(System.nanoTime() % 1337);
        int[][]uudetPisteet = new int[pisteet.length][pisteet[0].length];
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                uudetPisteet[i][j] = pisteet[i][j];
            }
        }
        int aste = 4;
        switch (tyyppi) {
            case 1:
                aste = 5;
                break;
            case 2:
                aste = 4;
                break;
            case 3:
                aste = 3;
                break;
            default:
                aste = 4;
                break;
        }
        for (int i = 0; i < uudetPisteet.length; i++) {
            for (int j = 0; j < uudetPisteet[0].length; j++) {
                int seinat = vierusSeinat(i, j, pisteet);
                if (pisteet[i][j] == 1) {
                    if (seinat < aste) {
                        uudetPisteet[i][j] = 0;
                    } else {
                        uudetPisteet[i][j] = 1;
                    }
                } else {
                    if (seinat > (8 - aste)) {
                        uudetPisteet[i][j] = 1;
                    } else {
                        uudetPisteet[i][j] = 0;
                    }
                }
            }
        }
        return uudetPisteet;
    }
        
    /**
     * Laskee montako pistettä pisteen x,y ympärillä on.
     * @param y Pisteen y taulukossa.
     * @param x Pisteen x taulukossa.
     * @param pisteet Tarkisteltava taulukko
     * @return Palauttaa montako pistettä pisteen x,y ympärillä on.
     */
    public int vierusSeinat(int y, int x, int[][]pisteet) {
        int seinat = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int naapuriY = y + i;
                int naapuriX = x + j;
                if (i == 0 && j == 0) {
                    
                } else if (naapuriY < 0 || naapuriX < 0 || naapuriY >= pisteet.length - 1 || naapuriX >= pisteet[0].length) {
                    seinat++;
                } else if (pisteet[naapuriY][naapuriX] == 1) {
                    seinat++;
                }
            }
        }
        return seinat;
    }
    
    /**
     * Siivoaa luolan pienistä seinistä.
     * @param pisteet Luolan taulukko.
     * @return Luolan taulukko.
     */
    public int[][]siivous(int[][]pisteet) {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 1) {
                    if (vierusSeinat(i, j, pisteet) == 0) {
                        pisteet[i][j] = 0;
                    }
                }
            }
        }
        return pisteet;
    }
}
