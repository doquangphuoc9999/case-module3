package controller.homeBlog;

import model.Comment;
import model.Post;
import service.CommentService;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeBlogServlet", urlPatterns = "/homeBlog")
public class HomeBlogServlet extends HttpServlet {
    PostService postService = new PostService();
    CommentService commentService = new CommentService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "commentPost":
                commentPost(request,response);
            break;
        }
    }

    private void commentPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Post post = postService.findById(id);
            request.setAttribute("postById",post);

            String nameUser = request.getParameter("nameUser");
            String gmailUser = request.getParameter("gmailUser");
            String content = request.getParameter("content");
            int idPost = Integer.parseInt(request.getParameter("id"));
            Post posts = new Post(idPost);

            Comment comment = new Comment(nameUser,gmailUser,content,posts);
            request.setAttribute("mess",this.commentService.insert(comment));
            List<Comment> commentList = commentService.findPostComment(idPost);
            request.setAttribute("listComment",commentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/BlogSingle.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "blogSingle":
                blogSingle(request,response);
                break;
            case "about":
                aboutBlog(request,response);
                break;

            case "contact":
                contactBlog(request,response);
                break;
            case "titlePost":
                titlePost(request,response);
                break;
            default:
                homeBlog(request,response);
        }

    }

    private void titlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        Post post = postService.findByTitlePost(title);

        request.setAttribute("PostTitle",post);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/searchPost.jsp");
        dispatcher.forward(request,response);

    }

    private void contactBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/Contact.jsp");
        dispatcher.forward(request,response);
    }

    private void aboutBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/About.jsp");
        dispatcher.forward(request,response);
    }

    private void blogSingle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Post post = postService.findById(id);

            List<Post> postLimit = postService.limt_new_post();

            request.setAttribute("post3Limit",postLimit);

            request.setAttribute("postById",post);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/BlogSingle.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }


    }


    private void homeBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Post> postList = postService.limt_new_post();
            request.setAttribute("limitNewPost",postList);


            List<Post> listPost = postService.getAll();
            request.setAttribute("listPost",listPost);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeBlog/HomeBlog.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
