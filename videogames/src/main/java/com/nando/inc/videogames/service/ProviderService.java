package com.nando.inc.videogames.service;

import com.nando.inc.videogames.domain.Provider;
import com.nando.inc.videogames.repositorty.IProviderRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Provider service class.
 *
 * @author fernando.penaranda
 */
@Service
public class ProviderService {

    private final IProviderRepository providerRepository;

    public ProviderService(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.getAllProviders();
    }

}
