package in.dream.web.controller.policymaker;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.GeospatialDataService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "policymakerFarmerPerformance", value = "/policymaker/area/performance/*")
public class FarmerPerformance extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;

    private boolean isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.isNew() || session.getAttribute("policymaker") == null;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        if(isLogin(request)) {
            response.sendRedirect(pathCtx+"/policymaker/login.jsp");
            return;
        }

        String path = "/policymaker/performance.jsp";

        String[] urlparas = request.getRequestURI().split("/");
        Long areaId = Long.parseLong(urlparas[urlparas.length-1]);

        request.setAttribute("area", geoService.getArea(areaId));
        request.setAttribute("farmerList", accountService.getFarmerPerformanceList(areaId));

        Policymaker pm = (Policymaker)request.getSession()
                .getAttribute("policymaker");

        request.setAttribute("user", pm.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        if(isLogin(request)) {
            response.sendRedirect(pathCtx+"/policymaker/login.jsp");
            return;
        }

        try {
            Map<String, String[]> paras = request.getParameterMap();
            // get data
            Map<Long, Integer> performanceData = new HashMap<>();
            for(Map.Entry<String, String[]> entry: paras.entrySet()){
                if(entry.getKey().startsWith("performance_")) {
                    Long key = Long.parseLong(entry.getKey().split("performance_")[1]);
                    Integer value = Integer.parseInt(entry.getValue()[0]);
                    performanceData.put(key, value);
                }
            }
            // update
            accountService.updatePerformance(performanceData);

            String path = getServletContext().getContextPath() + "/policymaker/area/" + request.getParameter("areaId");
            response.sendRedirect(path);

        }catch (Exception e) {
            request.setAttribute("errMsg", e.getMessage());
            this.doGet(request, response);
        }
    }
}
