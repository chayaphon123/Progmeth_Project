package config;

import router.IAppScene;
import ui.home.Home;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Router() {}
    public static final AppScene START_SCENE = AppScene.HOME;
    public enum AppScene {
        HOME, BATTLE, SETTINGS
    }
    public static HashMap<AppScene, IAppScene> scenes = new HashMap<>(
            Map.of(
                    AppScene.HOME, new Home()
            )
    );
}

