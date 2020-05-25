package com.codegym.service.Impl;

import com.codegym.model.Song;
import com.codegym.model.Users;
import com.codegym.repository.SongRepository;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    public static List<Song> listSong = new ArrayList<>();

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepository.delete(id);
    }

    @Override
    public List<Song> findAllSongByIdUser(Users user) {
        List<Song> songList = this.songRepository.findAllByUser(user);
        return songList;
    }
}
