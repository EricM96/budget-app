package com.ericmccullough.budgetapp.repositories;

import com.ericmccullough.budgetapp.models.Envelope;
import org.springframework.data.repository.CrudRepository;

public interface EnvelopeRepository extends CrudRepository<Envelope, Integer> {

}
