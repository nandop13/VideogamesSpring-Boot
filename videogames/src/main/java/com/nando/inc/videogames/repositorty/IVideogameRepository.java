package com.nando.inc.videogames.repositorty;

import com.nando.inc.videogames.domain.Provider;
import com.nando.inc.videogames.domain.Videogame;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fernando.penaranda
 */
public interface IVideogameRepository extends JpaRepository<Videogame, Integer> {

    @Query("from Videogame")
    List<Videogame> getAllVideogames();

    //@Query("from Videogame videogame where videogame.provider.id = ?1")
    List<Videogame> findByProviderId(int providerId);

    //@Query("from Videogame videogame where videogame.videogameName like %?1%")
    List<Videogame> findByVideogameNameContaining(String nameToMatch);
    
}
