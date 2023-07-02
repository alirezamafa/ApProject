package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class MaterialsMenu extends Application {
    //user user;
    @Override
    public void start(Stage stage) throws Exception {
        URL url=FoodMenu.class.getResource("/FXML/Materialsmenu.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        //user =null;
        new MainMarket().start(MainMarket.getStage());
    }

    public void toWood(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("wood");
    }

    public void toIron(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("iron");
    }

    public void toPitch(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("pitch");
    }

    public void toStone(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("stone");
    }
    //setuser and getuser;
    public void toSellOrBuyMenu(String value) throws Exception {
        switch (value){
            case "stone":
                SellOrBuyPage.setItem(new Image(MaterialsMenu.class.getResource("/Media/materials/stone.png").toExternalForm()));
                break;
            case "wood":
                SellOrBuyPage.setItem(new Image(MaterialsMenu.class.getResource("/Media/materials/wood.png").toExternalForm()));
                break;
            case "iron":
                SellOrBuyPage.setItem(new Image(MaterialsMenu.class.getResource("/Media/materials/iron.png").toExternalForm()));
                break;
            case "pitch":
                SellOrBuyPage.setItem(new Image(MaterialsMenu.class.getResource("/Media/materials/oil.png").toExternalForm()));
                break;
            default:break;
        }
        SellOrBuyPage.setMenuType("material");
        //SellOrBuyPage.setuser(getuser);
        new SellOrBuyPage().start(MainMarket.getStage());
    }
}
