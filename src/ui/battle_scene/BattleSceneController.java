package ui.battle_scene;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import ui.battle_scene.components.BattleBoard;
import ui.camera.PCamera;
import ui.common.BaseController;

public class BattleSceneController implements BaseController {
    @FXML
    private SubScene battleSubScene;

    @FXML
    private Button howtoButton;
    @Override
    public void start() {
        BattleBoard battleBoard = new BattleBoard();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(battleBoard);
        stackPane.setAlignment(Pos.CENTER);

        PCamera pCamera = new PCamera();
        battleSubScene.setVisible(true);
        battleSubScene.setCamera(pCamera);
        battleSubScene.setRoot(stackPane);
    }
}
