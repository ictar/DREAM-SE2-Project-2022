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

@WebServlet(name = "farmerPost", value="/farmer/forum/post/*")
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String title, content;
        // only one forum is allowed.
        Long forumId = 1L;
        try {
            title = StringEscapeUtils.escapeJava(request.getParameter("title"));
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Farmer farmer = (Farmer)session.getAttribute("farmer");
            Timestamp posttime = new Timestamp(System.currentTimeMillis());

            if(title== null || title.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            Long postid = forumService.createPost(title, content, farmer, posttime, forumId).getPostid();
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/forum/post/" + postid.toString());

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/forum").forward(request, response);
        }
    }
}
