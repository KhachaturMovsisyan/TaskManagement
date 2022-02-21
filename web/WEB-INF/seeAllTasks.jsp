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
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<h2>ALL TASKS</h2>


<table style="background-color: white">
    <thead>
    <tr style="border-style: solid">
        <th style="border-style: solid; border-color: #0062cc"><h3>Title</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>Description</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>Task_Status</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>Deadline</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>User Name</h3></th>
    </tr>
    </thead>
    <tbody>
    <% for (Task task : tasks) { %>
    <tr style="border-style: solid">
        <td style="border-style: solid; border-color: #0062cc"><h4><%=task.getTitle()%>
        </h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=task.getDescription()%>
        </h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=task.getStatus()%>
        </h4>

        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=task.getDeadline()%>
        </h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=task.getUser().getName()%>
        </h4>
    </tr>
    <% } %>
    </tbody>

</table>

</body>
</html>
