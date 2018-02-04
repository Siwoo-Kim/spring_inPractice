<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>${pageTitle}</title>
    <style>
        .error{
            border: 2px solid red;
        }
    </style>
</head>
<body>

    <spring:message var="pageTitle" code="newUserRegistration.pageTitle" ></spring:message>

    <div class="container" style="margin-top: 85px">
        <div class="col-12">
            <h1>${pageTitle}</h1>
            <form:form class="form-group" modelAttribute="account" action="/chapter4/users">

                <form:errors path="*">
                    <div><spring:message code="error.global"></spring:message></div>
                </form:errors>
                <div>
                    <spring:message code="newUserRegistration.label.username" /> : <form:input path="username" cssClass="form-control" cssErrorClass="error"></form:input>
                </div>
                    <form:errors path="username"></form:errors>
                <div>
                    Password: <form:password path="password" cssClass="form-control" cssErrorClass="error"></form:password>
                </div>
                    <form:errors path="password"></form:errors>

                <div>Confirm: <form:password path="confirmPassword" cssClass="form-control" cssErrorClass="error"></form:password></div>
                <div>
                    E-mail: <form:input path="email" cssClass="form-control" cssErrorClass="error"></form:input>
                </div>
                    <form:errors path="email"></form:errors>
                <div>First Name: <form:input path="firstName" cssClass="form-control" cssErrorClass="error"></form:input></div>
                <div>Last Name: <form:input path="lastName" cssClass="form-control" cssErrorClass="error"></form:input></div>
                <div class="from-check">
                    <div><form:checkbox cssClass="form-check-input" path="marketingOk" id="marketingOk"></form:checkbox> Send up-to-dated product info by email. </div>
                    <div><form:checkbox cssClass="form-check-input" path="acceptTerms" id="acceptTerms" cssErrorClass="error"></form:checkbox> <spring:message code="newUserRegistration.label.acceptTerms" /></div>
                        <form:errors path="acceptTerms"></form:errors>
                </div>
                <div><button type="submit" class="btn btn-primary" >Register</button></div>
            </form:form>
        </div>

    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>