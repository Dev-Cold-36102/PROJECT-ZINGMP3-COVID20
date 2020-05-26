package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.PlaylistService;
import com.codegym.service.Playlist_SongService;
import com.codegym.service.SongService;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private Environment environment;
    @Autowired
    private UsersService usersService;
    @Autowired
    private SongService songService;
    @Autowired
    private Playlist_SongService playlist_songService;
    Song songnew= new Song();
    Playlist playlist = new Playlist();

    @GetMapping("/api/playlist")
    @ResponseBody
    public List<Playlist> getListPlaylist(){
        List<Playlist> playlists = playlistService.findAll();
        System.out.println(playlists.size());
        return playlists;
    }
    @PostMapping("/api/listSongPlaylist")
    public ResponseEntity<List<Song>> listPlaylist(@RequestBody Long id){
        Playlist playlist=playlistService.findById(id);
        List<Song> songList = new ArrayList<>();
        List<Playlist_Song> playlist_songs = playlist_songService.findPlaylist_SongByPlaylist(playlist);
        System.out.println(playlist_songs.size());
        for (int i=0; i< playlist_songs.size(); i++) {
            System.out.println(playlist_songs.get(i).getSong());
            songList.add(playlist_songs.get(i).getSong());
        }
        return new ResponseEntity<>(songList,HttpStatus.OK);
    }
    @PostMapping("/api/addsongin-playlist")
    public ResponseEntity<Void> saveSongInPlaylist(@RequestBody Song song){
        System.out.println(song.getIdSong());
        System.out.println(song.getNameSong());
        System.out.println(song.getImageSong());
        System.out.println(song.getCategory());
        this.songnew= song;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/sendplaylist")
    public ResponseEntity<List<Song>> getPlaylist(@RequestBody Playlist playlist){
        System.out.println(playlist.getName());
        System.out.println(playlist.getId());
        System.out.println(playlist.getImage());
        System.out.println(playlist.getLikePlaylist());
        List<Song> songList = new ArrayList<>();
        this.playlist=playlist;
        if (this.songnew!= null){
            Playlist_Song playlist_song = new Playlist_Song(this.playlist,this.songnew);
            playlist_songService.save(playlist_song);
            List<Playlist_Song> playlist_songs = playlist_songService.findPlaylist_SongByPlaylist(this.playlist);
            for (Playlist_Song playlist_songnew:
                    playlist_songs) {
                songList.add(playlist_songnew.getSong());
            }
        }
        return new ResponseEntity<>(songList,HttpStatus.OK);
    }

    @PostMapping("/api/playlist-user")
    public ResponseEntity<List<Playlist>> getPlayListByUser(@RequestBody Long id){
        Users users = usersService.findById(id);
        System.out.println(id);
        System.out.println(users.getId());
        List<Playlist>playlists=playlistService.findAllByUser(users);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
    @GetMapping("api/playlist/{id}")
    @ResponseBody
    public Playlist getPlaylist(@PathVariable Long id){
        Playlist playlist = playlistService.findById(id);
        return playlist;
    }

    @PostMapping(value = "/create-playlist", consumes = "multipart/form-data")
    public ResponseEntity<Void> createPlaylist(@ModelAttribute FromPlaylist fromPlaylist,
                                               @RequestPart(value = "image") MultipartFile imagePlaylist) throws ParseException {


        String imageUpload = environment.getProperty("image_upload_playlist").toString();
        String imageName = imagePlaylist.getOriginalFilename();
        Users users = usersService.findByUserName(fromPlaylist.getUsers());
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
