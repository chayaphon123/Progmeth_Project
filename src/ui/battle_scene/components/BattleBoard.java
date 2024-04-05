package ui.battle_scene.components;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;

public class BattleBoard extends StackPane {
    public BattleTeam team1 = new BattleTeam();
    public BattleTeam team2 = new BattleTeam();

    public Group group1 = new Group();
    private static Card selectedCard = null;

    public BattleBoard() {
        group1.getChildren().add(team1);
        group1.getChildren().add(team2);
        team2.setTranslateX(800);

        group1.setRotationAxis(Rotate.X_AXIS);
        group1.setRotate(-50);
        group1.setTranslateZ(500);
        group1.prefWidth(800);
        group1.prefHeight(1000);

        getChildren().add(group1);
    }

    public static Card getSelectedCard() {
        return selectedCard;
    }

    public static void setSelectedCard(Card card) {
        if (selectedCard != null) {
            selectedCard.getController().deselect();
        }
        selectedCard = card;
        selectedCard.getController().select();
    }
}
