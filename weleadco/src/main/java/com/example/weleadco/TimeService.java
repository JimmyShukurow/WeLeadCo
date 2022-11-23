package com.example.weleadco;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Service
@NoArgsConstructor
public class TimeService {

    public String gerCurrentDateAndTime() {
        var currentTimestamp = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return formatter.format(currentTimestamp);
    }

}
