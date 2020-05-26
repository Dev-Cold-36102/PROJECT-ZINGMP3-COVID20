package com.codegym.service;

import com.codegym.model.Playlist;
import com.codegym.model.Users;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();
    Playlist findById(Long id);
    List<Playlist> findAllByUser(Users users);
    void save(Playlist playlist);
    void remove(Playlist playlist);
}
