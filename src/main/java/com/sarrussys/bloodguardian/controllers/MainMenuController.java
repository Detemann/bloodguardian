package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button btnEstoque;

    public void loadMainMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-Page.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,550,350);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }

    public void  onActionChangeToEstoquePage(ActionEvent event) {
        System.out.println("Estoque");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Estoque-page.fxml"));
            Parent pane = loader.load();
            Stage mainStage = new Stage();
            Scene mainScene = new Scene(pane,550,350);
            mainStage.setScene(mainScene);
            mainStage.setTitle("SGBS");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.currentStage(event).close();
    }
}
