package taskManagement.meneger;

import taskManagement.DB.DBConnectionProvider;
import taskManagement.enums.TaskStatus;
import taskManagement.model.Task;
import taskManagement.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private UserManager userManager = new UserManager();

    public Task getById(long id) {
        String sql = "SELECT * FROM task WHERE id=" + id;
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getTaskFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public boolean addTask(Task task) {
        String sql = "INSERT  INTO task (name,description,status,user_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setObject(3, task.getStatus().name());
            preparedStatement.setLong(4, task.getUser().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException E) {
            E.printStackTrace();
            return false;
        }

    }


    public List<Task> getTaskByUser(User user) {
        List<Task> toDoList = new ArrayList<>();
        String sql = "SELECT * FROM task where user_id = " + user.getId();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoList.add(getTaskFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return toDoList;
    }

    public List<Task> getTaskByUserandStatus(User user, TaskStatus status) {
        List<Task> toDoList = new ArrayList<>();
        String sql = "SELECT * FROM todo where user_id =? AND status =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, status.name());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toDoList.add(getTaskFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return toDoList;
    }

    public boolean update(long id, TaskStatus status) {
        String sql = "UPDATE todo SET status=? WHERE id=?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(2, id);
            statement.setString(1, status.name());
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delate(long id) {
        String sql = "delete * FROM todo WHERE id=?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Task getTaskFromResultSet(ResultSet resultSet) {
        Task task = new Task();
        try {
            task.setId(resultSet.getInt(1));
            task.setName(resultSet.getString(2));
            task.setDescription((resultSet.getString(3)));
            task.setStatus(TaskStatus.valueOf(resultSet.getString(4)));
            task.setUser(userManager.getById(resultSet.getLong(5)));
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}