package router;

import javafx.scene.Scene;
import javafx.stage.Stage;

import static router.Config.scenes;

import router.Config.AppPage;

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

        _currentScene = new Scene(scenes.get(Config.START_SCENE).getNode(),
                config.Config.APP_WIDTH, config.Config.APP_HEIGHT);
        stage.setScene(_currentScene);
        stage.setTitle(config.Config.APP_NAME);
        stage.setResizable(false);
        stage.show();
    }

    public static synchronized void createInstance(Stage stage) {
        if (instance == null) {
            instance = new Router(stage);
        }
    }

    public static synchronized Router getInstance() {
        return instance;
    }

    public void push(AppPage scene) {
        _currentScene.setRoot(scenes.get(scene).getNode());
    }
}

