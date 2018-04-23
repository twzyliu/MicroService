function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_store(user_id, name, description, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.name = name;
    _jsObj.description = description;
    _request({
        url: _server + '/stores',
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

function get_stores(server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/stores',
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        return JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
}

function get_store(store_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/stores/' + store_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        return JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
}

function update_store(store_id, user_id, name, description, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.user_id = user_id;
    _jsObj.name = name;
    _jsObj.description = description;
    _request({
        url: _server + '/stores/' + store_id,
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


function create_unloading(product_id, quantity, pay, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.product_id = product_id;
    _jsObj.quantity = quantity;
    _jsObj.pay = pay;
    _request({
        url: _server + '/unloadings',
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

function get_unloadings(server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/unloadings',
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        return JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }
}

function get_unloading(unloading_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/unloadings/' + unloading_id,
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _unloading = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _product = get_product(_unloading.product_id);
    _unloading.product = _product;
    return _unloading;
}


function create_inventory(store_id, items, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.inventory_items = items;
    _request({
        url: _server + '/stores/' + store_id + "/inventory",
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

function get_inventory(store_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/stores/' + store_id+"/inventory",
        type: 'GET',
        execute: function (data) {
            _xhr = data;
        }
    });

    if (_xhr.status == "200") {
        var _inventory = JSON.parse(_xhr.responseText);
    } else if (_xhr.status == "404") {
        return "Not Found";
    }

    var _items = _inventory.inventory_items
    for (var _index in _items) {
        var _item = _items[_index];
        var _product = get_product(_item.product_id);
        _item.product = _product;
    }
    return _inventory;
}









