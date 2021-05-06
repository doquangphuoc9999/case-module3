package controller.loginBlog;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginBlogServlet", urlPatterns = "/loginBlog")
public class LoginBlogServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("email");
        String passWord = request.getParameter("pass");


        User user = userService.find_pass_nameUser(userName,passWord);
//      đăng nhập thành công
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("userName",user.getNameUser());
            session.setAttribute("user",user);
            session.setAttribute("id",user.getId());
                response.sendRedirect("/admin");
        }else {
//       đăng nhập thất bại
            HttpSession session = request.getSession();
            session.setAttribute("error","Wrong!!!!, Please try again");
            response.sendRedirect("/loginBlog");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginBlog/Login-jsp/login.jsp");
        dispatcher.forward(request,response);
    }
}
