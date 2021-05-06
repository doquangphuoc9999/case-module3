package dao;

import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao implements IBaseDAO<User> {
    private final String SELECT_ALL_USER = "SELECT * FROM userPost";
    private final String ADD_USER = "INSERT INTO userpost(nameUser,gmailUser,nickname,introduce,passWordUser,statusUser,image) VALUES(?,?,?,?,?,0,?)";
    private final String FIND_BY_ID_USER = "SELECT * FROM userPost WHERE id = ?";
    private final String UPDATE_USER = "UPDATE userpost SET nameUser = ?, gmailUser = ?, nickname = ?, introduce = ?, passWordUser = ?, image = ? WHERE id = ?";
    private final String SQL_DELETE_USER_FK_POST = "DELETE FROM `casestudy`.`post` WHERE (`idAuthor` = ?);";
    private final String SQL_DELETE_USER = "DELETE FROM `casestudy`.`userpost` WHERE (`id` = ?)";
    private final String FIND_USERNAME_PASSWORD = "SELECT * FROM userpost WHERE gmailUser = ? AND passWordUser = ?";




    public User find_pass_nameUser(String UserName, String passWord){
        User user = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_USERNAME_PASSWORD);
                )
        {
            statement.setString(1,UserName);
            statement.setString(2,passWord);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameUser = resultSet.getString("nameUser");
                String gmailUser = resultSet.getString("gmailUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String passWordUser = resultSet.getString("passWordUser");
                String image = resultSet.getString("image");
                int statusUser = resultSet.getInt("statusUser");
                user = new User(id, nameUser, gmailUser, nickname, introduce, passWordUser, image, statusUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
                        ResultSet resultSet = statement.executeQuery();
                ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameUser = resultSet.getString("nameUser");
                String gmailUser = resultSet.getString("gmailUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String passWordUser = resultSet.getString("passWordUser");
                String image = resultSet.getString("image");
                int statusUser = resultSet.getInt("statusUser");
                User user = new User(id, nameUser, gmailUser, nickname, introduce, passWordUser, image, statusUser);
                users.add(user);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public void insert(User object) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_USER);) {
            statement.setString(1, object.getNameUser());
            statement.setString(2, object.getGmailUser());
            statement.setString(3, object.getNickname());
            statement.setString(4, object.getIntroduce());
            statement.setString(5, object.getPassWordUser());
            statement.setString(6, object.getImage());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(User object) throws SQLException {

    }

    @Override
    public User findById(int id) throws SQLException {
        User user = null;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_USER);

                ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nameUser = resultSet.getString("nameUser");
                String gmailUser = resultSet.getString("gmailUser");
                String nickname = resultSet.getString("nickname");
                String introduce = resultSet.getString("introduce");
                String passWordUser = resultSet.getString("passWordUser");
                String image = resultSet.getString("image");
                int statusUser = resultSet.getInt("statusUser");
                user = new User(id, nameUser, gmailUser, nickname, introduce, passWordUser, image, statusUser);
            }

        }
        return user;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_FK_POST);
            statement.setInt(1, id);
            statement.executeUpdate();

            statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            rowDeleted = statement.executeUpdate() > 0;

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException ex) {
            ex.getMessage();
            connection.rollback();
            connection.close();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User object) throws SQLException {
        boolean update = false;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(UPDATE_USER);

                ) {
            statement.setString(1,object.getNameUser());
            statement.setString(2,object.getGmailUser());
            statement.setString(3,object.getNickname());
            statement.setString(4,object.getIntroduce());
            statement.setString(5,object.getPassWordUser());
            statement.setString(6,object.getImage());
            statement.setInt(7,object.getId());
            update = statement.executeUpdate() > 0;
        }
        return update;
    }
}

