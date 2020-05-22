package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findOne(id);
    }

    @Override
//    @Transactional
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepository.delete(id);
    }
}
