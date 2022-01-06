function init() {
    //初始化数据
    var trs = document.querySelectorAll(".tr");
    trs.forEach((tr) => {
        trInit(tr);
    })
}

init();

function trInit(tr) {
    tr.addEventListener("click", function (e) {
        var option = e.target.className
        //打开更改操作界面
        if (option == "modify") {
            switchOption(tr);

        } else if (option == "submit") {
            //提交更改
            var sNum = tr.querySelector("#s_num").value;
            var sName = tr.querySelector("#s_name").value;
            var password = tr.querySelector("#s_password").value;
            var obj = {
                "s_num": sNum,
                "s_name": sName,
                "s_password": password
            }
            console.log(obj);
            post("updateStudent", obj, (data) => {
                if (data.code) {
                    flush();
                } else {
                    alert("更新失败");
                    switchOption();
                }

            });
        } else if (option == "delete") {
            //删除学生

            var sNum = tr.querySelector("#s_num").value;

            data = {
                "number": sNum
            }
            console.log(data);
            formDelete("deleteStudent", data, function (data) {
                if (data.code) {
                    flush();
                } else {
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
                    <input  id="s_num" class="td" ></input>
                    <input  id="s_name" class="td" ></input>
                    <input id="s_password" class="td"></input>
                    <div class="td td-normal-option">
                        <button class="submitAdd">提交</button>
                        <button class="cancelAdd">取消</button>
                    </div>
                `
    tr.innerHTML = html;

    var submit = tr.querySelector(".submitAdd");
    var cancel = tr.querySelector(".cancelAdd");

    submit.addEventListener("click", () => {
        var sNum = tr.querySelector("#s_num").value;
        var sName = tr.querySelector("#s_name").value;
        var password = tr.querySelector("#s_password").value;
        var obj = {
            "studentNumber": sNum,
            "name": sName,
            "password": password
        }
        console.log(obj);
        formPost("addStudent", obj, function (result) {
            if (result.code) {
                flush();
            } else {
                alert(result.msg);
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
