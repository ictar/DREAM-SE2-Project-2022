package in.dream.web.controller.farmer;

import in.dream.ejb.services.ForumService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerPost", urlPatterns = "/farmer/Comment")
public class Comment extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String title, content;
        try {
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Timestamp posttime = new Timestamp(System.currentTimeMillis());

            if(content== null || content.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            forumService.createComment(content,posttime);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/comment.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/index.jsp").forward(request, response);
        }
    }
}
