package com.ironhack.erp.providerservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.providerservice.model.entity.Provider;
import com.ironhack.erp.providerservice.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProviderControllerImplTest {

    @Autowired
    ProviderControllerImpl providerController;

    @MockBean
    ProviderRepository providerRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Provider provider;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        provider = new Provider("1223451B", "test@test", "test", "test", "test");


        when(providerRepository.findAll()).thenReturn(Arrays.asList(provider));
        when(providerRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(provider));
        when(providerRepository.save(provider)).thenReturn(provider);
    }


    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/providers")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/providers/1")).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/providers")
                .content(objectMapper.writeValueAsString(provider))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteProvider() throws Exception {
        mockMvc.perform(delete("/providers/1")).andExpect(status().isNoContent());
    }

}