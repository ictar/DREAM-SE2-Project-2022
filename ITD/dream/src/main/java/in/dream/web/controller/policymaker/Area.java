package in.dream.web.controller.policymaker;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.GeospatialDataService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "policymakerArea", urlPatterns = {"/policymaker/area/*"})
public class Area extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("policymaker") == null) {
            response.sendRedirect(pathCtx+"/policymaker/login.jsp");
            return;
        }

        String path = "/policymaker/area.jsp";

        Long areaId = Long.parseLong(StringEscapeUtils.escapeJava(request.getParameter("id")));

        request.setAttribute("area", geoService.getArea(areaId));
        request.setAttribute("weather", geoService.getWeather(areaId));
        request.setAttribute("waterList", geoService.getWaterIrrigation(areaId));
        request.setAttribute("soilList", geoService.getSoil(areaId));
        // TODO
        // request.setAttribute("productionList", productionService.getFarmerProductionList(areaId);

        Policymaker pm = (Policymaker)session.getAttribute("policymaker");
        request.setAttribute("user", pm.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }
}
