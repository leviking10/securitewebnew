package com.groupeisi.securiteweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 80, nullable = false)
    private String username;
    @Column(length = 80, nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Droit> appDroit = new ArrayList<Droit>();

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

    public List<Droit> getAppDroit() {
        return appDroit;
    }

    public void setAppDroit(List<Droit> appDroit) {
        this.appDroit = appDroit;
    }


}
