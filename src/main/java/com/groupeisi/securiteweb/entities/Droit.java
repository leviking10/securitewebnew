package com.groupeisi.securiteweb.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Droit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(length = 80, nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "appDroit", fetch = FetchType.EAGER)
    private List<Compte> appComptes = new ArrayList<Compte>();

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

    public List<Compte> getAppComptes() {
        return appComptes;
    }
    public void setAppComptes(List<Compte> appComptes) {
        this.appComptes = appComptes;
    }
}
