package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends ValidateService implements IBaseService<User>{
    UserDao userDao = new UserDao();


    public User find_pass_nameUser(String UserName, String passWord){
       return userDao.find_pass_nameUser(UserName,passWord);
    }
    @Override
    public ArrayList<String> listResult(User user) throws SQLException {
        ArrayList<String> errorList = new ArrayList<>();
        List<User> list = getAll();

        for (User user1 : list){
            if (user1.getNameUser().equals(user.getNameUser())){
                errorList.add("Tên dùng user bị trùng");
            }
            if (user1.getGmailUser().equals(user.getGmailUser())){
                errorList.add("Tên gmail bị trùng");
            }
        }
        return errorList;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.selectAll();
    }

    @Override
    public ArrayList<String> insert(User user) throws SQLException {
        ArrayList<String> arrayList = listResult(user);
        if (arrayList.size() == 0){
            userDao.insert(user);
        }
        return arrayList;
    }

    @Override
    public ArrayList<String> update( User user) throws SQLException {
        ArrayList<String> errorList = new ArrayList<>();
        User oldUser = findById(user.getId());

        if (
                           oldUser.getNameUser().equals(user.getNameUser())
                        && oldUser.getImage().equals(user.getImage())
                        && oldUser.getGmailUser().equals(user.getGmailUser())
                        && oldUser.getNickname().equals(user.getNickname())
        ){
            errorList.add("Không có gì thay đỗi cả");
        }else {
                userDao.update(user);
        }

        return errorList;
    }


    @Override
    public boolean delete(int id) throws SQLException {
        return userDao.delete(id);
    }

    @Override
    public User findById(int id) throws SQLException {
        return userDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(User user) throws SQLException {
        return false;
    }
}
