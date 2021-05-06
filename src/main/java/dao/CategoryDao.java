package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BaseDao implements IBaseDAO<Category>{
    private final String SELECT_ALL_CATEGORY = "SELECT * FROM category";
    private final String SQL_DELETE_USER_FK_POST = "DELETE FROM post WHERE id = ?";
    private final String SQL_DELETE_CATEGORY = "DELETE FROM category WHERE id = ?";
    private final String ADD_CATEGORY = "INSERT INTO category(nameCategory) VALUES(?)";
    private final String FIND_BY_ID_CATEGORY = "SELECT * FROM category WHERE id = ?";
    private final String UPDATE_CATEGORY = "UPDATE category SET nameCategory = ? WHERE id = ?";

    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORY);
                        ResultSet resultSet = statement.executeQuery()
                )
        {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(id,nameCategory);
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public void insert(Category object) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_CATEGORY)
                )
        {
            statement.setString(1,object.getNameCategory());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(Category object) throws SQLException {

    }

    @Override
    public Category findById(int id) throws SQLException {
        Category category = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_CATEGORY)
                )
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");
                category = new Category(idCategory,nameCategory);
            }
        }
        return category;
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

            statement = connection.prepareStatement(SQL_DELETE_CATEGORY);
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
    public boolean update(Category object) {
        boolean update = false;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY)
                )
        {
            statement.setString(1,object.getNameCategory());
            statement.setInt(2,object.getId());
            update = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
}
