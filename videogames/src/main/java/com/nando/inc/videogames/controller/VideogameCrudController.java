package com.nando.inc.videogames.controller;

import com.nando.inc.videogames.domain.Provider;
import com.nando.inc.videogames.domain.Videogame;
import com.nando.inc.videogames.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Centralized controller class to manage videogames by CRUD.
 *
 * @author fernando.penaranda
 */
@Controller
public class VideogameCrudController {

    private final ProviderService providerService;

    public VideogameCrudController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @RequestMapping("/videogames/add")
    public String showAddVideogameForm(Model model) {
        model.addAttribute("allProviders", providerService.getAllProviders());
        //adds an empty Videogame object to manage data on the view
        model.addAttribute("videogameObject", new Videogame());

        return "AddVideogameForm";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Provider.class, providerService);
    }

    @PostMapping("/videogames/save")
    public String saveNewVideogame(Videogame videogame) {
        System.out.println(videogame);
        return "redirect:/";
    }

}
