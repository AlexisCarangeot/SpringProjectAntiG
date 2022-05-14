package com.example.antig.repository;

import com.example.antig.data.Categorie;
import com.example.antig.data.Commercant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommercantRepository extends CrudRepository<Commercant, Integer> {
    List<Categorie> findByCategories_Commercants_Id(int id);






}