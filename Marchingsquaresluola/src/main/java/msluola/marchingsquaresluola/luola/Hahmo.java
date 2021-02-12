package msluola.marchingsquaresluola.luola;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hahmo {
    ImageView hahmo;
    Luola luola;
    Boolean liike;
    int x;
    int y;
    
    public Hahmo(int x, int y) throws FileNotFoundException {
        hahmo = new ImageView(new Image(new FileInputStream("src\\media\\hahmo.png")));
        hahmo.setX(x);
        hahmo.setY(y);
        this.x = x;
        this.y = y;
        liike = false;
    }
    
    public ImageView haeHahmo() {
        return hahmo;
    }
    
    public void liikuOikealle() {
        
    }
    
    public void liikuVasemmalle() {
        
    }
    
    public void liikuYlos() {

    }
    
    public void liikuAlas() {
        
    }
    
}
