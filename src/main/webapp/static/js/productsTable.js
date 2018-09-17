

var $table = $('#productsListTable');
if ($table.length) {
    let jsonUrl = '';

    if (window.categoryId == '') {
        jsonUrl = `${window.contextRoot}/json/data/all/products`;
    } else {
        jsonUrl = `${window.contextRoot}/json/data/category/${window.categoryId}/products`;
    }
    
    $table.DataTable({
        lengthMenu: [[3, 10, 20, -1], ['3 Records', '10 Records', '20 Records', 'All', ]],
        ajax:{
            url: jsonUrl,
            dataSrc: ''
        },
        columns: [
            {
                data: 'code',
                mRender: function(data, type, row){
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
                mRender: function(data, type, row){
                    return '&euro; ' + data;
                }
            },
            {
                data: 'quantity'
            },
            {
                data: 'id',
                fSortable: false,
                mRender: function(data, type, row){
                    let url = '';
                    url += `<a href=${window.contextRoot}/show/${data}/product class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span><a/> &nbsp`;
                    url += `<a href=${window.contextRoot}/card/add/${data}/product class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span><a/>`;
                    return url;
                }
            }
        ]
    });
}

