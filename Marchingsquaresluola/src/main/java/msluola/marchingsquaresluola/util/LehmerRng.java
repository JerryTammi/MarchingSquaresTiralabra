package msluola.marchingsquaresluola.util;

public class LehmerRng {
    long seed;
    int[][]pisteet;
    long m = 2147483647;
    long a = 39373;
    
    public LehmerRng(int[][]pisteet, long seed) {
        this.pisteet = pisteet;
        this.seed = seed;
    }
    
    public LehmerRng(long seed) {
        this.seed = seed;
    }
    
    
    public long lehmer() {
        long uusiSeed = (a * seed) % m;
        seed = uusiSeed;
        return uusiSeed;
    }
    
    public int[][]haePisteet() {
        return pisteet;
    }
    
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
