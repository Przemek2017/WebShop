// ********** Product list ***********

let $table = $('#productsListTable');
if ($table.length) {
    let jsonUrl = '';
    if (window.categoryId == '') {
        jsonUrl = `${window.contextRoot}/json/data/all/products`;
    } else {
        jsonUrl = `${window.contextRoot}/json/data/category/${window.categoryId}/products`;
    }

    $table.DataTable({
        lengthMenu: [[5, 10, 20, -1], ['5 Records', '10 Records', '20 Records', 'All']],
        pageLength: 10,
        ajax: {
            url: jsonUrl,
            dataSrc: ''
        },
        columns: [
            {
                data: 'code',
                mRender: function (data, type, row) {
                    return `<img src="${window.contextRoot}/resources/images/${data}.jpg" class="productsView"/>`;
                }
            },
            {
                data: 'name'
            },
            {
                data: 'brand'
            },
            {
                data: 'unitPrice',
                mRender: function (data, type, row) {
                    return '&euro; ' + data;
                }
            },
            {
                data: 'quantity',
                mRender: function (data, type, row) {
                    if (data < 1) {
                        return '<span style="color:red">Out of Stock!</span>';
                    }
                    return data;
                }
            },
            {
                data: 'id',
                fSortable: false,
                mRender: function (data, type, row) {
                    let url = '';
                    url += `<a href=${window.contextRoot}/show/${data}/product class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span><a/> &nbsp`;
                    if (row.quantity < 1) {
                        url += `<a href=javascript:void(0) class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span><a/>`;
                    } else {
                        url += `<a href=${window.contextRoot}/card/add/${data}/product class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span><a/>`;
                    }
                    return url;
                }
            }
        ]
    });
}

// ************** DataTable for Admin ************** 

let $adminProductsTable = $('#adminProductsTable');
if ($adminProductsTable.length) {
    let jsonUrl = window.contextRoot + '/json/data/admin/all/products';
    $adminProductsTable.DataTable({
        lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'All']],
        pageLength: 30,
        ajax: {
            url: jsonUrl,
            dataSrc: ''
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'code',
                mRender: function (data, type, row) {
                    return `<img src="${window.contextRoot}/resources/images/${data}.jpg" class="adminDataTableImg"/>`;
                }
            },
            {
                data: 'name'
            },
            {
                data: 'brand'
            },
            {
                data: 'quantity',
                mRender: function (data, type, row) {
                    if (data < 1) {
                        return '<span style="color:red">Out of Stock!</span>';
                    }
                    return data;
                }
            },
            {
                data: 'unitPrice',
                mRender: function (data, type, row) {
                    return '&euro; ' + data;
                }
            },
            {
                data: 'active',
                fSortable: false,
                mRender: function (data, type, row) {
                    let url = '';
                    url += `<label class="switch">`;
                    if (data) {
                        url += `<input type="checkbox" checked="checked" value="${row.id}"/>`;
                    } else {
                        url += `<input type="checkbox" value="${row.id}"/>`;
                    }
                    url += `<div class="slider"></div>`;
                    url += `</label>`;
                    return url;
                }
            },
            {
                data: 'id',
                fSortable: false,
                mRender: function (data, type, row) {
                    let str = '';
                    str += `<a href="${window.contextRoot}/manage/${data}/product" class="btn btn-warning">`;
                    str += `<span class="glyphicon glyphicon-pencil"></span></a>`;
                    return str;
                }
            }
        ],

        initComplete: function () {
            let api = this.api();
            api.$('.switch input[type="checkbox"]').on('change', function () {
                let checkbox = $(this);
                let checked = checkbox.prop('checked');
                let dialogMessage = (checked) ? 'You want activate the product?' : 'You want deactivate the product?';
                let value = checkbox.prop('value');

                bootbox.confirm({
                    size: 'medium',
                    title: 'Product Activation/Deactivation',
                    message: dialogMessage,
                    callback: function (confirmed) {
                        if (confirmed) {
                            console.log(value);

                            let activationUrl = `${window.contextRoot}/manage/product/${value}/activation`;

                            $.post(activationUrl, function (data) {
                                bootbox.alert({
                                    size: 'medium',
                                    title: 'Information',
                                    message: data
                                });
                            });
                        } else {
                            checkbox.prop('checked', !checked);
                        }
                    }
                });
            });
        }
    });
}
//    Category validation

let $categoryForm = $('#categoryForm');
if ($categoryForm.length) {
    $categoryForm.validate({
        rules: {
            name: {
                required: true,
                minlength: 2
            },
            description: {
                required: true
            }
        },
        messages: {
            name: {
                required: 'Please add the category name',
                minlength: 'The category name should not be less than 2'
            },
            description: {
                required: 'Please add a description for this category'
            }
        },
        errorElement: 'em',
        errorPlacement: function (error, element) {
            // add error class css
            error.addClass('help-block');
            // add the error element after input element
            error.insertAfter(element);
        }
    });
};

