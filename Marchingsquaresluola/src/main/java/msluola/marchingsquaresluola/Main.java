package msluola.marchingsquaresluola;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.Luola.Luola;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Marching squares");
        
        /////////////////////////////////////////////
        // Siirrä gui
        /////////////////////////////////////////////
        
        Luola luola = new Luola(1000, 1000, 20);
        HBox root = new HBox();
        Pane p = new Pane();
        p.setLayoutX(35);
        p.setLayoutY(25);
        SubScene s = new SubScene(p,150,1000);
        Scene mainScene = new Scene(root,1150,1000);
        
        Button nappi = new Button("Uusi luola");
        nappi.setOnAction(e -> {
            Luola l = new Luola(1000, 1000, 20);
            root.getChildren().remove(0);
            root.getChildren().add(0, l.luoLuola());
            stage.show();
        });
        p.getChildren().add(nappi);
        
        root.getChildren().addAll(luola.luoLuola(), s);
        /////////////////////////////////////////////
        
        stage.setScene(mainScene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
