package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.models.Saidas;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class SaidasRepository {
    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void salvar(Saidas saidas) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(saidas);
            transaction.commit();
        }
    }

    public void deletar(String codBolsa) {
        deletar(null, codBolsa);
    }
    /**
     *@description Método com sobrecarga, pode enviar tanto o objeto ou id
     * @Param Saidas saidas, String codBosla
     * **/
    public void deletar(Saidas saidas, String codBolsa) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            if(saidas != null) {
                session.delete(saidas);
            } else {
                saidas = session.get(Saidas.class, codBolsa);
                session.delete(saidas);
            }
            transaction.commit();
        }
    }

    public void update(Saidas saidas) {
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(saidas);
            transaction.commit();
        }
    }

    public Saidas buscarPorCodBolsa(String codBolsa) {
        try(Session session = getSession()) {
            return session.get(Saidas.class, codBolsa);
        }
    }

    public List<Saidas> buscarTodos() {
        try(Session session = getSession()) {
            String hql = "FROM Saidas";
            Query query = session.createQuery(hql, Saidas.class);
            return query.getResultList();
        }
    }
}
