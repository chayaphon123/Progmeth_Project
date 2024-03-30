package ui.battle_scene.components;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.battle_scene.components.Card;

import java.util.ArrayList;

public class BattleLine extends StackPane {
    private ArrayList<Card> cards = new ArrayList<>();
    private StackPane card_container = new StackPane();
    private Text text = new Text(cards.size() + "/3");

    public BattleLine(int prefSize) {
        setPrefWidth(100);
        setPrefHeight(600);
        setAlignment(Pos.CENTER);

        for (int i = 0; i < prefSize; i++) {
            Card card = new Card();
            addCard(card);
        }

        card_container.setAlignment(Pos.TOP_CENTER);
        getChildren().add(card_container);

        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        getChildren().add(text);

        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
        card_container.setBorder(new Border(new BorderStroke(Color.VIOLET, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
    }

    public void addCard(Card card) {
        cards.add(card);
        card_container.getChildren().removeAll(cards);
        for (Card c : cards) {
            card_container.getChildren().add(c);
            c.setTranslateY((cards.indexOf(c)) * 200);
        }
        card_container.setMaxHeight(200 * cards.size());
        text.setText(cards.size() + "/3");
    }

    public void removeCard(Card card) {
        cards.remove(card);
        card_container.getChildren().removeAll(cards);
        for (Card c : cards) {
            card_container.getChildren().add(c);
            c.setTranslateY((cards.indexOf(c)) * 200);
        }
        card_container.setMaxHeight(200 * cards.size());
        text.setText(cards.size() + "/3");
    }

    public boolean isContainThisCard(Card card) {
        return cards.contains(card);
    }
}
