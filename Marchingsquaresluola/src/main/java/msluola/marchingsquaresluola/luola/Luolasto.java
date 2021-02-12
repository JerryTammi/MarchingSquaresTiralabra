package msluola.marchingsquaresluola.luola;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import msluola.marchingsquaresluola.generaattorit.LehmerRng;

public class Luolasto {
    ArrayList<Luola>luolat;
    int n;
    AnchorPane pane;
    boolean ensimmainen;
    
    public Luolasto(int n) {
        this.n = n;
        this.luolat = new ArrayList<>();
    }
    
    
    public void louLuolasto(int korkeus, int leveys, int vali, AnchorPane p) {
        //TODO
        // Random numerot vittuun
        this.pane = p;
        LehmerRng rand = new LehmerRng(System.nanoTime() % System.currentTimeMillis());
        long edellinen = 0;
        for (int i = 0; i < n; i++) {
            Long seed = rand.lehmer() % 100000;
            Luola l = new Luola(korkeus, leveys, vali, seed);
            if (i > 0) {
                l.asetaEdellinenSeed(edellinen);
            }
            luolat.add(l);
            int x = 100 + (int)(rand.lehmer() % (leveys - 200));
            int y = 100 + (int)(rand.lehmer() % (korkeus - 200));
            lisaaPisteLuola(y, x, i, p, l);
            edellinen = seed;
        }
        lisaaJokaiselleLuolalleSeuraavaLuola();
        
    }
    
    public void lisaaPisteLuola(int y, int x, int i, AnchorPane p, Luola l) {
        Circle c = new Circle(x, y, 8);
        if (i == 0) {
            c.setFill(Color.RED);
        }
        else if (i == (n - 1)) {
            c.setFill(Color.GREEN);
        }
        else {
            c.setFill(Color.BLACK);
        }
        p.getChildren().add(c);
    }
    
    public void lisaaJokaiselleLuolalleSeuraavaLuola() {
        ArrayList<Luola> uusiLuolasto = new ArrayList<>();
        for (int i = 0; i < luolat.size() - 1; i++) {
            Luola l1 = luolat.get(i);
            Luola l2 = luolat.get(i+1);
            l1.asetaSeuraavaSeed(l2.haeOmaSeed());
            uusiLuolasto.add(l1);
        }
        uusiLuolasto.add(luolat.get(luolat.size()-1));
        luolat = uusiLuolasto;
    }
    
    public ArrayList<Luola> haeLuolasto() {
        return luolat;
    }
    
}
