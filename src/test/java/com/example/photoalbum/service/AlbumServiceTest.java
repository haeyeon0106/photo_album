package com.example.photoalbum.service;

import com.example.photoalbum.domain.Album;
import com.example.photoalbum.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AlbumServiceTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void getAlbum(){
        Album album = new Album();
        album.setAlbumName("테스트");
        Album saveAlbum = albumRepository.save(album);

        Album resAlbum = albumService.getAlbum(saveAlbum.getAlbumId());
        assertEquals("테스트",resAlbum.getAlbumName());
    }

    @Test
    void getAlbumByName(){
        Album album = new Album();
        album.setAlbumName("앨범명");
        Album saveAlbum = albumRepository.save(album);

        Album resAlbum = albumService.getAlbumByAlbumName(saveAlbum.getAlbumName());
        assertEquals("앨범명",resAlbum.getAlbumName());
    }
}