package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            req.getParameter(names.nextElement());
        }
    }
}
