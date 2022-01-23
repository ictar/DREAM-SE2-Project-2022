package in.dream.web.controller.policymaker;

import in.dream.ejb.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.commons.text.StringEscapeUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@WebServlet(name = "Register", value = "/policymaker/Register")
public class Register extends HttpServlet {

    private TemplateEngine templateEngine;
    private ServletContext servletContext;
    private WebContext ctx;

    @EJB(name = "services/AccountService")
    private AccountService accountService;

    public void init() {
        servletContext = getServletContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
        templateResolver.setSuffix(".html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result;
        String username = StringEscapeUtils.escapeJava(request.getParameter("name"));
        String password = StringEscapeUtils.escapeJava(request.getParameter("pwd"));
        String email = StringEscapeUtils.escapeJava(request.getParameter("email"));

        boolean success = accountService.createPolicyMakerAccount(username, email, password);

        if (!success)
            result = "Error occurred";
        else
            result = "Registration was successful";

        ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("errorMsgReg", result);
        templateEngine.process("/index.html", ctx, response.getWriter());
    }
}
