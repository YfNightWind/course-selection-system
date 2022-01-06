var v1 = "";
var v2 = "";
var v3 = "";

var v1Id = 0;
var v2Id = 0;
var v3Id = 0;

function init() {
    initVolunteerBtn();
}

init();

//给志愿按钮增加点击事件
function initVolunteerBtn() {
    var trs = document.querySelectorAll(".tr");
    trs.forEach((tr) => {
        var buttons = tr.querySelectorAll("button");
        var username = tr.querySelector("#username").value;
        var userid = tr.querySelector("#userid").value;
        //实现点击按钮，改变全局的志愿名字
        buttons.forEach((button) => {
            button.addEventListener("click", function() {
                if (this.className == "v1") {
                    v1 = username;
                    v1Id = userid;
                } else if (this.className == "v2") {
                    v2 = username;
                    v2Id = userid;
                } else {
                    v3 = username;
                    v3Id = userid;
                }
                assignmnetVolunteers();
            })
        })
    })
}


function assignmnetVolunteers() {
    var v1S = document.querySelector("#v1");
    var v2S = document.querySelector("#v2");
    var v3S = document.querySelector("#v3");
    v1S.innerText = v1;
    v2S.innerText = v2;
    v3S.innerText = v3;
}
function submit(s_id){
    var url = "setTeacher";
    var data={
        "v1":v1Id,
        "v2":v2Id,
        "v3":v3Id,
        "s_id":s_id
    }
    console.log(data);
    post(url,data,function (result){
        if(result.code){
            alert("志愿提交成功");
        }else {
            alert(result.msg);
        }
    })
}