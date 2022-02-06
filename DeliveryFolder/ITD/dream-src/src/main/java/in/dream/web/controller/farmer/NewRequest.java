package in.dream.web.controller.farmer;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.ProblemService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerNewRequest", value = "/farmer/request/create")
public class NewRequest extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ProblemService")
    private ProblemService problemService;
    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the farmer is not logged in, redirect to the login
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }
        String path="/farmer/newRequest.jsp";

        Farmer fm = (Farmer)session.getAttribute("farmer");

        request.setAttribute("user", fm.getName());
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathCtx = getServletContext().getContextPath();
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("farmer") == null) {
            response.sendRedirect(pathCtx+"/farmer/login.jsp");
            return;
        }

        String title, content;
        Timestamp time;
        try {
            title = StringEscapeUtils.escapeJava(request.getParameter("title"));
            content = StringEscapeUtils.escapeJava(request.getParameter("content"));
            Farmer farmer = (Farmer)session.getAttribute("farmer");
            time = new Timestamp(System.currentTimeMillis());

            if(title== null || title.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            // find agronomist;
            Agronomist agronomist = accountService.getAgronomistByFarmer(farmer.getFarmerid());
            problemService.createProblem(title, content,farmer,time, agronomist);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/request");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            this.doGet(request, response);
        }
    }
}
