package com.codegym.repository;

import com.codegym.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
}