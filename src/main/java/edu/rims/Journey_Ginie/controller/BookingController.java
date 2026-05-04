package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.dto.BookingDto;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.service.BookingService;
import edu.rims.Journey_Ginie.service.DestinationService;
import edu.rims.Journey_Ginie.service.TourService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final TourService tourService;
    private final DestinationService destinationService;

    @GetMapping
    public String myBookings(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";
        model.addAttribute("bookings", bookingService.getBookingsByUser(user.getUserId()));
        return "booking/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("bookingDto", new BookingDto());
        model.addAttribute("tours", tourService.getAllTours());
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "booking/create";
    }

    @PostMapping("/create")
    public String createBooking(@Valid @ModelAttribute("bookingDto") BookingDto dto,
                                BindingResult result,
                                HttpSession session,
                                RedirectAttributes ra) {
        if (result.hasErrors()) return "booking/create";
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";
        bookingService.createBooking(user.getUserId(), dto);
        ra.addFlashAttribute("success", "Booking created successfully!");
        return "redirect:/bookings";
    }

    @GetMapping("/{id}")
    public String viewBooking(@PathVariable String id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "booking/detail";
    }

    @PostMapping("/cancel/{id}")
    public String cancel(@PathVariable String id, RedirectAttributes ra) {
        bookingService.cancelBooking(id);
        ra.addFlashAttribute("success", "Booking cancelled.");
        return "redirect:/bookings";
    }
}
