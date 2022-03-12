<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Task</th>
      <th scope="col">Creator</th>
      <th scope="col">Assignee</th>
      <th scope="col">Priority</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach item="${info}" var="task">
    <tr>
      <th scope="row"></th>
      <td>${task.task_id}</td>
      <td>${task.name}</td>
      <td>${task.assignee}</td>
      <td>${task.priority}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>