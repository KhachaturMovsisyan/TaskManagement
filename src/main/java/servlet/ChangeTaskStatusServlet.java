package servlet;

import taskManagement.enums.TaskStatus;
import taskManagement.meneger.TaskManager;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeStatus")
public class ChangeTaskStatusServlet extends HttpServlet {
    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        TaskStatus newStatus = TaskStatus.valueOf(status);
//int taskId=Integer.parseInt(req.getParameter());
        TaskManager taskManager=new TaskManager();
      //  taskManager.update(status,);

        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");

    }
}
