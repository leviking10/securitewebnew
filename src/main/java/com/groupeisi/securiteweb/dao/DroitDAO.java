package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.config.HibernateUtil;
import com.groupeisi.securiteweb.dto.RepositoryDAO;
import com.groupeisi.securiteweb.entities.Droit;

import com.groupeisi.securiteweb.interfaces.Idroit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class DroitDAO extends RepositoryDAO<Droit> implements Idroit {

    public List<Droit> getAllDroit() {

        Transaction transaction = null;
        List < Droit > listOfDroit = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfDroit = session.createQuery("from Droit").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDroit;
    }
}
