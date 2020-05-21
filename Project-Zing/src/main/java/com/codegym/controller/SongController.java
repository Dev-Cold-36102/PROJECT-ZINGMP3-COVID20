package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private Environment environment;


    @GetMapping("/api/songs")
    public List<Song> getListCustomers() {
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

    @PostMapping("/create-song")
    public ResponseEntity<?> createSong(@RequestBody SongForm songForm) {
        System.out.println(songForm.getAuthor());
        System.out.println(songForm.getImageSong());
        MultipartFile multipartImage = songForm.getImageSong();
        String imageName = multipartImage.getOriginalFilename();
        String imageUpload = environment.getProperty("image_upload").toString();

        MultipartFile multipartAudio = songForm.getLinkSong();
        String audioName = multipartAudio.getOriginalFilename();
        String audioUpload = environment.getProperty("audio_upload").toString();

        try {
            FileCopyUtils.copy(songForm.getImageSong().getBytes(), new File(imageUpload + imageName));
            FileCopyUtils.copy(songForm.getLinkSong().getBytes(), new File(audioUpload + audioName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(
                songForm.getNameSong(),
                songForm.getInfoSong(),
                imageName,
                songForm.getDateSong(),
                songForm.getLikeSong(),
                songForm.getListenSong(),
                songForm.getDownloadSong(),
                songForm.getCommendSong(),
                songForm.getCategory(),
                songForm.getAuthor(),
                audioName
        );
        songService.save(song);
        return new ResponseEntity<Song>(song, HttpStatus.CREATED);
    }
}
