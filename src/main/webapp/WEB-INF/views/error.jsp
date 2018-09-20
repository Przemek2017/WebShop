<%-- 
    Document   : page_content
    Created on : 2018-09-01, 01:26:33
    Author     : Przemek
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Online Shopping - ${title}</title>

        <!-- Bootstrap Core CSS -->
        <link href="${css}/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap DataTable CSS -->
        <link href="${css}/dataTable.bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${css}/myapp.css" rel="stylesheet">

    </head>

    <body>

        <div class="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${contextRoot}/home">Home</a>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="jumbotron">
                                <h1>${errorTitle}</h1>
                                <hr/>
                                <blockquote style="word-wrap:break-word">
                                    ${errorDescription}
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer -->
            <%@include file="./include/footer.jsp" %>
        </div>
    </body>
</html>
