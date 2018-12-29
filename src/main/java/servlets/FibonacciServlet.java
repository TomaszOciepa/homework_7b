package servlets;

import app.FibonacciCalculate;
import app.FibonacciElement;
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
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/fibonacci")
public class FibonacciServlet extends HttpServlet {

    private static final String TEMPLATE_OK = "fibonacci";
    private static final String TEMPLATE_FAILED = "failed";
    private static final Logger LOG = LoggerFactory.getLogger(FibonacciServlet.class);

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private FibonacciCalculate fibonacciCalculate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        String numberStr = req.getParameter("number");


        try {
            long element = Long.parseLong(numberStr);

            if (element < 0) {
                Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_FAILED);

                try {
                    template.process(model, out);
                    LOG.info("okgf");
                } catch (TemplateException e) {
                    LOG.error("Failed");
                }

            } else {
                List<FibonacciElement> fibonacciElementList = fibonacciCalculate.generateFibonacciElements(element);
                int lastElementFibonacciElementList = fibonacciElementList.size() - 1;
                model.put("fibo", fibonacciElementList);
                model.put("last", fibonacciElementList.get(lastElementFibonacciElementList));

                Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_OK);

                try {
                    template.process(model, out);
                    LOG.info("ok");
                } catch (TemplateException e) {
                    LOG.error("Failed");
                }
            }


        } catch (NumberFormatException e) {
            Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_FAILED);
            try {
                template.process(model, out);
            } catch (TemplateException e1) {
                e1.printStackTrace();
            }
        }


    }
}
