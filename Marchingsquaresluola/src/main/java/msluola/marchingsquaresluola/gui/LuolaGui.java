package msluola.marchingsquaresluola.gui;

import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import msluola.marchingsquaresluola.luola.Luola;
import msluola.marchingsquaresluola.luola.Luolasto;

public class LuolaGui {
    Stage stage;
    Scene luolaScene;
    Scene luolastoScene;
    Scene asetusScene;
    Text vanhaAika;
    Text uusiAika;
    Luola luola;
    int utilityPaikka;
    int luolienMaara;
    Luola nykyinenLuola;
    
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
                stage.setScene(luolastoScene);
            }
        });
        
        rootAsetukset.getChildren().addAll(luolienMaaraMaaritys, luolienMaaraMaaritysNappi);
        asetusScene = new Scene(rootAsetukset, 400, 100);
    }
    
    public void luoLuolasto(int n) {
        AnchorPane rootLuolasto = new AnchorPane();
        AnchorPane rootLuola = new AnchorPane();
        Pane utility = new Pane();
        utility.setLayoutX(35);
        utility.setLayoutY(25);
        Button uusiLuolaNappi = new Button("Seuraava luola");
        utility.getChildren().add(uusiLuolaNappi);
        SubScene s = new SubScene(utility, 200, 1000);
        s.setLayoutX(1920);
        
        Luolasto luolasto = new Luolasto(n);
        luolasto.louLuolasto(1000, 1920, 20, rootLuolasto);
        Button siirryLuoliin = new Button("Siirry ensimmäiseen luolaan");
        siirryLuoliin.setLayoutX(25);
        siirryLuoliin.setLayoutY(25);
        nykyinenLuola = luolasto.haeLuolasto().get(0);
        
        uusiLuolaNappi.setOnAction(ex -> {
            int index = luolasto.haeLuolasto().indexOf(nykyinenLuola);
            if (index < luolasto.haeLuolasto().size() - 1) {
                Luola seuraavaLuola = luolasto.haeLuolasto().get(index + 1);
                rootLuola.getChildren().remove(0);
                rootLuola.getChildren().add(0, seuraavaLuola.luoLuola());
                nykyinenLuola = seuraavaLuola;
                stage.show();
            }
        });
        
        siirryLuoliin.setOnAction(e -> {
            luolaScene = new Scene(rootLuola, 2100, 1000);
            rootLuola.getChildren().addAll(nykyinenLuola.luoLuola(), s);
            stage.setScene(luolaScene);
            stage.show();
        });
        
        rootLuolasto.getChildren().add(siirryLuoliin);
        luolastoScene = new Scene(rootLuolasto, 1920, 1000);
    }
    
    public Scene haeAsetusScene() {
        return asetusScene;
    }
}
