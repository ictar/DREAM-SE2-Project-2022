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

@WebServlet(name = "farmerComment", value = "/farmer/forum/comment")
public class Comment extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String content;

        Long postId =  Long.parseLong(StringEscapeUtils.escapeJava(request.getParameter("postId")));
        try {
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Timestamp commenttime = new Timestamp(System.currentTimeMillis());


            Farmer fm = (Farmer)session.getAttribute("farmer");

            forumService.createComment(fm, postId, content,commenttime);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/forum/post/" + postId);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/forum/post/" + postId).forward(request, response);
        }

    }

}
