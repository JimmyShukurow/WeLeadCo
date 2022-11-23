package com.example.weleadco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TimeServiceTest {
    private TimeService timeService;

    @BeforeEach
    void setUp() {
        timeService = new TimeService();

    }

    @Test
    void gerCurrentDateAndTime() {
        //given
        var currentTimestamp = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        //when
        var expectedFormattedCurrentTimestamp = formatter.format(currentTimestamp);

        var actualCurrentTimestamp =  timeService.gerCurrentDateAndTime();

        //then

        assertThat(actualCurrentTimestamp).isEqualTo(expectedFormattedCurrentTimestamp);

    }
}
