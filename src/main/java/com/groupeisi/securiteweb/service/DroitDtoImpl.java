package com.groupeisi.securiteweb.service;

import com.groupeisi.securiteweb.dao.DroitImpl;
import com.groupeisi.securiteweb.dto.DroitDto;
import com.groupeisi.securiteweb.entities.Droit;

import java.util.ArrayList;
import java.util.List;

public class DroitDtoImpl implements IDroitDto {
    private DroitImpl appDroitdao = new DroitImpl();
    @Override
    public int add(DroitDto appDroitDto) {
        return appDroitdao.add(appDroitdao.appDroitDtoToAppDroitEntity(appDroitDto));
    }

    @Override
    public int delete(int id) {

        return appDroitdao.delete(id, new Droit());
    }

    @Override
    public int update(DroitDto appDroitDto) {

        return appDroitdao.update(appDroitdao.appDroitDtoToAppDroitEntity(appDroitDto));
    }

    @Override
    public List<DroitDto> list() {
        List<DroitDto> appRoleDtos = new ArrayList<DroitDto>();
        appDroitdao.list(new Droit()).forEach(appRole -> {

            appRoleDtos.add(appDroitdao.appDroitEntityToAppDroitDto(appRole));
        });
        return appRoleDtos;
    }

    @Override
    public DroitDto get(int id) {

        return appDroitdao.appDroitEntityToAppDroitDto(appDroitdao.get(id, new Droit()));
    }
}
