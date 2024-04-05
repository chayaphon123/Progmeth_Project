package ui.battle_scene.components;

import data.Character;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import ui.common.BaseController;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.util.HashMap;
public class PannelController implements BaseController {
    @FXML
    private HBox attackerBox;

    @FXML
    private HBox supporterBox;

    @Override
    public void start() {
        attackerBox.setAlignment(Pos.CENTER);
        supporterBox.setAlignment(Pos.CENTER);

        HashMap<String, Character> characters = Character.getCharacters();
        for (Character character: characters.values()) {
            Circle circle = new Circle(60);
            circle.setFill(new ImagePattern(character.img));
            circle.getProperties().put("character_id", character.id);

            if (Integer.parseInt(character.id) < 4) {
                attackerBox.getChildren().add(circle);
            } else {
                supporterBox.getChildren().add(circle);
            }

            circle.setCursor(Cursor.HAND);
            circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                System.out.println("Clicked " + ((Circle) e.getTarget()).getProperties().get("character_id"));
                BattleBoard.getSelectedCard().getController().setCharacter(characters.get(((String) ((Circle) e.getTarget()).getProperties().get("character_id"))));
            });
        }
    }
}
