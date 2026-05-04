package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.dto.UserDto;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userDto") UserDto dto,
                           BindingResult result,
                           RedirectAttributes ra) {
        if (result.hasErrors()) return "user/register";
        try {
            userService.register(dto);
            ra.addFlashAttribute("success", "Registration successful! Please login.");
            return "redirect:/users/login";
        } catch (RuntimeException e) {
            result.rejectValue("userEmail", "error", e.getMessage());
            return "user/register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() { return "user/login"; }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes ra) {
        try {
            User user = userService.login(email, password);
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/users/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";
        model.addAttribute("user", userService.getUserById(user.getUserId()));
        return "user/profile";
    }
}
