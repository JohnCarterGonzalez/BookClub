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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
    <h1 class="text-primary">Welcome!</h1>
    <h4 class="text-dark">Join our growing community</h4>
      <div class="row">
          <h2 class="text-dark">Registration</h2>
          <form:form action="/reg" method="post" modelAttribute="newUser">
              <div class="mb-3">
                  <form:label path="userName" class="form-label">User Name:</form:label>
                  <form:errors path="userName"/>
                  <form:input class="form-control" path="userName"/>
                </div>

              <div class="mb-3">
                  <form:label path="email" class="form-label">Email address</form:label>
                  <form:errors path="email"/>
                  <form:input type="email" class="form-control"/>
                  <div class="form-text">We'll never share your email with anyone else.</div>
                </div>

                <div class="mb-3">
                  <form:label class="form-label" path="password">Password</form:label>
                  <form:errors path="password"/>
                  <form:input type="password" class="form-control"/>
                </div>
                <div class="mb-3">
                  <form:label class="form-label" path="confirm">Confirm Password</form:label>
                  <form:errors path="confirm"/>
                  <form:input type="confirm" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
          </form:form>
      </div>

      <div class="row">
      <h2 class="text-dark">Login</h2>
		<form:form action="/log" method="post" modelAttribute="newLogin">
		  <div class="mb-3">
			<form:label for="exampleInputEmail1" class="form-label">Email address</form:label>
			<form:errors path="email"/>
			<form:input type="email" class="form-control" path="email"/>
		  </div>
		  <div class="mb-3">
			<form:label for="exampleInputPassword1" class="form-label">Password</form:label>
			<form:errors path="password"/>
			<form:input type="password" class="form-control"/>
		  </div>
		  <button type="submit" class="btn btn-success">Submit</button>
		</form:form>
      </div>

  </div>
</body>
</html>
