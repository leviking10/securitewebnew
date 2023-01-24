package com.groupeisi.securiteweb.service;

import com.groupeisi.securiteweb.dto.DroitDto;

import java.util.List;

public interface IDroitDto {
    public int add(DroitDto appRoleDto);
    public int delete(int id);
    public int update(DroitDto appRoleDto);
    public List<DroitDto> list();
    public DroitDto get(int id);
}
