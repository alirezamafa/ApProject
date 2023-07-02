package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class FoodMenu extends Application {
    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;
    public Label label5;
    public Label label6;
    public Label label7;
    public Label label8;

    //User user;
    @Override
    public void start(Stage stage) throws Exception {
        URL url=FoodMenu.class.getResource("/FXML/foodmenu.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        //label haro bara tedad material haye user set mikonim;
    }
    public void toCheese(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("cheese");
    }

    public void toMeat(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("meat");
    }

    public void toApple(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("apple");
    }

    public void toAle(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("ale");
    }

    public void toHops(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("hops");
    }

    public void toWheat(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("wheat");
    }

    public void toBread(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("bread");
    }

    public void toFlour(MouseEvent mouseEvent) throws Exception {
        toSellOrBuyMenu("flour");
    }
    public void toSellOrBuyMenu(String value) throws Exception {
        switch (value){
            case "meat":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/meat.png").toExternalForm()));
                break;
                case "cheese":
                    SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/cheese.png").toExternalForm()));
                    break;
            case "bread":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/bread.png").toExternalForm()));
                break;
            case "flour":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/floor.png").toExternalForm()));
                break;
            case "wheat":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/wheat.png").toExternalForm()));
                break;
            case "ale":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/ale.png").toExternalForm()));
                break;
            case "hops":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/barley.png").toExternalForm()));
                break;
            case "apple":
                SellOrBuyPage.setItem(new Image(FoodMenu.class.getResource("/Media/absloutefood/apple.png").toExternalForm()));
                break;
            default:break;
        }
        SellOrBuyPage.setMenuType("food");
        new SellOrBuyPage().start(MainMarket.getStage());
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        //user=null
        new MainMarket().start(MainMarket.getStage());
    }
}
