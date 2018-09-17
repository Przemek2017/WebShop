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

        <script>
            window.menu = '${title}';
            window.contextRoot = '${contextRoot}';
        </script>

        <!-- Bootstrap Core CSS -->
        <link href="${css}/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap DataTable CSS -->
        <link href="${css}/dataTable.bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${css}/myapp.css" rel="stylesheet">

    </head>

    <body>

        <div class="wrapper">
            <!-- Navigation -->
            <%@include file="./include/navbar.jsp"%>
            <!-- /.container -->
            <div class="content">
                <!-- Page Content -->
                <!-- When user click HOME -->
                <c:if test="${userClickHome == true}">
                    <%@include file="home.jsp" %>
                </c:if>
                <!-- When user click PRODUCTS -->
                <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
                    <%@include file="products.jsp" %>
                </c:if>
                <!-- When user click ABOUT -->
                <c:if test="${userClickAbout == true}">
                    <%@include file="about.jsp" %>
                </c:if>
                <!-- When user click CONTACT -->
                <c:if test="${userClickContact == true}">
                    <%@include file="contact.jsp" %>
                </c:if>
                <!-- When user click SINGLE PRODUCT -->
                <c:if test="${userClickShowSingleProduct == true}">
                    <%@include file="singleProduct.jsp" %>
                </c:if>
            </div>
            <!-- Footer -->
            <%@include file="./include/footer.jsp" %>
        </div>
        <!-- jQuery -->
        <script src="${js}/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${js}/bootstrap.min.js"></script>

        <!-- DataTables -->
        <script src="${js}/jquery.dataTables.js"></script>

        <!-- DataTables Bootstrap-->
        <script src="${js}/dataTables.bootstrap.js"></script>

        <!-- Menu JavaScript -->
        <script src="${js}/active_menu.js"></script>

        <!-- Table JavaScript -->
        <script src="${js}/productsTable.js"></script>

    </body>
</html>