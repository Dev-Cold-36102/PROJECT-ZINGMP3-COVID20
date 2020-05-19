package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findOne(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(int id) {
        songRepository.delete(id);
    }
}
