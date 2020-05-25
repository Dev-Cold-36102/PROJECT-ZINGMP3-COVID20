package com.codegym.service.Impl;

import com.codegym.model.FromPlaylist;
import com.codegym.model.Playlist;
import com.codegym.repository.PlaylistRepository;
import com.codegym.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;


    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public FromPlaylist findById(Long id) {
        return playlistRepository.findOne(id);
    }

    @Override
    public void save(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void remove(Long id) {
        playlistRepository.delete(id);
    }
}
