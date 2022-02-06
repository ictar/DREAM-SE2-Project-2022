package in.dream.web.controller.farmer;

import in.dream.ejb.services.AccountService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerRegister", value = "/farmer/Register")
public class Register extends HttpServlet {

    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;

    public void init() {
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
            String phnumber = StringEscapeUtils.escapeJava(request.getParameter("phonenumber"));

            if(username== null || username.isEmpty()
                    || password == null || password.isEmpty()
                    || phnumber == null || phnumber.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            accountService.createFarmerAccount(username, password, phnumber);
            response.sendRedirect(getServletContext().getContextPath() + "/farmer/login.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/farmer/register.jsp").forward(request, response);
        }
    }
}
