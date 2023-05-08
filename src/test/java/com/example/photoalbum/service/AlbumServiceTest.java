package com.example.photoalbum.service;

import com.example.photoalbum.domain.Album;
import com.example.photoalbum.domain.Photo;
import com.example.photoalbum.dto.AlbumDto;
import com.example.photoalbum.repository.AlbumRepository;
import com.example.photoalbum.repository.PhotoRepository;
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
    @Autowired
    PhotoRepository photoRepository;

    @Test
    void getAlbum(){
        Album album = new Album();
        album.setAlbumName("테스트");
        Album saveAlbum = albumRepository.save(album);

        AlbumDto resAlbum = albumService.getAlbum(saveAlbum.getAlbumId());
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

    @Test
    void TestCount(){
        // 앨범 저장
        Album album = new Album();
        album.setAlbumName("앨범 1");
        Album saveAlbum = albumRepository.save(album);

        Photo photo1 = new Photo();
        photo1.setFileName("파일명1");
        photo1.setAlbum(saveAlbum);
        photoRepository.save(photo1);

        Photo photo2 = new Photo();
        photo2.setFileName("파일명2");
        photo2.setAlbum(saveAlbum);
        photoRepository.save(photo2);

        assertEquals(2,photoRepository.countByAlbum_AlbumId(saveAlbum.getAlbumId()));
    }
}