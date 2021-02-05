package msluola.marchingsquaresluola.gui;

import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.luola.Luola;

public class LuolaGui {
    Scene luolaScene;
    
    public LuolaGui(Stage stage) {
        Luola luola = new Luola(1000, 1000, 20);
        HBox root = new HBox();
        Pane p = new Pane();
        p.setLayoutX(35);
        p.setLayoutY(25);
        SubScene s = new SubScene(p, 150, 1000);
        this.luolaScene = new Scene(root, 1150, 1000);
        
        Button uusiLuolaNappi = new Button("Uusi luola");
        uusiLuolaNappi.setOnAction(e -> {
            Luola l = new Luola(1000, 1000, 20);
            root.getChildren().remove(0);
            root.getChildren().add(0, l.luoLuola());
            stage.show();
        });
        p.getChildren().add(uusiLuolaNappi);
        
        root.getChildren().addAll(luola.luoLuola(), s);
    }
    
    public Scene haeScene() {
        return luolaScene;
    }
}
