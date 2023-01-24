package com.groupeisi.securiteweb.dto;

import java.util.ArrayList;
import java.util.List;

public class DroitDto {
    private int id;
    private String nom;
    private List<String> appComptes = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getAppComptes() {
        return appComptes;
    }

    public void setAppComptes(List<String> appComptes) {
        this.appComptes = appComptes;
    }
}
