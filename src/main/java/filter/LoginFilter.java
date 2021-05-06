package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MustLoginFilter", urlPatterns = {"/admin"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        httpResponse.setHeader("Pragma","no-cache");
        httpResponse.setDateHeader ("Expires", 0);


//     lôi session về
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user == null){
            response.sendRedirect("/loginBlog");
        }
        else {

            filterChain.doFilter(servletRequest,servletResponse);
        }
    }


}
