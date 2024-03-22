package ui.battle_scene;

import application.Main;
import javafx.geometry.Point2D;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import ui.camera.PCamera;

import java.util.Optional;
import java.util.Random;

public class Card extends Pane {
    private double mouseStartX, mouseStartY;
    private double cardStartX, cardStartY, cardStartZ;
    private boolean isDragged = false;

    public Card() {
        Rectangle card = new Rectangle(100, 150);
        card.setFill(Color.GRAY);
        card.setStroke(Color.BLACK);
        card.setStrokeWidth(2);
        getChildren().add(card);

        setCache(true);
        setCacheHint(CacheHint.QUALITY);

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            mouseStartX = e.getSceneX();
            mouseStartY = e.getSceneY();
            cardStartX = this.getTranslateX();
            cardStartY = this.getTranslateY();
            cardStartZ = this.getTranslateZ();
        });
        addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            double deltaX = e.getSceneX() - mouseStartX;
            double deltaY = e.getSceneY() - mouseStartY;
//            this.setTranslateZ(cardStartZ - 50);

            Parent parent = this.getParent();
            Parent parent1 = parent.getParent();
            Parent parent2 = parent1.getParent();
            Point2D p = new Point2D(e.getX(), e.getY());
            p = localToParent(p);
            p = parent.localToParent(p);
            p = parent1.localToParent(p);

            this.setTranslateX(p.getX());
            this.setTranslateY(p.getY());

            isDragged = true;
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            if (isDragged) {
                Parent _team = this.getParent();
                Parent _line = this.getParent();
                while (_team != null && !(_team instanceof BattleTeam)) _team = _team.getParent();
                while (_line != null && !(_line instanceof BattleLine)) _line = _line.getParent();
                if (_team == null || _line == null) return;

                BattleTeam team = (BattleTeam) _team;
                Optional<Node> node = team.getChildren().stream().filter(n -> {
                    if (n instanceof BattleLine) {
                        if (((BattleLine) n).isContainThisCard(this)) {
                            System.out.println("false");
                            return false;
                        } else {
                            Parent parent = this.getParent();
                            Parent parent1 = parent.getParent();
                            Parent parent2 = parent1.getParent();
                            Point2D p = new Point2D(e.getX(), e.getY());
                            p = localToParent(p);
                            p = parent.localToParent(p);
                            p = parent1.localToParent(p);
                            p = parent2.localToParent(p);

                            p = n.parentToLocal(p);
                            return n.contains(p);
                        }
                    }
                    System.out.println("false");
                    return false;
                }).findAny();
                if ((node.isEmpty()) || !(node.get() instanceof BattleLine)) {
                    this.setTranslateX(cardStartX);
                    this.setTranslateY(cardStartY);
                    this.setTranslateZ(cardStartZ);
                    return;
                }

                BattleLine line = (BattleLine) node.get();
                if (line.isContainThisCard(this)) {
                    this.setTranslateX(cardStartX);
                    this.setTranslateY(cardStartY);
                    this.setTranslateZ(cardStartZ);
                    return;
                }

                ((BattleLine) _line).removeCard(this);
                line.addCard(this);

                this.setTranslateX(0);
                this.setTranslateY(0);
                this.setTranslateZ(0);

                isDragged = false;
            }
        });
    }
}
