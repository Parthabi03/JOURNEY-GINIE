package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.service.DestinationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @GetMapping
    public String list(@RequestParam(required = false) String keyword,
                       @RequestParam(required = false) String country,
                       Model model) {
        if (keyword != null && !keyword.isBlank())
            model.addAttribute("destinations", destinationService.searchByKeyword(keyword));
        else if (country != null && !country.isBlank())
            model.addAttribute("destinations", destinationService.getByCountry(country));
        else
            model.addAttribute("destinations", destinationService.getAllDestinations());
        return "destination/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("destination", destinationService.getById(id));
        model.addAttribute("places", destinationService.getPlacesByDestination(id));
        return "destination/detail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("destination", new Destination());
        return "destination/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("destination") Destination dest,
                      BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) return "destination/add";
        destinationService.addDestination(dest);
        ra.addFlashAttribute("success", "Destination added!");
        return "redirect:/destinations";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("destination", destinationService.getById(id));
        return "destination/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("destination") Destination dest,
                         BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) return "destination/edit";
        destinationService.updateDestination(id, dest);
        ra.addFlashAttribute("success", "Destination updated!");
        return "redirect:/destinations";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes ra) {
        destinationService.deleteDestination(id);
        ra.addFlashAttribute("success", "Destination deleted!");
        return "redirect:/destinations";
    }
}
