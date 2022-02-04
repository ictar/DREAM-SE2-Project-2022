package in.dream.web.controller.agronomist;

import in.dream.ejb.external.Weather;
import in.dream.ejb.models.Agronomist;
import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.DailyPlanService;
import in.dream.ejb.services.GeospatialDataService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "agronomistHome", urlPatterns = {"/agronomist/Home"})
public class Home extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;
    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;
    @EJB(name = "in.dream.ejb.services/DailyPlanService")
    private DailyPlanService dailyPlanService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the agronomist is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("agronomist") == null) {
            response.sendRedirect(pathCtx+"/agronomist/login.jsp");
            return;
        }

        String path = "/agronomist/home.jsp";
        Agronomist agronomist = (Agronomist) session.getAttribute("agronomist");

        Long areaId = agronomist.getArea().getAreaid();

        request.setAttribute("area", geoService.getArea(areaId));
        Weather weather = geoService.getWeather(areaId);
        request.setAttribute("weather", weather);
        request.setAttribute("water", geoService.getWaterIrrigation(areaId));
        request.setAttribute("soil", geoService.getSoil(areaId));
        request.setAttribute("FarmerPerformance", accountService.getFarmerPerformanceList(areaId));
        request.setAttribute("Dailyplan", dailyPlanService.getDailyPlanList(agronomist.getAgronomistid(),-1,-1));

        request.setAttribute("user", agronomist.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }
}
