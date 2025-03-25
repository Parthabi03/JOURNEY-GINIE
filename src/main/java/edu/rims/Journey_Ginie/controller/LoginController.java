package edu.rims.Journey_Ginie.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.Journey_Ginie.constant.UserRole;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.UserRepository;

@Controller
public class LoginController {

     @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder encoder;

    @GetMapping("/customer/login")
    String fragmentLogin() {
        return "customer/login";
    }

    //  @PostMapping("/customer/sign-up")
    // public String signUp(@ModelAttribute User user) {

        // user.setCreatedDate(LocalDateTime.now());
        // user.setUpdatedDate(LocalDateTime.now());
        // user.setCreatedBy("user");
        // user.setUpdatedBy("user");
        // user.setPassword(encoder.encode(user.getPassword()));
        // user.setRole(UserRole.CUSTOMER);
    //     userRepository.save(user);
    //     return "redirect:/customer/login";
    // }
}

