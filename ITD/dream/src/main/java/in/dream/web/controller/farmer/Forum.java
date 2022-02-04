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

@WebServlet(name = "farmerForum", value= {"/farmer/forum"})
public class Forum extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ForumService")
    private ForumService forumService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }
        String path="/farmer/forum.jsp";

        Farmer fm = (Farmer)session.getAttribute("farmer");

        request.setAttribute("user", fm.getName());
        request.setAttribute("postList", forumService.getPost());
        request.getRequestDispatcher(path).forward(request, response);
    }
}
