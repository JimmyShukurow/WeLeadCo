package com.example.weleadco;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeService timeService;
    @MockBean
    private UploadService uploadService;

    @Test
    void shouldGetCurrentDateTime() throws Exception {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        var currentTime = formatter.format(OffsetDateTime.now());
        //when
        when(timeService.gerCurrentDateAndTime()).thenReturn(currentTime);

        //then
        mockMvc
                .perform(get("/time"))
                .andExpect(content().string(currentTime))
                .andExpect(status().isOk());
    }


}