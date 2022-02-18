package servlet;

import taskManagement.enums.TaskStatus;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/addTask")

public class addTaskServlet extends HttpServlet {

    private UserManager userManager = new UserManager();
    private TaskManager taskManager = new TaskManager();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("title");
        String description = req.getParameter("description");
        TaskStatus status = TaskStatus.valueOf(req.getParameter("status"));
        try {
            Date deadline = sdf.parse(req.getParameter("deadline"));
            int user_id = Integer.parseInt(req.getParameter("user"));
            Task task = new Task();
            task.setTitle(name);
            task.setDescription(description);
            task.setStatus(status);
            task.setDeadline(deadline);
            task.setUser(userManager.getById(user_id));
            taskManager.addTask(task);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(taskManager.getAllTask());


        req.setAttribute("allUsers", userManager.getAllUsers());

        req.getRequestDispatcher("/WEB-INF/addTask.jsp").forward(req, resp);
    }
}
