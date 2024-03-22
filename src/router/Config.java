package router;

import ui.battle_scene.Battle;
import ui.home.Home;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Config() {}
    public static final AppPage START_SCENE = AppPage.HOME;
    public enum AppPage {
        HOME, BATTLE, SETTINGS
    }
    public static HashMap<AppPage, IAppScene> scenes = new HashMap<>(
            Map.of(
                    AppPage.HOME, new Home(),
                    AppPage.BATTLE, new Battle()
            )
    );
}

