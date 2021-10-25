package com.airport.terminal.rabbitmq;

import com.airport.terminal.domain.CheckIn;
import com.airport.terminal.services.CheckInService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CheckInListener {

    @Autowired
    CheckInService checkInService;
    
    /**
     * Listens for and saves new checkins received from the checkin queue.
     * @param checkIn The checkin object received
     */
    @RabbitListener(queues = "${airport.rabbitmq.queue}")
    public void receivedMessage(CheckIn checkIn) {
        log.info("Reading new check in event from the queue.");
        checkInService.saveNewCheckin(checkIn);
        log.info("Saved new check in event to Mongo.");
    }
}
