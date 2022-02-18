package servlet;

import taskManagement.meneger.TaskManager;
import taskManagement.meneger.UserManager;
import taskManagement.model.Task;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/adminHome")
public class MenuAdminServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    private TaskManager taskManager = new TaskManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allUsers",userManager.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/adminHome.jsp").forward(req, resp);

    }
}
