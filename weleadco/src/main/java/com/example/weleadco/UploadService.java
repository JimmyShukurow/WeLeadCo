package com.example.weleadco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
@Slf4j
public class UploadService {
    private final String FOLDER_PATH = System.getProperty("user.dir") + "/src/main/resources/files/";

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        log.info(file.getOriginalFilename());
        var filePath = FOLDER_PATH + file.getOriginalFilename();
        var entity = new ImageEntity();
        entity.setPath(filePath);
        imageRepository.save(entity);
        file.transferTo(new File(filePath));

        return "Image is uploaded";
    }
}
