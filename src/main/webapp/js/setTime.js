function getTime(date) {
    var y = date.split("-")[0];
    var m = date.split("-")[1];
    var d = date.split("-")[2];
    var time = new Date(y, m - 1, d);
    return time;
}
var date;

function submit() {
    var url="setState";
    var data = {
        state:"Start"
    }
    var flag = true;
    var v0Time = getTime(document.getElementById("v0Time").value);
    var v1Time = getTime(document.getElementById("v1Time").value);
    var v2Time = getTime(document.getElementById("v2Time").value);
    var v3Time = getTime(document.getElementById("v3Time").value);
    var byElectionTime = getTime(document.getElementById("byElection").value);
    if (moreLate(v1Time, v2Time) ||
        moreLate(v2Time, v3Time) ||
        moreLate(v1Time, v3Time) ||
        moreLate(v0Time, v1Time) ||
        moreLate(v0Time, v2Time) ||
        moreLate(v0Time, v3Time) ||
        moreLate(v1Time,byElectionTime)||
        moreLate(v2Time,byElectionTime)||
        moreLate(v3Time,byElectionTime)||
        moreLate(v0Time,byElectionTime)){
        alert("4个时间的设定必须依次递增");
        flag = false;
    } else if(earlierNow(byElectionTime)) {
    //差额补选
        data.state="byElection";
    }else if (earlierNow(v3Time)) {
        //第三志愿截止时间比现在还早，说明已经过了第三志愿截止时间
        data.state = "V3Out";
    } else if (earlierNow(v2Time)) {
        //第二志愿截止时间到，开始第三志愿选择
        data.state = "V2Out";
    } else if (earlierNow(v1Time)) {
        //第一志愿时间截止
        data.state = "V1Out";
    } else if (earlierNow(v0Time)) {
        //学生填报志愿结束，导师进行第一志愿的选择
           data.state = "Ready";
    }
    if(flag){
        formPost(url,data,function (result){
            alert(result.msg);
        })
    }

}

//与当前时间进行比较
//如果传进来的值比当前时间大，则为true
//否则为false
function earlierNow(date = new Date()) {
    var now = new Date();
    if (date.getTime() > now.getTime()) {
        return false;
    } else {
        return true;
    }
}
//如果date1晚于date2
//则返回true。否则返回false
function moreLate(date1, date2) {
    if (date1.getTime() > date2.getTime()) {
        return true;
    } else {
        return false;
    }
}