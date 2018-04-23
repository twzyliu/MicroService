function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_order(user_id, name, phone, address, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.name = name;
    _jsObj.phone = phone;
    _jsObj.address = address;
    _jsObj.order_items = items;
    _request({
        url: _server + '/orders',
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

function get_orders(user_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/orders?user_id=' + user_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _orders = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    for (var _index_o in _orders) {
        var _items = _orders[_index_o].order_items
        for (var _index_i in _items) {
            var _product = get_product(_items[_index_i].product_id);
            _items[_index_i].product = _product;
        }
    }
    return _orders;
}

function get_order(order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/orders/' + order_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _order = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _items = _order.order_items
    for (var _index_i in _items) {
        var _product = get_product(_items[_index_i].product_id);
        _items[_index_i].product = _product;
    }
    return _order;
}


function create_payment(user_id, order_id, pay_type, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.pay_type = pay_type;
    _request({
        url: _server + '/orders/' + order_id + "/payment",
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

function get_payment(order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/orders/' + order_id + "/payment",
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _payment = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _order = get_order(_payment.order_id);
    _payment.order = _order
    return _payment;
}

function get_logistic(order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/orders/' + order_id + "/logistic",
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _logistic = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
    var _order = get_order(_logistic.order_id);
    _logistic.order = _order
    return _logistic;
}


function create_confirmation(order_id, recipient, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.recipient = recipient;
    _request({
        url: _server + '/orders/' + order_id + "/logistic/confirmation",
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

function get_confirmation(order_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/orders/' + order_id + "/logistic/confirmation",
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
    var _order = get_order(_confirmation.order_id);
    _confirmation.order = _order
    return _confirmation;
}




















