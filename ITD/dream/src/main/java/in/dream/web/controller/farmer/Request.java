package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.ProblemService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerRequest", urlPatterns = "/farmer/request/*")
public class Request extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/Problem")
    private ProblemService problemService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String path = "/farmer/request.jsp";
        Farmer farmer = (Farmer)session.getAttribute("farmer");


        request.setAttribute("user", farmer.getName());
        request.getRequestDispatcher(path).forward(request, response);
    }
}
