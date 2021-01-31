package msluola.marchingsquaresluola;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.Luola.Luola;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Marching squares");
        
        Luola luola = new Luola(1000, 1000, 20);
        luola.luoTaulukko();
        luola.lisaaPisteet();
        luola.lisaaViivat();
        
        Scene scene = new Scene(luola.haePane(), luola.haeLeveys(), luola.haeKorkeus());
        scene.setFill(Color.TEAL);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
