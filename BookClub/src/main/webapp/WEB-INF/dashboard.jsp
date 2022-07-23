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
<title>Dashboard</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<h1 class="text-primary">Welcome, <c:out value="${user.userName}"/> to your Book Shelf</h1>
		<h3 class=text-dark">Find actions here:</h3>
		<a href = "/logout">Logout</a>
		<a href = "/add/Book">Add a Book to your Shelf</a>

		<table class="table">
			<thead>
				<tr>
					<th scope="col"><c:out value="${id}"/></th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
					<th scope="col">Actions</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach var="x" items="${books}">
				<tr>
					<td><a href="/books/${x.id}"><c:out value="${x.title}"/></a></td>
					<td><c:out value="${x.author}"/></td>
					<td><c:out value="${x.user.userName}"/></td>
					<td><a href="/books/edit/{x.id}"<c:out value="${x.id}"/>">Edit</a>
					<form:form action="/books/${x.id}" method="post">
					    <form:input type="hidden" name="_method" value="delete">
					    <form:input type="submit" class="btn btn-danger" value="Delete">
					</form:form>
					</td>
				</tr>	
			</c:forEach>
			</tbody>
		</table>
	</div>	
</body>
</html>
