package ui.battle_scene;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import ui.camera.PCamera;
import ui.common.BaseController;

public class BattleController implements BaseController {
    @Override
    public void start() {
        BattleBoard battleBoard = new BattleBoard();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(battleBoard);
        stackPane.setAlignment(Pos.CENTER);

        PCamera pCamera = new PCamera();
        BattleSubScene.setVisible(true);
        BattleSubScene.setCamera(pCamera);
        BattleSubScene.setRoot(stackPane);
    }
    @FXML
    private SubScene BattleSubScene;

    @FXML
    private Button howtoButton;

}
