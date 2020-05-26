package com.codegym.service;

import com.codegym.model.Playlist;
import org.springframework.security.access.method.P;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();
    FromPlaylist findById(Long id);
    Playlist findById(Long id);
    List<Playlist> findAllByUser(Users users);
    void save(Playlist playlist);
    void remove(Playlist playlist);
}
