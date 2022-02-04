package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;

import in.dream.ejb.services.ForumService;


import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerPost", urlPatterns= {"/farmer/post/*"})
public class Post extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }
        String path = "/farmer/post.jsp";

        String[] urlparas = request.getRequestURI().split("/");
        Long postId = Long.parseLong(urlparas[urlparas.length-1]);

        request.setAttribute("post", forumService.getPostByID(postId));
        request.setAttribute("commentList", forumService.getComment(postId));

        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());
        request.getRequestDispatcher(path).forward(request, response);
    }
}
