package msluola.marchingsquaresluola;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.SubScene;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.generaattorit.Mst;
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
//        Luola l = new Luola(1000,1000,20, (long)100);
//        SubScene  s = l.luoLuola();
//        Mst mst = new Mst();
//        int[][]taulu = l.haeTaulukko();
//        for (int i = 0; i < taulu.length; i++) {
//            for (int j = 0; j < taulu[0].length; j++) {
//                System.out.print(taulu[i][j] + " ");
//            } 
//            System.out.println("");
//        }
//        mst.linkita(taulu);
        launch(args);
    }
}
