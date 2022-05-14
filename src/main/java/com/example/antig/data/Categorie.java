package com.example.antig.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private int id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "id_produit")
    private List<Panier> paniers = new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "commercant_has_categorie",
            joinColumns = @JoinColumn(name = "id_categorie"),
            inverseJoinColumns = @JoinColumn(name = "id_commercant")
    )
    private List<Commercant> commercants = new ArrayList<>();

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

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }

    public List<Commercant> getCommercants() {
        return commercants;
    }

    public void setCommercants(List<Commercant> commercants) {
        this.commercants = commercants;
    }
}
