package ui.battle_scene;

import application.Main;
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
        setSpacing(50);
        setRotationAxis(Rotate.X_AXIS);
        setRotate(-50);

//        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        getChildren().add(team1);

        Text text = new Text("VS");
        text.setTextOrigin(VPos.CENTER);
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font: 24 arial;");
        setAlignment(Pos.CENTER);
        getChildren().add(text);

        getChildren().add(team2);
    }

    public Optional<Node> getLineByMouse(MouseEvent e) {
        for (Node node : team1.getChildren()) {
            if (node.getBoundsInParent().contains(e.getX(), e.getY())) {
                return Optional.of(node);
            }
        }
        for (Node node : team2.getChildren()) {
            if (node.getBoundsInParent().contains(e.getX(), e.getY())) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    public Optional<Card> getCardByMouse(MouseEvent e) {
        for (Node node : team1.getChildren()) {
            if (node instanceof BattleLine) {
                BattleLine line = (BattleLine) node;
                Optional<Node> _card = line.getCardContainer().getChildren().stream().filter(card ->
                        card.getBoundsInParent().contains(line.parentToLocal(e.getX(), e.getY()))).findAny();
                if (_card.isPresent()) {
                    return Optional.of((Card) _card.get());
                }
            }
        }
        for (Node node : team2.getChildren()) {
            if (node instanceof BattleLine) {
                BattleLine line = (BattleLine) node;
                Optional<Node> _card = line.getCardContainer().getChildren().stream().filter(card ->
                        card.contains(e.getX(), e.getY())).findAny();
                if (_card.isPresent()) {
                    return Optional.of((Card) _card.get());
                }
            }
        }
        return Optional.empty();
    }
}
