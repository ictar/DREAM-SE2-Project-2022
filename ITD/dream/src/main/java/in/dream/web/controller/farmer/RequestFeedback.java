package in.dream.web.controller.farmer;


import in.dream.ejb.services.ProblemService;
import org.apache.commons.text.StringEscapeUtils;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "farmerRequestFeedback", urlPatterns = "/farmer/request/feedback")
public class RequestFeedback extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ProblemService")
    private ProblemService problemService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        try {
            Long pid = Long.parseLong(StringEscapeUtils.escapeJava(request.getParameter("problemid")));
            int feedback = Integer.parseInt(StringEscapeUtils.escapeJava(request.getParameter("feedback")));

            problemService.updateFeedback(pid, feedback);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(getServletContext().getContextPath() + "/farmer/request");
    }
}
