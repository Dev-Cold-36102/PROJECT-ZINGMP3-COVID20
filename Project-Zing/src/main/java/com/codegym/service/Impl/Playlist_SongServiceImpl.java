package com.codegym.service.Impl;

import com.codegym.model.Playlist;
import com.codegym.model.Playlist_Song;
import com.codegym.repository.Playlist_SongRepository;
import com.codegym.service.Playlist_SongService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Playlist_SongServiceImpl implements Playlist_SongService {
    @Autowired
    private Playlist_SongRepository playlist_songRepository;

    @Override
    public List<Playlist_Song> findAll() {
        return playlist_songRepository.findAll();
    }

    @Override
    public List<Playlist_Song> findPlaylist_SongByPlaylist(Playlist playlist) {
        return playlist_songRepository.findByPlaylist(playlist);
    }

    @Override
    public void save(Playlist_Song playlist_song) {
        playlist_songRepository.save(playlist_song);
    }

    @Override
    public void delete(Playlist_Song playlist_song) {
        playlist_songRepository.delete(playlist_song);
    }

    @Override
    public void deleteListPlaylist_Song(List<Playlist_Song> playlist_songs) {
        playlist_songRepository.delete(playlist_songs);
    }
}
