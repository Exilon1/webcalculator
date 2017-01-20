import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Alexey on 20.01.2017.
 */
public class FormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        // Get the values of all request parameters
        Enumeration en = req.getParameterNames();
        while(en.hasMoreElements()) {
            // Get the name of the request parameter
            String name = (String)en.nextElement();
            out.println(name);

            // Get the value of the request parameter
            String value = req.getParameter(name);

            // If the request parameter can appear more than once in the query string, get all values
            String[] values = req.getParameterValues(name);

            for (int i=0; i<values.length; i++) {
                out.println(" " + values[i]);
            }
        }
        out.close();
    }
}

