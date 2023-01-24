package com.groupeisi.securiteweb.service;

import com.groupeisi.securiteweb.dto.CompteDto;
import com.groupeisi.securiteweb.dto.DroitDto;

import java.util.List;

public interface ICompteDto {
    /* public int add(CompteDto appDroitDto) {
        return appDroitdao.add(appDroitdao.appCompteDtoToAppCompteEntity(appDroitDto));
    }*/ boolean validate(String username, String password);

    public int add(CompteDto appCompteDto);
    public int delete(int id);
    public int update(CompteDto appCompteDto);
    public List<CompteDto> list();
    public CompteDto get(int id);
}
