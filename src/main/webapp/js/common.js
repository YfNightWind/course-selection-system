function post(url, data, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("post", url, true);
    //此句代码不可删去，否则报400错误
    data = JSON.stringify(data);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(data);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                resultdata = JSON.parse(xhr.responseText);
                callback(resultdata);
            } else {
                alert("Request was unsuccessful:" + xhr.status);
            }
        }
    }
}

function formPost(url, data, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("post", url, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //拼装url
    var dataArr = Object.entries(data);
    formdata = ""
    dataArr.forEach((item, index) => {
        if (index != 0) {
            formdata += "&" + item[0] + "=" + item[1];
        } else {
            formdata += item[0] + "=" + item[1];
        }
    })

    xhr.send(formdata);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                resultdata = JSON.parse(xhr.responseText);
                callback(resultdata);
            } else {
                alert("Request was unsuccessful:" + xhr.status);
            }
        }
    }
}

function formDelete(url, data, callback) {
    var xhr = new XMLHttpRequest();
    var dataArr = Object.entries(data);
    formdata = ""
    dataArr.forEach((item, index) => {
        if (index != 0) {
            formdata += "&" + item[0] + "=" + item[1];
        } else {
            formdata += "?" + item[0] + "=" + item[1];
        }
    })
    xhr.open("delete", url + formdata, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //拼装url


    xhr.send(null);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                resultdata = JSON.parse(xhr.responseText);
                callback(resultdata);
            } else {
                alert("Request was unsuccessful:" + xhr.status);
            }
        }
    }
}

//刷新页面
function flush() {
    location.reload(true);
}

function get(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                callback(xhr.responseText);
            } else {
                alert("Request was unsuccessful:" + xhr.status);
            }
        }
    }
    xhr.open("GET", url, false);
    xhr.send(null);
}

