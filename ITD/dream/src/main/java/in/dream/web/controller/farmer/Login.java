package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "farmerLogin", value = "/farmer/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @EJB(name = "in.dream.ejb.services/AccountService")
    private AccountService accountService;

    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pnumber, pwd;
        String path;

        try {
            pnumber = request.getParameter("phonenumber");
            pwd = request.getParameter("pwd");

            if(pnumber == null || pwd == null || pnumber.isEmpty() || pwd.isEmpty()) {
                throw new Exception("Missing credential value");
            }

            Farmer farmer = accountService.authenticateFarmer(pnumber, pwd);

            if(farmer == null) {
                throw new Exception("Incorrect phonenumber or password");
            }

            // everything is ok
            request.getSession().setAttribute("farmer", farmer);
            path = getServletContext().getContextPath() + "/farmer/Home";
            response.sendRedirect(path);

        }catch (Exception e) {
            path = "/farmer/login.jsp";
            request.setAttribute("errorMsgLog", e.getMessage());
            request.getRequestDispatcher(path).forward(request, response);

            return;
        }
    }
}
