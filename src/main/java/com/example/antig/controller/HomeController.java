package com.example.antig.controller;


import com.example.antig.data.User;
import com.example.antig.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {

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


        return "home";
    }
}