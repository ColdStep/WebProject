package Controller;

import Module.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet("/log")

public class Logger  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestedSessionId();
        Database database = new Database();

        try {
            if (database.isExist(req.getParameter("login"),req.getParameter("password"))==true) {
                resp.sendRedirect("Pages/Home.html");
            }else {
                resp.getWriter().write("Wrong Login or password");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
