package edu.rims.Journey_Ginie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.UserRepository;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long getId(String email) {
        return userRepository.findByEmail(email).orElseThrow().getId();
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

}
    

