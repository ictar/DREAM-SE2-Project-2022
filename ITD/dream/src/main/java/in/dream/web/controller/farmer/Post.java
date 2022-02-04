package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;

import in.dream.ejb.services.ForumService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerPost", urlPatterns= "/farmer/post/*")
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
        Farmer fm = (Farmer)session.getAttribute("farmer");

        String[] urlparas = request.getRequestURI().split("/");
        Long postId = Long.parseLong(urlparas[urlparas.length-1]);

        String path = "/farmer/post.jsp";

        request.setAttribute("user", fm.getName());
        request.setAttribute("post", forumService.getPostByID(postId));
        request.setAttribute("commentList", forumService.getComment(postId));

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String title, content;
        try {
            title = StringEscapeUtils.escapeJava(request.getParameter("title"));
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Timestamp posttime = new Timestamp(System.currentTimeMillis());

            if(title== null || title.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            forumService.createPost(title, content,posttime);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/post.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/post.jsp").forward(request, response);
        }
    }


}
