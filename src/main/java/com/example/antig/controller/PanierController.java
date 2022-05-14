package com.example.antig.controller;


import com.example.antig.data.Panier;
import com.example.antig.data.User;
import com.example.antig.repository.PanierRepository;
import com.example.antig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class PanierController {

    @Autowired private PanierRepository panierRepo;
    @Autowired private UserRepository userRepo;

    @GetMapping("/paniers")
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


        Iterable<Panier> listPanier = panierRepo.findByUser_IdUserIsNull();
        model.addAttribute("paniers",listPanier);

        return "list_paniers";
    }

    @GetMapping("/panier")
    public String panier(@RequestParam("id") int idPanier, Model model, Principal principal)
    {
        String principalMail = principal.getName();
        Optional<User> userConnected = userRepo.findByEmail(principalMail);
        Optional<Panier> panier = panierRepo.findById(idPanier);

        if (userConnected.isPresent()) {
            int id = userConnected.get().getIdUser();
            String prenom = userConnected.get().getPrenom();
            String nom = userConnected.get().getNom();
            String mail = userConnected.get().getEmail();

            model.addAttribute("prenom", prenom);
            model.addAttribute("nom", nom);
            model.addAttribute("mail", mail);
        }

        if(panier.isPresent()){
            String panierCategorie = panier.get().getCategorie().getNom();
            String panierLocalisation = panier.get().getLocalisation();
            String panierCommercant = panier.get().getCommercant().getNom();

            model.addAttribute("panierCategorie", panierCategorie);
            model.addAttribute("panierLocalisation", panierLocalisation);
            model.addAttribute("panierCommercant", panierCommercant);
        }


        model.addAttribute("panierId", idPanier);
        return "panier";
    }

    @GetMapping("/reserver")
    public String reserver(@RequestParam("id") int idPanier, Model model, Principal principal)
    {
        String principalMail = principal.getName();
        Optional<User> userConnected = userRepo.findByEmail(principalMail);
        Optional<Panier> panier = panierRepo.findById(idPanier);

        if (userConnected.isPresent()) {
            int id = userConnected.get().getIdUser();
            String prenom = userConnected.get().getPrenom();
            String nom = userConnected.get().getNom();
            String mail = userConnected.get().getEmail();

            model.addAttribute("prenom", prenom);
            model.addAttribute("nom", nom);
            model.addAttribute("mail", mail);
        }

        if(panier.isPresent()){
            panier.get().setUser(userConnected.get());
            panierRepo.save(panier.get());
        }

        return "panier_success";
    }
}