package in.dream.web.controller.policymaker;

import in.dream.ejb.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.commons.text.StringEscapeUtils;

@WebServlet(name = "policymakerRegister", value = "/policymaker/Register")
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
            String email = StringEscapeUtils.escapeJava(request.getParameter("email"));

            if(username== null || username.isEmpty()
                    || password == null || password.isEmpty()
                    || email == null || email.isEmpty()) {
                throw new Exception("Required field is missing.");
            }

            accountService.createPolicyMakerAccount(username, password, email);
            response.sendRedirect(getServletContext().getContextPath() + "/policymaker/login.jsp");

        } catch (Exception e) {
            request.setAttribute("errorMsgReg", e.getMessage());
            request.getRequestDispatcher("/policymaker/register.jsp").forward(request, response);

        }

    }
}
