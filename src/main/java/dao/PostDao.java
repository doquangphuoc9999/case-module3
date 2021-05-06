package dao;



import model.Category;
import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends BaseDao implements IBaseDAO<Post> {

    private final String SELECT_ALL_NEW_POST = "SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname,userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id where post.is_deleted = 0 order by post.id desc";
    private final String ADD_POST = "INSERT INTO post(title, shortContent, fullContent, image, idCategory, idAuthor) VALUES(?,?,?,?,?,?)";
    private final String FIND_BY_ID = "SELECT post.*, nameCategory, userpost.nameUser, userpost.nickname, userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id WHERE post.id = ?";
    private final String UPDATE_POST = "UPDATE post SET title = ?, shortContent = ?, fullContent = ?, image = ?, idCategory = ?, idAuthor = ? WHERE post.id = ?";
    private final String SOFT_DELETE = "UPDATE `casestudy`.`post` SET `is_deleted` = '1' WHERE `id` = ?";
    private final String DELETE_POST = "DELETE FROM post WHERE id = ?";
    private final String DELETE_COMMENT = "DELETE FROM commentpost WHERE id = ";
    private final String LIMIT_3_NEW_POST = "SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname, userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id where is_deleted = 0 order by post.id desc limit 3";
    private final String FIND_POST_BY_ID_USER = "SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id where userpost.id = ? order by post.id desc";
    private final String FIND_POST_BY_TITLE = "SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id where post.title = ? order by post.id desc ";
    private final String SELECT_ALL_POST_DELETE = "SELECT post.*, nameCategory, userPost.id,userPost.nameUser, userPost.nickname,userPost.image, userPost.introduce FROM (post LEFT JOIN category ON post.idCategory = category.id) LEFT JOIN userPost ON post.idAuthor = userPost.id where post.is_deleted = 1 order by post.id desc";



    public List<Post> selectAllPostDelete() {
        List<Post> postList = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_POST_DELETE);
                        ResultSet resultSet = statement.executeQuery();
                )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");

                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);

                int idUser = resultSet.getInt("idAuthor");
                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String imageUser = resultSet.getString("image");
                User user = new User(idUser,nameUser,nickname,imageUser,introduce);
                int view = resultSet.getInt("viewPost");
                Post post = new Post(idPost,title,shortContent,fullContent,dateTime,image,category,user,view);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }



    public boolean soft_delete(int id){
        boolean delete = false;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SOFT_DELETE);
                )
        {
            statement.setInt(1,id);
            delete  = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return delete;
    }


    public Post findByTitlePost(String title){
        Post post = null;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(FIND_POST_BY_TITLE);

                )
        {
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");

                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);

                int idUser = resultSet.getInt("userPost.id");
                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String imageUser = resultSet.getString("image");
                User user = new User(idUser,nameUser,nickname,imageUser,introduce);
                int view = resultSet.getInt("viewPost");
                post = new Post(idPost,title,shortContent,fullContent,dateTime,image,category,user,view);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }


    public List<Post> finPostByIdUser(int idUser) {
        List<Post> postList = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(FIND_POST_BY_ID_USER);

                )
        {
            statement.setInt(1,idUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");

                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);

                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String imageUser = resultSet.getString("image");
                User user = new User(idUser,nameUser,nickname,imageUser,introduce);
                int view = resultSet.getInt("viewPost");
                Post post = new Post(idPost,title,shortContent,fullContent,dateTime,image,category,user,view);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }


    public List<Post> limit_new_post(){
        List<Post> postList = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(LIMIT_3_NEW_POST);
                        ResultSet resultSet = statement.executeQuery();
                )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");

                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);

                int idUser = resultSet.getInt("idAuthor");
                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String imageUser = resultSet.getString("image");
                User user = new User(idUser,nameUser,nickname,image,introduce);


                int view = resultSet.getInt("viewPost");
                Post post = new Post(idPost,title,shortContent,fullContent,dateTime,image,category,user,view);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }


    @Override
    public List<Post> selectAll() {
        List<Post> postList = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NEW_POST);
                        ResultSet resultSet = statement.executeQuery();
                        )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");

                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);

                int idUser = resultSet.getInt("idAuthor");
                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String imageUser = resultSet.getString("image");
                User user = new User(idUser,nameUser,nickname,imageUser,introduce);
                int view = resultSet.getInt("viewPost");
                Post post = new Post(idPost,title,shortContent,fullContent,dateTime,image,category,user,view);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    @Override
    public void insert(Post object) {
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_POST);
                )
        {
            statement.setString(1,object.getTitle());
            statement.setString(2,object.getShortContent());
            statement.setString(3,object.getFullContent());
            statement.setString(4,object.getImage());
            statement.setInt(5,object.getCategory().getId());
            statement.setInt(6,object.getUser().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(Post object) throws SQLException {

    }

    @Override
    public Post findById(int id) throws SQLException {
        Post post = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
                )
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);

                int idUser = resultSet.getInt("idAuthor");
                String nameUser = resultSet.getString("nameUser");
                String nickname = resultSet.getString("nickname");
                String imageUser = resultSet.getString("userpost.image");
                String introduce = resultSet.getString("introduce");
                User user = new User(idUser,nameUser,nickname,imageUser,introduce);
                int view = resultSet.getInt("viewPost");
                post = new Post(id,title,shortContent,fullContent,dateTime,image,category,user,view);
            }
        }
        return post;
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_POST)
                )
        {
        statement.setInt(1,id);
        delete = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return delete;
    }

    @Override
    public boolean update(Post object) {
        boolean update = false;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_POST);
                )
        {
            statement.setString(1,object.getTitle());
            statement.setString(2,object.getShortContent());
            statement.setString(3,object.getFullContent());
            statement.setString(4,object.getImage());
            statement.setInt(5,object.getCategory().getId());
            statement.setInt(6,object.getUser().getId());
            statement.setInt(7,object.getId());
            update = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
}
