package in.dream.web.controller.policymaker;

import in.dream.ejb.models.Policymaker;
import in.dream.ejb.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "policymakerLogin", value = "/policymaker/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;

    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email, pwd;

        ServletContext servletContext = getServletContext();

        String path;

        try {
            email = request.getParameter("email");
            pwd = request.getParameter("pwd");

            if(email == null || pwd == null || email.isEmpty() || pwd.isEmpty()) {
                throw new Exception("Missing credential value");
            }

            Policymaker pm = accountService.authenticatePolicymaker(email, pwd);

            if(pm == null) {
                throw new Exception("Incorrect username or password");
            }

            // everything is ok
            request.getSession().setAttribute("policymaker", pm);
            path = getServletContext().getContextPath() + "/policymaker/Home";
            response.sendRedirect(path);

        }catch (Exception e) {
            path = "/policymaker/login.jsp";
            request.setAttribute("errorMsgLog", e.getMessage());
            request.getRequestDispatcher(path).forward(request, response);

            return;
        }
    }
}
