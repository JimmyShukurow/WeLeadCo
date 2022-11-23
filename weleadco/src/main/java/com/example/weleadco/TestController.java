package com.example.weleadco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    private  TimeService timeService;
    @Autowired
    private  UploadService uploadService;


    @GetMapping("/time")
    public String getCurrentDateTime() {
        return timeService.gerCurrentDateAndTime();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        var result =uploadService.uploadImage(file);

        return ResponseEntity.ok(result);
    }

}
