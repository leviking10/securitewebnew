package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.config.HibernateUtil;
import com.groupeisi.securiteweb.entities.Compte;
import org.hibernate.Session;

import java.util.List;

import org.hibernate.Transaction;

public class CompteDao  {

    /**
     * Save User
     *
     * @param compte
     * @return
     */
    public int saveCompte(Compte compte) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(compte);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Update User
     * @param compte
     */
    public void updateCompte(Compte compte) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(compte);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete User
     * @param id
     */
    public static void deleteCompte(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Compte Compte = session.get(Compte.class, id);
            if (Compte != null) {
                session.delete(Compte);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public Compte getCompte(int id) {

        Transaction transaction = null;
        Compte compte = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            compte = session.get(Compte.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return compte;
    }

    /**
     * Get all Users
     * @return
     */

    public List < Compte > getAllCompte() {

        Transaction transaction = null;
        List < Compte > listOfCompte = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfCompte = session.createQuery("from Compte").getResultList();

            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCompte;
    }


}

