package ui.battle_scene;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import router.IAppScene;
import ui.camera.PCamera;
import ui.common.BaseController;

public class BattleScene implements IAppScene {
    private Parent _node;
    private BaseController _controller;

    @Override
    public void init() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleScene.fxml"));
        _node = loader.load();
        _controller = loader.getController();
    }

    @Override
    public Parent getNode() {
        return _node;
    }

    @Override
    public void start() {
        _controller.start();
    }
}
