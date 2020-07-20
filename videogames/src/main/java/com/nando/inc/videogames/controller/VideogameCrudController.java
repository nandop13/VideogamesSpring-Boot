package com.nando.inc.videogames.controller;

import com.nando.inc.videogames.domain.Provider;
import com.nando.inc.videogames.domain.Videogame;
import com.nando.inc.videogames.service.ProviderService;
import com.nando.inc.videogames.service.VideogameService;
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
    private final VideogameService videogameService;

    public VideogameCrudController(ProviderService providerService, VideogameService videogameService) {
        this.providerService = providerService;
        this.videogameService = videogameService;
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
        videogameService.saveVideogame(videogame);
        return "redirect:/";
    }

}
