package ui.battle_scene;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class BattleTeam extends HBox {
    public BattleLine battleLine1 = new BattleLine(1);
    public BattleLine battleLine2 = new BattleLine(3);
    public BattleLine battleLine3 = new BattleLine(1);

    BattleTeam() {
        setSpacing(30);

        getChildren().add(battleLine1);
        getChildren().add(battleLine2);
        getChildren().add(battleLine3);
    }
}
