function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_price(user_id, product_id, price, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.product_id = product_id;
    _jsObj.price = price;
    _request({
        url: _server + '/prices',
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

function get_price(product_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/prices?product_id=' + product_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        return _xhr.responseText;
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
}
















