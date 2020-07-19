package com.nando.inc.videogames.repositorty;

import com.nando.inc.videogames.domain.Provider;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IProviderRepository extends JpaRepository<Provider, Integer>{
    
    @Query("from Provider  order by providerName")
    List<Provider> getAllProviders();
    
}
