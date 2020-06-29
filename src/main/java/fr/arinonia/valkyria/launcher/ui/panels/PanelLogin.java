package fr.arinonia.valkyria.launcher.ui.panels;

import fr.arinonia.valkyria.launcher.Main;
import fr.arinonia.valkyria.launcher.ui.PanelManager;
import fr.arinonia.valkyria.launcher.ui.panel.Panel;
import fr.arinonia.valkyria.launcher.ui.panels.includes.LeftPanel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher.ui.panels
 */
public class PanelLogin extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        GridPane loginPanel = new GridPane();
        GridPane mainPane = new GridPane();
        GridPane bottomPane = new GridPane();

        loginPanel.setMaxWidth(400);
        loginPanel.setMinWidth(400);
        loginPanel.setMaxHeight(580);
        loginPanel.setMinHeight(580);

        GridPane.setVgrow(loginPanel, Priority.ALWAYS);
        GridPane.setHgrow(loginPanel, Priority.ALWAYS);
        GridPane.setValignment(loginPanel, VPos.CENTER);
        GridPane.setHalignment(loginPanel, HPos.CENTER);

        RowConstraints bottomConstraint = new RowConstraints();
        bottomConstraint.setValignment(VPos.BOTTOM);
        bottomConstraint.setMaxHeight(55);
        loginPanel.getRowConstraints().addAll(new RowConstraints(),bottomConstraint);
        loginPanel.add(mainPane,0,0);
        loginPanel.add(bottomPane,0,1);

        GridPane.setVgrow(mainPane, Priority.ALWAYS);
        GridPane.setHgrow(mainPane, Priority.ALWAYS);
        GridPane.setVgrow(bottomPane, Priority.ALWAYS);
        GridPane.setHgrow(bottomPane, Priority.ALWAYS);

        mainPane.setStyle("-fx-background-color: #181818;");
        bottomPane.setStyle("-fx-background-color: #181818; -fx-opacity: 50%");

        Label noAccount = new Label("Vous n'avez pas encore de compte ?");
        Label registerHere = new Label("S'inscrire ici");
        GridPane.setVgrow(noAccount, Priority.ALWAYS);
        GridPane.setHgrow(noAccount, Priority.ALWAYS);
        GridPane.setValignment(noAccount, VPos.TOP);
        GridPane.setHalignment(noAccount, HPos.CENTER);
        noAccount.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-padding: 5px");

        GridPane.setVgrow(registerHere, Priority.ALWAYS);
        GridPane.setHgrow(registerHere, Priority.ALWAYS);
        GridPane.setValignment(registerHere, VPos.BOTTOM);
        GridPane.setHalignment(registerHere, HPos.CENTER);
        registerHere.setStyle("-fx-text-fill: #69a7ed; -fx-font-size: 14px;");
        registerHere.setTranslateY(-10);
        registerHere.setUnderline(true);
        registerHere.setOnMouseEntered(e->{
            this.layout.setCursor(Cursor.HAND);
        });
        registerHere.setOnMouseExited(e->{
            this.layout.setCursor(Cursor.DEFAULT);
        });
        registerHere.setOnMouseClicked(e->{
            try {
                Desktop.getDesktop().browse(new URI("https://valkyria.fr/"));
            } catch (IOException | URISyntaxException ex) {
                Main.LOGGER.warn(ex.getMessage());
            }
        });

        bottomPane.getChildren().addAll(noAccount,registerHere);

        Label connectLabel = new Label("SE CONNECTER");
        GridPane.setVgrow(connectLabel, Priority.ALWAYS);
        GridPane.setHgrow(connectLabel, Priority.ALWAYS);
        GridPane.setValignment(connectLabel, VPos.TOP);

        connectLabel.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 16px;");
        connectLabel.setTranslateY(27);
        connectLabel.setTranslateX(37.5);
        Separator connectSeparator = new Separator();
        GridPane.setVgrow(connectSeparator, Priority.ALWAYS);
        GridPane.setHgrow(connectSeparator, Priority.ALWAYS);
        GridPane.setHalignment(connectSeparator, HPos.CENTER);
        GridPane.setValignment(connectSeparator, VPos.TOP);
        connectSeparator.setTranslateY(60);
        connectSeparator.setMaxWidth(325);
        connectSeparator.setMinWidth(325);
        connectSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 50%");

        Label usernameLabel = new Label("Nom d'utilisateur");
        GridPane.setVgrow(usernameLabel, Priority.ALWAYS);
        GridPane.setHgrow(usernameLabel, Priority.ALWAYS);
        GridPane.setHalignment(usernameLabel, HPos.LEFT);
        GridPane.setValignment(usernameLabel, VPos.TOP);
        usernameLabel.setStyle("-fx-text-fill: #95bad3; -fx-font-size: 14px;");
        usernameLabel.setTranslateX(37.5);
        usernameLabel.setTranslateY(110);

        javafx.scene.control.TextField usernameField = new javafx.scene.control.TextField();
        GridPane.setVgrow(usernameField, Priority.ALWAYS);
        GridPane.setHgrow(usernameField, Priority.ALWAYS);
        GridPane.setHalignment(usernameField, HPos.LEFT);
        GridPane.setValignment(usernameField, VPos.TOP);
        //usernameField.setText(this.panelManager.getLauncher().getFileManager().getConfig().get("username"));
        usernameField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5;");
        usernameField.setMaxWidth(325);
        usernameField.setMaxHeight(40);
        usernameField.setTranslateX(37.5);
        usernameField.setTranslateY(140);

        Separator usernameSeparator = new Separator();
        GridPane.setVgrow(usernameSeparator, Priority.ALWAYS);
        GridPane.setHgrow(usernameSeparator, Priority.ALWAYS);
        GridPane.setHalignment(usernameSeparator, HPos.CENTER);
        GridPane.setValignment(usernameSeparator, VPos.TOP);
        usernameSeparator.setTranslateY(181);
        usernameSeparator.setMaxWidth(325);
        usernameSeparator.setMinWidth(325);
        usernameSeparator.setMaxHeight(1);
        usernameSeparator.setMinHeight(1);
        usernameSeparator.setStyle("-fx-opacity: 40%");

        Label passwordLabel = new Label("Mot de passe");
        GridPane.setVgrow(passwordLabel, Priority.ALWAYS);
        GridPane.setHgrow(passwordLabel, Priority.ALWAYS);
        GridPane.setHalignment(passwordLabel, HPos.LEFT);
        GridPane.setValignment(passwordLabel, VPos.TOP);
        passwordLabel.setStyle("-fx-text-fill: #95bad3; -fx-font-size: 14px;");
        passwordLabel.setTranslateX(37.5);
        passwordLabel.setTranslateY(200);

        PasswordField passwordField = new PasswordField();
        GridPane.setVgrow(passwordField, Priority.ALWAYS);
        GridPane.setHgrow(passwordField, Priority.ALWAYS);
        GridPane.setHalignment(passwordField, HPos.LEFT);
        GridPane.setValignment(passwordField, VPos.TOP);
        //passwordField.setText(this.panelManager.getLauncher().getFileManager().getConfig().get("password"));
        passwordField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5;");
        passwordField.setMaxWidth(325);
        passwordField.setMaxHeight(40);
        passwordField.setTranslateX(37.5);
        passwordField.setTranslateY(230);

        Separator passwordSeparator = new Separator();
        GridPane.setVgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setHgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setHalignment(passwordSeparator, HPos.CENTER);
        GridPane.setValignment(passwordSeparator, VPos.TOP);
        passwordSeparator.setTranslateY(271);
        passwordSeparator.setMaxWidth(325);
        passwordSeparator.setMinWidth(325);
        passwordSeparator.setMaxHeight(1);
        passwordSeparator.setMinHeight(1);
        passwordSeparator.setStyle("-fx-opacity: 40%");

        Label forgotPasswordLabel = new Label("Mot de passe oublié ?");
        GridPane.setVgrow(forgotPasswordLabel, Priority.ALWAYS);
        GridPane.setHgrow(forgotPasswordLabel, Priority.ALWAYS);
        GridPane.setHalignment(forgotPasswordLabel, HPos.LEFT);
        GridPane.setValignment(forgotPasswordLabel, VPos.CENTER);
        forgotPasswordLabel.setStyle("-fx-text-fill: #69a7ed; -fx-font-size: 12px");
        forgotPasswordLabel.setUnderline(true);
        forgotPasswordLabel.setTranslateX(37.5);
        forgotPasswordLabel.setTranslateY(30);

        forgotPasswordLabel.setOnMouseEntered(e->{
            this.layout.setCursor(Cursor.HAND);
        });
        forgotPasswordLabel.setOnMouseExited(e->{
            this.layout.setCursor(Cursor.DEFAULT);
        });
        forgotPasswordLabel.setOnMouseClicked(e->{
            try {
                Desktop.getDesktop().browse(new URI("https://valkyria.fr/"));
            } catch (IOException | URISyntaxException ex) {
                Main.LOGGER.warn(ex.getMessage());
            }
        });

        javafx.scene.control.Button connectButton = new javafx.scene.control.Button("Se connecter");
        GridPane.setVgrow(connectButton, Priority.ALWAYS);
        GridPane.setHgrow(connectButton, Priority.ALWAYS);
        GridPane.setHalignment(connectButton, HPos.LEFT);
        GridPane.setValignment(connectButton, VPos.CENTER);
        connectButton.setTranslateX(37.5);
        connectButton.setTranslateY(80);
        connectButton.setMinWidth(325);
        connectButton.setMinHeight(50);
        connectButton.setStyle("-fx-background-color: #007dbe; -fx-border-radius: 0px; -fx-background-insets: 0; -fx-font-size: 14px; -fx-text-fill: white; ");
        connectButton.setOnMouseEntered(e->{
            this.layout.setCursor(Cursor.HAND);
        });
        connectButton.setOnMouseExited(e->{
            this.layout.setCursor(Cursor.DEFAULT);
        });
        connectButton.setOnMouseClicked(e->{
            panelManager.showPanel(panelManager.getHomePanel());
        });
        Separator chooseConnectSeparator = new Separator();
        GridPane.setVgrow(chooseConnectSeparator, Priority.ALWAYS);
        GridPane.setHgrow(chooseConnectSeparator, Priority.ALWAYS);
        GridPane.setHalignment(chooseConnectSeparator, HPos.CENTER);
        GridPane.setValignment(chooseConnectSeparator, VPos.CENTER);
        chooseConnectSeparator.setTranslateY(160);
        chooseConnectSeparator.setMaxWidth(325);
        chooseConnectSeparator.setMinWidth(325);
        chooseConnectSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 30%");

        javafx.scene.control.Button chooseConnexionLabel = new javafx.scene.control.Button("CONNEXION AVEC");
        GridPane.setVgrow(chooseConnexionLabel, Priority.ALWAYS);
        GridPane.setHgrow(chooseConnexionLabel, Priority.ALWAYS);
        GridPane.setHalignment(chooseConnexionLabel, HPos.CENTER);
        GridPane.setValignment(chooseConnexionLabel, VPos.CENTER);
        chooseConnexionLabel.setTranslateY(160);
        chooseConnexionLabel.setStyle("-fx-background-color: #181818; -fx-text-fill: #5e5e5e; -fx-font-size: 14px;");

        javafx.scene.image.Image logoImageValkyria = new Image(Main.class.getResource("/img/valkyria.png").toExternalForm());
        ImageView imageViewValkyria = new ImageView(logoImageValkyria);




        mainPane.getChildren().addAll(connectLabel, connectSeparator, usernameLabel, usernameField,usernameSeparator,passwordLabel,passwordField,
                passwordSeparator,forgotPasswordLabel,connectButton,chooseConnectSeparator,chooseConnexionLabel);

        this.layout.getChildren().add(loginPanel);

    }
}
