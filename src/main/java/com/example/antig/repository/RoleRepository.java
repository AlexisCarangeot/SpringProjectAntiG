package com.example.antig.repository;


import com.example.antig.data.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByNom(String nom);







}