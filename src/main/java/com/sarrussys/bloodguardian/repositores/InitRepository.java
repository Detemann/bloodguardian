package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InitRepository {
    public static void placeData() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<TipoSanguineo> list = List.of(new TipoSanguineo[]{
                    new TipoSanguineo(1, "A+"),
                    new TipoSanguineo(2, "A-"),
                    new TipoSanguineo(3, "B+"),
                    new TipoSanguineo(4, "B-"),
                    new TipoSanguineo(5, "AB+"),
                    new TipoSanguineo(6, "AB-"),
                    new TipoSanguineo(7, "O+"),
                    new TipoSanguineo(8, "O-")
            });
            list.forEach(session::save);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("[ERRO - InitRepository] Algo deu erro ao salvar os tipos sanguineos");
        }
    }
}
