package fr.arinonia.valkyria.launcher.ui.panels.includes;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panels.includes
 */
public class TopPanel extends Panel {

    private GridPane topBar;

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        this.topBar = this.layout;
        this.layout.setStyle("-fx-background-color: rgb(31,35,37)");
        GridPane topBarButton = new GridPane();

        this.layout.getChildren().add(topBarButton);

        GridPane.setHgrow(topBarButton, Priority.ALWAYS);
        GridPane.setVgrow(topBarButton, Priority.ALWAYS);

        Label title = new Label("Valkyria");
        this.layout.getChildren().add(title);
        title.setFont(Font.font("Consolas", FontWeight.THIN, FontPosture.REGULAR, 22.0f));
        title.setStyle("-fx-text-fill: white;");

        GridPane.setHalignment(title, HPos.CENTER);
        topBarButton.setMaxWidth(100.0d);
        topBarButton.setMinWidth(100.0d);
        GridPane.setVgrow(topBarButton, Priority.ALWAYS);
        GridPane.setHgrow(topBarButton, Priority.ALWAYS);
        GridPane.setHalignment(topBarButton, HPos.RIGHT);

        MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE);
        MaterialDesignIconView fullscreen = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
        MaterialDesignIconView hide = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);

        GridPane.setVgrow(close, Priority.ALWAYS);
        GridPane.setVgrow(hide, Priority.ALWAYS);
        close.setFill(Color.WHITE);
        close.setOpacity(0.70f);
        close.setSize("18.0px");
        close.setOnMouseEntered(e -> close.setOpacity(1.0f));
        close.setOnMouseExited(e -> close.setOpacity(0.70f));
        close.setOnMousePressed(e -> System.exit(0));
        close.setTranslateX(70.0d);
        fullscreen.setFill(Color.WHITE);
        fullscreen.setOpacity(0.70f);
        fullscreen.setSize("16.0px");
        fullscreen.setOnMouseEntered(e -> fullscreen.setOpacity(1.0f));
        fullscreen.setOnMouseExited(e -> fullscreen.setOpacity(0.70f));
        fullscreen.setOnMousePressed(e -> this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
        fullscreen.setTranslateX(50);
        hide.setFill(Color.WHITE);
        hide.setOpacity(0.70f);
        hide.setSize("18.0px");
        hide.setOnMouseEntered(e -> hide.setOpacity(1.0f));
        hide.setOnMouseExited(e -> hide.setOpacity(0.70f));
        hide.setOnMousePressed(e -> this.panelManager.getStage().setIconified(true));
        hide.setTranslateX(26);
        topBarButton.getChildren().addAll(close,fullscreen, hide);
    }


    public GridPane getTopBar() { return topBar; }
}
