package com.sarrussys.bloodguardian;

import com.sarrussys.bloodguardian.repositores.InitRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        InitRepository.placeData();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage.setTitle("Exemplo JavaFX + Hibernate + PostgreSQL");
            stage.setScene(new Scene(root, 300, 250));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}