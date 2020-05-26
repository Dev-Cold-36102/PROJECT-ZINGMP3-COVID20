package com.codegym.repository;

import com.codegym.model.Playlist;
import com.codegym.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
    List<Playlist> findAllByUsers(Users users);
}
