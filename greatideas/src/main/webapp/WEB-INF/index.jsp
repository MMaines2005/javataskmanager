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
	<div class="container my-5">
		 	<div class="row justify-content-around">
		        
		       
		        <div class="col-5 border border-dark pl-5">
					
					<h2 class="my-3">Register</h2>
			         
			        <form:form action="/register" method="POST" modelAttribute="user">
			        	
						<!-- Name Field -->
			        	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="name">Name</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="name"/>
				        		<form:errors class="small" path="name"/>
				        	</div>
				    	</div>
				    	
				    	
				    	<!-- Email Field -->
			        	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="email">Email</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="email" path="email"/>
				        		<form:errors class="small" path="email"/>
				        	</div>
				    	</div>
				    			    	
				    	<!-- Password Field -->
				    	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="password">Password</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="password" path="password"/>
				        		<form:errors class="small" path="password"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Password Confirmation Field -->
				    	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="confirmPassword">Password Confirm</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="password" path="confirmPassword"/>
				        		<form:errors class="small" path="confirmPassword"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-3 offset-3">
			    				<input class = "btn btn-success" type="submit" value="Register"/>
			    			</div>	
			    		</div>
				    	
			    	</form:form>
		        
		       
		    </div>
		<div class="col-5 border border-dark pl-5">
		            
		            <h2 class="my-3">Login</h2>
			        
					<p id="errors" class="mb-3"><c:out value="${error}" /></p>
					
			        <form action="/login" method="POST">
			        	
						<!-- Email Field -->
			        	<div class="form-group row">
				        	<label class="col-3 col-form-label" for="email">Email</label>
				       		 <div class="col-8">
				        		<input class="form-control" type="email" id="email" name="email"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Password Field -->
				    	<div class="form-group row">
				        	<label class="col-3 col-form-label" for="password">Password</label>
				       		 <div class="col-8">
				        		<input class="form-control" type="password" id="password" name="password"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-3 offset-3">
			    				<input class = "btn btn-success" type="submit" value="Log In"/>
			    			</div>	
			    		</div>
			    		
			    	</form>
			    	
		        </div>
		  </div>		        
	</div>
	
</body>
</html>