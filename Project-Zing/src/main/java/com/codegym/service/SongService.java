package com.codegym.service;

import com.codegym.model.Song;

public interface SongService {

    Iterable<Song> findAll();

    Song findById(int id);

    void save(Song song);

    void remove(int id);
}
