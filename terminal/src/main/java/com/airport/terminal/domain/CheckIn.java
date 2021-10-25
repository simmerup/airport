package com.airport.terminal.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CheckIn {

    private Passenger passenger;
    private FlightDetails flightDetails;
    private Date checkInDate;    
}
