package router;

import javafx.scene.Node;
import javafx.scene.Parent;

public interface IAppScene {
    public void init() throws Exception;
    public Parent getNode();
}
