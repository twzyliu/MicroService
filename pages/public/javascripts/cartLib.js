function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_cart(user_id, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.cart_items = items;
    _request({
        url: _server + '/carts',
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

function get_cart(cart_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/carts/' + cart_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _cart = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
    var _items = _cart.cart_items;
    for (var _index in _items) {
        var _item = _items[_index];
        var _product = get_product(_item.product_id);
        _item.product = _product;
    }
    return _cart;
}

function update_cart(cart_id, user_id, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.cart_items = items;
    _request({
        url: _server + '/carts/' + cart_id,
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
















