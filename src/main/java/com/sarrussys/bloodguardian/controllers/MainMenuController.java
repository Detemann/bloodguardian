package com.sarrussys.bloodguardian.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.util.Alerts;
import com.sarrussys.bloodguardian.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart; // Adicionado o BarChart no FXML

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



    private void fillBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        BolsaSangueRepository repository = new BolsaSangueRepository();

        // Adiciona dados diretamente
        series.getData().add(new XYChart.Data<>("A+", repository.quantidadeDeTipo(1)));
        series.getData().add(new XYChart.Data<>("A-", repository.quantidadeDeTipo(2)));
        series.getData().add(new XYChart.Data<>("B+", repository.quantidadeDeTipo(3)));
        series.getData().add(new XYChart.Data<>("B-", repository.quantidadeDeTipo(4)));
        series.getData().add(new XYChart.Data<>("AB+", repository.quantidadeDeTipo(5)));
        series.getData().add(new XYChart.Data<>("AB-", repository.quantidadeDeTipo(6)));
        series.getData().add(new XYChart.Data<>("O+", repository.quantidadeDeTipo(7)));
        series.getData().add(new XYChart.Data<>("O-", repository.quantidadeDeTipo(8)));

        // Define o título do gráfico
        barChart.setTitle("Estoque de Sangue");
        barChart.setLegendVisible(false);

        // Adiciona os dados ao gráfico
        barChart.getData().add(series);

        // Itera sobre os pontos de dados e define a cor com base na quantidade
        for (XYChart.Data<String, Number> data : series.getData()) {
            double value = data.getYValue().doubleValue();
            String colorStyle = getColorStyle(value);
            data.getNode().setStyle(colorStyle);
        }
    }

    private String getColorStyle(double value) {
        int maxQuantidade = 50; // Defina o valor máximo desejado para escala de cores

        // Calcule a escala com base na quantidade
        double scale = Math.min(value / maxQuantidade, 1.0);

        // Defina os intervalos de quantidade e seus tons correspondentes de vermelho
        int[][] intervalos = {
                {1, 10, 255},   // Intervalo 1-5: Vermelho claro (255)
                {11, 20, 200},  // Intervalo 6-11: Vermelho mais escuro (200)
                {21, 30, 150}, // Intervalo 12-17: Vermelho mais escuro ainda (150)
                {31, 40, 100}, // Intervalo 12-17: Vermelho mais escuro ainda (100)
                {41, 500, 50}, // Intervalo 12-17: Vermelho mais escuro ainda (50)
                // Adicione mais intervalos conforme necessário
        };

        // Encontre o intervalo correspondente
        int red = 0;
        for (int[] intervalo : intervalos) {
            int inicio = intervalo[0];
            int fim = intervalo[1];
            int tomVermelho = intervalo[2];

            if (value >= inicio && value <= fim) {
                red = tomVermelho;
                break;
            }
        }

        int green = 0; // Sempre zero para garantir a cor vermelha
        int blue = 0;  // Sem azul para garantir uma cor vermelha

        // Converta para formato hexadecimal
        String hexColor = String.format("#%02x%02x%02x", red, green, blue);

        // Defina a cor da barra no formato CSS
        return String.format("-fx-bar-fill: %s;", hexColor);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillBarChart();
    }
}
