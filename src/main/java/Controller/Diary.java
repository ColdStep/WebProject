package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import Module.*;



@WebServlet("/diary")
public class Diary extends HttpServlet{



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        HttpSession session = req.getSession();
        String textDiary = new String(req.getParameter("reqDiary").getBytes("ISO-8859-1"), Charset.forName("UTF-8"));
        String login = session.getAttribute("login").toString();
        String password = session.getAttribute("password").toString();

        try {
            Database database = new Database();
            database.setDiary(textDiary,login);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.getWriter().write("Save");

    }
}
