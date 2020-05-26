package com.codegym.service;

import com.codegym.model.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbum();

    Album findAlbumByName(String name);

    Album findById(Long id);

    void save(Album album);

    void remove(Long id);
}
