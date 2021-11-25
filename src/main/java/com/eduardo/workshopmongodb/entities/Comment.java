package com.eduardo.workshopmongodb.entities;

import com.eduardo.workshopmongodb.dto.AuthorDTO;
import com.eduardo.workshopmongodb.dto.UserDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Comment implements Serializable {
    static final long serialVersionUID = 1L;

    private String id;
    private String text;
    private Date date;

    private User author;

    private Post post;

    public Comment() {
    }

    public Comment(String id, String text, Date date, User author, Post post) {
        super();
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
        this.post = post;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
