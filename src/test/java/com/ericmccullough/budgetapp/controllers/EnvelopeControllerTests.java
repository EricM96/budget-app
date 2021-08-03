package com.ericmccullough.budgetapp.controllers;

import com.ericmccullough.budgetapp.services.EnvelopeService;
import com.ericmccullough.budgetapp.models.Envelope;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EnvelopeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvelopeService mockEnvelopeService;

    @Test
    public void createEnvelope_whenPayloadIsValid_shouldReturnOk() throws Exception {
        final String payload = "{ \"name\": \"newEnvelope\", \"balance\": \"2000.00\" }";
        doNothing().when(mockEnvelopeService).saveEnvelope(isA(Envelope.class));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isOk());
        Mockito.verify(mockEnvelopeService, times(1)).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void createEnvelope_whenPayloadIsMissing_shouldReturnBadRequest() throws Exception {
        final String payload = "";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isBadRequest());
        Mockito.verify(mockEnvelopeService, times(0)).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void createEnvelope_whenPayloadIsMissingName_shouldReturnBadRequest() throws Exception {
        final String payload = "{ \"balance\": \"2000.00\" }";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isBadRequest());
        Mockito.verify(mockEnvelopeService, never()).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void createEnvelope_whenPayloadHasEmptyName_shouldReturnBadRequest() throws Exception {
        final String payload = "{ \"name\": \"\", \"balance\": \"2000.00\" }";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isBadRequest());
        Mockito.verify(mockEnvelopeService, never()).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void createEnvelope_whenPayloadHasBlankName_shouldReturnBadRequest() throws Exception {
        final String payload = "{ \"name\": \"       \", \"balance\": \"2000.00\" }";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isBadRequest());
        Mockito.verify(mockEnvelopeService, never()).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void createEnvelope_whenPayloadIsMissingBalance_shouldHaveBalanceOfZero() throws Exception {
        final String payload = "{ \"name\": \"newEnvelope\" }";
        doNothing().when(mockEnvelopeService).saveEnvelope(isA(Envelope.class));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/envelope")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value("0"));
        Mockito.verify(mockEnvelopeService, times(1)).saveEnvelope(any(Envelope.class));
    }

    @Test
    public void getEnvelopes_whenRequestIsValid_shouldReturnOk() throws Exception {
        List<Envelope> envelopes = new ArrayList<>();
        when(mockEnvelopeService.getEnvelopes()).thenReturn(envelopes);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/envelope")
        ).andExpect(status().isOk());
        Mockito.verify(mockEnvelopeService, times(1)).getEnvelopes();
    }
}
