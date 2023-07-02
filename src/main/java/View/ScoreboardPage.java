package View;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.DataBase;
import model.User;
import view.enums.Menus;
import view.user_system.StrongHoldCrusaderGame;

import java.util.ArrayList;

public class ScoreboardPage {
    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;
    public Label label5;
    public Label label6;
    public Label label7;
    public Label label8;
    public Label label9;
    public Label label10;
    public ImageView view1;
    public ImageView view2;
    public ImageView view3;
    public ImageView view4;
    public ImageView view5;
    public ImageView view6;
    public ImageView view7;
    public ImageView view8;
    public ImageView view9;
    public ImageView view10;
    private int index=0;
    private ArrayList<User>sorted;
    public void initialize(){
        sorted= DataBase.sortUsersByHighScore();
        index=0;
        showScoreboard(index,sorted);
    }

    private void showScoreboard(int index, ArrayList<User> sorted) {
        for (int i=index;i<index+10;i++){
            if (sorted.get(i)==null){
                break;
            }
            if (i==index){
                label1.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view1.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+1){
                label2.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view2.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+2){
                label3.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view3.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+3){
                label4.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view4.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+4){
                label5.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view5.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+5){
                label6.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view6.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+6){
                label7.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view7.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+7){
                label8.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view8.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+9){
                label10.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view10.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
            else if (i==index+8){
                label9.setText(i+1+"-"+sorted.get(i).getNickname()+" score: "+sorted.get(i).getHighScore());
                view9.setImage(new Image(ScoreboardPage.class.getResource(sorted.get(i).getUrl()).toExternalForm()));
            }
        }
    }

    public void profile(MouseEvent mouseEvent) {
        StrongHoldCrusaderGame.changeMenu(Menus.PROFILE);
    }

    public void upside(MouseEvent mouseEvent) {
        if (index==0){
            return;
        }
        index-=1;
        showScoreboard(index,sorted);
        return;
    }

    public void downside(MouseEvent mouseEvent) {
        if (index+10==sorted.size()){
            return;
        }
        index+=1;
        showScoreboard(index,sorted);
        return;
    }
}
