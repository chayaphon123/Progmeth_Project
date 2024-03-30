package ui.battle_scene.components;

import javafx.scene.layout.StackPane;

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
