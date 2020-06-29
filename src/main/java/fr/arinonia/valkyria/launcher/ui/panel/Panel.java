package fr.arinonia.valkyria.launcher.ui.panel;

import fr.arinonia.valkyria.launcher.ui.PanelManager;
import javafx.animation.FadeTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panel
 */
public class Panel implements IPanel{
    protected GridPane layout = new GridPane();
    protected PanelManager panelManager;

    @Override
    public void init(PanelManager panelManager) {
        this.panelManager = panelManager;
        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);
    }

    @Override
    public GridPane getLayout() {
        return this.layout;
    }

    @Override
    public void onShow() {
        FadeTransition transition = new FadeTransition(Duration.seconds(1), this.layout);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setAutoReverse(true);
        transition.play();
    }
}
