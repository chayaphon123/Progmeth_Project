package ui.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import router.IAppScene;

public class Home implements IAppScene {
    private Parent _node;

    @Override
    public void init() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        _node = loader.load();
    }

    @Override
    public Parent getNode() {
        return _node;
    }
}
