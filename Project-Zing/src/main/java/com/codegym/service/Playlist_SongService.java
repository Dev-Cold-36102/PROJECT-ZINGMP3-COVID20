package com.codegym.service;

import com.codegym.model.Playlist;
import com.codegym.model.Playlist_Song;

import java.util.List;

public interface Playlist_SongService {
    List<Playlist_SongService> findAll();
    List<Playlist_SongService> findByPlaylist(Playlist playlist);
    Playlist_Song findById(Long id);
    void save(Playlist_Song playlist_song);
    void remove(Playlist_Song playlist_song);
}
