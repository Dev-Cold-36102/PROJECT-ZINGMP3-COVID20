package com.codegym.service;

import com.codegym.model.Album;
import com.codegym.model.Song;

public interface AlbumService {

    Iterable<Album> findAll();

    Album findById(Long id);

    void save(Album album);

    void remove(Long id);
}
