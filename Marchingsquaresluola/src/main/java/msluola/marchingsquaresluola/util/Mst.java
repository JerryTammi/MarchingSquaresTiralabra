package msluola.marchingsquaresluola.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mst {
    int[][]pisteet;
    boolean[][]kayty;
    int huoneet;
    ArrayList<int[]>aloituspisteet;
    ArrayList<int[]>pisteidenvalit;
    boolean[][]verkko;
    int kaytavat;
    
    public Mst() {
        huoneet = 0;
        kaytavat = 0;
    }
    
    
    public int[][] linkita(int[][]pisteet) {
        this.pisteet = pisteet;
        kayty = new boolean[pisteet.length][pisteet[0].length]; 
        this.pisteet = pisteet;
        aloituspisteet = new ArrayList<>();
        pisteidenvalit = new ArrayList<>();
        
        laskeHuoneet();
        
        yhdistaHuoneet();
        muodostaKaytavat();
        return pisteet;
    }
    
    private void laskeHuoneet() {
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 0 && !kayty[i][j]) {
                    huoneet++;
                    kompSyvyys(i, j);
                    aloituspisteet.add(new int[]{i,j});
                }
            }
        }
    }
    
    private void kompSyvyys(int y, int x) {
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
    
    private void yhdistaHuoneet() {
        verkko = new boolean[aloituspisteet.size()][aloituspisteet.size()];
        for (int i = 0; i < aloituspisteet.size(); i++) {
            int[]pisteA = aloituspisteet.get(i);
            for (int j = 0; j < aloituspisteet.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (!verkko[i][j]) {
                    int[]pisteB = aloituspisteet.get(j);
                    int etaisyys = ((pisteA[0] - pisteB[0]) > 0 ? (pisteA[0] - pisteB[0]) : -(pisteA[0] - pisteB[0])) + 
                                          ((pisteA[1] - pisteB[1]) > 0 ? (pisteA[1] - pisteB[1]) : -(pisteA[1] - pisteB[1]));

                    pisteidenvalit.add(new int[]{pisteA[0], pisteA[1], pisteB[0], pisteB[1], etaisyys, i, j});
                    verkko[i][j] = true;
                    verkko[j][i] = true;
                }
            }
        }
        Collections.sort(pisteidenvalit, valiVertailu);
    }
    
    private void muodostaKaytavat() {
        UnionFind uf = new UnionFind(aloituspisteet.size());
        for (int i = 0; i < pisteidenvalit.size(); i++) {
            if (uf.kompMaara() <= 1) {
                break;
            }
            int[]kaari = pisteidenvalit.get(i);
            int[] aloitusPiste = new int[]{kaari[0], kaari[1], kaari[5]};
            int[] loppuPiste = new int[]{kaari[2], kaari[3], kaari[6]};
            if (uf.edustaja(aloitusPiste[2]) == uf.edustaja(loppuPiste[2])) {
                continue;
            }
            uf.yhdista(aloitusPiste[2], loppuPiste[2]);
            muutaKaytavaksi(aloitusPiste, loppuPiste);
        }
    }
    
    private void muutaKaytavaksi(int[] pisteA, int[]pisteB) {
        int yAloitus = pisteA[0];
        int yLoppu = pisteB[0];
        int xAloitus = pisteA[1];
        int xLoppu = pisteB[1];
        
        if (yAloitus == yLoppu) {
            
        }
        else if (yAloitus < yLoppu) {
            for (int i = yAloitus; i <= yLoppu; i++) {
                pisteet[i][xAloitus] = 0;
                if(rndMuutos() && xAloitus > 1) {
                    pisteet[i][xAloitus - 1] = 0;
                }
                if(rndMuutos() && xAloitus < pisteet[0].length - 2 ) {
                    pisteet[i][xAloitus + 1] = 0;
                }
            }
        }
        else {
            for (int i = yLoppu; i < yAloitus; i++) {
                pisteet[i][xAloitus] = 0;
                if(rndMuutos() && xAloitus > 1) {
                    pisteet[i][xAloitus - 1] = 0;
                }
                if(rndMuutos() && xAloitus < pisteet[0].length - 2 ) {
                    pisteet[i][xAloitus + 1] = 0;
                }
            }
        }
        
        if (xAloitus == xLoppu) {
            
        }
        else if (xAloitus < xLoppu) {
            for (int i = xAloitus; i <= xLoppu; i++) {
                pisteet[yLoppu][i] = 0;
                if(rndMuutos() && yAloitus > 1) {
                    pisteet[yLoppu - 1][i] = 0;
                }
                if(rndMuutos() && yAloitus < pisteet.length - 2 ) {
                    pisteet[yLoppu + 1][i] = 0;
                }
            }
        }
        else {
            for (int i = xLoppu; i < xAloitus; i++) {
                pisteet[yLoppu][i] = 0;
                if(rndMuutos() && yAloitus > 1) {
                    pisteet[yLoppu - 1][i] = 0;
                }
                if(rndMuutos() && yAloitus < pisteet.length - 2 ) {
                    pisteet[yLoppu + 1][i] = 0;
                }
            }
        }
        
    }
    
    private boolean rndMuutos() {
        boolean toteutuuko = false;
        LehmerRng rnd = new LehmerRng(System.nanoTime());
        if (rnd.lehmer() % 512 > 200) {
            toteutuuko = true;
        }
        return toteutuuko;
    }
    
    public int haeHuoneet() {
        return huoneet;
    }
    
    public static Comparator<int[]> valiVertailu = (int []p1, int[] p2) -> p1[4] - p2[4];
}
