package com.codegym.model;


import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class SongForm {

//    private Long idSong;

    private String nameSong;
    private String infoSong;
    private MultipartFile imageSong;
    private Date dateSong;
    private Long likeSong;
    private Long listenSong;
    private Long downloadSong;
    private String commendSong;
    private String category;
    private String author;
    private MultipartFile linkSong;


    public SongForm() {
    }

    public SongForm( String nameSong, String infoSong, MultipartFile imageSong, Date dateSong, Long likeSong, Long listenSong, Long downloadSong, String commendSong, String category, String author, MultipartFile linkSong) {
        this.nameSong = nameSong;
        this.infoSong = infoSong;
        this.imageSong = imageSong;
        this.dateSong = dateSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.downloadSong = downloadSong;
        this.commendSong = commendSong;
        this.category = category;
        this.author = author;
        this.linkSong = linkSong;
    }


    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getInfoSong() {
        return infoSong;
    }

    public void setInfoSong(String infoSong) {
        this.infoSong = infoSong;
    }

    public MultipartFile getImageSong() {
        return imageSong;
    }

    public void setImageSong(MultipartFile imageSong) {
        this.imageSong = imageSong;
    }

    public Date getDateSong() {
        return dateSong;
    }

    public void setDateSong(Date dateSong) {
        this.dateSong = dateSong;
    }

    public Long getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(Long likeSong) {
        this.likeSong = likeSong;
    }

    public Long getListenSong() {
        return listenSong;
    }

    public void setListenSong(Long listenSong) {
        this.listenSong = listenSong;
    }

    public Long getDownloadSong() {
        return downloadSong;
    }

    public void setDownloadSong(Long downloadSong) {
        this.downloadSong = downloadSong;
    }

    public String getCommendSong() {
        return commendSong;
    }

    public void setCommendSong(String commendSong) {
        this.commendSong = commendSong;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(MultipartFile linkSong) {
        this.linkSong = linkSong;
    }
}
