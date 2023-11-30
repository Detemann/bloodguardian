package com.sarrussys.bloodguardian.controllers;
import java.io.IOException;

import com.sarrussys.bloodguardian.util.Alerts;
import com.sarrussys.bloodguardian.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private Button btnEstoque;

    public void loadMainMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-Page.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,800,600);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }

    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = LoginPageController.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }

    public void  onActionChangeToEstoquePage(ActionEvent event) {
        System.out.println("Estoque");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Estoque-page.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,800,600);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }

    public void onActionChangeToSaidaPage(ActionEvent event) {
        System.out.println("Saida");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Saidas.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,800,600);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }
    
    public void onActionChangeToCadBolsas(ActionEvent event) {
        System.out.println("Saida");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastroBolsas.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,800,600);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }
    public void onActionChangeToCadSaidas(ActionEvent event) {
        System.out.println("Saida");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastroSaidas.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,800,600);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }
}
