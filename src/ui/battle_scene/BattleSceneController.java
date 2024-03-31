package ui.battle_scene;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import ui.battle_scene.components.BattleBoard;
import ui.battle_scene.components.Pannel;
import ui.camera.PCamera;
import ui.common.BaseController;

import java.awt.event.MouseEvent;

public class BattleSceneController implements BaseController {
    @FXML
    private SubScene battleSubScene;

    @FXML
    private Button howtoButton;

    @FXML
    private AnchorPane anchorPane;

    private Pannel pannel;
    @Override
    public void start() {
        BattleBoard battleBoard = new BattleBoard();
        StackPane _stackPane = new StackPane();
        _stackPane.getChildren().add(battleBoard);
        _stackPane.setAlignment(Pos.CENTER);

        PCamera pCamera = new PCamera();
        battleSubScene.setVisible(true);
        battleSubScene.setCamera(pCamera);
        battleSubScene.setRoot(_stackPane);

        pannel = new Pannel();
        anchorPane.getChildren().add(pannel);

        pannel.setVisible(false);
    }

    public void howtoButtonClicked() {
        pannel.setVisible(!pannel.isVisible());
        if (pannel.isVisible()) {
            TranslateTransition tt = new TranslateTransition();
            tt.setNode(battleSubScene);
            tt.setToX(Math.abs(pannel.getWidth() - battleSubScene.getLayoutX()));
            tt.setDuration(javafx.util.Duration.millis(800));
            tt.setInterpolator(javafx.animation.Interpolator.EASE_BOTH);

            tt.play();
        } else {
            TranslateTransition tt = new TranslateTransition();
            tt.setNode(battleSubScene);
            tt.setToX(0);
            tt.setDuration(javafx.util.Duration.millis(800));
            tt.setInterpolator(javafx.animation.Interpolator.EASE_BOTH);
            tt.play();
        }
    }
}
