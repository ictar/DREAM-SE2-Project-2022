package in.dream.web.controller.policymaker;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.DailyPlanService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "policymakerAgronomistDailyPlan", value = "/policymaker/agronomist/dailyplan/*")
public class AgronomistDailyPlan extends HttpServlet {
    @EJB(name="in.dream.ejb.services/DailyPlanService")
    private DailyPlanService dailyPlanService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("policymaker") == null) {
            response.sendRedirect(pathCtx+"/policymaker/login.jsp");
            return;
        }

        String path = "/policymaker/dailyplan.jsp";

        String[] urlparas = request.getRequestURI().split("/");
        Long dpid = Long.parseLong(urlparas[urlparas.length-1]);

        request.setAttribute("dailyplan", dailyPlanService.getDailyPlanDetail(dpid));

        Policymaker pm = (Policymaker)session.getAttribute("policymaker");
        request.setAttribute("user", pm.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }
}
