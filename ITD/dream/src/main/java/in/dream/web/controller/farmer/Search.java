package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.GeospatialDataService;
import in.dream.ejb.services.SearchService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerSearch", value = "/farmer/search")
public class Search extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/SearchService")
    private SearchService searchService;
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geospatialDataService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String path="/farmer/search.jsp";

        request.setAttribute("areaList", geospatialDataService.getAreaList());
        request.setAttribute("productList", geospatialDataService.getTypeList());
        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());
        //request.setAttribute("farm", fm.getFarm());

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String path="/farmer/suggestion.jsp";

        Long areaId = Long.parseLong(StringEscapeUtils.escapeJava(request.getParameter("area")));
        String producttype = StringEscapeUtils.escapeJava(request.getParameter("productiontype"));

        request.setAttribute("result", searchService.search(areaId, producttype));


    }
}
