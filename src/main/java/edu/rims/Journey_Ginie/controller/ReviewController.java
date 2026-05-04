package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.dto.ReviewDto;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/tour/{tourId}")
    public String tourReviews(@PathVariable String tourId, Model model) {
        model.addAttribute("reviews", reviewService.getReviewsByTour(tourId));
        model.addAttribute("tourId", tourId);
        model.addAttribute("reviewDto", new ReviewDto());
        return "review/list";
    }

    @PostMapping("/add")
    public String addReview(@Valid @ModelAttribute("reviewDto") ReviewDto dto,
                            BindingResult result,
                            HttpSession session,
                            RedirectAttributes ra) {
        if (result.hasErrors()) {
            ra.addFlashAttribute("error", "Invalid review data.");
            return "redirect:/reviews/tour/" + dto.getTourId();
        }
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";
        reviewService.addReview(user.getUserId(), dto);
        ra.addFlashAttribute("success", "Review submitted!");
        return "redirect:/reviews/tour/" + dto.getTourId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        reviewService.deleteReview(id);
        ra.addFlashAttribute("success", "Review deleted.");
        return "redirect:/tours";
    }
}
