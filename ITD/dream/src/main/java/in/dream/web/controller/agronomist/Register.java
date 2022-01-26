package in.dream.web.controller.agronomist;

import in.dream.ejb.services.AccountService;
import in.dream.ejb.services.GeospatialDataService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "agronomistRegister", value = "/agronomist/Register")
public class Register extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/agronomist/register.jsp";

        request.setAttribute("areaList", geoService.getAreaList());
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String acc_privacy = StringEscapeUtils.escapeJava(request.getParameter("acc_privacy"));
            String acc_terms = StringEscapeUtils.escapeJava(request.getParameter("acc_terms"));
            if (acc_privacy == null || !acc_privacy.equals("on") || acc_terms == null || ! acc_terms.equals("on")) {
                throw new Exception("Privacy Statement / Terms and Conditions should be checked");
            }

            String username = StringEscapeUtils.escapeJava(request.getParameter("name"));
            String password = StringEscapeUtils.escapeJava(request.getParameter("pwd"));
            String email = StringEscapeUtils.escapeJava(request.getParameter("email"));
            Long areaId = Long.parseLong(StringEscapeUtils.escapeJava(request.getParameter("area")));

            if(username== null || username.isEmpty()
                    || password == null || password.isEmpty()
                    || email == null || email.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            accountService.createAgronomistAccount(username,password,email, areaId);
            response.sendRedirect(getServletContext().getContextPath() + "/agronomist/Register");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            doGet(request, response);
        }
    }
}
