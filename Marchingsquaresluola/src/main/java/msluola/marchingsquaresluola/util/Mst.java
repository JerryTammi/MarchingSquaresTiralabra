package msluola.marchingsquaresluola.util;

public class Mst {
    int[][]pisteet;
    boolean[][]kayty;
    int huoneet;
    Lista aloituspisteet;
    Lista pisteidenValit;
    boolean[][]verkko;
    
    public Mst(int[][]pisteet) {
        this.pisteet = pisteet;
        huoneet = 0;
        kayty = new boolean[pisteet.length][pisteet[0].length]; 
        aloituspisteet = new Lista(2);
        pisteidenValit = new Lista(7);
    }
    
    public int[][] linkita() {
        laskeHuoneet();
        yhdistaHuoneet();
        return pisteet;
    }
    
    public void laskeHuoneet() {
        huoneet = 0;
        kayty = new boolean[pisteet.length][pisteet[0].length]; 
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
    
    public void kompSyvyys(int y, int x) {
        if (y > pisteet.length - 1 || x > pisteet[0].length - 1 || y < 1 || x < 1) {
            return;
        }
        if (pisteet[y][x] == 1 || kayty[y][x]) {
            return;
        }
        if (pisteet[y][x] == 0 && !kayty[y][x]) {
            kayty[y][x] = true;
            kompSyvyys(y + 1, x);
            kompSyvyys(y - 1, x);
            kompSyvyys(y, x + 1);
            kompSyvyys(y, x - 1);
        }
    }
    
    public void yhdistaHuoneet() {
        int apKoko = aloituspisteet.haeIndex() + 1;
        verkko = new boolean[apKoko][apKoko];
        for (int i = 0; i < apKoko; i++) {
            int[]pisteA = aloituspisteet.palautaOsio(i);
            for (int j = 0; j < apKoko; j++) {
                if (i == j) {
                    continue;
                }
                if (!verkko[i][j]) {
                    int[]pisteB = aloituspisteet.palautaOsio(j);
                    int etaisyys = ((pisteA[0] - pisteB[0]) > 0 ? (pisteA[0] - pisteB[0]) : -(pisteA[0] - pisteB[0])) + 
                            ((pisteA[1] - pisteB[1]) > 0 ? (pisteA[1] - pisteB[1]) : -(pisteA[1] - pisteB[1]));

                    pisteidenValit.add(new int[]{pisteA[0], pisteA[1], pisteB[0], pisteB[1], etaisyys, i, j});
                    verkko[i][j] = true;
                    verkko[j][i] = true;
                }
            }
        }
        pisteidenValit.jarjesta(0, pisteidenValit.haeIndex(), 4);
        muodostaKaytavat();
    }
    
    public void muodostaKaytavat() {
        UnionFind uf = new UnionFind(aloituspisteet.index + 1);
        for (int i = 0; i < pisteidenValit.haeIndex() + 1; i++) {
            if (uf.kompMaara() <= 1) {
                break;
            }
            int[]kaari = pisteidenValit.palautaOsio(i);
            int[] aloitusPiste = new int[]{kaari[0], kaari[1], kaari[5]};
            int[] loppuPiste = new int[]{kaari[2], kaari[3], kaari[6]};
            if (uf.edustaja(aloitusPiste[2]) == uf.edustaja(loppuPiste[2])) {
                continue;
            }
            uf.yhdista(aloitusPiste[2], loppuPiste[2]);
            muutaKaytavaksi(aloitusPiste, loppuPiste);
        }
    }
    
    public void muutaKaytavaksi(int[] pisteA, int[]pisteB) {
        int yAloitus = pisteA[0];
        int yLoppu = pisteB[0];
        int xAloitus = pisteA[1];
        int xLoppu = pisteB[1];
        
        if (yAloitus <= yLoppu) {
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
        
        if (xAloitus <= xLoppu) {
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
    
    public boolean rndMuutos() {
        boolean toteutuuko = false;
        LehmerRng rnd = new LehmerRng(System.nanoTime() % 1337);
        if ((rnd.lehmer() % 512) > 180) {
            toteutuuko = true;
        }
        return toteutuuko;
    }
    
    public int haeHuoneet() {
        return huoneet;
    }
}
