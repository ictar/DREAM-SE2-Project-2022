package in.dream.web.controller.farmer;

import in.dream.ejb.external.Weather;
import in.dream.ejb.models.Area;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.GeospatialDataService;
import in.dream.ejb.services.SearchService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "farmerSearch", value = "/farmer/search")
public class Search extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/SearchService")
    private SearchService searchService;

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

        Map<String, Object> infos = searchService.getSearchInfo();
        request.setAttribute("areaList", (List<Area>)infos.get("areaList"));
        request.setAttribute("productList",(List<String>)infos.get("typeList"));
        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());
        request.setAttribute("farm", fm.getFarm());

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

        Map<String, Object> result = searchService.search(areaId, producttype);
        request.setAttribute("weather",(Weather)result.get("weather") );
        if(result.get("suggestion") != null) {
            request.setAttribute("suggestion", (Map)result.get("suggestion"));
        }
        request.setAttribute("plantname", producttype);

        Farmer fm = (Farmer)session.getAttribute("farmer");
        request.setAttribute("user", fm.getName());

        request.getRequestDispatcher(path).forward(request, response);
    }
}
