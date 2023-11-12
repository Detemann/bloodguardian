package com.sarrussys.bloodguardian.controllers;

import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HelloController {
    @FXML
    private Button salvarButton;

    @FXML
    protected void salvarNoBanco() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Criando uma instância de Exemplo
            TipoSanguineo exemplo = new TipoSanguineo();
            exemplo.setTipoSanguineo("Exemplo de Dado");

            // Salvando no banco de dados
            session.save(exemplo);
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