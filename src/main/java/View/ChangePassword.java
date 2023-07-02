package View;

import controller.ControllerUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePassword {
    public PasswordField password;
    public PasswordField newPassword;
    public TextField captcha;
    public ImageView captchaView;
    public Label error;
    public Label passwordError;
    private static ArrayList<Integer>captchaImage=LoginPage.getCaptchaImage();

    public void run() throws IOException {
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        changePasswordStage(stage);
    }

    private void changePasswordStage(Stage stage) throws IOException {
        URL url=ChangePassword.class.getResource("/FXML/user_system/changepassword.fxml");
        Pane pane= FXMLLoader.load(url);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        newPassword.textProperty().addListener(observable -> {
            String state;
            if ((state=checkWeakness(newPassword.getText())) !=null) {
                passwordError.setText(state);
                passwordError.setStyle("-fx-text-fill: #fa0202");
            }
            else {
                passwordError.setText("");
                passwordError.setStyle("-fx-text-fill: #00FF00");
            }
        });
        Random random=new Random();
        int num=random.nextInt();
        if (num<0){
            num=-1*num;
        }
        num=num%50;
        captchaImage.get(num);
        captchaView.setImage(new Image(LoginPage.class.getResource("/Media/Captcha/"+captchaImage.get(num)+".png").toString()));
    }
    private String checkWeakness(String password) {
        if (password.length() < 6) {
            return "password is short!";
        }
        if (!password.matches(".*[a-z].*")) {
            return "password should have small letter!";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "password should have capital letter!";
        }
        if (!password.matches(".*[\\d].*")) {
            return "password should have at least one digit!";
        }
        if (!password.matches(".*([^\\da-zA-Z]).*")) {
            return "password should have one not letter nad numeric character!";
        }
        return null;
    }
    private void resetCaptchaFailRegister() {
        captcha.setText("");
        Random random=new Random();
        int num=random.nextInt();
        if (num<0){
            num=-1*num;
        }
        num=num%50;
        captchaImage.get(num);
        captchaView.setImage(new Image(LoginPage.class.getResource("/Media/Captcha/"+captchaImage.get(num)+".png").toString()));
    }

    public void resetCaptcha(MouseEvent mouseEvent) {
        captcha.setText("");
        Random random = new Random();
        int num = random.nextInt();
        if (num < 0) {
            num = -1 * num;
        }
        num = num % 50;
        captchaImage.get(num);
        captchaView.setImage(new Image(LoginPage.class.getResource("/Media/Captcha/" + captchaImage.get(num) + ".png").toString()));
    }
    public void submit(MouseEvent mouseEvent) {
        if (!ControllerUtils.getCurrentUser().getPassword().equals(password.getText())){
            error.setText("enter your password correctly");
            return;
        }
        String regex=".+(?<number>\\d\\d\\d\\d)\\.png";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher2= pattern.matcher(captchaView.getImage().getUrl());
        String Url=null;
        if (matcher2.matches()) {

            Url= matcher2.group("number");
        }
        if (!Url.equals(captcha.getText())){
            error.setText("Fill captcha correctly!");
            resetCaptchaFailRegister();
            return;
        }
        if (checkWeakness(newPassword.getText())!=null){
            error.setText("your password is weak");
            return;
        }
        ControllerUtils.getCurrentUser().setPassword(newPassword.getText());
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("success");
        alert.setHeaderText("change password");
        alert.setContentText("Your password change successfully");
        alert.showAndWait();
    }
}
