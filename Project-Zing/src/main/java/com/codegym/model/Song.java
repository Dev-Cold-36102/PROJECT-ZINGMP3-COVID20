package com.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSong;
    private String nameSong;
    private String infoSong;
    private String imageSong;
    private String dateSong;
    private String likeSong;
    private String listenSong;
    private String downloadSong;
    private String commendSong;

    public Song() {
    }

    public Song(int idSong, String nameSong, String infoSong, String imageSong, String dateSong, String likeSong, String listenSong, String downloadSong, String commendSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.infoSong = infoSong;
        this.imageSong = imageSong;
        this.dateSong = dateSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.downloadSong = downloadSong;
        this.commendSong = commendSong;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
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

    public String getDateSong() {
        return dateSong;
    }

    public void setDateSong(String dateSong) {
        this.dateSong = dateSong;
    }

    public String getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(String likeSong) {
        this.likeSong = likeSong;
    }

    public String getListenSong() {
        return listenSong;
    }

    public void setListenSong(String listenSong) {
        this.listenSong = listenSong;
    }

    public String getDownloadSong() {
        return downloadSong;
    }

    public void setDownloadSong(String downloadSong) {
        this.downloadSong = downloadSong;
    }

    public String getCommendSong() {
        return commendSong;
    }

    public void setCommendSong(String commendSong) {
        this.commendSong = commendSong;
    }
}
