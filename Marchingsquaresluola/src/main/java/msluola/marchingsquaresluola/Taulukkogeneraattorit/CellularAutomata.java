package msluola.marchingsquaresluola.Taulukkogeneraattorit;

import msluola.marchingsquaresluola.Luola.Luola;

public class CellularAutomata {
    
    public int[][] muunna(int[][]verkko) {
        int[][]uusiVerkko = new int[verkko.length][verkko[0].length];
        for (int i = 0; i < verkko.length; i++) {
            for (int j = 0; j < verkko[0].length; j++) {
                uusiVerkko[i][j] = verkko[i][j];
            }
        }
        
        for (int i = 0; i < uusiVerkko.length - 1; i++) {
            for (int j = 0; j < uusiVerkko[0].length - 1; j++) {
                int seinat = vierusSeinat(j, i, verkko);
                if (seinat > 3) {
                    uusiVerkko[i][j] = 1;
                } else if (seinat < 3){
                    uusiVerkko[i][j] = 0;
                }
            }
        }
        return uusiVerkko;
    }
    
    public int vierusSeinat(int x, int y, int[][]verkko) {
        int seinat = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x; j <= x + 1; j++) {
                if (i >= 0 && i <= verkko.length && j >= 0 && j <= verkko[0].length) {
                    if (i != y || j != x) {
                        seinat += verkko[i][j];
                    }
                } else {
                    seinat++;
                }
            }
        } 
        return seinat;
    }
}
