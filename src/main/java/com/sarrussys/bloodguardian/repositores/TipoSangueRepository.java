package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class TipoSangueRepository {
    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public TipoSanguineo buscarPorNomeTipoSanguineo(String tipo) {
        try(Session session = getSession()) {
            String sql = "SELECT ts.* FROM tb_tipos_sanguineos ts WHERE ts.tipo_sanguineo = :tipo";
            Query query = session.createNativeQuery(sql, TipoSanguineo.class);
            query.setParameter("tipo", tipo);    //Pode ignorar esse erro acho que é bug da IDE
            return (TipoSanguineo) query.getSingleResult();
        }
    }

    public TipoSanguineo buscarPorId(int id) {
        try(Session session = getSession()) {
            return session.get(TipoSanguineo.class, id);
        }
    }

    public List<TipoSanguineo> buscarTodos() {
        try(Session session = getSession()) {
            String hql = "FROM TipoSanguineo";
            Query query = session.createQuery(hql, TipoSanguineo.class);
            return query.getResultList();
        }
    }
}
