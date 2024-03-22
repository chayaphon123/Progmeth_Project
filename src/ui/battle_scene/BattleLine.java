package ui.battle_scene;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.CacheHint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;

public class BattleLine extends StackPane {
    private ArrayList<Card> cards = new ArrayList<>();
    private VBox card_container = new VBox();
    private VBox _container = new VBox();
    private Text text = new Text(cards.size() + "/3");

    public BattleLine(int prefSize) {
        _container.setPrefHeight(600);
        _container.setAlignment(Pos.CENTER);

        for (int i = 0; i < prefSize; i++) {
            addCard(new Card());
        }
        card_container.setSpacing(50);
        card_container.setCache(true);

        Rectangle bg_rect = new Rectangle(100, 600);
        bg_rect.setFill(Color.CORAL);
        bg_rect.setCache(true);
        bg_rect.toBack();
        getChildren().add(bg_rect);

        _container.getChildren().add(card_container);
        getChildren().add(_container);

        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        getChildren().add(text);

        setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
    }

    public void addCard(Card card) {
        cards.add(card);
        card_container.getChildren().removeAll(cards);
        card_container.getChildren().addAll(cards);
        text.setText(cards.size()+"/3");
    }
    public void removeCard(Card card) {
        cards.remove(card);
        card_container.getChildren().removeAll(cards);
        card_container.getChildren().addAll(cards);
        text.setText(cards.size()+"/3");
    }

    public boolean isContainThisCard(Card card) {
        return cards.contains(card);
    }

    public VBox getCardContainer() {
        return card_container;
    }
}
