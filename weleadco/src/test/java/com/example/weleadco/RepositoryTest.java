package com.example.weleadco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    void savingDataAndGettingItBack() {
        //given
        var imageEntity = new ImageEntity();
        imageEntity.setPath("/images/file1");

        //when
        var savedImage= imageRepository.save(imageEntity);

        //then
        assertThat(savedImage).isEqualTo(imageEntity);
    }
}
