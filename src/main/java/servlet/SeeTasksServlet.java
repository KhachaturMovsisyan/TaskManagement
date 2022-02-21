package servlet;

import taskManagement.meneger.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/seeAllTasks")
public class SeeTasksServlet extends HttpServlet {

    TaskManager taskManager=new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tasks", taskManager.getAllTask());

        req.getRequestDispatcher("/WEB-INF/seeAllTasks.jsp").forward(req,resp);
    }
}
