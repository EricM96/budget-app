package com.ericmccullough.budgetapp.controllers;

import com.ericmccullough.budgetapp.models.Envelope;
import com.ericmccullough.budgetapp.services.EnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path="/envelope")
public class EnvelopeController {
    @Autowired
    EnvelopeService envelopeService;

    @PostMapping
    public Envelope createEnvelope(@RequestBody Envelope envelope) throws ResponseStatusException {
        if (envelope.getName() == null || envelope.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Envelope name cannot be missing or blank");
        }
        envelopeService.saveEnvelope(envelope);

        return envelope;
    }
}
