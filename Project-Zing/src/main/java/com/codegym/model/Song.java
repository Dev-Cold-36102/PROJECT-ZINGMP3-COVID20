package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSong;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String nameSong;
    private String infoSong;
    private String imageSong;
    public Date dateSong;
    private Long likeSong;
    private Long listenSong;
    private Long downloadSong;
    private String commendSong;
    private String category;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSinger")
    private Singer singer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlbum")
    private Album album;

    public Song() {
    }

    public Song(Long idSong, String nameSong, String infoSong, String imageSong, Date dateSong, Long likeSong, Long listenSong, Long downloadSong, String commendSong,String category,String author) {
        this.idSong = idSong;
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
    }

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
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

    public String getImageSong() {
        return imageSong;
    }

    public void setImageSong(String imageSong) {
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

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
