package com.ironhack.erp.providerservice.exception;


public class ProviderNotFoundException extends RuntimeException {
    public ProviderNotFoundException(String message) {
            super(message);
        }
}
