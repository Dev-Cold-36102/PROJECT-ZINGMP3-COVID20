package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameUserComment;
    private String ContentComment;

    public Comment() {
    }

    public Comment(Long id, String nameUserComment, String contentComment) {
        this.id = id;
        this.nameUserComment = nameUserComment;
        ContentComment = contentComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUserComment() {
        return nameUserComment;
    }

    public void setNameUserComment(String nameUserComment) {
        this.nameUserComment = nameUserComment;
    }

    public String getContentComment() {
        return ContentComment;
    }

    public void setContentComment(String contentComment) {
        ContentComment = contentComment;
    }
}
