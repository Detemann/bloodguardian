package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Doador;
import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.repositores.TipoSangueRepository;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class HelloController {

    @FXML
    private Button salvarButton;

    @FXML
    protected void salvarNoBanco() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        TipoSangueRepository tipoSangueRepository = new TipoSangueRepository();

        try {
            transaction = session.beginTransaction();

            // Criando uma instância de Exemplo
            BolsaSangue bolsaSangue = new BolsaSangue();
            bolsaSangue.setCodigoBolsa(3215);
            bolsaSangue.setDtColeta(new Date("10/11/2023"));
            bolsaSangue.setValidade(new Date());
            bolsaSangue.setTipoSanguineo(tipoSangueRepository.buscarPorNomeTipoSanguineo("AB+"));

            // Salvando no banco de dados
            session.save(bolsaSangue);
            transaction.commit();

            System.out.println("Dado salvo no banco com sucesso!");
        } catch (Exception e) {
            // Tratamento de exceção durante a transação
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Fechando a sessão do Hibernate e fechando a janela
            session.close();
            Stage stage = (Stage) salvarButton.getScene().getWindow();
            stage.close();
        }
    }
}