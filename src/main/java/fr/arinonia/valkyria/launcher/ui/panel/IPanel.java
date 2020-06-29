package fr.arinonia.valkyria.launcher.ui.panel;

import fr.arinonia.valkyria.launcher.ui.PanelManager;
import javafx.scene.layout.GridPane;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panel
 */
public interface IPanel {
    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();
}
