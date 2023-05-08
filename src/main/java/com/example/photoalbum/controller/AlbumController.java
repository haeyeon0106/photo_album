package com.example.photoalbum.controller;

import com.example.photoalbum.dto.AlbumDto;
import com.example.photoalbum.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    @GetMapping("/{albumId}")
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable("albumId")Long albumId){
        AlbumDto album = albumService.getAlbum(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<AlbumDto> getAlbumByQuery(@RequestParam("albumId")Long albumId){
        AlbumDto album = albumService.getAlbum(albumId);
        return new ResponseEntity<>(album,HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<AlbumDto> getAlbumByJson(@RequestBody AlbumDto albumDto){
        AlbumDto album = albumService.getAlbum(albumDto.getAlbumId());
        return new ResponseEntity<>(album,HttpStatus.OK);
    }
}
