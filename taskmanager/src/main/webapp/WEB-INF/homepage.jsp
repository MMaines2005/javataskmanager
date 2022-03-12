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
<div class="container">
<div class="row justify-content: center" >
	<div class="col">
<h1>Register</h1>
<form:form method= "POST" action="/register" modelAttribute="user">
<div class="form-group">
<form:label path="name">Name</form:label>
<form:errors path="name"/>
<form:input type="text" path="name"/>
</div>
<div class="form-group">	
<form:label path="email">Email</form:label>
<form:errors path="email"/>
<form:input type="text" path="email"/>
</div>

<div class="form-group">
<form:label path="password">Password</form:label>
<form:errors path="password"/>
<form:input type="password" path="password"/>
</div>
<div class="form-group">
<form:label path="confirmpassword">Confirm Password</form:label>
<form:errors path="confirmpassword"/>
<form:input type="password" path="confirmpassword"/>
</div>
<input class="btn btn-danger" type="submit" value="Register">
</form:form>
	</div>
	<div class="col">
		
<form  method="post" action="/login">
<h1>Log in Here</h1>
<div class="form-group">
<form:label path="email">Email</form:label>
<form:errors path="email"/>
<form:input type="text" path="email"/>
</div>
<div class="form-group">
<form:label path="password">Password</form:label>
<form:errors path="password"/>
<form:input type="password" path="password"/>
</div>
<button>Login</button>
</form>
	</div>
</div>
</div>
</body>
</html>