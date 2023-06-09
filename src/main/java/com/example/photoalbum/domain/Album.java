package com.example.photoalbum.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "album", schema = "photo_album",uniqueConstraints = {@UniqueConstraint(columnNames = "album_id")})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id",unique = true, nullable = false)
    private Long albumId;

    @Column(name = "album_name",unique = false,nullable = false)
    private String albumName;

    @Column(name = "created_at",unique = false,nullable = true)
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album",cascade = CascadeType.ALL)
    private List<Photo> photos;
}
