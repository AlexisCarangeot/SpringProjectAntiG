package com.example.antig.data;

import javax.persistence.*;

@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_panier")
    private int id;


    @Column(name ="localisation" ,nullable = false, length = 255)
    private String localisation;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="id_categorie")
    private Categorie categorie;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="id_user")
    private User user;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="id_commercant")
    private Commercant commercant;


    public int getId() {
        return id;
    }

    public String getIdString(){
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Commercant getCommercant() {
        return commercant;
    }

    public void setCommercant(Commercant commercant) {
        this.commercant = commercant;
    }
}
