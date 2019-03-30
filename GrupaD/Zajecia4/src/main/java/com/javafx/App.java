package com.javafx;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;

class ColorWithName {
    private String mName = "";
    private Color mColor;

    ColorWithName(Color color, String name){
        mColor = color;
        mName = name;
    }

    public Color getColor(){
        return mColor;
    }

    public String getName(){
        return mName;
    }

}

public class App extends Application {

    ArrayList<ColorWithName> mColors = new ArrayList<>();
    ArrayList<Circle> mItems = new ArrayList<>();

    Circle mCurrentItem = null;

    @Override
    public void init() throws Exception {
        super.init();

        mColors.add(new ColorWithName(Color.AQUAMARINE,"Aquamarine"));
        mColors.add(new ColorWithName(Color.BISQUE,"Bisque"));

    }

    private int randomNumber(int max){
        return (int)(Math.random()*max)+1;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();

        Scene scene = new Scene(group, 640, 480);

        Circle circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);

        circle.setRadius(50);
        circle.setFill(mColors.get(0).getColor());

        URL url = getClass().getResource("ptak.gif");

        Image image = new Image(url.toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        group.getChildren().add(imageView);

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(2));
        tt.setNode(imageView);

        tt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double oldX = imageView.getTranslateX();
                double oldY = imageView.getTranslateY();

                mCurrentItem = getNewItem();

                double newX = mCurrentItem.getCenterX();
                double newY = mCurrentItem.getCenterY();

                if(mCurrentItem!=null){
                    tt.setFromX(oldX);
                    tt.setFromY(oldY);

                    tt.setToX(newX);
                    tt.setToY(newY);

                    System.out.println("("+oldX+" ,"+oldY+") -> "+"("+newX+" ,"+newY+")");
                }

            }
        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double oldX = imageView.getTranslateX();
                double oldY = imageView.getTranslateY();

                double newX = event.getX();
                double newY = event.getY();

                group.getChildren().remove(imageView);
                group.getChildren().removeAll(mItems);

                Circle item = addItem(newX,newY);

                mItems.add(item);

                group.getChildren().addAll(mItems);
                group.getChildren().add(imageView);


                if(newX>oldX) {
                    imageView.setScaleX(1);
                    newX -= imageView.getFitWidth();
                }
                else {
                    imageView.setScaleX(-1);
                }

                tt.setFromX(oldX);
                tt.setFromY(oldY);

                tt.setToX(newX);

                newY-=imageView.getFitHeight()/3;

                tt.setToY(newY);

                tt.stop();
                tt.play();

                ColorWithName color = mColors.get(randomNumber(mColors.size())-1);
                circle.setFill(color.getColor());

            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle addItem(double x, double y){
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);

        circle.setRadius(Math.random()*20+10);
        circle.setFill(Color.YELLOW);

        return circle;
    }

    private Circle getNewItem(){
        if(mItems.size()>0)
            return mItems.get(0);
        else
            return null;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
