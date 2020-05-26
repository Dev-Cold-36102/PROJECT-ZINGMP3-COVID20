package com.codegym.service;

import com.codegym.model.Playlist;
import com.codegym.model.Playlist_Song;

import java.util.List;

public interface Playlist_SongService {
    List<Playlist_Song> findAll();
    List<Playlist_Song> findPlaylist_SongByPlaylist(Playlist playlist);
    void save(Playlist_Song playlist_song );
    void delete(Playlist_Song playlist_song);
    void deleteListPlaylist_Song(List<Playlist_Song> playlist_songs);
}
