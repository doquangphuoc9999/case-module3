package model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String shortContent;
    private String fullContent;
    private LocalDateTime publisht;
    private String image;
    private Category category;
    private User user;
    private int viewPost;

    public Post(int id) {
        this.id = id;
    }

    public Post(String title, String shortContent, String fullContent, String image, Category category, User user) {
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.category = category;
        this.user = user;
    }


    public Post(int id, String title, String shortContent, String fullContent, LocalDateTime publisht, String image, Category category, User user, int viewPost) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.publisht = publisht;
        this.image = image;
        this.category = category;
        this.user = user;
        this.viewPost = viewPost;
    }

    public Post(int id, String title, String shortContent, String  fullContent, String image, Category category, User user) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.category = category;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public LocalDateTime getPublisht() {
        return publisht;
    }

    public void setPublisht(LocalDateTime publisht) {
        this.publisht = publisht;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getViewPost() {
        return viewPost;
    }

    public void setViewPost(int viewPost) {
        this.viewPost = viewPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", fullContent='" + fullContent + '\'' +
                ", publisht=" + publisht +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", viewPost=" + viewPost +
                '}';
    }
}
