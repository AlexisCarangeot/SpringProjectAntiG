package com.example.antig.controller;

import com.example.antig.data.Commercant;
import com.example.antig.data.Panier;
import com.example.antig.data.User;
import com.example.antig.repository.CommercantRepository;
import com.example.antig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CommercantRepository commercantRepo;

    @GetMapping("/admin")
    public String admin(Model model, Principal principal){
        String principalMail = principal.getName();
        Optional<User> userConnected = userRepo.findByEmail(principalMail);

        if (userConnected.isPresent()) {
            int id = userConnected.get().getIdUser();
            String prenom = userConnected.get().getPrenom();
            String nom = userConnected.get().getNom();
            String mail = userConnected.get().getEmail();
            int idRole = userConnected.get().getRole().getIdRole();

            model.addAttribute("prenom", prenom);
            model.addAttribute("nom", nom);
            model.addAttribute("mail", mail);
            model.addAttribute("idRole", idRole);
        }

        Iterable<Commercant> listCommercant = commercantRepo.findAll();
        model.addAttribute("commercants",listCommercant);

        return "admin";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int idCommercant,  Model model, Principal principal){

        Optional<Commercant> commercant = commercantRepo.findById(idCommercant);

        if(commercant.isPresent()){
        }

        return "home";
    }

    @GetMapping("/formcommercant")
    public String formcommercant(Model model, Principal principal){

        String principalMail = principal.getName();
        Optional<User> userConnected = userRepo.findByEmail(principalMail);

        if (userConnected.isPresent()) {
            int id = userConnected.get().getIdUser();
            String prenom = userConnected.get().getPrenom();
            String nom = userConnected.get().getNom();
            String mail = userConnected.get().getEmail();
            int idRole = userConnected.get().getRole().getIdRole();

            model.addAttribute("prenom", prenom);
            model.addAttribute("nom", nom);
            model.addAttribute("mail", mail);
            model.addAttribute("idRole", idRole);
        }

        return "add_commercant";
    }

    @GetMapping("/addcommercant")
    public String addcommercant(Model model, Principal principal, @RequestParam("nom") String nom, @RequestParam("localisation") String localisation){



        return "admin";
    }
}
