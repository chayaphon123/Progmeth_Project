package ui.home;

import router.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import router.Router;
import ui.common.BaseController;

public class HomeController implements BaseController {
    @FXML
    private Button startButton;

    @Override
    public void start() {
    }

    @FXML
    public void buttonHandler() {
        Router.getInstance().push(Config.AppPage.BATTLE);
    }
}
