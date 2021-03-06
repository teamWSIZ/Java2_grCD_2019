package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


class Kwadrat extends Rectangle {
    double mRozmiar;
    Paint mPaint;

    Kwadrat(double rozmiar, Paint paint, Group group){
        mRozmiar = rozmiar;
        mPaint = paint;

        setWidth(mRozmiar);
        setHeight(mRozmiar);

        setFill(mPaint);

        group.getChildren().add(this);
    }
}

class Trojkat extends Path{
    double a;
    double h;

    Paint mPaint;

    Trojkat(double rozmiar){

        this.a = rozmiar;
        this.h = Math.sqrt(3)/2.0*a;

        getElements().add(new MoveTo(a/2,0));
        getElements().add(new LineTo(a,h));
        getElements().add(new LineTo(0,h));
        getElements().add(new LineTo(a/2,0));

        setFill(Color.GREEN);

    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        Scene scene = new Scene(group,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();

        for(int i=0;i<100;i++){
            Kwadrat k = new Kwadrat(Math.random()*10+10,Color.YELLOW,group);
            k.setX(Math.random()*500);
            k.setY(Math.random()*500);
            k.setRotate(Math.random()*180);
        }

        for(int i=0;i<100;i++){
            Trojkat k = new Trojkat(Math.random()*20+20);
            k.setTranslateX(Math.random()*500);
            k.setTranslateY(Math.random()*500);
            k.setRotate(Math.random()*180);

            group.getChildren().add(k);
        }


    }
}
