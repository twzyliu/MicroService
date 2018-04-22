function _request(options) {
    var _xhr = new XMLHttpRequest();
    _xhr.onreadystatechange = function () {
        if (_xhr.readyState == 4) options.execute(_xhr);
    };
    _xhr.open(options.type, options.url, false);
    _xhr.setRequestHeader("Content-Type", "application/json");
    _xhr.send(options.data);
}

function create_user(user_name, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.name = user_name;
    _request({
        url: _server + '/users',
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

function create_user(user_name, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.name = user_name;
    _request({
        url: _server + '/users',
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

function update_user(user_id, user_name, server) {
    var _xhr;
    var _jsObj = {};
    var _server = (server || "http://127.0.0.1:8888");

    _jsObj.name = user_name;
    _request({
        url: _server + '/users/' + user_id,
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

function get_user(user_id, server) {
    var _xhr;
    var _server = (server || "http://127.0.0.1:8888");

    _request({
        url: _server + '/users/' + user_id,
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















