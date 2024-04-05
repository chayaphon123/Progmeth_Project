package ui.battle_scene.components;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Optional;

public class Card extends StackPane {
    private Parent _node;
    private CardController _controller;

    public String str = Math.random() * 100 + "";

    public Card() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
        try {
            _node = loader.load();
            _controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getChildren().add(_node);
        setPrefWidth(100);
        setPrefHeight(150);
        setMaxHeight(150); // set max height to prevent the card from expanding (which will cause the incorrect alignment in parent nodes)

        Text text = new Text(str);
        text.setFont(new Font(20));
        text.setFill(Color.BLACK);
        getChildren().add(text);

        _controller.setCard(this);
        _controller.start();
    }

    public CardController getController() {
        return _controller;
    }
}
