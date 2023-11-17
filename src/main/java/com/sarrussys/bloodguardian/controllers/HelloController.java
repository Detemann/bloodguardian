package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Doador;
import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.TipoSangueRepository;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

// CLASSE EXEMPLO
public class HelloController {

    @FXML
    private Button salvarButton;

    @FXML
    protected void salvarNoBanco() {
        BolsaSangueRepository bolsaSangueRepository = new BolsaSangueRepository();
        TipoSangueRepository tipoSangueRepository = new TipoSangueRepository();

        // Criando uma instância de Exemplo
        BolsaSangue bolsaSangue = new BolsaSangue();
        bolsaSangue.setCodigoBolsa("A999912123456");
        bolsaSangue.setDtColeta(new Date("10/11/2023"));
        bolsaSangue.setValidade(new Date());
        bolsaSangue.setTipoSanguineo(tipoSangueRepository.buscarPorNomeTipoSanguineo("AB+"));

        // Salvando no banco de dados
        bolsaSangueRepository.salvar(bolsaSangue);
        System.out.println("Dado salvo no banco com sucesso!");
    }
}