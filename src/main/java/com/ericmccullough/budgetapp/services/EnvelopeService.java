package com.ericmccullough.budgetapp.services;

import com.ericmccullough.budgetapp.models.Envelope;

public interface EnvelopeService {

    /**
     * Creates and persists a new envelope
     * @param envelope Envelope to persist
     */
    void saveEnvelope(Envelope envelope);
}
