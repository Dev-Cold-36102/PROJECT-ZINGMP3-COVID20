package com.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String description;
    private Date date;
    private Long likePlaylist;
    private Long listen;
    private Long download;
    @ManyToOne
    private Users users;

    public Playlist(Long id, String name, String image, String description, Date date, Long likePlaylist, Long listen, Long download, Users users) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.date = date;
        this.likePlaylist = likePlaylist;
        this.listen = listen;
        this.download = download;
        this.users = users;
    }

    public Playlist(String name, String image, String description, Date date, Long likePlaylist, Long listen, Long download, Users users) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.date = date;
        this.likePlaylist = likePlaylist;
        this.listen = listen;
        this.download = download;
        this.users = users;
    }

    public Playlist() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLikePlaylist() {
        return likePlaylist;
    }

    public void setLikePlaylist(Long likePlaylist) {
        this.likePlaylist = likePlaylist;
    }

    public Long getListen() {
        return listen;
    }

    public void setListen(Long listen) {
        this.listen = listen;
    }

    public Long getDownload() {
        return download;
    }

    public void setDownload(Long download) {
        this.download = download;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
