package ui.battle_scene;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import ui.camera.PCamera;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

public class BattleBoard extends HBox {
    public BattleTeam team1 = new BattleTeam();
    public BattleTeam team2 = new BattleTeam();
    public Pair<Optional<Node>, Boolean> selectedNode = new Pair<>(Optional.empty(), false);
    public BattleBoard() {
        setRotationAxis(Rotate.X_AXIS);
//        setRotate(-50);

        setTranslateX(0);
        setTranslateY(0);

        setPrefWidth(800);
        setPrefHeight(1000);
        setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        getChildren().add(team1);

        Text text = new Text("VS");
        text.setTextOrigin(VPos.CENTER);
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font: 24 arial;");
        setAlignment(Pos.CENTER);
        getChildren().add(text);

        getChildren().add(team2);
    }
}
