package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/api/songs")
    public List<Song> getListCustomers(){
        List<Song> songs = (List<Song>) songService.findAll();
        return songs;
    }



    @RequestMapping(value = "/songs/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Song> updateCustomer(@PathVariable("id") int id, @RequestBody Song song) {
        System.out.println("Updating Song " + id);

        Song currentSong = songService.findById(id);

        if (currentSong == null) {
            System.out.println("Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        currentSong.setNameSong(song.getNameSong());
        currentSong.setInfoSong(song.getInfoSong());
        currentSong.setImageSong(song.getImageSong());
        currentSong.setDateSong(song.getDateSong());
        currentSong.setLikeSong(song.getLikeSong());
        currentSong.setListenSong(song.getListenSong());
        currentSong.setDownloadSong(song.getDownloadSong());
        currentSong.setCommendSong(song.getCommendSong());

        songService.save(currentSong);
        return new ResponseEntity<Song>(currentSong, HttpStatus.OK);
    }


    @RequestMapping(value = "/songs/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Song> deleteCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Song with id " + id);

        Song song = songService.findById(id);
        if (song == null) {
            System.out.println("Unable to delete. Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        songService.remove(id);
        return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
    }
}
