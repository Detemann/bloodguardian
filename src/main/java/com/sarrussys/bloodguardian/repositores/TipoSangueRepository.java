package com.sarrussys.bloodguardian.repositores;

import com.sarrussys.bloodguardian.models.TipoSanguineo;
import com.sarrussys.bloodguardian.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class TipoSangueRepository {
    public TipoSanguineo buscarPorNomeTipoSanguineo(String tipo) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT ts.* FROM tb_tipos_sanguineos ts WHERE ts.tipo_sanguineo = :tipo";
            Query query = session.createNativeQuery(sql, TipoSanguineo.class);
            query.setParameter("tipo", tipo);    //Pode ignorar esse erro acho que é bug da IDE
            return (TipoSanguineo) query.getSingleResult();
        }
    }

    public void salvar(TipoSanguineo tipoSanguineo) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(tipoSanguineo);
            transaction.commit();
        }
    }
}
