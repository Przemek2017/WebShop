<%-- 
    Document   : page_content
    Created on : 2018-09-01, 01:26:33
    Author     : Przemek
--%>

<div class="container">

    <div class="row">
        <div class="col-md-3">
            <%@include file="./include/sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <div class="row">
                <div class="col-lg-12">

                    <c:if test="${userClickAllProducts == true}">
                        <script>
                            window.categoryId = '';
                        </script>
                        <ol class="breadcrumb">
                            <li><a href="${contextRoot}/home">Home</a></li>
                            <li class="active">All Products</li>
                        </ol>
                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <script>
                            window.categoryId = '${category.id}';
                        </script>
                        <ol class="breadcrumb">
                            <li><a href="${contextRoot}/home">Home</a></li>
                            <li class="active">Category</li>
                            <li class="active">${category.name}</li>
                        </ol>
                    </c:if>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <table id="productsListTable" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>