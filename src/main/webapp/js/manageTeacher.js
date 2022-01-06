function init() {
    //初始化数据
    var trs = document.querySelectorAll(".tr");
    trs.forEach((tr) => {
        trInit(tr);
    })
}
init();

function trInit(tr) {
    tr.addEventListener("click", function(e) {
        var option = e.target.className
            //打开更改操作界面
        if (option == "modify") {
            switchOption(tr);

        } else if (option == "submit") {
            //提交更改
            var username = tr.querySelector("#username").value;
            var password = tr.querySelector("#password").value;
            var nowCount = tr.querySelector("#nowCount").value;
            var allCount = tr.querySelector("#allCount").value;
            var id = tr.querySelector("#userid").value;
            var obj = {
                "t_name": username,
                "t_password": password,
                "s_count": nowCount,
                "s_max": allCount,
                "t_id":id
            }

            formPost("/admin/updateTeacher",obj, (data)=>{
                if(data.code){
                    flush();
                }else{
                    alert("更新失败");
                    switchOption();
                }

            });
        } else if (option == "delete") {
            //删除学生
            var userid = tr.querySelector("#userid").value;

            id={
                "id":userid
            }
            formDelete("/admin/deleteTeacher",id,function (data){
                if(data.code){
                    flush();
                }else{
                    alert("删除失败!");
                }
            })
        } else if (option == "cancel") {
            //取消更改
            switchOption(tr);

        } else {
            console.log(10);
        }
    })
}

//修改按钮切换
function switchOption(tr) {
    var tdModify = tr.querySelector(".td-modify-option");
    var tdNromal = tr.querySelector(".td-normal-option");
    if (tdModify.classList.contains("hide")) {
        //更改数据时的样式
        tdModify.classList.remove("hide");
        tdNromal.classList.add("hide");
        tr.classList.remove("tr-normal");
        var inputs = tr.querySelectorAll("input");
        inputs.forEach((input) => {
            input.removeAttribute("readOnly");
        })
    } else {
        //普通显示时的样式
        tdNromal.classList.remove("hide");
        tdModify.classList.add("hide");
        tr.classList.add("tr-normal");
        var inputs = tr.querySelectorAll("input");
        inputs.forEach((input) => {
            input.setAttribute("readOnly", "readOnly");
        })
    }

}
//增加数据
function add() {
    var tr = document.createElement("div");
    var tableMain = document.querySelector(".main-table");
    tr.classList.add("tr");
    var html = `
     <input  id="username" class="td" ></input>
                    <input  id="password" class="td"></input>
                    <input  id="nowCount" class="td"></input>
                    <input  id="allCount" class="td"></input>
                    <div class="td td-normal-option">
                        <button class="submitAdd">提交</button>
                        <button class="cancelAdd">取消</button>
                    </div>
                `
    tr.innerHTML = html;

    var submit = tr.querySelector(".submitAdd");
    var cancel = tr.querySelector(".cancelAdd");
    submit.addEventListener("click", () => {
        var obj = getUser(tr);
        console.log(obj);
        formPost("addTeacher",obj,function (result){
            alert(result.msg);
            if(result.code){
                flush();
            }
        })
    })
    cancel.addEventListener("click", () => {
            tr.remove();
        })
        //tr.classList.add("tr-normal");
        //trInit(tr);
    tableMain.insertAdjacentElement("beforeend", tr);
}
//对执行增加作用的那一行数据增加相关的操作
function addTrInit(tr) {

}
//得到input中有关用户的数据
function getUser(tr) {
    var username = tr.querySelector("#username").value;
    var password = tr.querySelector("#password").value;
    var nowCount = tr.querySelector("#nowCount").value;
    var allCount = tr.querySelector("#allCount").value;
    var obj = {
        "name": username,
        "password": password,
        "count": nowCount,
        "max": allCount,
    }
    return obj;
}
