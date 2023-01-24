package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.dto.CompteDto;
import com.groupeisi.securiteweb.entities.Compte;
import com.groupeisi.securiteweb.interfaces.Icompte;

import java.util.ArrayList;
import java.util.List;

public class CompteImpl extends RepositoryImpl<Compte> implements Icompte {
    @Override
    public Compte getByNom(String nom) {

        //return (AppUser) session.get(AppUser.class, email); //A revoir
        return (Compte) session.createQuery("FROM compte c WHERE c.username = :username")
                .setParameter("username", nom).uniqueResult();
    }

    /*public Compte appCompteDtoToAppCompteEntity (CompteDto appCompteDto) {

    }*/

    public CompteDto appCompteEntityToAppCompteDto(Compte appCompte) {
        CompteDto appCompteDto = new CompteDto();
        appCompteDto.setId(appCompte.getId());
        appCompteDto.setUsername(appCompte.getUsername());
        appCompteDto.setPassword(appCompte.getPassword());
        if (appCompte.getAppDroit() != null) {
            List<String> nomDroit = new ArrayList<String>();
            appCompte.getAppDroit().forEach(droits->{
                nomDroit.add(droits.getNom());
            });
            appCompteDto.setAppDroit(nomDroit);
        }

        return appCompteDto;
    }

}
