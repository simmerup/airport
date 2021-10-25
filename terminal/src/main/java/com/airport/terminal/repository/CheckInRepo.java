package com.airport.terminal.repository;

import com.airport.terminal.domain.CheckIn;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CheckInRepo extends MongoRepository<CheckIn, String> {

    @Query(value = "{ 'passenger.firstName' : ?1 }", fields = "{ 'passenger.firstName' : 1 }")
    public CheckIn findByFirstName(String firstName);
}
