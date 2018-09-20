<%-- 
    Document   : singleProduct
    Created on : 2018-09-17, 23:00:08
    Author     : Przemek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <!-- Breadcrumb -->
    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb">
                <li><a href="${contextRoot}/home">Home</a></li>
                <li><a href="${contextRoot}/show/all/products">Products</a></li>
                <li class="active">${product.name}</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-4">
            <!-- product image -->
            <div class="thumbnail">
                <img src="${images}/${product.code}.jpg" class="img img-responsive"/>
            </div>
        </div>
        <div class="col-xs-12 col-sm-8">
            <!-- product description -->
            <h3>${product.name}</h3>
            <hr/>
            <p>${product.description}</p>
            <hr/>
            <h3><strong>Price: </strong>${product.unitPrice} &euro;</h3>
            <hr/>
            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <h5>Quantity: <span style="color:red">Out of Stock!</span></h5>
                </c:when>

                <c:otherwise>
                    <h5>Quantity: ${product.quantity}</h5>
                </c:otherwise>
            </c:choose>
            <hr/>

            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span><strike>Add to card</strike></a>
                </c:when>

                <c:otherwise>
                    <a href="${contextRoot}/card/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to card</a>
                </c:otherwise>
            </c:choose>
            <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
        </div>
    </div>
</div>
