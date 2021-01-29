
package tiralabra.LuolaGeneraattori;

import java.util.Random;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Luola {
    Pane ikkuna;
    int leveys;
    int korkeus;
    int vali;
    int[][]pisteet;
    
    public Luola(int leveys, int korkeus, int vali) {
        ikkuna = new Pane();
        ikkuna.setBackground(Background.EMPTY);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vali = vali;
        this.pisteet = new int[(korkeus/vali)+1][(leveys/vali)+1];
        
    }
    
    public Pane haePane() {
        return ikkuna;
    }
    
    public int haeLeveys() {
        return leveys;
    }
    
    public int haeKorkeus() {
        return korkeus;
    }
    
    public int haeVali() {
        return vali;
    }
    
    public void luoTaulukko() {
        Random r = new Random();
        for(int i = 0; i < pisteet.length; i++) {
            for(int j = 0; j < pisteet.length; j++) {
                int randomnumero = r.nextInt(2);
                pisteet[i][j] = randomnumero;
            }
        }
    }
    
    public void lisaaPisteet() {
        for(int i = 0; i < pisteet.length; i++) {
            for(int j = 0; j < pisteet.length; j++) {
                Circle c = new Circle (j * vali, i * vali, 3);
                if(pisteet[i][j] == 0) {
                    c.setFill(Color.WHITE);
                }
                else {
                    c.setFill(Color.BLACK);
                }
                ikkuna.getChildren().add(c);
            }
        }
    }
    
    public void lisaaViivat() {
        for(int i = 0; i < pisteet.length-1; i++) {
            for(int j = 0; j < pisteet.length-1; j++) {
                String binaariNumero = "";
                binaariNumero += pisteet[i][j];
                binaariNumero += pisteet[i][j + 1];
                binaariNumero += pisteet[i + 1][j + 1];
                binaariNumero += pisteet[i + 1][j];
                
                int x = j * vali;
                int y = i * vali;
                
                lisaaVektori(binaariMuuntaminen(binaariNumero), x, y, ikkuna);
            }
        }
    }
    
    public int binaariMuuntaminen(String luku) {
        return (luku.charAt(0) - '0') * 8 + (luku.charAt(1) - '0') * 4 
               + (luku.charAt(2) - '0') * 2 + (luku.charAt(3) - '0');
    }
    
    public void lisaaVektori(int luku, int x, int y, Pane p) {
        if(luku < 1) {
            return;
        }
        else if(luku == 1) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
        }
        else if(luku == 2) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 3) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 4) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 5) {
            Line viiva1 = new Line(x + (vali / 2), y, x, y + (vali / 2));
            Line viiva2 = new Line(x + vali, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
        }
        else if(luku == 6) {
            Line viiva = new Line(x +(vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
        }
        else if(luku == 7) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 8) {
            Line viiva = new Line(x + (vali / 2), y, x, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 9) {
            Line viiva = new Line(x +(vali / 2), y, x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
        }
        else if(luku == 10) {
            Line viiva1 = new Line(x + (vali / 2), y, x + vali, y + (vali / 2));
            Line viiva2 = new Line(x + (vali / 2), y + vali, x, y + (vali / 2));
            p.getChildren().add(viiva1);
            p.getChildren().add(viiva2);
        }
        else if(luku == 11) {
            Line viiva = new Line(x + vali / 2, y, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 12) {
            Line viiva = new Line(x, y + (vali / 2), x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 13) {
            Line viiva = new Line(x + (vali / 2), y + vali, x + vali, y + (vali / 2));
            p.getChildren().add(viiva);
        }
        else if(luku == 14) {
            Line viiva = new Line(x, y + (vali / 2), x + (vali / 2), y + vali);
            p.getChildren().add(viiva);
        }
        else if(luku >= 15) {
            return;
        }
    }
}
