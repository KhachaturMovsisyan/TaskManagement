<%@ page import="java.util.List" %>
<%@ page import="taskManagement.model.User" %>
<%@ page import="taskManagement.model.Task" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Home</title>
    <style>
        body {

            background-image: url("images/icons/task-management-software.png");
            background-size: 100% 100%;
        }
    </style>


</head>
<style> input[type=text], input[type=date], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid black;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: black;
    color: darkgray;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: black;
}
</style>


<body>
<%
    User user = (User) session.getAttribute("user");
    List<Task> taskList =  (List<Task>) session.getAttribute("tasks");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<h2>Welcome</h2>
<h2><%=user.getName()%></h2>
<h2><%=user.getSurname()%></h2>

<table style="background-color: lavender"; >
    <thead>
    <tr style="border-style: solid">
        <th><h3>Title</h3></th>
        <th><h3>Description</h3></th>
        <th><h3>Status</h3></th>
        <th><h3>Deadline</h3></th>
        <th><h3>Change Status</h3></th>
    </tr>
    </thead>
    <tbody>
    <% for (Task task : taskList) { %>
    <tr style="border-style: solid">
        <td><h3><%=task.getTitle()%></h3>
        </td>
        <td><h3><%=task.getDescription()%></h3>
        </td>
        <td><h3><%=task.getStatus()%></h3>
        </td>
        <td><h3><%=sdf.format(task.getDeadline())%></h3>
        </td>
        <td><select style="margin-top: auto" name="status">
            <option value="NEW">New</option>
            <option value="IN_PROGRESS">In progress</option>
            <option value="FINISHED">Finished</option>     </select><br>
            <input style="margin-top: auto" type="submit" value="Change"> <br>
        </td>

    </tr>
    <% } %>
    </tbody>

    </table>








</body>
</html>
