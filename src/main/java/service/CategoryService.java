package service;

import dao.CategoryDao;
import model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements IBaseService<Category>{
    CategoryDao categoryDao = new CategoryDao();

    @Override
    public ArrayList<String> listResult(Category category) {
        return null;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return categoryDao.selectAll();
    }

    @Override
    public ArrayList<String> insert(Category category) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<>();
        List<Category> list = getAll();
        for (Category category1 : list){
            if (category1.getNameCategory().toUpperCase().equals(category.getNameCategory().toUpperCase())){
                arrayList.add("Lỗi!!!! Thể loại này đã có trong danh sách");
            }
        }
        if (arrayList.size() == 0){
            categoryDao.insert(category);
        }
        return arrayList;
    }

    @Override
    public ArrayList<String> update(Category category) throws SQLException {
        ArrayList<String> errorList = new ArrayList<>();
        List<Category> list = getAll();

        for (Category category1 : list){
            if (category1.getNameCategory().equals(category.getNameCategory())){
                errorList.add("Không có gì thay đỗi");
            }
        }
        if (errorList.size() == 0){
            categoryDao.update(category);
        }
        return errorList;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return categoryDao.delete(id);
    }


    @Override
    public Category findById(int id) throws SQLException {
        return categoryDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Category category) throws SQLException {
        return false;
    }
}
