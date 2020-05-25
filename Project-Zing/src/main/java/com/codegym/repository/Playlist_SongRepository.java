package com.codegym.repository;

import com.codegym.model.Playlist;
import com.codegym.model.Playlist_Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Playlist_SongRepository extends JpaRepository<Playlist_Song,Long> {
    List<Playlist_Song> findByPlaylist(Playlist playlist);

}
