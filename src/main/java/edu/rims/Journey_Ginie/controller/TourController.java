package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.entity.User;
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
@RequestMapping("/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @GetMapping
    public String list(@RequestParam(required = false) String destination,
                       @RequestParam(required = false) Double maxPrice,
                       Model model) {
        if (destination != null && !destination.isBlank())
            model.addAttribute("tours", tourService.searchByDestination(destination));
        else if (maxPrice != null)
            model.addAttribute("tours", tourService.getByMaxPrice(maxPrice));
        else
            model.addAttribute("tours", tourService.getAllTours());
        return "tour/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        model.addAttribute("packages", tourService.getPackagesByTour(id));
        return "tour/detail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tour", new Tour());
        return "tour/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("tour") Tour tour,
                      BindingResult result,
                      HttpSession session,
                      RedirectAttributes ra) {
        if (result.hasErrors()) return "tour/add";
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";
        tourService.addTour(tour, user.getUserId());
        ra.addFlashAttribute("success", "Tour added successfully!");
        return "redirect:/tours";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "tour/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("tour") Tour tour,
                         BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) return "tour/edit";
        tourService.updateTour(id, tour);
        ra.addFlashAttribute("success", "Tour updated!");
        return "redirect:/tours";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes ra) {
        tourService.deleteTour(id);
        ra.addFlashAttribute("success", "Tour deleted!");
        return "redirect:/tours";
    }
}
