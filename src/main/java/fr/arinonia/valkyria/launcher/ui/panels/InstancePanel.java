package fr.arinonia.valkyria.launcher.ui.panels;

import com.sun.javafx.tk.Toolkit;
import fr.arinonia.valkyria.launcher.Main;
import fr.arinonia.valkyria.launcher.instance.Instance;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.panel.Panel;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Created by Arinonia on 29/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panels
 */
public class InstancePanel extends Panel {

    private final Instance instance;

    public InstancePanel(Instance instance) {
        this.instance = instance;

    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        //this.layout.setStyle("-fx-background-color: #" + instance.getColor() + ";");
        this.panelManager.getLayout().setStyle("-fx-background-image: url('"+this.instance.getUrl()+"');"
                +"-fx-backgound-repeat: skretch;"+"-fx-backgound-position: center center;"
                +"-fx-background-size: cover;");

        ScrollPane scrollPane = new ScrollPane();
        GridPane.setHgrow(scrollPane, Priority.ALWAYS);
        GridPane.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.getStylesheets().add(Main.class.getResource("/css/scrollbar.css").toExternalForm());

        VBox vBox = new VBox();
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        vBox.setMinHeight(200);
        vBox.setMinWidth(900);
        vBox.setMaxWidth(900);
        vBox.setAlignment(Pos.CENTER);
        vBox.setTranslateX(30);
        vBox.setTranslateY(1);
        //vBox.setStyle("-fx-background-color: #ff58b3");

        GridPane topPane = new GridPane();
        GridPane.setVgrow(topPane, Priority.ALWAYS);
        GridPane.setHgrow(topPane, Priority.ALWAYS);
        GridPane.setValignment(topPane, VPos.TOP);
        topPane.setMaxWidth(880);
        topPane.setMinWidth(880);
        topPane.setMaxHeight(340);
        topPane.setMinHeight(340);
        this.showTopPanel(topPane);
        //topPane.setStyle("-fx-background-color: #4dfff0");

        GridPane newsPane = new GridPane();
        GridPane.setVgrow(newsPane, Priority.ALWAYS);
        GridPane.setHgrow(newsPane, Priority.ALWAYS);
        GridPane.setValignment(newsPane, VPos.BOTTOM);
        newsPane.setMaxWidth(880);
        newsPane.setMinWidth(880);
        newsPane.setMaxHeight(300);
        newsPane.setMinHeight(300);
        newsPane.setTranslateY(50);
        //newsPane.setStyle("-fx-background-color: #fffa00");

        GridPane aboutPane = new GridPane();
        GridPane.setVgrow(aboutPane, Priority.ALWAYS);
        GridPane.setHgrow(aboutPane, Priority.ALWAYS);
        GridPane.setValignment(aboutPane, VPos.BOTTOM);
        aboutPane.setMaxWidth(880);
        aboutPane.setMinWidth(880);
        aboutPane.setMaxHeight(600);
        aboutPane.setMinHeight(600);
        aboutPane.setTranslateY(100);
        //aboutPane.setStyle("-fx-background-color: #006fff");

        GridPane  footerPane = new GridPane();
        GridPane.setVgrow(footerPane, Priority.ALWAYS);
        GridPane.setHgrow(footerPane, Priority.ALWAYS);
        GridPane.setValignment(footerPane, VPos.BOTTOM);
        footerPane.setMaxWidth(880);
        footerPane.setMinWidth(880);
        footerPane.setMaxHeight(280);
        footerPane.setMinHeight(280);
        footerPane.setTranslateY(100);
        //footerPane.setStyle("-fx-background-color: #00ff11");

        this.layout.getChildren().add(scrollPane);
        scrollPane.setContent(vBox);
        vBox.getChildren().add(0,topPane);
        vBox.getChildren().add(1,newsPane);
        vBox.getChildren().add(2,aboutPane);
        vBox.getChildren().add(3,footerPane);
    }

    private void showTopPanel(GridPane panel){
        Label valkyriaTitle = new Label(this.instance.getName());
        GridPane.setVgrow(valkyriaTitle, Priority.ALWAYS);
        GridPane.setHgrow(valkyriaTitle, Priority.ALWAYS);
        GridPane.setValignment(valkyriaTitle, VPos.TOP);
        valkyriaTitle.setStyle("-fx-font-size: 26px; -fx-text-fill: #fff; -fx-font-weight: bold");
        valkyriaTitle.setTranslateY(20);

        Label key1 = new Label(this.instance.getKeyword()[0]);
        GridPane.setVgrow(key1, Priority.ALWAYS);
        GridPane.setHgrow(key1, Priority.ALWAYS);
        GridPane.setValignment(key1, VPos.TOP);
        key1.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        key1.setTranslateY(70);

        Label key2 = new Label(this.instance.getKeyword()[1]);
        GridPane.setVgrow(key2, Priority.ALWAYS);
        GridPane.setHgrow(key2, Priority.ALWAYS);
        GridPane.setValignment(key2, VPos.TOP);
        key2.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        key2.setTranslateY(70);
        key2.setTranslateX(Toolkit.getToolkit().getFontLoader().computeStringWidth(key1.getText(), key1.getFont()) + 15);

        Label key3 = new Label(this.instance.getKeyword()[2]);
        GridPane.setVgrow(key3, Priority.ALWAYS);
        GridPane.setHgrow(key3, Priority.ALWAYS);
        GridPane.setValignment(key3, VPos.TOP);
        key3.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        key3.setTranslateY(70);
        key3.setTranslateX(Toolkit.getToolkit().getFontLoader().computeStringWidth(key1.getText(), key1.getFont()) + Toolkit.getToolkit().getFontLoader().computeStringWidth(key2.getText(), key2.getFont()) + 30);

        panel.getChildren().add(valkyriaTitle);
        panel.getChildren().add(key1);
        panel.getChildren().add(key2);
        panel.getChildren().add(key3);

    }

}
