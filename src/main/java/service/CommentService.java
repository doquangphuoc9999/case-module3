package service;

import dao.CommentDao;
import model.Comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements IBaseService<Comment>{
    CommentDao commentDao = new CommentDao();
    @Override
    public ArrayList<String> listResult(Comment comment) throws SQLException {
        return null;
    }
    public List<Comment> findPostComment(int idPost){
        return commentDao.findPostComment(idPost);
    }
    @Override
    public List<Comment> getAll() throws SQLException {
        return commentDao.selectAll();
    }

    @Override
    public ArrayList<String> insert(Comment comment) throws SQLException {
        ArrayList<String> listError = new ArrayList<>();
        List<Comment> commentList = getAll();

        for (Comment comment1 : commentList){
            if (comment1.getContent().toUpperCase().contentEquals("Con cặc")){
                listError.add("Lỗi comment không hợp lệ");
            }
        }
        if (listError.size() == 0){
            commentDao.insert(comment);
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(Comment comment) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Comment findById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean checkDuplicate(Comment comment) throws SQLException {
        return false;
    }
}
