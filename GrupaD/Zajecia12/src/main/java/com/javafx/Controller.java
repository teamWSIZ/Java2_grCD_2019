package com.javafx;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MyButton extends Button{
    private int mNumber;

    MyButton(int number){

        mNumber = number;

        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this,Priority.ALWAYS);

        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);

        this.setText(""+mNumber);

        setOnMouseClicked(event -> {

            mNumber = mNumber+1;
            this.setText(""+mNumber);

            wyswietlAlert(mNumber);
        });
    }

    private void wyswietlAlert(int number) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tytuł okna");
        alert.setHeaderText("Przykładowy nagłówek");
        alert.setContentText("Kliknięto: " + number);

        alert.showAndWait();
    }
}

public class Controller {
    @FXML
    Button klawisz0;

    @FXML
    Pane gamePane;

    @FXML
    void initialize(){
        klawisz0.setText("Przykład");
        klawisz0.setOnMouseClicked(event -> {
            wyswietlAlert(0);
        });

        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.AZURE,null,null)));

        grid.setAlignment(Pos.CENTER);

        grid.setVgap(10);
        grid.setHgap(10);

        grid.setMaxSize(400,400);


        final int dimension = 5;

        for (int j = 0; j < dimension; j++) {
            for (int i = 0; i < dimension; i++) {

                grid.add(new MyButton(j * dimension + i + 1), i, j);
            }
        }

        Button button = new Button("Reset");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(grid,button);

        gamePane.getChildren().add(vbox);

    }

    private void wyswietlAlert(int number) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tytuł okna");
        alert.setHeaderText("Przykładowy nagłówek");
        alert.setContentText("Kliknięto: " + number);

        alert.showAndWait();
    }


}
