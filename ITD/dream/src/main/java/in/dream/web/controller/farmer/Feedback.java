package in.dream.web.controller.farmer;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.services.ProblemService;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "farmerNewRequest", urlPatterns = "/farmer/NewRequest")
public class Feedback extends HttpServlet {
    @EJB(name = "in.dream.ejb.services/ProblemService")
    private ProblemService problemService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }
