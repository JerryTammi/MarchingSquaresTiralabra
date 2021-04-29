package msluola.marchingsquaresluola.util;

/**
 *  Huolehtii luolan huoneiden linkityksestä Kruskalin algoritmin avulla. 
 */
public class Mst {
    int[][]pisteet;
    boolean[][]kayty;
    int huoneet;
    Lista aloituspisteet;
    Lista pisteidenValit;
    boolean[][]verkko;
    
    /**
     * @param pisteet Luolan taulukko.
     */
    public Mst(int[][]pisteet) {
        this.pisteet = pisteet;
        huoneet = 0;
        kayty = new boolean[pisteet.length][pisteet[0].length]; 
        aloituspisteet = new Lista(2);
        pisteidenValit = new Lista(7);
    }
    
    /**
     * Linkittää luolan huoneet.
     * @return Luolan taulukko.
     */
    public int[][] linkita() {
        laskeHuoneet();
        yhdistaHuoneet();
        return pisteet;
    }
    
    /**
     * Laskee huoneiden määrän ja lisää aloituspisteet listaan. Aina kun löytyy uusi huone aloitetaan syvyyshaku, jolla varmistetaan ettei löydetä huonetta jossa ollaan jo käyty.
     */
    public void laskeHuoneet() {
        huoneet = 0;
        kayty = new boolean[pisteet.length][pisteet[0].length]; 
        for (int i = 0; i < pisteet.length; i++) {
            for (int j = 0; j < pisteet[0].length; j++) {
                if (pisteet[i][j] == 0 && !kayty[i][j]) {
                    huoneet++;
                    kompSyvyys(i, j);
                    aloituspisteet.add(new int[]{i, j});
                }
            }
        }
    }
    
    /**
     * Syvyyshaku, jolla käydään läpi luolan huoneita.
     * @param y Tarkisteltavan pisteen y.
     * @param x Tarkisteltavan pisteen x.
     */
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
    
    /**
     * Yhdistää luolan huoneet. Aloittaa tarkistelemalla aloituspisteet, jotka se yhdistää toisiinsa.
     * Tämän jälkeen järjestää listan jotta lyhimmät polut ovat ekana ja aloittaa Kruskalilla yhdistämään huoneita
     * kunnes jokainen huone on yhdistetty.
     */
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
    
    /**
     * Muodostaa aloitus- ja loppupisteen joiden väli yhdistetään.
     */
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
    /**
     * Muuttaa halutun välin käytäväksi kahden huoneen välillä.
     * @param pisteA Käytävän aloituspiste.
     * @param pisteB Käytävän loppupiste.
     */
    public void muutaKaytavaksi(int[] pisteA, int[]pisteB) {
        int yAloitus = pisteA[0];
        int yLoppu = pisteB[0];
        int xAloitus = pisteA[1];
        int xLoppu = pisteB[1];
        
        if (yAloitus <= yLoppu) {
            for (int i = yAloitus; i <= yLoppu; i++) {
                pisteet[i][xAloitus] = 0;
//                if (rndMuutos() && xAloitus > 1) {
//                    pisteet[i][xAloitus - 1] = 0;
//                }
//                if (rndMuutos() && xAloitus < pisteet[0].length - 2) {
//                    pisteet[i][xAloitus + 1] = 0;
//                }
            }
        } else {
            for (int i = yLoppu; i <= yAloitus; i++) {
                pisteet[i][xAloitus] = 0;
//                if (rndMuutos() && xAloitus > 1) {
//                    pisteet[i][xAloitus - 1] = 0;
//                }
//                if (rndMuutos() && xAloitus < pisteet[0].length - 2) {
//                    pisteet[i][xAloitus + 1] = 0;
//                }
            }
        }
        
        if (xAloitus <= xLoppu) {
            for (int i = xAloitus; i <= xLoppu; i++) {
                pisteet[yLoppu][i] = 0;
//                if (rndMuutos() && yAloitus > 1) {
//                    pisteet[yLoppu - 1][i] = 0;
//                }
//                if (rndMuutos() && yAloitus < pisteet.length - 2) {
//                    pisteet[yLoppu + 1][i] = 0;
//                }
            }
        } else {
            for (int i = xLoppu; i <= xAloitus; i++) {
                pisteet[yLoppu][i] = 0;
//                if (rndMuutos() && yAloitus > 1) {
//                    pisteet[yLoppu - 1][i] = 0;
//                }
//                if (rndMuutos() && yAloitus < pisteet.length - 2) {
//                    pisteet[yLoppu + 1][i] = 0;
//                }
            }
        }
    }
    
    /**
     * Arpoo muokataanko huoneiden välistä käytävää.
     * @return True jos muokataan, false jos ei.
     */    
    public boolean rndMuutos() {
        boolean toteutuuko = false;
        LehmerRng rnd = new LehmerRng(System.nanoTime() % 1337);
        if ((rnd.lehmer() % 512) > 180) {
            toteutuuko = true;
        }
        return toteutuuko;
    }
    
    /**
     * @return Palauttaa huoneiden määrän.
     */
    public int haeHuoneet() {
        return huoneet;
    }
}
