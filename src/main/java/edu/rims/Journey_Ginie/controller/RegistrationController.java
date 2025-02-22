package edu.rims.Journey_Ginie.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import edu.rims.Journey_Ginie.entity.User;
// import edu.rims.Journey_Ginie.repository.RegistrationplpRepository;

@Controller
public class RegistrationController {
     @GetMapping("/registrationplp")
     String fragmentRegistrationplp() {
        return "registrationplp";
    }
}


