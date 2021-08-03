package com.ericmccullough.budgetapp.services.impl;

import com.ericmccullough.budgetapp.models.Envelope;
import com.ericmccullough.budgetapp.repositories.EnvelopeRepository;
import com.ericmccullough.budgetapp.services.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvelopeServiceImpl implements EnvelopeService {
    @Autowired
    private EnvelopeRepository envelopeRepository;

    @Override
    public void saveEnvelope(Envelope envelope) {
        envelopeRepository.save(envelope);
    }
}
