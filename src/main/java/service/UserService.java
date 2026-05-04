package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.dto.UserDto;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(UserDto dto) {
        if (userRepository.existsByUserEmail(dto.getUserEmail()))
            throw new RuntimeException("Email already registered!");

        User user = User.builder()
                .userName(dto.getUserName())
                .userEmail(dto.getUserEmail())
                .userPassword(dto.getUserPassword()) // ⚠️ Hash in production
                .userPhoneNumber(dto.getUserPhoneNumber())
                .userAdharcard(dto.getUserAdharcard())
                .userGender(dto.getUserGender())
                .userImageUrl(dto.getUserImageUrl())
                .createdBy("system")
                .updatedBy("system")
                .build();
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("No account found with this email."));
        if (!user.getUserPassword().equals(password))
            throw new RuntimeException("Incorrect password.");
        return user;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Integer id, UserDto dto) {
        User user = getUserById(id);
        user.setUserName(dto.getUserName());
        user.setUserPhoneNumber(dto.getUserPhoneNumber());
        user.setUserGender(dto.getUserGender());
        user.setUserImageUrl(dto.getUserImageUrl());
        user.setUpdatedBy("system");
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
