package com.codegym.controller;

import com.codegym.model.FromPlaylist;
import com.codegym.model.Playlist;
import com.codegym.model.Users;
import com.codegym.service.PlaylistService;
import com.codegym.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private Environment environment;
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/create-playlist", consumes = "multipart/form-data")
    public ResponseEntity<Void> createPlaylist(@ModelAttribute FromPlaylist fromPlaylist,
                                               @RequestPart(value = "image") MultipartFile imagePlaylist) throws ParseException {


        String imageUpload = environment.getProperty("image_upload_playlist").toString();
        String imageName = imagePlaylist.getOriginalFilename();
        System.out.println(imageName);
        System.out.println(fromPlaylist.getDate());
        System.out.println(fromPlaylist.getName());
        System.out.println(fromPlaylist.getDescription());
        System.out.println(fromPlaylist.getUsers());
        Users users = usersService.findByUserName(fromPlaylist.getUsers());
        System.out.println(users.getusername());
        try {
            FileCopyUtils.copy(imagePlaylist.getBytes(), new File(imageUpload + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(users.getusername());
        Playlist playlist=new Playlist(fromPlaylist.getName(),
                imageName,fromPlaylist.getDescription(),new SimpleDateFormat("dd-MM-yyyy").parse(fromPlaylist.getDate()),
                fromPlaylist.getLikePlaylist(),fromPlaylist.getListen(),fromPlaylist.getDownload(),users);
        try {
            playlistService.save(playlist);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-playlist/{id}")
    public ResponseEntity<Void> updatePlayList(@PathVariable Long id, @RequestBody FromPlaylist fromPlaylist,
                                               @RequestPart(value = "image") MultipartFile imagePlaylist) throws ParseException {
        FromPlaylist fromPlaylistUpdate = playlistService.findById(id);



        String imageUpload = environment.getProperty("image_upload_playlist").toString();
        String imageName = imagePlaylist.getOriginalFilename();
        fromPlaylistUpdate.setDate(fromPlaylist.getDate());
        fromPlaylistUpdate.setName(fromPlaylist.getName());
        fromPlaylistUpdate.setDescription(fromPlaylist.getDescription());
        Users users = usersService.findByUserName(fromPlaylist.getUsers());
        System.out.println(users.getusername());

        Playlist playlist=new Playlist(fromPlaylist.getName(),
                imageName,fromPlaylist.getDescription(),new SimpleDateFormat("dd-MM-yyyy").parse(fromPlaylist.getDate()),
                fromPlaylist.getLikePlaylist(),fromPlaylist.getListen(),fromPlaylist.getDownload(),users);


        playlistService.save(playlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id){
        playlistService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
