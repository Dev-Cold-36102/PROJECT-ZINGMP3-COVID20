package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "playlist_song")
public class Playlist_Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Playlist playlist;
    @OneToOne
    private Song song;

    public Playlist_Song(Long id, Playlist playlist, Song song) {
        this.id = id;
        this.playlist = playlist;
        this.song = song;
    }

    public Playlist_Song(Playlist playlist, Song song) {
        this.playlist = playlist;
        this.song = song;
    }

    public Playlist_Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
