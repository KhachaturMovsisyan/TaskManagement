package servlet;

import taskManagement.meneger.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/managerHome")
public class ManagerMenuServlet extends HttpServlet {
    private UserManager userManager = new UserManager();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allUsers",userManager.getAllUsers());


        req.getRequestDispatcher("/WEB-INF/managerHome.jsp").forward(req, resp);

    }
}
