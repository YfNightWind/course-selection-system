function select(t_id, s_id) {
    var data={
        "t_id":t_id,
        "s_id":s_id
    }
    formPost("chooseStudent",data,function (result){
        if(result.code){
            flush();
        }else {
            alert(result.msg);
        }
    })
}

function out(s_id) {
    var data={
        "s_id":s_id
    }
    formPost("vOut",data,function (result){
        if(result.code){
            flush();
        }else {
            alert(result.msg);
        }
    })
}