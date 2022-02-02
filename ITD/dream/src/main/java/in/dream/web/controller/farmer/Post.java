package in.dream.web.controller.farmer;

import in.dream.ejb.services.ForumService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerPost", urlPatterns = "/farmer/Post")
public class Post extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

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
            request.getRequestDispatcher("/farmer/index.jsp").forward(request, response);
        }
    }
}
