package msluola.marchingsquaresluola;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.Luola.Luola;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Marching squares");
        Luola luola = new Luola(1000, 1000, 20);
        stage.setScene(luola.luoLuola());
        
        Button nappi = new Button("Uusi luola");
        nappi.setOnAction(e -> {
            Luola l = new Luola(1000, 1000, 20);
            stage.setScene(l.luoLuola());
            stage.show();
            l.haePane().getChildren().add(nappi);
        });
        luola.haePane().getChildren().add(nappi);
        
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
