package com.codegym.service;

import com.codegym.model.Album;
import com.codegym.model.Singer;

public interface SingerService {

    Iterable<Singer> findAll();

    Singer findById(Long id);

    void save(Singer singer);

    void remove(Long id);
}
