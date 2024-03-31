package ui.battle_scene.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Pannel extends AnchorPane {
    private Parent _node;
    public Pannel() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pannel.fxml"));
        try {
            _node = loader.load();
            loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getChildren().add(_node);
        this.setMaxWidth(850);
        this.setMaxHeight(900);
    }
}
