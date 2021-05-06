package model;

public class User {
    private int id;
    private String nameUser;
    private String gmailUser;
    private String nickname;
    private String introduce;
    private String passWordUser;
    private String image;
    private int statusUser;

    public User(int id) {
        this.id = id;
    }

    public User( String gmailUser, String passWordUser) {
        this.gmailUser = gmailUser;
        this.passWordUser = passWordUser;
    }

    public User(int id, String nameUser, String nickname, String image, String introduce) {
        this.id = id;
        this.nameUser = nameUser;
        this.nickname = nickname;
        this.image = image;
        this.introduce = introduce;
    }

    public User(int id, String nameUser, String gmailUser, String nickname, String introduce, String passWordUser, String image) {
        this.id = id;
        this.nameUser = nameUser;
        this.gmailUser = gmailUser;
        this.nickname = nickname;
        this.introduce = introduce;
        this.passWordUser = passWordUser;
        this.image = image;
    }

    public User(String nameUser, String gmailUser, String nickname, String introduce, String passWordUser, String image) {
        this.nameUser = nameUser;
        this.gmailUser = gmailUser;
        this.nickname = nickname;
        this.introduce = introduce;
        this.passWordUser = passWordUser;
        this.image = image;
    }

    public User(int id, String nameUser, String gmailUser, String nickname, String introduce, String passWordUser, String image, int statusUser) {
        this.id = id;
        this.nameUser = nameUser;
        this.gmailUser = gmailUser;
        this.nickname = nickname;
        this.introduce = introduce;
        this.passWordUser = passWordUser;
        this.image = image;
        this.statusUser = statusUser;
    }

    public User(int id, String nameUser) {
        this.id = id;
        this.nameUser = nameUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getGmailUser() {
        return gmailUser;
    }

    public void setGmailUser(String gmailUser) {
        this.gmailUser = gmailUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPassWordUser() {
        return passWordUser;
    }

    public void setPassWordUser(String passWordUser) {
        this.passWordUser = passWordUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(int statusUser) {
        this.statusUser = statusUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameUser='" + nameUser + '\'' +
                ", gmailUser='" + gmailUser + '\'' +
                ", nickname='" + nickname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", passWordUser='" + passWordUser + '\'' +
                ", image='" + image + '\'' +
                ", statusUser=" + statusUser +
                '}';
    }
}


