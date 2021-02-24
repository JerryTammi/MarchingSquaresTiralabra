package msluola.marchingsquaresluola;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.gui.LuolaGui;
import msluola.marchingsquaresluola.util.Lista;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Marching squares");
        LuolaGui luolagui = new LuolaGui(stage);
        stage.setScene(luolagui.haeAsetusScene());
        stage.show();
    }
    
    public static void main(String[] args) {
//        Lista l = new Lista(3);
//        int[]a1 = new int[]{0,0,3};
//        int[]a2 = new int[]{1,0,2};
//        int[]a3 = new int[]{0,1,7};
//        int[]a4 = new int[]{2,0,88};
//        int[]a5 = new int[]{0,2,77};
//        int[]a6 = new int[]{3,4,66};
//        int[]a7 = new int[]{8,1,55};
//        int[]a8 = new int[]{3,1,4};
//        int[]a9 = new int[]{3,5,99999};
//        
//        l.add(a1);
//        l.add(a2);
//        l.add(a3);
//        l.add(a4);
//        l.add(a5);
//        l.add(a6);
//        l.add(a7);
//        l.add(a8);
//        l.add(a9);
//        
//        l.tulosta();
//        System.out.println("");
//        l.jarjesta(0, l.haeIndex(), 2);
//        l.tulosta();
        launch(args);
    }
}
