package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class BolsaSangueRepository {
    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void salvar(BolsaSangue bolsaSangue) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(bolsaSangue);
            transaction.commit();
        }
    }

    public void deletar(int id) {
        deletar(null , id);
    }
    /**
     *@description Método com sobrecarga, pode enviar tanto o objeto ou id
    * @Param BolsaSangue bolsaSangue, int id
    * **/
    public void deletar(BolsaSangue bolsaSangue, int id) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            if(bolsaSangue != null) {
                session.delete(bolsaSangue);
            } else {
                bolsaSangue = session.get(BolsaSangue.class, id);
                session.delete(bolsaSangue);
            }
            transaction.commit();
        }
    }

    public void update(BolsaSangue bolsaSangue) {
        try(Session session = getSession()) {
            Transaction transaction = session.getTransaction();
            session.update(bolsaSangue);
            transaction.commit();
        }
    }

    public BolsaSangue buscarPorId(String id) {
        try(Session session = getSession()) {
            return session.get(BolsaSangue.class, id);
        }
    }

    public List<BolsaSangue> buscarTodos() {
        try(Session session = getSession()) {
            String hql = "FROM BolsaSangue";
            Query query = session.createQuery(hql, BolsaSangue.class);
            return query.getResultList();
        }
    }

    public List<BolsaSangue> buscarPorTipoSanguineo(String idTipoSanguineo) {
        try (Session session = getSession()) {
            String hql = "FROM BolsaSangue WHERE tipoSanguineo.idTipoSanguineo = :idTipo";
            Query query = session.createQuery(hql, BolsaSangue.class);
            query.setParameter("idTipo", Integer.parseInt(idTipoSanguineo));
            return query.getResultList();
        }
    }
}
