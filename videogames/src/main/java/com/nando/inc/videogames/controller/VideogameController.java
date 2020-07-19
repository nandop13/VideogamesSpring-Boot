package com.nando.inc.videogames.controller;

import com.nando.inc.videogames.domain.Videogame;
import com.nando.inc.videogames.service.VideogameService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Centralized Videogames controller.
 *
 * @author fernando.penaranda
 */
@Controller
public class VideogameController {
    
    private final VideogameService videogameService ;

    /**
     * Instances a new VideogameController including the VideogameService dependency.
     * 
     * @param videogameService VideogameService dependency.
     */
    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }
    
    /**
     * Lists all Videogames by requesting them to the Videogame service.
     *
     * @param model Object which allows to bridge the data to the view.
     * 
     * @return String which contains what is passed to the model. 
     */
    @RequestMapping("/")
    public String listVideogames(Model model)
    {
        final List<Videogame> highlightedVideogames = videogameService.listHighlightedVideogames();
        model.addAttribute("highlightedVideogames", highlightedVideogames);
        
        return "VideogamesList";
    }
    
    /**
     * Lists Videogames by provider, requesting them to the Videogame service.
     *
     * @param providerId int which represents the provider id.
     * @param model Object which allows to bridge the data to the view.
     * 
     * @return String which contains what is passed to the model. 
     */
    @RequestMapping("/videogamesByProvider")
    public String listVideogameByProvider(int providerId, Model model)
    {
        final List<Videogame> videogamesByProvider = videogameService.listVideogameProvider(providerId);
        model.addAttribute("highlightedVideogames", videogamesByProvider);
        
        return "VideogamesList";
    }
    
    /**
     * Lists Videogames which match with the name passed and requesting them to the Videogame service.
     *
     * @param nameToMatch Strig which contains the name of the videogame to match.
     * @param model Object which allows to bridge the data to the view.
     * 
     * @return String which contains what is passed to the model. 
     */
    @RequestMapping("/videogamesByName")
    public String listVideogameByName(@RequestParam("q") String nameToMatch, Model model)
    {
        final List<Videogame> videogamesByName = videogameService.findByVideogameNameContaining(nameToMatch);
        model.addAttribute("highlightedVideogames", videogamesByName);
        
        return "VideogamesList";
    }
    
}
