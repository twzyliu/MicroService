function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_product(user_id, name, description, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.name = name;
    _jsObj.description = description;
    _request({
        url: _server + '/products',
        type: 'POST',
        data: JSON.stringify(_jsObj),
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "201") {
        return _xhr.getResponseHeader("location");
    } else if (_xhr.status == "400") {
        return "Bad Request";
    }
}

function get_products(user_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/products?user_id=' + user_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _products = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    for (var _index in _products) {
        var _price = get_price(_products[_index].id);
        _products[_index].price = _price.price;
    }
    return _products;
}

function get_product(product_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/products/' + product_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _product = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _price = get_price(_product.id);
    _product.price = _price.price;
    return _product;
}

function update_product(product_id, user_id, name, description, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.name = name;
    _jsObj.description = description;
    _request({
        url: _server + '/products/' + product_id,
        type: 'PUT',
        data: JSON.stringify(_jsObj),
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "201") {
        return _xhr.getResponseHeader("location");
    } else if (_xhr.status == "400") {
        return "Bad Request";
    }
}
















