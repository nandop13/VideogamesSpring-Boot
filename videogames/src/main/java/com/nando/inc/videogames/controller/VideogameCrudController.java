package com.nando.inc.videogames.controller;

import com.nando.inc.videogames.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        
        return "AddVideogameForm";
    }
    
}
