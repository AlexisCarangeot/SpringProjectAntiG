package com.example.antig.controller;


import com.example.antig.data.Role;
import com.example.antig.data.User;
import com.example.antig.repository.RoleRepository;
import com.example.antig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthentificationController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @GetMapping("/login")
    public String login(){

        return "login_form";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Optional<Role> roleUser = roleRepo.findById(2);
        if(roleUser.isPresent()){
            user.setRole(roleUser.get());
        }

        userRepo.save(user);

        return "register_success";
    }

}