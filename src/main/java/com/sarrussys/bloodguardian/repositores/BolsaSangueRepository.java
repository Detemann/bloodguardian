package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.BolsaSangue;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
