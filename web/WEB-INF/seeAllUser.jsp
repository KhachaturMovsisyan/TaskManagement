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
    List<User> users = (List<User>) request.getAttribute("users");
%>
<h2>ALL USERS</h2>


<table style="background-color: white" >
    <thead>
    <tr style="border-style: solid">
        <th style="border-style: solid; border-color: #0062cc"><h3>Name</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>Surname</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>Email</h3></th>
        <th style="border-style: solid; border-color: #0062cc"><h3>User Type</h3></th>
    </tr>
    </thead>
    <tbody>
    <% for (User user : users) { %>
    <tr style="border-style: solid">
        <td style="border-style: solid; border-color: #0062cc"><h4><%=user.getName()%></h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=user.getSurname()%></h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=user.getEmail()%></h4>
        </td>
        <td style="border-style: solid; border-color: #0062cc"><h4><%=user.getUserType().name()%></h4>
        </td>

    </tr>
    <% } %>
    </tbody>

    </table>

</body>
</html>
