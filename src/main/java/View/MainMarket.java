package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.Socket;
import java.net.URL;

public class MainMarket extends Application {
    //User user;
    private static Stage stage;
    public void showPrices(MouseEvent mouseEvent) throws Exception {
     new PriceList().start(stage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        URL url=MainMarket.class.getResource("/FXML/mainMarket.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void food(MouseEvent mouseEvent) throws Exception {
        FoodMenu foodMenu = new FoodMenu();
        //foodmenu.setuser();
        foodMenu.start(MainMarket.stage);
    }

    public void materials(MouseEvent mouseEvent) throws Exception {
        MaterialsMenu materialsMenu=new MaterialsMenu();
        //materialsmenu.setuser;
        materialsMenu.start(MainMarket.stage);
    }

    public void weapon(MouseEvent mouseEvent) throws Exception {
        WeaponMenu weaponMenu=new WeaponMenu();
        //weaponmenu.setuser;
        weaponMenu.start(MainMarket.stage);
    }

    public void details(MouseEvent mouseEvent) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Market place");
        alert.setHeaderText("this is your market in your kingdom");
        alert.setContentText("buy and sell or trade a good in market!!!");
        alert.show();

    }

    public static Stage getStage() {
        return stage;
    }
    //getUser;
    //setUser;
}
