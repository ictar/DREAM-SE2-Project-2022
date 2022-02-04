package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.ProblemService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerRequest", value = "/farmer/request/*")
public class Request extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ProblemService")
    private ProblemService problemService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }
        Farmer farmer = (Farmer)session.getAttribute("farmer");
        String path = "/farmer/request.jsp";

        request.setAttribute("user", farmer.getName());
        request.setAttribute("problemList", problemService.getProblemByFarmer(farmer.getFarmerid()));

        request.getRequestDispatcher(path).forward(request, response);
    }
}