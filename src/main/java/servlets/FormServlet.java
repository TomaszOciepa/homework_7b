package servlets;


import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/aplikacja")
public class FormServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "form";
    private static final Logger LOG = LoggerFactory.getLogger(FormServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);


        try {
            template.process(model, out);
            LOG.info("Loaded form");
        } catch (TemplateException e) {
            LOG.error("Failed to load form.");
        }
    }
}
