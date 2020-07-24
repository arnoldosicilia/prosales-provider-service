package com.ironhack.erp.providerservice.controller.interfaces;

import com.ironhack.erp.providerservice.exception.ProviderNotFoundException;
import com.ironhack.erp.providerservice.model.entity.Provider;

import java.util.List;

public interface ProviderControllerInterface {

    public List<Provider> findAll();
    public Provider findById(Long id);
    public Provider create(Provider provider);
    public void delete(Long id);

}
