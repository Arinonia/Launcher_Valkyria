package fr.arinonia.valkyria.launcher.ui.panels.includes;

import fr.arinonia.valkyria.launcher.instance.Instance;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.components.InstanceButton;
import fr.arinonia.valkyria.launcher.ui.panel.IPanel;
import fr.arinonia.valkyria.launcher.ui.panel.Panel;
import fr.arinonia.valkyria.launcher.ui.panels.HomePanel;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Created by Arinonia on 29/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panels.includes
 */
public class LeftPanel extends Panel {


    public LeftPanel() {

    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        //Creator components for each server
        final VBox vBox = new VBox();
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        vBox.setSpacing(5.0D);
        for (Instance instance : this.panelManager.getLauncher().getInstances()){
            vBox.getChildren().add(new InstanceButton(instance, this.panelManager.getLauncher()));
        }
        Separator separator = new Separator();
        GridPane.setVgrow(separator, Priority.ALWAYS);
        GridPane.setHgrow(separator, Priority.ALWAYS);
        GridPane.setHalignment(separator, HPos.RIGHT);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setTranslateY(1);
        separator.setTranslateX(4);
        separator.setMinWidth(2);
        separator.setMaxWidth(2);
        separator.setOpacity(0.30);
        this.layout.getChildren().add(vBox);
        this.layout.getChildren().add(separator);
    }
}
