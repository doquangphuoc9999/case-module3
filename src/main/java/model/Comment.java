package model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private String nameUser;
    private String gmail;
    private LocalDateTime publisht;
    private Post post;


    public Comment( String nameUser, String gmail,String content, Post post) {
        this.nameUser = nameUser;
        this.gmail = gmail;
        this.content = content;
        this.post = post;
    }
    public Comment(int id, String content, String nameUser, String gmail, LocalDateTime publisht, Post post) {
        this.id = id;
        this.content = content;
        this.nameUser = nameUser;
        this.gmail = gmail;
        this.publisht = publisht;
        this.post = post;
    }

    public LocalDateTime getPublisht() {
        return publisht;
    }

    public void setPublisht(LocalDateTime publisht) {
        this.publisht = publisht;
    }

    public Comment(int id, String content, String nameUser, String gmail, Post post) {
        this.id = id;
        this.content = content;
        this.nameUser = nameUser;
        this.gmail = gmail;
        this.post = post;
    }

    public Comment(String content, String nameUser, String gmail) {
        this.content = content;
        this.nameUser = nameUser;
        this.gmail = gmail;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Comment(int id, String content, String gmail, Post post) {
        this.id = id;
        this.content = content;
        this.gmail = gmail;
        this.post = post;
    }

    public Comment(String content, String gmail) {
        this.content = content;
        this.gmail = gmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", gmail='" + gmail + '\'' +
                ", post=" + post +
                '}';
    }
}
