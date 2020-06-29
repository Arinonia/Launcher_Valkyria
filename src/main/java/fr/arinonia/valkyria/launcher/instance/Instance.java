package fr.arinonia.valkyria.launcher.instance;

import fr.arinonia.valkyria.launcher.ui.panel.IPanel;
import fr.arinonia.valkyria.launcher.ui.panels.InstancePanel;

/**
 * Created by Arinonia on 29/06/2020 inside the package - fr.arinonia.valkyria.launcher.instance
 */
public class Instance {

    private final IPanel instancePanel = new InstancePanel(this);
    private final String name;
    private final String url;
    private final String[] keyword;

    public Instance(String name, String url, String[] keyword) {
        this.name = name;
        this.url = url;
        this.keyword = keyword;
    }

    public IPanel getInstancePanel() {
        return instancePanel;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String[] getKeyword() {
        return keyword;
    }
}
