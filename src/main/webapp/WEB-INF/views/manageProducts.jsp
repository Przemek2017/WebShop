<%-- 
    Document   : manageProducts
    Created on : 2018-09-23, 23:56:40
    Author     : Przemek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">

        <c:if test="${not empty successMessage}">
            <div class="col-xs-12">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${successMessage}
                </div>
            </div>
        </c:if>

        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4>${formTitle}</h4>
                </div>
                <div class="panel-body">
                    <sf:form class="form-horizontal" modelAttribute="managedProduct" 
                             action="${contextRoot}/manage/products" 
                             method="POST"
                             enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="control-label col-md-4" for="name">Enter Product Name:</label>
                            <div class="col-md-8">
                                <sf:input class="form-control" type="text" path="name" id="name" placeholder="Product Name"/>
                                <sf:errors path="name" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
                            <div class="col-md-8">
                                <sf:input class="form-control" type="text" path="brand" id="brand" placeholder="Brand Name"/>
                                <sf:errors path="brand" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="description">Enter Description:</label>
                            <div class="col-md-8">
                                <sf:textarea class="form-control" type="text" path="description" id="description" rows="4" placeholder="Write a description for the product"/>
                                <sf:errors path="description" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
                            <div class="col-md-8">
                                <sf:input class="form-control" type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price &#8377"/>
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="quantity">Quantity:</label>
                            <div class="col-md-8">
                                <sf:input class="form-control" type="number" path="quantity" id="quantity" placeholder="Quantity"/>
                            </div>
                        </div>
                        <!--Image upload file element-->
                        <div class="form-group">
                            <label class="control-label col-md-4" for="file">Select an Image: </label>
                            <div class="col-md-8">
                                <sf:input class="form-control" type="file" path="file" id="file"/>
                                <sf:errors path="file" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="categoryId">Select Category:</label>
                            <div class="col-md-8">
                                <sf:select class="form-control" path="categoryId" id="categoryId"
                                           items="${categories}"
                                           itemLabel="name"
                                           itemValue="id"
                                           />
                                <c:if test="${managedProduct.id == 0}">
                                    <div class="text-right">
                                        <br/>
                                        <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add Category</button>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input class="btn btn-primary" type="submit" name="submit" id="submit" value="Submit"/>

                                <!--hidden fields for newProduct-->
                                <sf:hidden path="id"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="supplierId"/>
                                <sf:hidden path="active"/>
                                <sf:hidden path="purchases"/>
                                <sf:hidden path="views"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <h3>Available Products</h3>
            <hr>
        </div>
        <div class="col-xs-12">
            <div style="overflow: auto">
                <table id="adminProductsTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>&#160;</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Active</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <!--<tbody></tbody>-->
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>&#160</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Active</th>
                            <th>Edit</th>
                        </tr>
                    </tfoot>
                </table>

            </div>
        </div>

    </div>

    <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                    <h4 class="modal-title">Add new Category</h4>
                </div>
                <!-- Category Form -->
                <div class="modal-body">
                    <sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" 
                             method="POST" 
                             class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-md-4">Category Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" placeholder="Category Name" path="name" id="category_name" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Category Description</label>
                            <div class="col-md-8">
                                <sf:textarea rows="5" placeholder="Category Description" path="description" id="category_description" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-4">
                                <input type="submit" name="submit" value="Add Category" class="btn btn-primary"/>
                            </div>
                        </div>

                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
