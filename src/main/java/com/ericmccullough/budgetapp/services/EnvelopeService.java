package com.ericmccullough.budgetapp.services;

import com.ericmccullough.budgetapp.models.Envelope;

import java.util.List;

public interface EnvelopeService {

    /**
     * Creates and persists a new envelope
     * @param envelope Envelope to persist
     */
    void saveEnvelope(Envelope envelope);

    /**
     * Retrieves all envelopes from the envelope store
     * @return a collection of all envelopes
     */
    Iterable<Envelope> getEnvelopes();
}
