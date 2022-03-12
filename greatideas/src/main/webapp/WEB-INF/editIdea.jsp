<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h1>Welcome, ${user.name}</h1>
<div><a href="/logout">Logout</a></div>
	<h3><c:out value="${idea.name}"/></h3>
			
		<hr>
		
		<div class="ml-3" >
	
			<h5 class="mb-4"> Edit Idea</h5>

			<!-- Add Event Form -->
			<div class="row">
				<div class="col-6">
					<form:form action="/ideas/${idea.id}/edit" method="POST" modelAttribute="idea">
						<input type="hidden" name="_method" value="put"/>
												
						<!-- Passing user_id for relating the event created with the user -->
						<form:hidden value="${ user.id }" path="creator"/>
						        	
						<!-- Name Field -->
			        	<div class="form-group row">
				        	<form:label class="col-2 col-form-label" path="name">${idea.name}</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="name"/>
				        		<form:errors class="small" path="name"/>
				        	</div>
				    	</div>
				    		    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-1 offset-2">
			    				<input class = "btn btn-success" type="submit" value="Edit"/>
			    			</div>
			    			<div class="col-1 ml-2">
    							<a class= "btn btn-danger text-decoration-none" href="/ideas/${idea.id}/delete">Delete</a>
    						</div>
			    		</div>
			    		
			    		<p id="errors" class="mb-3"><c:out value="${error}" /></p>
				    	
				    </form:form>
		    	
		    	</div>
		    </div>
		</div>
</body>
</html>