package dao;

import model.Comment;
import model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends BaseDao implements IBaseDAO<Comment>{
    private final String SELECT_ALL_COMMENT = "SELECT * FROM commentPost";
    private final String ADD_COMMENT = "INSERT INTO commentPost(content,nameUser,gmailUser,idPost) VALUES (?,?,?,?)";
    private final String COMMENT_BY_ID_POST = "select * from commentpost where idPost = ?";

    public List<Comment> findPostComment(int idPost){
        List<Comment> commentList = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(COMMENT_BY_ID_POST);
        )
        {
            statement.setInt(1,idPost);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String nameUser = resultSet.getString("nameUser");
                String gmailUser = resultSet.getString("gmailUser");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                Post post = new Post(idPost);
                Comment comment = new Comment(id,content,nameUser,gmailUser,dateTime,post);
                commentList.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return commentList;
    }

    @Override
    public List<Comment> selectAll()  {
        List<Comment> commentList = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COMMENT);
                ResultSet resultSet = statement.executeQuery();
                )
        {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String nameUser = resultSet.getString("nameUser");
                String gmailUser = resultSet.getString("gmailUser");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                int idPost = resultSet.getInt("commentpost.id");
                Post post = new Post(idPost);
                Comment comment = new Comment(id,content,nameUser,gmailUser,dateTime,post);
                commentList.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return commentList;
    }

    @Override
    public void insert(Comment object) throws SQLException {
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_COMMENT);
                )
        {
            statement.setString(1,object.getContent());
            statement.setString(2,object.getNameUser());
            statement.setString(3,object.getGmail());
            statement.setInt(4,object.getPost().getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void Save(Comment object) throws SQLException {

    }

    @Override
    public Comment findById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Comment object) throws SQLException {
        return false;
    }
}
