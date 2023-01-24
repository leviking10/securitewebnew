package com.groupeisi.securiteweb.dto;

import java.util.ArrayList;
import java.util.List;

public class CompteDto {

    private int id;
    private String username;
    private String password;
    private List<String> appDroit = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAppDroit() {
        return appDroit;
    }

    public void setAppDroit(List<String> appDroit) {
        this.appDroit = appDroit;
    }


}
