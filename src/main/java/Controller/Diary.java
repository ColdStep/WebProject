package Controller;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/diary")
public class Diary extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("C:\\Users\\vbaku\\IdeaProjects\\webproject\\src\\main\\webapp\\Files\\diary.txt");
        String textDiary = req.getParameter("reqDiary");
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("login"));
        System.out.println(session.getAttribute("password"));

        FileUtils.write(file,textDiary);
        resp.getWriter().write("Save");

    }
}
