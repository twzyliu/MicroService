function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_return_order(order_id, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.order_id = order_id;
    _jsObj.return_order_items = items;
    _request({
        url: _server + '/return_orders',
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

function get_return_orders(server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/return_orders',
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _return_orders = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    for (var _index_r in _return_orders) {
        var _return_order = _return_orders[_index_r];
        var _order = get_order(_return_order.order_id);
        _return_order.order = _order;
        var _items = _return_order.return_order_items;
        for (var _index_i in _items) {
            var _item = _items[_index_i];
            var _product = get_product(_item.product_id);
            _item.product = _product;
        }
    }
    return _return_orders;
}

function get_return_order(return_order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/return_orders/' + return_order_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _return_order = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _order = get_order(_return_order.order_id);
    _return_order.order = _order;
    var _items = _return_order.return_order_items;
    for (var _index_i in _items) {
        var _item = _items[_index_i];
        var _product = get_product(_item.product_id);
        _item.product = _product;
    }
    return _return_order;
}


function create_refund(return_order_id, amount, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.amount = amount;
    _request({
        url: _server + '/return_orders/' + return_order_id + "/refund",
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

function get_refund(return_order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/return_orders/' + return_order_id + "/refund",
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _refund = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _return_order = get_return_order(_refund.return_order_id);
    _refund.return_order = _return_order;
    return _refund;
}


function create_return_confirmation(return_order_id, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/return_orders/' + return_order_id + "/confirmation",
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

function get_return_confirmation(return_order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/return_orders/' + return_order_id + "/confirmation",
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _confirmation = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _return_order = get_return_order(return_order_id);
    _confirmation.return_order = _return_order;
    return _confirmation;
}








