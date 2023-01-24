package com.groupeisi.securiteweb.dao;

import com.groupeisi.securiteweb.dto.DroitDto;
import com.groupeisi.securiteweb.entities.Compte;
import com.groupeisi.securiteweb.entities.Droit;
import com.groupeisi.securiteweb.interfaces.Idroit;

import java.util.ArrayList;
import java.util.List;

public class DroitImpl extends RepositoryImpl<Droit> implements Idroit {


    public  Droit getByNom(String nom) {

        return (Droit) session.createQuery("FROM AppRole role WHERE role.nom = :role_nom")
                .setParameter("role_nom", nom).uniqueResult();
    }

    public Droit appDroitDtoToAppDroitEntity (DroitDto appRoleDto) {
        Droit appRole = new Droit();
        appRole.setId(appRoleDto.getId());
        appRole.setNom(appRoleDto.getNom());
        if (appRoleDto.getAppComptes() != null) {
            List<Compte> appUsers = new ArrayList<Compte>();
            appRoleDto.getAppComptes().forEach(nom->{
                Compte appUser = new CompteImpl().getByNom(nom);
                appUsers.add(appUser);
            });
            appRole.setAppComptes(appUsers);
        }

        return appRole;
    }

    public DroitDto appDroitEntityToAppDroitDto (Droit appRole) {
        DroitDto appRoleDto = new  DroitDto();
        appRoleDto.setId(appRole.getId());
        appRoleDto.setNom(appRole.getNom());
        if (appRole.getAppComptes()!= null) {
            List<String> nomUsers = new ArrayList<String>();
            appRole.getAppComptes().forEach(compte->{
                nomUsers.add(compte.getUsername());
            });
            appRoleDto.setAppComptes(nomUsers);
        }
        return appRoleDto;
    }
}
