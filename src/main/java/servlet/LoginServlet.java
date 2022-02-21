package servlet;

import taskManagement.enums.UserType;
import taskManagement.meneger.TaskManager;
import taskManagement.meneger.UserManager;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        User user = userManager.getUserByEmailAndPassword(email, password);
        if (user == null) {
            req.getRequestDispatcher("/WEB-INF/wrongData.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("tasks", taskManager.getTaskByUser(user));
            if (user.getUserType() == UserType.MANAGER) {
                resp.sendRedirect("/managerHome");
            } else {
                resp.sendRedirect("/userMenu");
            }
        }
    }
}
