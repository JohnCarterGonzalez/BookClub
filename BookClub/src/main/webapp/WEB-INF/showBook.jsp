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
    <title>Your Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1 class="text-primary">One of <c:out value="${book.user.userName}"/>'s Books</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col"><c:out value="${book.id}"/></th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Thoughts on the Book</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${book.title}"/></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.description}"/></td>
				</tr>	
			</tbody>
		</table>
		<a href="/dashboard" class="btn btn-primary" role="button">Go Back</a>
		<a href="/books/edit/{book.id}" class ="btn btn-warning">Edit your Book</a>
	</div>
</body>
</html>
