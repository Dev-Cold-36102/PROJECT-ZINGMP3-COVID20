package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.model.Users;

import java.util.List;

public interface SongService {

    Iterable<Song> findAll();

    Song findById(Long id);

    void save(Song song);

    void remove(Long id);

    List<Song> findAllSongByIdUser(Users user);
}
