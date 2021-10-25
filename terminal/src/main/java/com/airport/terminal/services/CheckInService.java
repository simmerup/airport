package com.airport.terminal.services;

import java.util.Date;

import javax.annotation.PostConstruct;

import com.airport.terminal.domain.CheckIn;
import com.airport.terminal.domain.FlightDetails;
import com.airport.terminal.domain.Passenger;
import com.airport.terminal.rabbitmq.CheckInMessageSender;
import com.airport.terminal.repository.CheckInRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckInService {
    
    @Autowired
    CheckInMessageSender checkInMessageSender;

    @Autowired
    CheckInRepo checkInRepo;
    
    /**
     * Put a new checkin object onto the queue every second to prove the service.
     */
    @Scheduled(fixedRate=1000)
    public void addCheckinsPeriodically() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("John");
        passenger.setFirstName("Rigby");

        FlightDetails flightDetails = new FlightDetails();
        flightDetails.setDestination("Copenhagen");
        flightDetails.setFlightCode("MH76");

        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInDate(new Date());
        checkIn.setPassenger(passenger);
        checkIn.setFlightDetails(flightDetails);                

        checkInMessageSender.send(checkIn);
    }    


    /**
     * Persist the passed in CheckIn object
     * @param checkIn The checkin object to persist
     */
    public void saveNewCheckin(CheckIn checkIn) {

        checkInRepo.save(checkIn);
    }
}
