package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class MercanryPostPage extends Application {
    public Label peasantsNumber;
    public Label error;

    @Override
    public void start(Stage stage) throws Exception {
        URL url=BarrackPage.class.getResource("/FXML/barrackmenu.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene =new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        //peasantsNumber.setText(barrack.getowner.getpeasants());
    }
    public void details(MouseEvent mouseEvent) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Barrack");
        alert.setHeaderText("this building is for european soldier");
        alert.setContentText("develop your army my lord !!!");
        alert.show();

    }

    public void slave(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void archer(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void swordman(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void slinger(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void horseman(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void assassins(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }

    public void firethrower(MouseEvent mouseEvent) {
        if (peasantsNumber.textProperty().equals("0")){
            error.setText("not enough people in castle my lord!!!");
            return;
        }
        //if(currentpalyer.getgold<UHman.getcost){
        // error.setText("not enough gold my lord")
        // return;}
        //UHman uhman=new UHman();
        //uhman.setposition(barrack.getposition)
        //barrack.getposition.add(uhman)
        int num=Integer.parseInt(peasantsNumber.getText());
        num-=1;
        peasantsNumber.setText(String.valueOf(num));
    }
}
