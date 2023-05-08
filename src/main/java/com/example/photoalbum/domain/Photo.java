package com.example.photoalbum.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "photo",schema = "photo_album",uniqueConstraints = {@UniqueConstraint(columnNames = "photo_id")})
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id",unique = true,nullable = false)
    private Long photoId;

    @Column(name = "file_name",nullable = false)
    private String fileName;

    @Column(name = "thumb_url",nullable = false)
    private String thumbUrl;

    @Column(name = "original_url",nullable = false)
    private String originalUrl;

    @Column(name = "file_size",nullable = false)
    private int fileSize;

    @Column(name = "uploaded_at",nullable = false)
    private Date uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;
}
