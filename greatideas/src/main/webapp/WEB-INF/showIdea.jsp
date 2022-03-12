<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ideas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
    <script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class = "mt-3 mb-4">
	
<h1>Welcome, ${user.name}</h1>
<div><a href="/logout">Logout</a></div>

<h3>Ideas</h3>
<div class="row">
	
					<div class="col-9">
						
						<table class="table table-dark mt-1">
	<thead>
		<tr>
			<th>Idea:</th>
			<th>Created By:</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ideas}" var="idea">
		<tr>
			<td>
				<a href="/ideas/${idea.id}"><c:out value="${idea.name}"/></a>
			</td>
			<td><c:out value="${idea.creator.name}"/></td>
		</tr> 
		</c:forEach>
	</tbody>
</table>

</div>
</div>
					</div>
					<div>
    			<a class= "btn btn-success text-decoration-none" href="/ideas/new">Create An Idea</a>
    		</div>

</body>
</html>