package msluola.marchingsquaresluola;

import javafx.application.Application;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.gui.LuolaGui;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Marching squares");
        LuolaGui gui = new LuolaGui(stage);
        stage.setScene(gui.haeAsetusScene());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
