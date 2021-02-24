package msluola.marchingsquaresluola.gui;

import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.luola.Luola;
import msluola.marchingsquaresluola.luola.Luolasto;

public class LuolaGui {
    Stage stage;
    Scene luolaScene;
    Scene asetusScene;
    Luola luola;
    int utilityPaikka;
    int luolienMaara;
    Luola nykyinenLuola;
    Luolasto luolasto;
    AnchorPane rootLuola;
    boolean saakoLisataPisteet;
    
    public LuolaGui(Stage stage) {
        this.stage = stage;
        alustaAlkutoimet();
    }
    
    public void alustaAlkutoimet() {
        AnchorPane rootAsetukset = new AnchorPane();
        TextField luolienMaaraMaaritys = new TextField("50");
        Button luolienMaaraMaaritysNappi = new Button("Montako luolaa?");
        
        luolienMaaraMaaritys.setLayoutX(25);
        luolienMaaraMaaritys.setLayoutY(25);
        luolienMaaraMaaritysNappi.setLayoutX(250);
        luolienMaaraMaaritysNappi.setLayoutY(25);
        
        luolienMaaraMaaritysNappi.setOnAction(e -> {
            String lukumaara = luolienMaaraMaaritys.getText();
            char[]chars = lukumaara.toCharArray();
            boolean virhe = false;
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isDigit(chars[i])) {
                    virhe = true;
                    System.out.println("Ainoastaan numerot sallittu");
                    break;
                }
            }
            if (!virhe) {
                luolienMaara = Integer.parseInt(lukumaara);
                if (luolienMaara > 10000) {
                    luolienMaara = 10000;
                }
                if (luolienMaara < 2) {
                    luolienMaara = 2;
                }
                luoLuolasto(luolienMaara);
                stage.setScene(luolaScene);
                stage.centerOnScreen();
            }
        });
        
        rootAsetukset.getChildren().addAll(luolienMaaraMaaritys, luolienMaaraMaaritysNappi);
        asetusScene = new Scene(rootAsetukset, 400, 100);
    }
    
    public void luoLuolasto(int n) {
        rootLuola = new AnchorPane();
        luolaScene = new Scene(rootLuola, 2100, 1000);
                
        luolasto = new Luolasto(n);
        luolasto.louLuolasto(1000, 1920, 20);
        nykyinenLuola = luolasto.haeLuolasto().get(0);
        rootLuola.getChildren().addAll(nykyinenLuola.luoLuola(), utilityScene());
    }
    
    public SubScene utilityScene() {
        Pane utility = new Pane();
        utility.setLayoutX(35);
        utility.setLayoutY(25);
        
        Button seuraavaLuolaNappi = new Button("Seuraava luola");
        Button luolaPisteet = new Button("Näytä pisteet");
        luolaPisteet.setLayoutY(seuraavaLuolaNappi.getLayoutY() + 50);
        utility.getChildren().addAll(seuraavaLuolaNappi, luolaPisteet);
        
        SubScene s = new SubScene(utility, 200, 1000);
        s.setLayoutX(1920);
        
        seuraavaLuolaNappi.setOnAction(e -> {
            int index = luolasto.haeLuolasto().indexOf(nykyinenLuola);
            if (index < luolasto.haeLuolasto().size() - 1) {
                Luola seuraavaLuola = luolasto.haeLuolasto().get(index + 1);
                nykyinenLuola = seuraavaLuola;
                rootLuola.getChildren().clear();
                rootLuola.getChildren().addAll(nykyinenLuola.luoLuola(), utilityScene());
            }
        });
        saakoLisataPisteet = true;
        luolaPisteet.setOnAction(e -> {
            if (saakoLisataPisteet) {
                nykyinenLuola.lisaaPisteet(rootLuola);
                saakoLisataPisteet = false;
            }
        });
        return s;
    }
    
    public Scene haeAsetusScene() {
        return asetusScene;
    }
}
