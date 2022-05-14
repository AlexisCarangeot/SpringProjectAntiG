package com.example.antig.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commercant")
public class Commercant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commercant")
    private int id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name ="localisation" ,nullable = false, length = 255)
    private String localisation;

    @ManyToMany(
            mappedBy = "commercants",
            cascade = CascadeType.ALL
    )
    private List<Categorie> categories = new ArrayList<>();

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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
