package controller.admin;

import model.Category;
import model.Post;
import model.User;
import service.CategoryService;
import service.IBaseService;
import service.PostService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        fix unicode
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }

        switch (action){
            case "addPostAdmin":
                    doAdd(request,response);
                break;
            case "addUser":
                doAddUser(request,response);
                break;
            case "addCategory":
                doAddCategory(request,response);
                break;
            case "editPost":
                    doEditPost(request,response);
                    break;
            case "editUser":
                    doEditUser(request,response);
                    break;
            case "editCategory":
                    doEditCategory(request,response);
                    break;
            default:
                break;
        }
    }

    private void doEditCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            Category oldCategory = null;
            int idCategory = Integer.parseInt(request.getParameter("id"));
            String nameCategory = request.getParameter("nameCategory");

            Category category = new Category(idCategory,nameCategory);
            ArrayList<String> mess = this.categoryService.update(category);

            if (mess != null){
                oldCategory = categoryService.findById(idCategory);
                request.setAttribute("mess", oldCategory);
                request.setAttribute("mess", mess);
            }else {
                request.setAttribute("mess",category);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void doAddCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            String nameCategory = request.getParameter("nameCategory");
            Category category = new Category(nameCategory);

            request.setAttribute("mess",this.categoryService.insert(category));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doEditUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int idUser = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String nickname = request.getParameter("nickname");
            String password = request.getParameter("password");
            String image = request.getParameter("image");
            String gmail = request.getParameter("gmail");
            String introduce = request.getParameter("introduce");

            User user = new User(idUser,name,gmail,nickname,introduce,password,image);

            ArrayList<String> mess = this.userService.update(user);
            if (mess != null){
                User ollUser = userService.findById(idUser);
                request.setAttribute("user",ollUser);
                request.setAttribute("mess",mess);
            }
            else {
                request.setAttribute("user",user);
                request.setAttribute("mess",user);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void doAddUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String nameUser = request.getParameter("name");
            String nickName = request.getParameter("nickname");
            String introduce = request.getParameter("introduce");
            String gmail  = request.getParameter("gmail");
            String image = request.getParameter("image");
            String password = request.getParameter("password");

            User user = new User(nameUser,gmail,nickName,introduce,password,image);
            request.setAttribute("messs",this.userService.insert(user));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void doEditPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int idPost= Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String shortContent = request.getParameter("shortContent");
            String fullContent = request.getParameter("fullContent");
            String image = request.getParameter("image");
            int idCategory = Integer.parseInt(request.getParameter("category"));
            Category category = new Category(idCategory);
            int idAuthor = Integer.parseInt(request.getParameter("user"));
            User user = new User(idAuthor);
            Post post1 = new Post(idPost,title,shortContent,fullContent,image,category,user);

            List<Category> categoryList = categoryService.getAll();
            request.setAttribute("listCategory",categoryList);

            List<User> userList = userService.getAll();
            request.setAttribute("listUsers",userList);

            ArrayList<String> mess = this.postService.update(post1);
            if (mess != null){
                Post postOdd = postService.findById(idPost);
                request.setAttribute("PostById",postOdd);
                request.setAttribute("mess",mess);
            }else {
                request.setAttribute("PostById",post1);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String title = request.getParameter("title");
            String shortContent = request.getParameter("shortContent");
            String fullContent = request.getParameter("fullContent");
            String image = request.getParameter("image");
            int IdCategory = Integer.parseInt(request.getParameter("category"));
            Category category = new Category(IdCategory);
            int idUser = Integer.parseInt(request.getParameter("user"));
            User user = new User(idUser);


            List<Category> list = categoryService.getAll();
            request.setAttribute("listCategory",list);

            List<User> userList = userService.getAll();
            request.setAttribute("listUsers",userList);

            User userId = userService.findById(idUser);
            request.setAttribute("idUser",userId);

            Post post = new Post(title,shortContent,fullContent,image,category,user);
            request.setAttribute("mess",this.postService.insert(post));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      fix unicode
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }
        switch (action){
            case "addGetPostAdmin":
                addPostAdmin(request,response);
                break;
            case "addUser":
                getAddUser(request,response);
                break;
            case "addCategory":
                getAddCategory(request,response);
                break;
            case "editPost":
                getEditPost(request,response);
                break;
            case "deleteTryPost":
                try {
                    getDeleteTryPost(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deletePost":
                getDeletePost(request,response);
                break;
            case "deleteUser":
                getDeleteUser(request,response);
                break;
            case "deleteCategory":
                getDeleteCategory(request,response);
                break;
            case "listAuthor":
                listAuthor(request,response);
                break;
            case "listCategory":
                listCategory(request,response);
                break;
            case "editUser":
                getEditUser(request,response);
                break;
            case "trashCan":
                transhCan(request,response);
                break;
            case "editCategory":
                getEditCategory(request,response);
                break;
            default:
                listPostAdmin(request,response);
                break;
        }
    }

    private void getDeleteTryPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        postService.soft_delete(id);
        request.setAttribute("listPostAdmin", postService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listPosts.jsp");
        dispatcher.forward(request,response);
    }

    private void transhCan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> list = postService.selectAllPostDelete();
        request.setAttribute("listPostDelete",list);
        HttpSession session = request.getSession();

        int idUser= (int) session.getAttribute("id");

        List<Post> postList1 = postService.finPostByIdUser(idUser);

        request.setAttribute("listPostByUser",postList1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/deleteTry.jsp");
        dispatcher.forward(request,response);
    }

    private void getDeleteCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            categoryService.delete(id);
            List<Category> list = categoryService.getAll();
            request.setAttribute("listCategory",list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void getEditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCategory = Integer.parseInt(request.getParameter("id"));
           request.setAttribute("categoryById",this.categoryService.findById(idCategory));
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editCategory.jsp");
           dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getAddCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDeleteUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> userList = null;
            int idUser = Integer.parseInt(request.getParameter("id"));
            userService.delete(idUser);
            userList = userService.getAll();
            request.setAttribute("listUser",userList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categoryList = categoryService.getAll();
            request.setAttribute("listCategory", categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void getEditUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("user",userService.findById(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAddUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> userList = userService.getAll();
            request.setAttribute("listUser", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listUser.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDeletePost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("mess",this.postService.soft_delete(id));
            request.setAttribute("listPostDelete",this.postService.selectAllPostDelete());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/deleteTry.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void getEditPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Post post = postService.findById(id);
            request.setAttribute("PostById",post);

            List<Category> list = categoryService.getAll();
            request.setAttribute("listCategory",list);

            List<User> listUser = userService.getAll();
            request.setAttribute("listUsers",listUser);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/editPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addPostAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            List<User> userList = userService.getAll();
            List<Category> categoryList = categoryService.getAll();
            request.setAttribute("listUsers",userList);
            request.setAttribute("listCategory", categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/addPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void listPostAdmin(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Post> postList =  postService.getAll();

            HttpSession session = request.getSession();

            int idUser= (int) session.getAttribute("id");

            List<Post> postList1 = postService.finPostByIdUser(idUser);

            request.setAttribute("listPostByUser",postList1);

            request.setAttribute("listPostAdmin",postList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminPage/listPosts.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
