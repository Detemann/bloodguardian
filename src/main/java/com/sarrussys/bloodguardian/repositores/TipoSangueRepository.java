package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TipoSangueRepository {
    public TipoSanguineo buscarPorNomeTipoSanguineo(String tipo) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT ts.* FROM tb_tipo_sanguineo ts WHERE ts.tipo_sanguineo = :tipo";
            Query query = session.createNativeQuery(sql, TipoSanguineo.class);
            query.setParameter("tipo", tipo);
            return (TipoSanguineo) query.getSingleResult();
        }
    }
}
