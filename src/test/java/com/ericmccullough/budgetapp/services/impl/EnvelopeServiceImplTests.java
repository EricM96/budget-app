package com.ericmccullough.budgetapp.services.impl;

import com.ericmccullough.budgetapp.models.Envelope;
import com.ericmccullough.budgetapp.repositories.EnvelopeRepository;
import com.ericmccullough.budgetapp.services.EnvelopeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EnvelopeServiceImplTests {
    @MockBean
    private EnvelopeRepository mockEnvelopeRepository;

    @Autowired
    private EnvelopeService envelopeService;

    @Test
    public void saveEnvelope_envelopeIsValid_shouldSaveEnvelope() {
        Envelope envelope = new Envelope();
        envelope.setName("TestName");
        envelope.setBalance(new BigDecimal("12.00"));
        when(mockEnvelopeRepository.save(envelope)).thenReturn(envelope);

        envelopeService.saveEnvelope(envelope);

        verify(mockEnvelopeRepository, times(1)).save(envelope);
    }

    @Test
    void getEnvelopes_callIsValid_shouldRetrieveEnvelopes() {
        List<Envelope> envelopes = new ArrayList<>();
        when(mockEnvelopeRepository.findAll()).thenReturn(envelopes);

        envelopeService.getEnvelopes();

        verify(mockEnvelopeRepository, times(1)).findAll();
    }
}
