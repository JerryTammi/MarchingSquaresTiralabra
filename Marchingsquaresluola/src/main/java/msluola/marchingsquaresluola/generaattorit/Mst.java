package msluola.marchingsquaresluola.generaattorit;

import javafx.scene.layout.Pane;

public class Mst {
    int[][]pisteet;
    boolean[][]kayty;
    int komp;
    
    public Mst() {
        this.komp = 0;
    }
    
    public int[][] linkita(int[][]pisteet) {
        this.kayty = new boolean[pisteet.length][pisteet[0].length]; 
        this.pisteet = pisteet;
        
        laskeKomp();
        
        return pisteet;
    }
    
    public void laskeKomp() {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 0 && !kayty[i][j]) {
                    komp++;
                    kompSyvyys(i, j);
                }
            }
        }
    }
    
    public void kompSyvyys(int y, int x) {
        if (y > pisteet.length - 1 || x > pisteet[0].length - 1 || y < 1 || x < 1) {
            return;
        }
        if (pisteet[y][x] == 1 || kayty[y][x]) {
            return;
        }
        if (pisteet[y][x] == 0 && !kayty[y][x]) {
            kayty[y][x] = true;
            kompSyvyys(y + 1, x );
            kompSyvyys(y - 1, x );
            kompSyvyys(y, x + 1);
            kompSyvyys(y, x - 1);
        }
    }
}
