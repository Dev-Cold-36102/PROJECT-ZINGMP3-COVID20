package com.codegym.service;

import com.codegym.model.FromPlaylist;
import com.codegym.model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();
    FromPlaylist findById(Long id);
    void save(Playlist playlist);
    void remove(Long id);
}
