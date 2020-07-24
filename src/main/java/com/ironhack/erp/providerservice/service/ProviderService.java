package com.ironhack.erp.providerservice.service;

import com.ironhack.erp.providerservice.exception.ProviderNotFoundException;
import com.ironhack.erp.providerservice.model.entity.Provider;
import com.ironhack.erp.providerservice.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> findAll(){ return providerRepository.findAll();}
    public Provider findById(Long id){ return providerRepository.findById(id).orElseThrow(()-> new ProviderNotFoundException("Provider with id: " + id + " not found"));}
    public Provider create(Provider provider){ return providerRepository.save(provider);}
    public void delete(Long id){ providerRepository.deleteById(id);}

}
