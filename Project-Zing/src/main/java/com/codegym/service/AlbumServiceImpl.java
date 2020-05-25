package com.codegym.service;

import com.codegym.model.Album;
import com.codegym.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void remove(Long id) {
        albumRepository.delete(id);
    }
}
