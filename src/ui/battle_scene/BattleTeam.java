package ui.battle_scene;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.Optional;

public class BattleTeam extends StackPane {
    public BattleLine battleLine1 = new BattleLine(1);
    public BattleLine battleLine2 = new BattleLine(3);
    public BattleLine battleLine3 = new BattleLine(1);

    BattleTeam() {
        getChildren().add(battleLine1);
        getChildren().add(battleLine2);
        getChildren().add(battleLine3);

        battleLine1.setTranslateX(0);
        battleLine2.setTranslateX(200);
        battleLine3.setTranslateX(400);
    }
}
