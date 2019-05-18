/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

class MyButton extends Button{
    MyButton(String text){
        super(text);
    }

    private void wyswietlAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tytuł okna");
        alert.setHeaderText("Przykładowy nagłówek");
        alert.setContentText("Przykładowy tekst");

        alert.showAndWait();
    }
}

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

        MyButton button0 = new MyButton("0");
        button0.setPrefSize(100,100);

        MyButton button1 = new MyButton("1");
        button1.setPrefSize(100,100);

        MyButton button2 = new MyButton("2");
        button2.setPrefSize(100,100);

        MyButton button3 = new MyButton("3");
        button3.setPrefSize(100,100);


        HBox hbox = new HBox();

        button0.setLayoutX(100);


        group.getChildren().addAll(button0,button1,button2,button3);

    }
}
