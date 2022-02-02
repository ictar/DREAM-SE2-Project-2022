package in.dream.web.controller.farmer;

import in.dream.ejb.external.Weather;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.GeospatialDataService;
import in.dream.ejb.services.ProductionReportService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerReport", value = "/farmer/report")
public class Report extends HttpServlet {

    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geospatialDataService;
    @EJB(name = "in.dream.ejb.services/ProductionReportService")
    private ProductionReportService reportService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String path="/farmer/report.jsp";

        request.setAttribute("productList", geospatialDataService.getTypeList());
        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());

        String path="/farmer/report";

        String producttype = StringEscapeUtils.escapeJava(request.getParameter("productiontype"));
        float amount = Float.parseFloat(StringEscapeUtils.escapeJava(request.getParameter("amount")));
        float acreage = Float.parseFloat(StringEscapeUtils.escapeJava(request.getParameter("acreage")));
        String starttime = StringEscapeUtils.escapeJava(request.getParameter("starttime"));
        String endtime = StringEscapeUtils.escapeJava(request.getParameter("endtime"));

        try {
            reportService.reportProduction(fm, producttype, amount, acreage, starttime, endtime);
            request.setAttribute("errorMsg", "Report successfully!");
        } catch (CreateException e) {
            request.setAttribute("errorMsg", e.getMessage());
        }

        this.doGet(request, response);
    }
}
