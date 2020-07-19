package com.nando.inc.videogames.service;

import com.nando.inc.videogames.domain.Videogame;
import com.nando.inc.videogames.repositorty.IVideogameRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Videogame service class.
 *
 * @author fernando.penaranda
 */
@Service
public class VideogameService {

    private final IVideogameRepository videogameRepository;

    public VideogameService(IVideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    /**
     * Obtains the highlighted Videogames.
     *
     * @return List which contains Videogames.
     */
    public List<Videogame> listHighlightedVideogames() {
        return videogameRepository.getAllVideogames();
    }

    /**
     * Gets the videogame list depending on ID provider given.
     *
     * @param providerId provider ID to look for
     * @return List which contain the videogames which match the criterion.
     */
    public List<Videogame> listVideogameProvider(int providerId) {
        return videogameRepository.findByProviderId(providerId);
    }

    /**
     * Finds the videogame by matching the string given.
     *
     * @param nameToMatch String to match.
     * @return List of Videogame which match the criterion.
     */
    public List<Videogame> findByVideogameNameContaining(String nameToMatch) {
        return videogameRepository.findByVideogameNameContaining(nameToMatch);
    }
    
}
