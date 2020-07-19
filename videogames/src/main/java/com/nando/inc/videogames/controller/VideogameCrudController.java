package com.nando.inc.videogames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Centralized controller class to manage videogames by CRUD.
 *
 * @author fernando.penaranda
 */
@Controller
public class VideogameCrudController {

    @RequestMapping("/videogames/add")
    public String showAddVideogameForm() {
        return "AddVideogameForm";
    }

}
