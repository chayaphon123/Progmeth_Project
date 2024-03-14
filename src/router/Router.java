package router;

import config.Config;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static config.Router.scenes;

import config.Router.AppScene;

public class Router {
    private static Router instance;
    private static Stage stage;
    private static Scene _currentScene;

    private Router(Stage stage) {
        Router.stage = stage;

        for (IAppScene scene : scenes.values()) {
            try {
                scene.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        _currentScene = new Scene(scenes.get(config.Router.START_SCENE).getNode(),
                Config.APP_WIDTH, Config.APP_HEIGHT);
        stage.setScene(_currentScene);
        stage.setTitle(Config.APP_NAME);
        stage.setResizable(false);
        stage.show();
    }

    public static synchronized Router createInstance(Stage stage) {
        if (instance == null) {
            return new Router(stage);
        }
        return instance;
    }
}

