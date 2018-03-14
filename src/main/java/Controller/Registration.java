package Controller;
import Module.*;
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
        Database database = new Database();
        Enumeration<String> names = req.getParameterNames();
        String[] values = new String[6];
        int i=0;
        while (names.hasMoreElements()){
            values[i]=req.getParameter(names.nextElement());
            i++;
        }


        database.setAllIndormation(values[0],values[1],Integer.valueOf(values[2]),values[3],values[4]);
        resp.sendRedirect("Pages/Home.html");

        }

        }

