package com.codegym.model;

public class FromPlaylist {
    private String name;
    private String description;
    private String date;
    private Long likePlaylist;
    private Long listen;
    private Long download;
    private String users;

    public FromPlaylist(String name,  String description, String date, Long likePlaylist, Long listen, Long download, String users) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.likePlaylist = likePlaylist;
        this.listen = listen;
        this.download = download;
        this.users = users;
    }

    public FromPlaylist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}
