package com.codegym.service;

import com.codegym.model.Playlist;
import org.springframework.security.access.method.P;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();
    Playlist findById(Long id);
    void save(Playlist playlist);
    void remove(Playlist playlist);
}
