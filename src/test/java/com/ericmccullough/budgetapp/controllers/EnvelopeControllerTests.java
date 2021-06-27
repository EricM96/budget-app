package com.ericmccullough.budgetapp.controllers;

import com.ericmccullough.budgetapp.repositories.EnvelopeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EnvelopeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvelopeRepository envelopeRepository;

    @Test
    public void createEnvelope_whenPayloadIsValid_shouldReturnOk() throws Exception {
        final String payload = "{ \"name\": \"newEnvelope\", \"balance\": \"2000.00\" }";

        mockMvc.perform(MockMvcRequestBuilders
            .post("/envelope")
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());
    }
}
