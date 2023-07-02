package View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SellOrBuyPage extends Application {
    private static Image item;
    public Label goodNumber;
    public ImageView current;
    public ImageView prev;
    public ImageView next;
    public Label coinsLabel;
    private int index;
    //private user user
    private static String menuType;
    private static HashMap<Integer,Image>images=new HashMap<>();
    static {
        images.put(0, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/floor.png").toExternalForm()));
        images.put(1, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/meat.png").toExternalForm()));
        images.put(2, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/cheese.png").toExternalForm()));
        images.put(3, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/apple.png").toExternalForm()));
        images.put(4, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/ale.png").toExternalForm()));
        images.put(5, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/barley.png").toExternalForm()));
        images.put(6, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/wheat.png").toExternalForm()));
        images.put(7, new Image(SellOrBuyPage.class.getResource("/Media/absloutefood/bread.png").toExternalForm()));
        images.put(8, new Image(SellOrBuyPage.class.getResource("/Media/materials/wood.png").toExternalForm()));
        images.put(9, new Image(SellOrBuyPage.class.getResource("/Media/materials/iron.png").toExternalForm()));
        images.put(10, new Image(SellOrBuyPage.class.getResource("/Media/materials/oil.png").toExternalForm()));
        images.put(11, new Image(SellOrBuyPage.class.getResource("/Media/materials/stone.png").toExternalForm()));
        images.put(12, new Image(SellOrBuyPage.class.getResource("/Media/weapon/sword.png").toExternalForm()));
        images.put(13, new Image(SellOrBuyPage.class.getResource("/Media/weapon/arc.png").toExternalForm()));
        images.put(14, new Image(SellOrBuyPage.class.getResource("/Media/weapon/pike.png").toExternalForm()));
        images.put(15, new Image(SellOrBuyPage.class.getResource("/Media/weapon/mace.png").toExternalForm()));
        images.put(16, new Image(SellOrBuyPage.class.getResource("/Media/weapon/crossbow.png").toExternalForm()));
        images.put(17, new Image(SellOrBuyPage.class.getResource("/Media/weapon/metalarmour.png").toExternalForm()));
        images.put(18, new Image(SellOrBuyPage.class.getResource("/Media/weapon/leatherArmour.png").toExternalForm()));
        images.put(19, new Image(SellOrBuyPage.class.getResource("/Media/weapon/spear.png").toExternalForm()));
    }
    @Override
    public  void start(Stage stage) throws Exception {
        URL url=SellOrBuyPage.class.getResource("/FXML/sellorbuymenu.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        String regex=".+Media/(?<ggg>.+)";
        Pattern pattern=Pattern.compile(regex);
        String value=null;
        Matcher matcher=pattern.matcher(item.getUrl());
        if (matcher.matches()){
            value="/Media/".concat(matcher.group("ggg"));
        }
        for (Map.Entry<Integer, Image> integerImageEntry : images.entrySet()) {
            String regex2=".+Media/(?<sss>.+)";
            pattern=Pattern.compile(regex2);
            String value2=null;
            Matcher matcher2=pattern.matcher(integerImageEntry.getValue().getUrl());
            if (matcher2.matches()){
                value2="/Media/".concat(matcher2.group("sss"));
            }
            System.out.println(value2.equals(value));
            if (value2.equals(value)){
                index=integerImageEntry.getKey();
            }
        }
        current.setImage(images.get(index));
        if (index==0){
            next.setImage(images.get(1));
            prev.setImage(images.get(19));
        }
        else if (index==19){
            next.setImage(images.get(0));
            prev.setImage(images.get(18));
        }
        else {
            next.setImage(images.get(index+1));
            prev.setImage(images.get(index-1));
        }
    }
    public static void setItem(Image item) {
        SellOrBuyPage.item = item;
    }

    public static Image getItem() {
        return item;
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        if (menuType.equals("food")){
            new FoodMenu().start(MainMarket.getStage());
        }
        else if (menuType.equals("material")){
            new MaterialsMenu().start(MainMarket.getStage());
        }
        else {
            new WeaponMenu().start(MainMarket.getStage());
        }
    }

    public static void setMenuType(String menuType) {
        SellOrBuyPage.menuType = menuType;
    }

    public static String getMenuType() {
        return menuType;
    }

    public void prev(MouseEvent mouseEvent) {
        index -= 1;
        if (index == -1) {
            index = 19;
        }
        current.setImage(images.get(index));
        if (index == 0) {
            prev.setImage(images.get(19));
            next.setImage(images.get(index + 1));
        } else if (index == 19) {
            next.setImage(images.get(0));
            prev.setImage(images.get(index - 1));
        } else {
            prev.setImage(images.get(index - 1));
            next.setImage(images.get(index + 1));
        }
    }

    public void next(MouseEvent mouseEvent) {
        index+=1;
        if (index==20){
            index=0;
        }
        current.setImage(images.get(index));
        if (index == 0) {
            prev.setImage(images.get(19));
            next.setImage(images.get(index + 1));
        } else if (index == 19) {
            next.setImage(images.get(0));
            prev.setImage(images.get(index - 1));
        } else {
            prev.setImage(images.get(index - 1));
            next.setImage(images.get(index + 1));
        }
    }

    public void buy(MouseEvent mouseEvent) {
        String regex=".+/(?<good>.+).png";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(current.getImage().getUrl());
        //item target
        if (matcher.matches()){
            String value=matcher.group("good");
            switch (value){
                case "apple":
                    //item=apple
                    //place=granery
                    break;
                case "cheese":
                    //item=cheese
                    //place=granery
                    break;
                case "meat":
                    //==
                    //place granery
                    break;
                case "floor":
                    //==
                    //place stockpile
                    break;
                case "ale":
                    //stockpile
                    //==
                    break;
                case "barley":
                    //stockpile
                    //==
                    break;
                case "wheat":
                    //stockpile
                    //==
                    break;
                case "iron":
                    //stockpile
                    //==
                    break;
                case "wood":
                    //stockpile
                    //==
                    break;
                case "oil":
                    //stockpile
                    //==
                    break;
                case "stone":
                    //stockpile
                    //==
                    break;
                case "arc":
                    //weaponary
                    //==
                    break;
                case "sword":
                    //weaponary
                    //==
                    break;
                case "pike":
                    //weaponary
                    //==
                    break;
                case "mace":
                    //weaponary
                    //==
                    break;
                case "crossbow":
                    //weaponary
                    //==
                    break;
                case "metalarmour":
                    //weaponary
                    //==
                    break;
                case "leatherArmour":
                    //weaponary
                    //==
                    break;
                case "spear":
                    //weaponary
                    //==
                    break;
                default:
                    break;
            }
            //if (storage.havecapacity()){
            //if (user have enough gold to buy item){
            // user.setgold(user.getgold-item.cost)
            // user.getitem().set(+1)}}
            //else{
            // error.settext(your storage is full my lord)}
        }
    }

    public void sell(MouseEvent mouseEvent) {
        String regex=".+/(?<good>.+).png";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(current.getImage().getUrl());
        //item target
        if (matcher.matches()){
            String value=matcher.group("good");
            switch (value){
                case "apple":
                    //item=apple
                    break;
                case "cheese":
                    //item=cheese
                    break;
                case "meat":
                    //==
                    break;
                case "floor":
                    //==
                    break;
                case "ale":
                    //==
                    break;
                case "barley":
                    //==
                    break;
                case "wheat":
                    //==
                    break;
                case "iron":
                    //==
                    break;
                case "wood":
                    //==
                    break;
                case "oil":
                    //==
                    break;
                case "stone":
                    //==
                    break;
                case "arc":
                    //==
                    break;
                case "sword":
                    //==
                    break;
                case "pike":
                    //==
                    break;
                case "mace":
                    //==
                    break;
                case "crossbow":
                    //==
                    break;
                case "metalarmour":
                    //==
                    break;
                case "leatherArmour":
                    //==
                    break;
                case "spear":
                    //==
                    break;
                default:
                    break;
            }
            //if (user have enough item){
            // user.get(item)-1
            // user.setgold(user.gold+item.cost)}
        }
    }
}
