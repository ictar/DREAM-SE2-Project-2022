package in.dream.web.controller.farmer;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.GeospatialDataService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "policymakerHome", value = "/policymaker")
public class Home extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("policymaker") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        Policymaker pm = (Policymaker)session.getAttribute("policymaker");
        String path = "/policymaker/index.jsp";

        request.setAttribute("user", pm.getName());
        request.setAttribute("areaList", geoService.getAreaList());
        request.setAttribute("agList", accountService.getAgronomistList());
        request.getRequestDispatcher(path).forward(request, response);
    }
}
