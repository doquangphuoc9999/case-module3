CREATE DATABASE caseStudy; 
USE caseStudy;
DROP TABLE post;
CREATE TABLE post(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    shortContent TEXT NOT NULL,
    fullContent LONGTEXT NOT NULL,
    publisht DATETIME DEFAULT NOW(),
    image VARCHAR(500) NOT NULL,
    idCategory INT NOT NULL,
    idAuthor INT NOT NULL,
    viewPost INT DEFAULT 0,
    CONSTRAINT fk_category FOREIGN KEY(idCategory) REFERENCES category(id),
    CONSTRAINT fk_user FOREIGN KEY(idAuthor) REFERENCES userPost(id)
);



SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname,userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id order by post.id desc;

CREATE TABLE category(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameCategory VARCHAR(250) NOT NULL
);

CREATE TABLE userPost(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameUser VARCHAR(250) NOT NULL,
    gmailUser VARCHAR(250) NOT NULL,
    nickname VARCHAR(250) NOT NULL,
    introduce TEXT NOT NULL,
    passWordUser VARCHAR(250) NOT NULL,
    image VARCHAR(250) NOT NULL,
    statusUser INT NOT NULL
);
drop table commentPost;
CREATE TABLE commentPost(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    nameUser VARCHAR(50) NOT NULL,
    gmailUser VARCHAR(100) NOT NULL,
    publisht DATETIME DEFAULT NOW(),
    idPost INT NOT NULL,
    CONSTRAINT fk_userPost FOREIGN KEY(idPost) REFERENCES post(id)
);
INSERT INTO commentPost(content,nameUser,gmailUser,idPost) VALUES ("Vui quá","Hải chơi đỉ","hai@gmail.com",14);
SELECT * FROM commentPost left join post ON  commentPost.id = post.id where post.id = 14;

select * from commentpost where idPost = 14;



INSERT INTO commentPost(content,gmailUser,idPost) VALUES ("Bài viết hay qá","hai@gmail.com",16);

SELECT post.*, nameCategory, userpost.nameUser, userpost.nickname, userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id WHERE post.id = 1;


SELECT * FROM userpost WHERE gmailUser = "hai@gmail.com" AND passWordUser = "123456789";
SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname, userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id order by post.id desc limit 3;
SELECT * FROM post order by id desc limit 3;
SELECT * FROM category WHERE id = 1;
UPDATE userpost SET nameUser = "Hải", gmailUser = "hai@gmail.com", nickname = "hải chơi đỉ", introduce = "ông trùm chơi đỉ", passWordUser = "123456789", image = "https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.0-9/72341359_539994303445165_1603635819325685760_o.jpg?_nc_cat=110&ccb=3&_nc_sid=174925&_nc_ohc=fwBw7XiGuOYAX9D7Xhn&_nc_ht=scontent.fsgn2-6.fna&oh=df047dad6e37f5b6750f01e5eeb492bc&oe=6064E9F2" WHERE id = 1;
UPDATE post SET title = ?, shortContent = ?, fullContent = ?, image = ?, idCategory = ?, idAuthor = ? WHERE post.id = ? ; 
SELECT post.*, nameCategory, userpost.* FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id WHERE post.id = 1;
INSERT INTO userPost(nameUser,gmailUser,nickname,introduce,passWordUser,image, statusUser) VALUES ("Huy Anh","huyanh@gmail.com","anhCute","top 1 trường","123456","adsadsad",1);
INSERT INTO category(nameCategory) VALUES("Kinh Doanh");
INSERT INTO post(title, shortContent, fullContent, image, idCategory, idAuthor) VALUES("Ca Nhạc","Lyric","Nhớ người hay nhớ ta nhớ người","ágdạhsdgagdádj", 1,1);