package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Doador;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class DoadorRepository {
    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void salvar(Doador doador) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(doador);
            transaction.commit();
        }
    }

    public void deletar (String cpf) {
        deletar(null, cpf);
    }
    /**
     *@description Método com sobrecarga, pode enviar tanto o objeto ou id
     * @Param Doador doador, String cpf
     * **/
    public void deletar(Doador doador, String cpf) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            if(doador != null) {
                session.save(doador);
            } else {
                doador = session.get(Doador.class, cpf);
                session.delete(doador);
            }
            transaction.commit();
        }
    }

    public void update(Doador doador) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(doador);
            transaction.commit();
        }
    }

    public Doador buscarPorCpf(String cpf) {
        try(Session session = getSession()) {
            return session.get(Doador.class, cpf);
        }
    }

    public List<Doador> buscarTodos() {
        try(Session session = getSession()) {
            String hql = "FROM Doador";
            Query query = session.createQuery(hql, Doador.class);
            return query.getResultList();
        }
    }

    public List<BolsaSangue> buscarPorTipoSanguineo(String tipo) {
        try(Session session = getSession()) {
            String hql = "FROM Doador WHERE tipoSanguineo = :tipo";
            Query query = session.createQuery(hql, BolsaSangue.class);
            query.setParameter("tipo", tipo);
            return query.getResultList();
        }
    }
}
