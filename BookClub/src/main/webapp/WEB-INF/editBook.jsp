<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit your Book Shelf</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="container">
	<h2 class="text-success">Edit a Book</h2>
	<form:form action="books/{id}" class="form" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
			<div class="mb-3">
			    <form:label class="form-label" path="title">Title of the Book: </form:label>
			    <form:errors path="title"/>
			    <form:input type="text" class="form-control" path="title"/>
		  </div>
		  <div class="mb-3">
			    <form:label class="form-label" path="author">Name of Author: </form:label>
			    <form:errors path="author"/>
			    <form:input type="text" class="form-control" path="author"/>
		  </div>
		<div class="form-floating">
			  <form:textarea class="form-control" path="description" placeholder="Enter some of your thoughts here." style="height: 100px"></form:textarea>
			  <form:errors path="description"/>
			  <form:label for="floatingTextarea2" path="description">Your Thoughts: </form:label>
		</div>
		  <button type="submit" class="btn btn-success">Update your Book</button>
		</form:form>
		</div>
	</div>
</body>
</html>
