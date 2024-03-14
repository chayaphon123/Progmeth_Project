package application;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;
import router.Router;

import java.awt.*;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Router.createInstance(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
