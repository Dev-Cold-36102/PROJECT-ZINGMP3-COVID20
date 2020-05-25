package com.codegym.repository;

import com.codegym.model.Song;
import com.codegym.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
    List<Song> findAllByUser(Users user);
}
