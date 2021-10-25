package com.airport.terminal.rabbitmq;

import com.airport.terminal.domain.CheckIn;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CheckInMessageSender {
            
    @Autowired
    private AmqpTemplate airportRabbitTemplate;
    
    @Value("${airport.rabbitmq.exchange}")
    private String exchange;
    
    /**
     * Send a checkin message to the checkin queue.
     * @param checkIn The checkin object to send.
     */
    public void send(CheckIn checkIn) {
        log.info("Sending new check in event to the queue.");
        airportRabbitTemplate.convertAndSend(exchange, "", checkIn);        
    }
}
