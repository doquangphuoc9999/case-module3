package service;

import dao.PostDao;
import model.Post;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService extends ValidateService implements IBaseService<Post> {
    PostDao postDao = new PostDao();


    public List<Post> selectAllPostDelete(){
        return  postDao.selectAllPostDelete();
    }

    public boolean soft_delete(int id){
       return postDao.soft_delete(id);
    }


    public Post findByTitlePost(String title){
        return postDao.findByTitlePost(title);
    }

    public List<Post> finPostByIdUser(int idUser){
        return postDao.finPostByIdUser(idUser);
    }

    @Override
    public ArrayList<String> listResult(Post post) {
        ArrayList<String> errorList = new ArrayList<>();
        if (!validateLength(post.getTitle(),5,250) || !validateLength(post.getShortContent(),10,300)){
            errorList.add("Vui lòng nhập lại nội dung của bạn");
        }
        return errorList;
    }

    @Override
    public List<Post> getAll() throws SQLException {
        return postDao.selectAll();
    }

    @Override
    public ArrayList<String> insert(Post post) throws SQLException {
        ArrayList<String> errorList = listResult(post);
        List<Post> postList = getAll();
        for (Post post1 : postList){
            if (post1.getTitle().equals(post.getTitle())){
                errorList.add("Tiêu đề này đã tồn tại vui lòng nhập một tiêu đề khác");
            }
            if (post1.getShortContent().equals(post.getShortContent())) {
                errorList.add("Nội dung ngắn này đã tồn tại vui lòng nhập một nội dung khác");
            }
        }
        if (errorList.size() == 0) {
            postDao.insert(post);
        }
        return errorList;
    }

    @Override
    public ArrayList<String> update(Post post) throws SQLException {
        ArrayList<String> errorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>(getAll());
        for (Post post1 : postList){
            if (
                       post1.getTitle().equals(post.getTitle()) && post1.getShortContent().equals(post.getShortContent())
                    && post1.getFullContent().equals(post.getFullContent()) && post1.getImage().equals(post.getImage())
                    && post1.getCategory().getId() == post.getCategory().getId() && post1.getUser().getId() == post.getUser().getId()
            ){
                errorList.add("Không có gì thay đỗi cả");
            }
        }
        if (errorList.size() == 0){
            postDao.update(post);
        }
        return errorList;
    }



    @Override
    public boolean delete(int id) throws SQLException {
        return postDao.delete(id);
    }

    @Override
    public Post findById(int id) throws SQLException {
        return postDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Post post) throws SQLException {
        List<Post> arrayList = getAll();
        for (Post post1 : arrayList){
            if (
                    post1.getTitle().equals(post.getTitle())
                    || post1.getShortContent().equals(post.getShortContent())
            ){
                return true;
            }
        }
        return false;
    }
    public boolean checkUpdate(Post post) throws SQLException {
        List<Post> postList = getAll();

        for (Post post1 : postList){
            if (
                    post1.getTitle().equals(post.getTitle()) && post1.getShortContent().equals(post.getShortContent())
                    && post1.getFullContent().equals(post.getFullContent()) && post1.getImage().equals(post.getImage())
                    && post1.getCategory().getId() == post.getCategory().getId() && post1.getUser().getId() == post.getUser().getId()
            ){
                return true;
            }
        }
        return false;
    }

    public List<Post> limt_new_post(){
        return postDao.limit_new_post();
    }
}
