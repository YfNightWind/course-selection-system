function post(url,data,callback){
    var xhr =new XMLHttpRequest();
    xhr.open("post",url,true);
    //此句代码不可删去，否则报400错误
    data = JSON.stringify(data);
    xhr.setRequestHeader("Content-Type","application/json");
    xhr.send(data);
    xhr.onreadystatechange=()=>{
        if(xhr.readyState==4){
            if((xhr.status>=200&&xhr.status<300)||xhr.status==304){
                resultdata =JSON.parse(xhr.responseText);
                callback(resultdata);
            }else{
                alert("Request was unsuccessful:"+xhr.status);
            }
        }
    }
}

function formPost(url,data,callback){
    var xhr =new XMLHttpRequest();
    xhr.open("post",url,true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //拼装url
    var dataArr = Object.entries(data);
    formdata=""
    dataArr.forEach((item,index)=>{
        if(index!=0){
            formdata+="&"+item[0]+"="+item[1];
        }else{
            formdata+=item[0]+"="+item[1];
        }
    })

    xhr.send(formdata);
    xhr.onreadystatechange=()=>{
        if(xhr.readyState==4){
            if((xhr.status>=200&&xhr.status<300)||xhr.status==304){
                resultdata =JSON.parse(xhr.responseText);
                callback(resultdata);
            }else{
                alert("Request was unsuccessful:"+xhr.status);
            }
        }
    }
}
