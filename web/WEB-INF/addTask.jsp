<%@ page import="java.util.List" %>
<%@ page import="taskManagement.model.User" %>
<%@ page import="taskManagement.model.Task" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
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
<% List<User> allUsers = (List<User>) request.getAttribute("allUsers");
    List<Task> allTasks = (List<Task>) request.getAttribute("allTasks");
%>

<div style="display: flex; justify-content: space-around">

    <form action="/addUser" method="post">
        <h1>Add User:</h1><br>
        name: <input style="margin-top: auto" type="text" name="name"> <br>
        surname: <input style="margin-top: auto" type="text" name="surname"> <br>
        email: <input style="margin-top: auto" type="text" name="email"> <br>
        password: <input style="margin-top: auto" type="text" name="password"> <br>
        <input style="margin-top: auto" type="submit" value="Add User">


        <div style="margin-top: 80px ">
            <form action="/all_users" method="get">
                <input type="submit" value="see all users"></form>


            <form action="/all_tasks" method="get">
                <input type="submit" value="see all tasks"></form>
        </div>
    </form>


    <form action="/addTask" method="post">
        <h1>Add Tasks:</h1><br>
        title: <input style="margin-top: auto" type="text" name="title"> <br>
        description: <input style="margin-top: auto" type="text" name="description"> <br>
        user: <select style="margin-top: auto" name="user"><%
        for (User user : allUsers) {%>
        <option value=<%=user.getId()%>> <%=user.getName() %>
        </option>
        <% }%></select><br>
        status: <select style="margin-top: auto" name="status">
        <option value="NEW">New</option>
        <option value="IN_PROGRESS">In progress</option>
        <option value="FINISHED">Finished</option>     </select><br>
        deadline: <input style="margin-top: auto" type="date" name="deadline"> <br>
        <input style="margin-top: auto" type="submit" value="Submit"> <br>

    </form>

</div>



</body>
</html>
