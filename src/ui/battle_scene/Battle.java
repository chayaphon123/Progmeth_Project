package ui.battle_scene;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import router.IAppScene;
import ui.common.BaseController;

public class Battle implements IAppScene {
    private Parent _node;
    private BaseController _controller;

    @Override
    public void init() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Battle.fxml"));
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
