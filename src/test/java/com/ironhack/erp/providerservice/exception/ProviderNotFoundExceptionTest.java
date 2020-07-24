package com.ironhack.erp.providerservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProviderNotFoundExceptionTest {

    @Test
    void assertThrows() {
        new ProviderNotFoundException(null);
    }
}