package com.ericmccullough.budgetapp.controllers;

import com.ericmccullough.budgetapp.models.Envelope;
import com.ericmccullough.budgetapp.repositories.EnvelopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/envelope")
public class EnvelopeController {
    @Autowired
    private EnvelopeRepository envelopeRepository;

    @PostMapping
    public Envelope createEnvelope(@RequestBody Envelope envelope) {
        envelopeRepository.save(envelope);

        return envelope;
    }
}
