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

    public ProviderService(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.getAllProviders();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Optional<Provider> provider = this.providerRepository.findById(Integer.parseInt(text));

        this.setValue(provider.get());
    }

}
