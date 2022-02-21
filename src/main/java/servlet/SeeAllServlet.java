package servlet;

import taskManagement.meneger.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/seeAllUser")
public class SeeAllServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userManager.getAllUsers());

        req.getRequestDispatcher("/WEB-INF/seeAllUser.jsp").forward(req, resp);
    }
}
