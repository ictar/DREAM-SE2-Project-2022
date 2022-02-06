package in.dream.web.controller.policymaker;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.DailyPlanService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "policymakerAgronomist", value = "/policymaker/agronomist/*")
public class Agronomist extends HttpServlet {

    @EJB(name="in.dream.ejb.services/DailyPlanService")
    private DailyPlanService dailyPlanService;
    @EJB(name="in.dream.ejb.services/AccountService")
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the policy maker is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("policymaker") == null) {
            response.sendRedirect(pathCtx+"/policymaker/login.jsp");
            return;
        }

        String path = "/policymaker/agronomist.jsp";

        String[] urlparas = request.getRequestURI().split("/");
        Long agid = Long.parseLong(urlparas[urlparas.length-1]);
        int page = -1;
        String tmp = StringEscapeUtils.escapeJava(request.getParameter("page"));
        if(tmp != null && !tmp.isEmpty()) {
            page = Integer.parseInt(tmp);
        }

        int count = -1;
        tmp = StringEscapeUtils.escapeJava(request.getParameter("count"));
        if(tmp != null && !tmp.isEmpty()) {
            count = Integer.parseInt(tmp);
        }

        request.setAttribute("dpList", dailyPlanService.getDailyPlanList(agid, page, count));
        Policymaker pm = (Policymaker)session.getAttribute("policymaker");
        request.setAttribute("user", pm.getName());

        request.setAttribute("agronomist", accountService.getAgronomist(agid));
        request.getRequestDispatcher(path).forward(request, response);
    }

}
