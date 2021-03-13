package msluola.marchingsquaresluola.util;

/**
 * Rng -luokka, jota käytetään luolien generoimisessa.
 * Lisätietoja: https://en.wikipedia.org/wiki/Lehmer_random_number_generator
 */
public class LehmerRng {
    long seed;
    int[][]pisteet;
    long m = 2147483647;
    long a = 39373;
    
    /**
     * Tätä käytetään ainoastaan luolan seinien/lattian generoimisessa.
     * @param pisteet Muokattava taulukko.
     * @param seed Luolan numero.
     */
    public LehmerRng(int[][]pisteet, long seed) {
        this.pisteet = pisteet;
        this.seed = seed;
    }
    
    /**
     * Tätä käytetään kun halutaan yksittäinen random numero.
     * @param seed Aloitusnumero.
     */
    public LehmerRng(long seed) {
        this.seed = seed;
    }
    
    /**
     * Muokkaa nykyistä numeroa.
     * @return Paluttaa uuden numeron.
     */
    public long lehmer() {
        long uusiSeed = (a * seed) % m;
        seed = uusiSeed;
        return uusiSeed;
    }
    
    /**
     * @return Paluttaa taulukon.
     */
    public int[][]haePisteet() {
        return pisteet;
    }
    
    /**
     * Täyttää tyhjän taulkon 1 tai 0.
     * @return Paluttaa valmiiksi muokatun taulukon.
     */
    public int[][] luoTaulu() {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (i < 1 || i == pisteet.length - 1 || j < 1 || j == pisteet[0].length - 1) {
                    pisteet[i][j] = 1;
                } else if ((lehmer() % 256) >  115) {
                    pisteet[i][j] = 1;
                } else {
                    pisteet[i][j] = 0;
                }
            }
        }
        return pisteet;
    }
}
