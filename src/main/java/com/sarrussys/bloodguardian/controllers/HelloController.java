package com.sarrussys.bloodguardian.controllers;

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
            Doador doador = new Doador();
            doador.setCpf(123);
            doador.setNome("Lucas");
            doador.setTipoSanguineo(tipoSangueRepository.buscarPorNomeTipoSanguineo("A+"));
            doador.setEmail("email@email.com");
            doador.setTelefone("999999999");
            doador.setDtNascimento(new Date());

            // Salvando no banco de dados
            session.save(doador);
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