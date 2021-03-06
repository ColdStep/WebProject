package Controller;

import Module.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/log")

public class Logger  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestedSessionId();
        Database database = new Database();
        try {
            if (database.isExist(req.getParameter("login"),req.getParameter("password"))==true) {
                HttpSession session = req.getSession();
                session.setAttribute("login",req.getParameter("login"));
                session.setAttribute("password",req.getParameter("password"));
                resp.setStatus(302);
                resp.getWriter().write("/Pages/Home.html");

            }else if (database.isExist(req.getParameter("login"),req.getParameter("password"))==false){
                resp.getWriter().write("Wrong Login or password");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
