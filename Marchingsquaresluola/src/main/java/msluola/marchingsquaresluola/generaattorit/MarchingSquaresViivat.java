package msluola.marchingsquaresluola.generaattorit;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class MarchingSquaresViivat {
        
    public void lisaaViivat(int[][]pisteet, Pane ikkuna, int vali) {
        for (int i = 0; i < pisteet.length - 1; i++) {
            for (int j = 0; j < pisteet[0].length - 1; j++) {
                String binaariNumero = "";
                binaariNumero += pisteet[i][j];
                binaariNumero += pisteet[i][j + 1];
                binaariNumero += pisteet[i + 1][j + 1];
                binaariNumero += pisteet[i + 1][j];
                
                int x = j * vali;
                int y = i * vali;
                
                luoViiva(binaariMuuntaminen(binaariNumero), x, y, ikkuna, vali);
            }
        }
    }
    /**
     * 
     * Metodi muuntaa binäärinumeron tavalliseksi numeroksi 0 - 15 väliltä. 
     * 
     * @param luku Binaarinumero, joka on generoitu pisteet -taulukon sisällöstä riippuen missä kohtaa
     * ollaan. Esimerkiksi "1111" tai "1011"
     * @return Tavallinen numero, joka vastaa binäärinumeroa. Esimerkiksi "1111" muuttuu 15.
     */
    public int binaariMuuntaminen(String luku) {
        return (luku.charAt(0) - '0') * 8 + (luku.charAt(1) - '0') * 4 
               + (luku.charAt(2) - '0') * 2 + (luku.charAt(3) - '0');
    }
    
    /**
     * 
     * Metodi luo viivan annetun tiedon perusteella ja lisää sen paneen. 
     * 
     * @param luku Muutettu binäärinumero, jotta saadaan tieto mihin vaihtoehtoon päädytään vektorin
     * generoimisessa.
     * @param x Piste x ikkunassa.
     * @param y Piste y ikkunassa.
     * @param p Pane johon viivat sijoitetaan.
     */
    public void luoViiva(int luku, int x, int y, Pane p, int vali) {
        if (luku < 1) {
            return;
        } else if (luku == 1) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 2) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 3) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 4) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 5) {
            Line viiva1 = new Line(x + (vali / 2), y, x, y + (vali / 2));
            Line viiva2 = new Line(x + vali, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
            
        } else if (luku == 6) {
            Line viiva = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 7) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 8) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 9) {
            Line viiva = new Line(x + (vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku == 10) {
            Line viiva1 = new Line(x + (vali / 2), y, x + vali, y + (vali / 2));
            Line viiva2 = new Line(x + (vali / 2), y + vali, x, y + (vali / 2));
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
            
        } else if (luku == 11) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 12) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 13) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
            
        } else if (luku == 14) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
            
        } else if (luku > 14) {
            return;
        }
    }
}
