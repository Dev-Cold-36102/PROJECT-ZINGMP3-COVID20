package com.codegym.controller;

import com.codegym.model.Album;
import com.codegym.model.Singer;
import com.codegym.model.Song;
import com.codegym.service.AlbumService;
import com.codegym.service.SingerService;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private SingerService singerService;

    @GetMapping("/api/songs")
    @ResponseBody()
    public Iterable<Song> getListCustomers() {
        Iterable<Song> songs = songService.findAll();
        return songs;
    }

    @GetMapping("/api/albums")
    @ResponseBody()
    public Iterable<Album> getListAlbums() {
        Iterable<Album> albums = albumService.findAll();
        return albums;
    }

        @GetMapping("api/singers")
        @ResponseBody()
        public Iterable<Singer> getListSingers () {
            Iterable<Singer> singers = singerService.findAll();
            return singers;
        }
//
////    @GetMapping("/api/view/{id}")
////    public ResponseEntity<Void> viewSong(@PathVariable Long id){
////        Song song = songService.findById(id);
////        return new ResponseEntity<>(HttpStatus.OK);
////    }

    @PostMapping("api/create")
    public ResponseEntity<?> createSong(@RequestBody Song song){
        System.out.println(song.toString());
//        songService.save(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @RequestMapping(value = "api/create", method = RequestMethod.POST)
//    public ResponseEntity<Void> createCustomer(@RequestBody Song song, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Customer " + song.getNameSong());
//        songService.save(song);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/songs/{id}").buildAndExpand(song.getIdSong()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

//    @Transactional
    @RequestMapping(value = "/songs/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Song> updateCustomer(@PathVariable("id") Long id, @RequestBody Song song) {
        System.out.println("Updating Song " + id);

        Song currentSong = songService.findById(id);

        if (currentSong == null) {
            System.out.println("Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }
        currentSong.setAuthor(song.getAuthor());
        currentSong.setCategory(song.getCategory());
        currentSong.setCommendSong(song.getCommendSong());
        currentSong.setDateSong(song.getDateSong());
        currentSong.setDownloadSong(song.getDownloadSong());
        currentSong.setImageSong(song.getImageSong());
        currentSong.setInfoSong(song.getInfoSong());
        currentSong.setLikeSong(song.getLikeSong());
        currentSong.setListenSong(song.getListenSong());
        currentSong.setNameSong(song.getNameSong());

        songService.save(currentSong);
        return new ResponseEntity<Song>(currentSong, HttpStatus.OK);
    }


    @RequestMapping(value = "/songs/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Song> deleteCustomer(@PathVariable("id") Long id) {
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
