package fr.arinonia.valkyria.launcher.ui.panels;

import fr.arinonia.valkyria.launcher.instance.Instance;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.panel.IPanel;
import fr.arinonia.valkyria.launcher.ui.panel.Panel;
import fr.arinonia.valkyria.launcher.ui.panels.includes.LeftPanel;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * Created by Arinonia on 29/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panels.includes
 */
public class HomePanel extends Panel {

    private final LeftPanel leftPanel = new LeftPanel();
    private final GridPane centerPanel = new GridPane();

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.LEFT);
        columnConstraints.setMinWidth(300);
        columnConstraints.setMaxWidth(300);

        this.layout.getColumnConstraints().addAll(columnConstraints, new ColumnConstraints());
        this.layout.add(leftPanel.getLayout(),0,  0);
        this.leftPanel.init(this.panelManager);

        this.layout.add(centerPanel,1,  0);
        GridPane.setHgrow(centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(centerPanel, Priority.ALWAYS);

        this.showInstancePanel(panelManager.getLauncher().getInstances().get(0));
    }

    public void showInstancePanel(Instance instance){
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(instance.getInstancePanel().getLayout());

        GridPane.setHgrow(instance.getInstancePanel().getLayout(), Priority.ALWAYS);
        GridPane.setVgrow(instance.getInstancePanel().getLayout(), Priority.ALWAYS);
        instance.getInstancePanel().init(this.panelManager);
    }
}
