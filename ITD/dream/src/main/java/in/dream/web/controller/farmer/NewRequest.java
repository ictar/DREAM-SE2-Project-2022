package in.dream.web.controller.farmer;
import in.dream.ejb.models.Farmer;

import in.dream.ejb.services.ProblemService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
@WebServlet(name = "farmerNewRequest", urlPatterns = "/farmer/NewRequest")
public class NewRequest extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ProblemService")
    private ProblemService problemService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String title, content;
        try {
            title = StringEscapeUtils.escapeJava(request.getParameter("title"));
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Farmer farmer = (Farmer)session.getAttribute("farmer");
            Timestamp requesttime = new Timestamp(System.currentTimeMillis());

            if(title== null || title.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            problemService.createRequest(title, content,farmer,requesttime);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/request.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/index.jsp").forward(request, response);
        }
    }
}
