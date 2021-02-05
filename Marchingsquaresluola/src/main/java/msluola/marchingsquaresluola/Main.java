package msluola.marchingsquaresluola;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.gui.LuolaGui;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Marching squares");
        LuolaGui luola = new LuolaGui(stage);
        stage.setScene(luola.haeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
