package fr.arinonia.valkyria.launcher;

import fr.arinonia.valkyria.launcher.files.FileManager;
import fr.arinonia.valkyria.launcher.instance.Instance;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.panels.PanelLogin;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher
 */
public class ValkyriaLauncher {

    private final FileManager fileManager = new FileManager();
    private final List<Instance> instances = new ArrayList<>();

    private PanelManager panelManager;

    public ValkyriaLauncher() {
        this.instances.add(new Instance("Faction", "https://dev.valkyria.fr/images/faction.jpg", new String[]{"FarmToWin","Complet","Fluide"}));
        this.instances.add(new Instance("Skyblock", "https://dev.valkyria.fr/images/skyblock.jpg", new String[]{"Modé","Maj régulière","En team"}));
        this.instances.add(new Instance("Mmo", "https://dev.valkyria.fr/images/mmo.jpg", new String[]{"Quêtes innédit","Voix custom","Lore perso"}));
    }

    public void init(Stage stage) {
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
        this.panelManager.showPanel(this.panelManager.getPanelLogin());

    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public PanelManager getPanelManager() {
        return panelManager;
    }
}
