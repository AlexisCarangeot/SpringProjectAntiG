package com.example.antig.controller;

import com.example.antig.data.Categorie;
import com.example.antig.data.Commercant;
import com.example.antig.data.Panier;
import com.example.antig.data.User;
import com.example.antig.repository.CommercantRepository;
import com.example.antig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CommercantController {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommercantRepository commercantRepo;

    @GetMapping("/commercants")
    public String listPaniers(Model model, Principal principal) {

        String principalMail = principal.getName();
        Optional<User> userConnected = userRepo.findByEmail(principalMail);

        if (userConnected.isPresent()) {
            int id = userConnected.get().getIdUser();
            String prenom = userConnected.get().getPrenom();
            String nom = userConnected.get().getNom();
            String mail = userConnected.get().getEmail();

            model.addAttribute("prenom", prenom);
            model.addAttribute("nom", nom);
            model.addAttribute("mail", mail);
        }


        Iterable<Commercant> listCommercant = commercantRepo.findAll();
        model.addAttribute("commercants",listCommercant);

        return "list_commercants";
    }
}
