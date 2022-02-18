<%@ page import="taskManagement.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="taskManagement.model.User" %>
<%
    List<Task> tasks = (List<Task>) request.getAttribute("allUserTasks");
%>

<% User user = (User) request.getSession().getAttribute("user");%>
<table class="styled-table">
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>UserName</th>
        <th>Status</th>
        <th>Deadline</th>
    </tr>
    </thead>
    <tbody>
    <% for (Task task : tasks) { %>
    <tr>


        <td><%=task.getDescription()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=task.getStatus()%>
        </td>

    </tr>
    <% } %>
    </tbody>
</table>

