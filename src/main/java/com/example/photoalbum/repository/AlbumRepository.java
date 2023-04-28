package com.example.photoalbum.repository;

import com.example.photoalbum.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album,Long> {
    Optional<Album> findByAlbumName(String albumName);
}
