package com.airport.terminal.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import com.airport.terminal.domain.CheckIn;
import com.airport.terminal.rabbitmq.CheckInMessageSender;
import com.airport.terminal.repository.CheckInRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
public class CheckInServiceTest {
    
    @MockBean
    CheckInMessageSender checkInMessageSender;

    @MockBean
    CheckInRepo checkInRepo;

    @Autowired
    CheckInService checkInService;

    @Test
    public void testSaveNewCheckIn() {
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInDate(new Date());

        checkInService.saveNewCheckin(checkIn);
        verify(checkInRepo, times(1)).save(checkIn);   
    }
}
