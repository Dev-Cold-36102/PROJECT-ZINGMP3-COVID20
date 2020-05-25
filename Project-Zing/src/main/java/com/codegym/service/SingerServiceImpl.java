package com.codegym.service;

import com.codegym.model.Singer;
import com.codegym.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SingerServiceImpl implements SingerService  {
    @Autowired
    private SingerRepository singerRepository;

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer findById(Long id) {
        return singerRepository.findOne(id);
    }

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

    @Override
    public void remove(Long id) {
        singerRepository.delete(id);
    }
}
