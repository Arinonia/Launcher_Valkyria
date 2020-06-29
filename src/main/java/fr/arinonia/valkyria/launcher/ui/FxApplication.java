package fr.arinonia.valkyria.launcher.ui;

import fr.arinonia.valkyria.launcher.ValkyriaLauncher;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui
 */
public class FxApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new ValkyriaLauncher().init(stage);
    }
}
