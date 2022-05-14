package com.example.antig.data;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role role;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_panier")
    private List<Panier> listPanier;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Panier> getListPanier() {
        return listPanier;
    }

    public void setListPanier(List<Panier> listPanier) {
        this.listPanier = listPanier;
    }
}