package com.nando.inc.videogames.service;

import com.nando.inc.videogames.domain.Provider;
import com.nando.inc.videogames.repositorty.IProviderRepository;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Provider service class.
 *
 * @author fernando.penaranda
 */
@Service
public class ProviderService extends PropertyEditorSupport {

    private final IProviderRepository providerRepository;

    /**
     * ProviderService constructor which recieves a dependency of providerRepository.
     * 
     * @param providerRepository IProviderRepository instance to be set.
     */
    public ProviderService(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    /**
     * Gets all providers registred on DB.
     * 
     * @return List of all Provider objects.
     */
    public List<Provider> getAllProviders() {
        return providerRepository.getAllProviders();
    }

    /**
     * Get the Provider object given an ID.
     * 
     * @param text id field as String.
     * @throws IllegalArgumentException 
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Optional<Provider> provider = this.providerRepository.findById(Integer.parseInt(text));

        if (provider.isPresent()) {
            this.setValue(provider.get());
        }
    }

}
