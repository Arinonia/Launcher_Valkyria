package fr.arinonia.valkyria.launcher.ui.components;

import fr.arinonia.arilibfx.ui.component.AProgressBar;
import fr.arinonia.valkyria.launcher.Main;
import fr.arinonia.valkyria.launcher.ValkyriaLauncher;
import fr.arinonia.valkyria.launcher.instance.Instance;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by Arinonia on 29/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.components
 */
public class InstanceButton extends GridPane {

    private final Instance instance;
    private final ValkyriaLauncher launcher;


    public InstanceButton(final Instance instance, final ValkyriaLauncher launcher) {
        this.instance = instance;
        this.launcher = launcher;
        init();
    }

    public void init(){
        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);

        //this.setStyle("-fx-background-color: #" + this.instance.getColor() + ";");
       // this.setStyle("-fx-background-color: rgba(22,22,22,0.3);");
        this.setPrefHeight(40);
        this.setMaxHeight(40);
        this.setPrefWidth(300);
        this.setMaxWidth(300);

        this.setOnMouseClicked(e->{
            launcher.getPanelManager().getHomePanel().showInstancePanel(this.instance);
        });

        Separator blueLeftSeparator = new Separator();
        GridPane.setVgrow(blueLeftSeparator, Priority.ALWAYS);
        GridPane.setHgrow(blueLeftSeparator, Priority.ALWAYS);
        blueLeftSeparator.setOrientation(Orientation.VERTICAL);
        blueLeftSeparator.setMinWidth(4);
        blueLeftSeparator.setMaxWidth(4);
        blueLeftSeparator.setMinHeight(36);
        blueLeftSeparator.setMaxHeight(36);
        blueLeftSeparator.setStyle("-fx-background-color: rgb(5,179,242); -fx-border-width: 4 4 4 0; -fx-border-color: rgb(5,179,242);");

        Image logoImage = new Image(Main.class.getResource("/img/" + this.instance.getName() + ".png").toExternalForm());
        ImageView imageView = new ImageView(logoImage);
        GridPane.setVgrow(imageView, Priority.ALWAYS);
        GridPane.setHgrow(imageView, Priority.ALWAYS);
        GridPane.setValignment(imageView, VPos.CENTER);
        imageView.setTranslateX(20);
        imageView.setFitWidth(28);
        imageView.setFitHeight(28);

        Label valkyriaLabel = new Label(this.instance.getName());
        GridPane.setVgrow(valkyriaLabel, Priority.ALWAYS);
        GridPane.setHgrow(valkyriaLabel, Priority.ALWAYS);
        GridPane.setValignment(valkyriaLabel, VPos.CENTER);
        valkyriaLabel.setTranslateX(60);
        valkyriaLabel.setStyle("-fx-text-fill: #fff");
        valkyriaLabel.setFont(Font.loadFont(Main.class.getResource("/font/Poppins-Medium.ttf").toExternalForm(), 14));

        AProgressBar aProgressBar = new AProgressBar(170,3);
        GridPane.setVgrow(aProgressBar, Priority.ALWAYS);
        GridPane.setHgrow(aProgressBar, Priority.ALWAYS);
        GridPane.setValignment(aProgressBar, VPos.BOTTOM);

        aProgressBar.setBackgroundColor(Color.rgb(222,222,222,0.3d));
        aProgressBar.setForegroundColor(Color.rgb(255,255,255));
        aProgressBar.setTranslateX(60.0D);
        aProgressBar.setProgress(40.0f, 127.0f);
        this.getChildren().addAll(blueLeftSeparator, imageView, valkyriaLabel, aProgressBar);
    }


}
