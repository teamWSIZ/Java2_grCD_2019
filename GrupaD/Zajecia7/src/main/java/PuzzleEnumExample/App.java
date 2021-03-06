/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package PuzzleEnumExample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

enum PuzzleOrientation{
    //0,90,180,270;
    correct,right,upsidedown,left;
}

class PuzzleElement extends ImageView {

    private int mI, mJ;
    private int mDimension;

    private PuzzleOrientation mOrientation;

    @FunctionalInterface
    public interface onPuzzleClicked {
        void onClicked(int i, int j);
    }

    onPuzzleClicked mListener;

    public void setOnPuzzleClickedListener(onPuzzleClicked listener) {
        mListener = listener;
    }

    WritableImage mImage;

    double mAngle = 0;

    PuzzleElement(WritableImage image, int dimension, int i, int j) {
        super(image);

        mDimension = dimension;

        mOrientation = PuzzleOrientation.correct;

        this.setX(i * dimension);

        mI = i;
        mJ = j;

        randomize();

        setOnMouseClicked(event -> {
            rotate();
        });
    }

    private void rotate(){

        switch(mOrientation){
            case correct:
                mOrientation = PuzzleOrientation.right;
                mAngle = 90;
                break;
            case right:
                mOrientation = PuzzleOrientation.upsidedown;
                mAngle = 180;
                break;
            case upsidedown:
                mOrientation = PuzzleOrientation.left;
                mAngle = 270;
            case left:
                mOrientation = PuzzleOrientation.correct;
                mAngle = 0;
                break;
        }

        setRotate(mAngle);
    }

    public void randomize(){
        for(int i=0;i<Math.random()*4;i++)
            rotate();
    }
}

public class App extends Application {

    final int puzzleDim = 4;
    PuzzleElement[][] mPuzzle = new PuzzleElement[puzzleDim][puzzleDim];

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        Scene scene = new Scene(group, 500, 500);

        createPuzzle();

        for (int j = 0; j < puzzleDim; j++)
            for (int i = 0; i < puzzleDim; i++)
                group.getChildren().add(mPuzzle[i][j]);

        primaryStage.setScene(scene);
        primaryStage.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puzle");
        alert.setHeaderText("Rozpocznij grę");
        alert.setContentText("Program po poprawnym ułożeniu powinien pokazać poprawną ilość ruchów");

        alert.showAndWait();
    }

    private void createPuzzle() {

        Image image = new Image(getClass().getResource("elephant.png").toString());

        PixelReader reader = image.getPixelReader();

        int d = (int) (image.getWidth() / puzzleDim);

        for (int j = 0; j < puzzleDim; j++) {
            for (int i = 0; i < puzzleDim; i++) {
                WritableImage newImage = new WritableImage(reader, i * d, j * d, d, d);
                mPuzzle[i][j] = new PuzzleElement(newImage, d, i, j);

                mPuzzle[i][j].setX(i * d);
                mPuzzle[i][j].setY(j * d);
            }
        }
    }
}
