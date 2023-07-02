package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class WeaponMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url=FoodMenu.class.getResource("/FXML/weaponmenu.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        //user =null
        new MainMarket().start(MainMarket.getStage());
    }

    public void toSword(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("sword");
    }

    public void toBow(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("bow");
    }

    public void toCrossBow(MouseEvent mouseEvent)throws Exception {
        toSellOrBuyMenu("crossbow");
    }

    public void toMace(MouseEvent mouseEvent)throws Exception {
        toSellOrBuyMenu("mace");
    }

    public void toPike(MouseEvent mouseEvent)throws Exception {
        toSellOrBuyMenu("pike");
    }

    public void toMetal(MouseEvent mouseEvent)throws Exception {
        toSellOrBuyMenu("metal");
    }

    public void toLeather(MouseEvent mouseEvent) throws Exception{
        toSellOrBuyMenu("leather");
    }

    public void toSpear(MouseEvent mouseEvent) throws Exception{
        toSellOrBuyMenu("spear");
    }
    public void toSellOrBuyMenu(String value) throws Exception {
        switch (value){
            case "sword":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/sword.png").toExternalForm()));
                break;
            case "bow":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/arc.png").toExternalForm()));
                break;
            case "pike":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/pike.png").toExternalForm()));
                break;
            case "mace":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/mace.png").toExternalForm()));
                break;
            case "crossbow":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/crossbow.png").toExternalForm()));
                break;
            case "metal":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/metalarmour.png").toExternalForm()));
                break;
            case "leather":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/leatherArmour.png").toExternalForm()));
                break;
            case "spear":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/weapon/spear.png").toExternalForm()));
                break;
            default:break;
        }
        SellOrBuyPage.setMenuType("weapon");
        //SellOrBuyPage.setuser(getuser);
        new SellOrBuyPage().start(MainMarket.getStage());
    }
}
