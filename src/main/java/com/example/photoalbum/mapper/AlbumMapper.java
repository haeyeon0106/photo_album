package com.example.photoalbum.mapper;

import com.example.photoalbum.domain.Album;
import com.example.photoalbum.dto.AlbumDto;

public class AlbumMapper {

    public static AlbumDto convertToDto(Album album){
        AlbumDto albumDto = new AlbumDto();
        albumDto.setAlbumId(album.getAlbumId());
        albumDto.setAlbumName(album.getAlbumName());
        albumDto.setCreatedAt(album.getCreatedAt());

        return albumDto;
    }
}
