package msluola.marchingsquaresluola;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.SubScene;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.util.Mst;
import msluola.marchingsquaresluola.gui.LuolaGui;
import msluola.marchingsquaresluola.luola.Luola;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Marching squares");
        LuolaGui luolagui = new LuolaGui(stage);
        stage.setScene(luolagui.haeAsetusScene());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
