package msluola.marchingsquaresluola.gui;

import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
    Scene asetusScene;
    Luola luola;
    int utilityPaikka;
    int luolienMaara;
    Luola nykyinenLuola;
    Luolasto luolasto;
    AnchorPane rootLuola;
    boolean saakoLisataPisteet;
    boolean saakoTulostaa;
    int n;
    int tyyppi;
    
    public LuolaGui(Stage stage) {
        this.stage = stage;
        tyyppi = 2;
        alustaAlkutoimet();
    }
    
    public Scene alustaAlkutoimet() {
        AnchorPane rootAsetukset = new AnchorPane();
        TextField luolienMaaraMaaritysTf = new TextField("100");
        TextField luolanLeveysTf = new TextField("1000");
        TextField luolanKorkeusTf = new TextField("1000");
        Slider luolanTiheysSl = new Slider(10, 20, 20);
        Text luolanLeveysTeksti = new Text("Luolan leveys");
        Text luolanKorkeusTeksti = new Text("Luolan korkeus");
        Text luolanTiheysTeksti = new Text("Luolan tiheys");
        Button luolienMaaraMaaritysNappi = new Button("Montako luolaa?");
        
        luolienMaaraMaaritysTf.setLayoutX(25);
        luolienMaaraMaaritysTf.setLayoutY(25);
        
        luolienMaaraMaaritysNappi.setLayoutX(250);
        luolienMaaraMaaritysNappi.setLayoutY(25);
        
        luolanLeveysTf.setLayoutX(25);
        luolanLeveysTf.setLayoutY(75);
        luolanLeveysTeksti.setLayoutX(250);
        luolanLeveysTeksti.setLayoutY(95);
        
        luolanKorkeusTf.setLayoutX(25);
        luolanKorkeusTf.setLayoutY(125);
        luolanKorkeusTeksti.setLayoutX(250);
        luolanKorkeusTeksti.setLayoutY(145);
        
        luolanTiheysSl.setLayoutX(25);
        luolanTiheysSl.setLayoutY(175);
        luolanTiheysSl.setMajorTickUnit(10);
        luolanTiheysSl.setMinorTickCount(0);
        luolanTiheysSl.setSnapToTicks(true);
        luolanTiheysTeksti.setLayoutX(250);
        luolanTiheysTeksti.setLayoutY(195);
        
        luolienMaaraMaaritysNappi.setOnAction(e -> {
            String luolienLukumaara = luolienMaaraMaaritysTf.getText();
            String luolanLeveys =luolanLeveysTf.getText();
            String luolanKorkeus =luolanKorkeusTf.getText();
            char[]charsLuolienLukumaara = luolienLukumaara.toCharArray();
            char[]charsLuolanLeveys = luolanLeveys.toCharArray();
            char[]charsLuolanKorkeus = luolanKorkeus.toCharArray();
            
            boolean virhe = false;
            if (charsLuolienLukumaara.length > 8) {
                virhe = true;
                System.out.println("Liian suuri numero");
            }
            for (int i = 0; i < charsLuolienLukumaara.length; i++) {
                if (!Character.isDigit(charsLuolienLukumaara[i])) {
                    virhe = true;
                    System.out.println("Ainoastaan numerot sallittu");
                    break;
                }
            }
            
            for (int i = 0; i < charsLuolanLeveys.length; i++) {
                if (!Character.isDigit(charsLuolanLeveys[i])) {
                    virhe = true;
                    System.out.println("Ainoastaan numerot sallittu");
                    break;
                }
            }
            if (charsLuolanLeveys.length > 4) {
                virhe = true;
                System.out.println("Liian suuri numero");
            }
            
            for (int i = 0; i < charsLuolanKorkeus.length; i++) {
                if (!Character.isDigit(charsLuolanKorkeus[i])) {
                    virhe = true;
                    System.out.println("Ainoastaan numerot sallittu");
                    break;
                }
            }
            if (charsLuolanKorkeus.length > 4) {
                virhe = true;
                System.out.println("Liian suuri numero");
            }
            
            if (Integer.parseInt(luolanLeveys) > 1920 || Integer.parseInt(luolanLeveys) < 500) {
                virhe = true;
                System.out.println("Luolan leveyden minimiarvo on 500 ja maksimiarvo on 1920.");
            }
            if (Integer.parseInt(luolanKorkeus) > 1000 || Integer.parseInt(luolanKorkeus) < 500) {
                virhe = true;
                System.out.println("Luolan korkeuden minimiarvo on 500 ja maksimiarvo on 1000.");
            }
            
            if (!virhe) {
                luolienMaara = Integer.parseInt(luolienLukumaara);
                int leveys = Integer.parseInt(luolanLeveys);
                int korkeus = Integer.parseInt(luolanKorkeus);
                int vali = (int) luolanTiheysSl.getValue();
                if (luolienMaara > 100000) {
                    luolienMaara = 100000;
                }
                if (luolienMaara < 2) {
                    luolienMaara = 2;
                }
                luoLuolastoUi(luolienMaara, leveys, korkeus, vali);
                stage.setScene(luolaScene);
                stage.centerOnScreen();
            }
        });
        
        rootAsetukset.getChildren().addAll(luolienMaaraMaaritysTf, luolienMaaraMaaritysNappi, luolanLeveysTf, 
                                                              luolanKorkeusTf, luolanTiheysSl, luolanLeveysTeksti, luolanKorkeusTeksti, 
                                                              luolanTiheysTeksti);
        asetusScene = new Scene(rootAsetukset, 400, 250);
        return asetusScene;
    }
    
    public void luoLuolastoUi(int n, int korkeus, int leveys, int vali) {
        this.n = n;
        rootLuola = new AnchorPane();
        luolaScene = new Scene(rootLuola, leveys + 180, korkeus);
                
        luolasto = new Luolasto(n);
        luolasto.luoLuolasto(korkeus, leveys, vali);
        nykyinenLuola = luolasto.uusiLuola(tyyppi);
        rootLuola.getChildren().addAll(nykyinenLuola.luoLuola(), utilityScene(leveys, korkeus));
    }
    
    public SubScene utilityScene(int leveys, int korkeus) {
        Pane utility = new Pane();
        utility.setLayoutX(35);
        utility.setLayoutY(25);
        
        Button seuraavaLuolaNappi = new Button("Seuraava luola");
        Button luolaPisteet = new Button("Näytä pisteet");
        Button tulostaLuola = new Button("Tulosta luola");
        Button palaaAsetuksiin = new Button("Asetukset");
        Slider tyyppiSlider = haeSlider(tyyppi);
        luolaPisteet.setLayoutY(seuraavaLuolaNappi.getLayoutY() + 50);
        tulostaLuola.setLayoutY(luolaPisteet.getLayoutY() + 50);
        palaaAsetuksiin.setLayoutY(korkeus - 75);
        palaaAsetuksiin.setLayoutX(10);
        tyyppiSlider.setLayoutY(tulostaLuola.getLayoutY() + 50);
        tyyppiSlider.setLayoutX(tyyppiSlider.getLayoutX() - 10);
        
        utility.getChildren().addAll(seuraavaLuolaNappi, luolaPisteet, tyyppiSlider, tulostaLuola, palaaAsetuksiin);
        
        SubScene s = new SubScene(utility, 200, korkeus);
        s.setLayoutX(leveys);
        
        seuraavaLuolaNappi.setOnAction(e -> {
            if (luolasto.haeIndex() < n) {
                tyyppi = (int) tyyppiSlider.getValue();
                Luola uusiLuola = luolasto.uusiLuola(tyyppi);
                nykyinenLuola = uusiLuola;
                rootLuola.getChildren().clear();
                rootLuola.getChildren().addAll(nykyinenLuola.luoLuola(), utilityScene(leveys, korkeus));
            }
        });
        saakoLisataPisteet = true;
        luolaPisteet.setOnAction(e -> {
            if (saakoLisataPisteet) {
                nykyinenLuola.lisaaPisteet(rootLuola);
                saakoLisataPisteet = false;
            }
        });
        saakoTulostaa = true;
        tulostaLuola.setOnAction(e -> {
            if (saakoTulostaa) {
                nykyinenLuola.tulostaLuola();
                saakoTulostaa = false;
            }
        });
        palaaAsetuksiin.setOnAction(e -> {
            Scene uudetAsetukset = alustaAlkutoimet();
            stage.setScene(uudetAsetukset);
        });
        return s;
    }
    
    public Slider haeSlider(int missa) {
        Slider slider = new Slider(1, 3, missa);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        return slider;
    }
    
    public Scene haeAsetusScene() {
        return asetusScene;
    }
}
