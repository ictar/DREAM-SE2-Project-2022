package in.dream.web.controller.agronomist;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "agronomistLogin", value = "/agronomist/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email, pwd;
        String path;

        try {
            email = request.getParameter("email");
            pwd = request.getParameter("password");

            if (email == null || pwd == null || email.isEmpty() || pwd.isEmpty()) {
                throw new Exception("Missing credential value");
            }

            Agronomist ag = accountService.authenticateAgronomist(email, pwd);

            if (ag == null) {
                throw new Exception("Incorrect email or password");
            }

            // everything is ok
            request.getSession().setAttribute("agronomist", ag);
            path = getServletContext().getContextPath() + "/agronomist/Home";
            response.sendRedirect(path);

        } catch (Exception e) {
            path = "/agronomist/login.jsp";
            request.setAttribute("errorMsgLog", e.getMessage());
            request.getRequestDispatcher(path).forward(request, response);

            return;
        }
    }
}
