package com.groupeisi.securiteweb.service;

import com.groupeisi.securiteweb.config.HibernateUtil;
import com.groupeisi.securiteweb.dao.CompteImpl;
import com.groupeisi.securiteweb.dto.CompteDto;
import com.groupeisi.securiteweb.entities.Compte;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompteDtoImpl implements ICompteDto {

    private static CompteImpl appDroitdao = new CompteImpl();
    @Override
   /* public int add(CompteDto appDroitDto) {
        return appDroitdao.add(appDroitdao.appCompteDtoToAppCompteEntity(appDroitDto));
    }*/
    public boolean validate(String username, String password) {

        Transaction transaction = null;
        Compte comptes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            comptes = (Compte) session.createQuery("FROM Compte c WHERE c.username = :username").setParameter("username", username)
                    .uniqueResult();

            if (comptes != null && comptes.getPassword().equals(password)) {
                return true;

            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("impssible "+e);
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int add(CompteDto appCompteDto) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(CompteDto appCompteDto) {
        return 0;
    }

    @Override
    public List<CompteDto> list() {
        return null;
    }

    @Override
    public CompteDto get(int id) {
        return null;
    }
    /*
    @Override
    public int delete(int id) {

        return appDroitdao.delete(id, new Compte());
    }
    
/*
    @Override
    public int update(CompteDto appCompteDto) {

        return appDroitdao.update(appDroitdao.appCompteDtoToAppCompteEntity(appCompteDto));
    }

    @Override
    public List<CompteDto> list() {
        List<CompteDto> appRoleDtos = new ArrayList<CompteDto>();
        appDroitdao.list(new Compte()).forEach(appCompte -> {

            appRoleDtos.add(appDroitdao.appCompteEntityToAppCompteDto(appCompte));
        });
        return appRoleDtos;
    }

    @Override
    public CompteDto get(int id) {

        return appDroitdao.appCompteEntityToAppCompteDto(appDroitdao.get(id, new Compte()));
    }*/
}
