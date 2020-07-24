package com.ironhack.erp.providerservice.controller.impl;

import com.ironhack.erp.providerservice.controller.interfaces.ProviderControllerInterface;
import com.ironhack.erp.providerservice.model.entity.Provider;
import com.ironhack.erp.providerservice.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProviderControllerImpl implements ProviderControllerInterface {

    @Autowired
    ProviderService providerService;

    @GetMapping("/providers")
    public List<Provider> findAll() {
        return providerService.findAll();
    }

    @GetMapping("/providers/{id}")
    public Provider findById(@PathVariable Long id) {
        return providerService.findById(id);
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public Provider create(@RequestBody Provider provider) {
        return providerService.create(provider);
    }

    @DeleteMapping("/providers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        providerService.delete(id);
    }
}
