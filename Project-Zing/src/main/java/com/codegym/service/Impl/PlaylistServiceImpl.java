package com.codegym.service.Impl;

import com.codegym.model.Playlist;
import com.codegym.model.Users;
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
    public Playlist findById(Long id) {
        return playlistRepository.findOne(id);
    }


    @Override
    public List<Playlist> findAllByUser(Users users) {
        return playlistRepository.findAllByUsers(users);
    }

    @Override
    public void save(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void remove(Playlist playlist) {
        playlistRepository.delete(playlist);
    }


}
