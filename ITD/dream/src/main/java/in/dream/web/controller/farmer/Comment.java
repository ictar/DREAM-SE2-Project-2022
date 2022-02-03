package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Post;
import in.dream.ejb.services.ForumService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerPost", urlPatterns = "/farmer/comment/*")
public class Comment extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/request.jsp");
            return;
        }
        Farmer fm = (Farmer)session.getAttribute("farmer");
        Post ps = (Post)session.getAttribute("post");
        String path = "/farmer/comment.jsp";

        request.setAttribute("user", fm.getName());
        request.setAttribute("post", forumService.getPostByID());
        request.setAttribute("commentList", forumService.getComment(ps.getPostid()));


        request.getRequestDispatcher(path).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String title, content;
        try {
            title = StringEscapeUtils.escapeJava(request.getParameter("title"));
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Timestamp commenttime = new Timestamp(System.currentTimeMillis());

            if(title== null || title.isEmpty()) {
                throw new Exception("Required field is missing.");
            }
            Farmer fm = (Farmer)session.getAttribute("farmer");
            Post ps = (Post)session.getAttribute("post");

            forumService.createComment(fm.getFarmerid(), ps.getPostid(), content,commenttime);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/post.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/post.jsp").forward(request, response);
        }

    }

}