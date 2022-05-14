package com.example.antig.repository;

import com.example.antig.data.Categorie;
import com.example.antig.data.Panier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PanierRepository extends CrudRepository<Panier, Integer> {

    Optional<Panier> findByCategorie_Paniers_Categorie(Categorie categorie);

    List<Panier> findByUser_IdUserIsNull();





}