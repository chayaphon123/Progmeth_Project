package ui.battle_scene.components;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Optional;

public class Card extends StackPane {
    private double cardStartX, cardStartY, cardStartZ;
    private boolean isDragged = false;
    private Parent _node;

    public Card() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
        try {
            _node = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getChildren().add(_node);
        setPrefWidth(100);
        setPrefHeight(150);
        setMaxHeight(150); // set max height to prevent the card from expanding (which will cause the incorrect alignment in parent nodes)

        Text text = new Text(Math.random() * 100 + "");
        text.setFont(new Font(20));
        text.setFill(Color.BLACK);
        getChildren().add(text);

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            cardStartX = this.getTranslateX();
            cardStartY = this.getTranslateY();
            cardStartZ = this.getTranslateZ();
            // this will bring the card to the front
            // we also have to bring its parent to the front So it is above all other nodes
            this.toFront();
            Parent pr = this.getParent();
            while (pr != null && !(pr instanceof BattleLine)) pr = pr.getParent();
            if (pr != null) {
                BattleLine line = (BattleLine) pr;
                line.toFront();
                line.getParent().toFront();
            }
            // this make pickup base on geometric shape of this node
            setPickOnBounds(false);
        });
        addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            Point2D p = new Point2D(e.getX(), e.getY());
            p = localToParent(p);

            this.setTranslateX(p.getX() - this.getWidth()/2);
            this.setTranslateY(p.getY() - this.getHeight()/2);
            isDragged = true;
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            if (isDragged) {
                Parent _team = this.getParent();
                Parent _line = this.getParent();
                while (_team != null && !(_team instanceof BattleTeam)) _team = _team.getParent();
                while (_line != null && !(_line instanceof BattleLine)) _line = _line.getParent();
                if (_team == null || _line == null) return;

                // this will return us the node that the card is dragged to.
                // "localToParent" is used to convert the point to the parent's coordinate system
                // "parentToLocal" is used to convert the point to the node's coordinate system
                // we need to juggles between these two methods to get the correct point
                Optional<Node> node = ((BattleTeam) _team).getChildren().stream().filter(n -> {
                    if (n instanceof BattleLine) {
                        if (((BattleLine) n).isContainThisCard(this)) {
                            return false;
                        } else {
                            Point2D p = new Point2D(e.getX(), e.getY());
                            Parent pr = this;
                            do {
                                if (pr == null) {
                                    System.out.println("parent is null (should never happen");
                                    return false;
                                }
                                p = pr.localToParent(p);
                                pr = pr.getParent();
                            } while (!(pr instanceof BattleTeam));
                            p = n.parentToLocal(p);
                            return n.contains(p);
                        }
                    }
                    return false;
                }).findAny();

                // if the node is empty or the node is not a BattleLine, then we won't move the card
                if ((node.isEmpty()) || !(node.get() instanceof BattleLine)) {
                    this.setTranslateX(cardStartX);
                    this.setTranslateY(cardStartY);
                    this.setTranslateZ(cardStartZ);
                    return;
                }

                this.setTranslateX(0);
                this.setTranslateY(0);
                this.setTranslateZ(0);

                ((BattleLine) _line).removeCard(this);
                ((BattleLine) node.get()).addCard(this);

                isDragged = false;
            }
        });
    }
}
