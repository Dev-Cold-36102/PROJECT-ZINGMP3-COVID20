package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String description;
    @OneToOne
    private Users users;

    public Playlist(Long id, String name, String image, String description, Users users) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.users = users;
    }

    public Playlist(String name, String image, String description, Users users) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.users = users;
    }

    public Playlist() {
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
