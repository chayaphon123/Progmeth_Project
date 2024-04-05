package ui.battle_scene.components;

import com.sun.tools.jconsole.JConsoleContext;
import data.Character;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ui.common.CharacterWrapper;
import ui.common.Selectable;

import java.util.Optional;


public class CardController implements Selectable, CharacterWrapper {
    @FXML
    private Rectangle bg_rect;
    @FXML
    private ImageView cardImage;
    @FXML
    private StackPane cardPane;

    private Card _card;
    private Character _character;
    private double cardStartX, cardStartY, cardStartZ;
    private boolean isDragged = false;

    public void start() {
        _card.setCursor(Cursor.OPEN_HAND);
        _card.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            cardImage.setVisible(true);
            BattleBoard.setSelectedCard(_card);
            _card.setCursor(Cursor.CLOSED_HAND);
            cardStartX = _card.getTranslateX();
            cardStartY = _card.getTranslateY();
            cardStartZ = _card.getTranslateZ();
            // this will bring the card to the front
            // we also have to bring its parent to the front So it is above all other nodes
            _card.toFront();
            Parent pr = _card.getParent();
            while (pr != null && !(pr instanceof BattleLine)) pr = pr.getParent();
            if (pr != null) {
                BattleLine line = (BattleLine) pr;
                line.toFront();
                line.getParent().toFront();
            }
            // this make pickup base on geometric shape of this node
            _card.setPickOnBounds(false);
        });
        _card.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            cardImage.setVisible(false);
            _card.setCursor(Cursor.CLOSED_HAND);
            Point2D p = new Point2D(e.getX(), e.getY());
            p = _card.localToParent(p);

            _card.setTranslateX(p.getX() - _card.getWidth()/2);
            _card.setTranslateY(p.getY() - _card.getHeight()/2);
            isDragged = true;
        });
        _card.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            cardImage.setVisible(true);
            _card.setCursor(Cursor.OPEN_HAND);
            System.out.println("released");
            if (isDragged) {
                Parent _team = _card.getParent();
                Parent _line = _card.getParent();
                while (_team != null && !(_team instanceof BattleTeam)) _team = _team.getParent();
                while (_line != null && !(_line instanceof BattleLine)) _line = _line.getParent();
                if (_team == null || _line == null) return;

                // this will return us the node that the card is dragged to.
                // "localToParent" is used to convert the point to the parent's coordinate system
                // "parentToLocal" is used to convert the point to the node's coordinate system
                // we need to juggles between these two methods to get the correct point
                Optional<Node> node = ((BattleTeam) _team).getChildren().stream().filter(n -> {
                    if (n instanceof BattleLine) {
                        if (((BattleLine) n).isContainThisCard(_card)) {
                            return false;
                        } else {
                            Point2D p = new Point2D(e.getX(), e.getY());
                            Parent pr = _card;
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
                    _card.setTranslateX(cardStartX);
                    _card.setTranslateY(cardStartY);
                    _card.setTranslateZ(cardStartZ);
                    return;
                }

                _card.setTranslateX(0);
                _card.setTranslateY(0);
                _card.setTranslateZ(0);

                ((BattleLine) _line).removeCard(_card);
                ((BattleLine) node.get()).addCard(_card);

                isDragged = false;
            }
        });
    }

    public void setCard(Card card) {
        _card = card;
    }

    @Override
    public void setCharacter(Character character) {
        cardImage.setImage(character.img);
    }

    @Override
    public void select() {
        int depth = 70;
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.RED);
        borderGlow.setWidth(depth);
        borderGlow.setHeight(depth);

        bg_rect.setEffect(borderGlow);
    }

    @Override
    public void deselect() {
        bg_rect.setEffect(null);
    }

    @Override
    public Character getCharacter() { return _character; }
}
