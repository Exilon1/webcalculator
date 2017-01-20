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
        resp.setContentType("text");


        Enumeration en = req.getParameterNames();
        while(en.hasMoreElements()) {

            String name = (String)en.nextElement();
            out.println(name);

            String value = req.getParameter(name);

            String[] values = req.getParameterValues(name);

            for (int i=0; i<values.length; i++) {
                out.println(" " + values[i]);
            }
        }
        out.close();
    }
}

