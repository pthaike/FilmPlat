


/*************************校验函数***************/
var reg =
{
    naturalnum: /^\+?[0-9]*[1-9][0-9]*$/,   //正整数
    naturalnumf: /^[-]\d+$/,                 //负整数
    isint: /^-?\d+$/,                  //整数
    isfloat: /^(-?\d+)(\.\d+)?$/,        //浮点数
    isData: /^(-?\d+)(\.\d+)?$/,        //数字

    isfloatz: /^(\+?\d+)(\.\d+)?$/,       //正数
    isfloatf: /^([-]\d+)(\.\d+)?$/,       //负数
    //日期时间
    isdate: /((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/,
    isQQ: /^[1-9]*[1-9][0-9]*$/, //qq号，数字
    //身份证
    isidcard: /((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}[X0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))/,
    isemail: /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/, //Email
    isphone: /^(\d{3,4}[-])?(\d{3,8})$/, //电话号码
    ismphone: /^[0]?(86)?1\d{10}$/, //手机号
    isTelephone: /(^[0-9]{7,8}$)|(^[0-9]{3,4}\-[0-9]{7,8}$)|((([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{1,4}))?$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/, //(不带区号/带3,4位区号/带3,4位区号与1-4位分机号)电话/(号前带0/号前不带0)手机号码
    ispostcode: /^[1-9]\d{5}$/,         //邮政编码
    zmsz_: /^[_a-zA-Z0-9]+$/,      //只能输入字母数字和_
    zw: /^[\u4e00-\u9fa5]*$/,   //只能输入中文
    nozw: /^[^\u4e00-\u9fa5]*$/,   //不能输入中文
    zm: /^[_a-zA-Z]+$/,     //只能输入字母
    //王蒙添加
    score: /^([1-9]{1}[0-9]{0,4})$|^0$/,  //少于五位的正数(包括0)
    point: /^([1-9]{1}[0-9]{0,8})$|^0$/,  //int型
    ipReg: /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,  //IP
    isMoney: /^(\d+)(\.\d{0,2})?$/,  //验证金额
    isOKTest: /^([1-9]\d{0,}|0)$/  //验证大于等于零

    //添加结束

}
var msg =
{
    naturalnum: "请输入正整数",
    naturalnumf: "请输入负整数",
    isint: "请输入整数",
    isfloat: "请输入数字类型",
    isfloatz: "请输入正数",
    isfloatf: "请输入负数",
    isdate: "请输入格式如：1999-9-9的日期",
    isQQ: "请输入正确的QQ号",
    isidcard: "请输入正确的身份证号",
    isemail: "请输入正确的Email地址",
    isphone: "请输入格式如：028-865533443的电话号码",
    ismphone: "请输入正确的手机号码",
    isTelephone:"请输入格式为:区号（3-4位)-电话号(7-8位)-分机号(1-4位)的电话号码或手机号码",
    ispostcode: "请输入正确的邮政编码",
    zmsz_: "只能输入字母，数字或者_",
    zw: "只能输入中文",
    nozw: "不能输入中文",
    zm: "只能输入字母",
    //王蒙添加
    score: "请输入正整数且不能超过5位",
    point: "请输入少于8位的正整数",
    isData: "请输入数字",
    ipReg: "请输入IP地址 如：192.168.2.2",
    isMoney: "请输入正确的金额",
    isOKTest: "请输入大于或等于零的数"
    //添加结束

}




//表单验证函数
//obj：对象名称。需要验证的输入对象
//type：要求输入的类型
//isback：是否允许为空.ture:允许 / false：不允许
//title：提示信息标题。如：传“姓名”提示信息变成"姓名:不能为空"。
function $valid(obj, type, isback, title) {
    if (isback) {
        if (isnull(obj)) {
            return true;
        }
    }
    else {
        if (isnull(obj) || !isNaN(obj)) {
            alert(title + "不能为空");
            obj.focus();
            return false;
        }
    }

    if (type == "") {
        return true;
    }

    var regs = null;
    var msgs = null;
    switch (type) {
        case "正整数":
            {
                regs = reg.naturalnum;
                msgs = msg.naturalnum;
                break;
            }
        case "负整数":
            {
                regs = reg.naturalnumf;
                msgs = msg.naturalnumf;
                break;
            }
        case "整数":
            {
                regs = reg.isint;
                msgs = msg.isint;
                break;
            }
        case "浮点数":
            {
                regs = reg.isfloat;
                msgs = msg.isfloat;
                break;
            }
        case "数字":
            {
                regs = reg.isData;
                msgs = msg.isData;
                break;
            }

        case "正数":
            {
                regs = reg.isfloatz;
                msgs = msg.isfloatz;
                break;
            }
        case "负数":
            {
                regs = reg.isfloatf;
                msgs = msg.isfloatf;
                break;
            }
        case "日期":
            {
                regs = reg.isdate;
                msgs = msg.isdate;
                break;
            }
        case "QQ":
            {
                regs = reg.isQQ;
                msgs = msg.isQQ;
                break;
            }
        case "身份证":
            {
                regs = reg.isidcard;
                msgs = msg.isidcard;
                break;
            }
        case "Email":
            {
                regs = reg.isemail;
                msgs = msg.isemail;
                break;
            }
        case "电话":
            {
                regs = reg.isphone;
                msgs = msg.isphone;
                break;
            }
        case "手机":
            {
                regs = reg.ismphone;
                msgs = msg.ismphone;
                break;
            }
       case "电话或手机号码":
        {
            regs = reg.isTelephone;
            msgs = msg.isTelephone;
            break;
        }
        case "邮编":
            {
                regs = reg.ispostcode;
                msgs = msg.ispostcode;
                break;
            }
        case "字母数字或_":
            {
                regs = reg.zmsz_;
                msgs = msg.zmsz_;
                break;
            }
        case "字母":
            {
                regs = reg.zmsz_;
                msgs = msg.zmsz_;
                break;
            }
        case "中文":
            {
                regs = reg.zw;
                msgs = msg.zw;
                break;
            }
        case "非中文":
            {
                regs = reg.nozw;
                msgs = msg.nozw;
                break;
            }
        case "分数":
            {
                regs = reg.score;
                msgs = msg.score;
                break;
            }
        case "积分":
            {
                regs = reg.point;
                msgs = msg.point;
                break;
            }

        case "IP地址":
            {
                regs = reg.ipReg;
                msgs = msg.ipReg;
                break;
            }
        case "金额":
            {
                regs = reg.isMoney;
                msgs = msg.isMoney;
                break;
            }
        case "大于或等于零":
            {
                regs = reg.isOKTest;
                msgs = msg.isOKTest;
                break;
            }

    }

    var s = obj.val();
    if (regs.test(s)) {
        return true;
    }
    else {

        if (title != null && title != undefined) {
            msgs = title + msgs
        }
        alert(msgs);
        obj.focus();
        return false;

    }
}

//是否为空
//为空返回true，否则返回false
function isnull(obj) {
    if (obj.val() == "") {
        return true;
    }
    else {
        return false;
    }
}
//判断验证多行文本输入长度
//obj：文本对象
//max:最大长度
//event
//用法：onkeydown="return txtMaxLen(this,128,event)"
function txtMaxLen(obj, max, event,title) {
    if (obj.value.length >= max && !(event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 9 ||
        event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 39 || event.keyCode == 40 ||
        event.keyCode == 16 || event.keyCode == 17 || event.keyCode == 18 || event.keyCode == 20)) {
        alert(title+":"+"只能输入小于等于" + max + "个字符!");
        event.returnValue = false;
        return false;
    }
    else {
        return true;
    }
}

//全选
function checkAll() {
    var chbArr = $("input[type='checkbox']");
    var chbIds = "";
    if ($(".chb_main").attr("checked") == true) {
        for (var i = 0; i < chbArr.length; i++) {
            chbArr[i].checked = true;
            if (chbArr[i].className != "chb_main" && chbArr[i].className != "chb_main nor") {
                if (chbIds != "") {
                    chbIds += ",";
                }
                chbIds += chbArr[i].value;
            }
        }
    }
    else {
        for (var i = 0; i < chbArr.length; i++) {
            chbArr[i].checked = false;
        }
    }
    $("#hidden_chbIDs").attr("value", chbIds);
}

//选择多项数据(非全选)
function checkItem() {
    var chbArr = $("input[type='checkbox']");
    var flag = true;
    var count = 0;
    var chbIds = "";
    for (var i = 0; i < chbArr.length; i++) {
        if (chbArr[i].className != "chb_main" && chbArr[i].className != "chb_main nor") {
            if (chbArr[i].checked == flag) {
                if (count != 0) {
                    chbIds += ","
                }
                chbIds += chbArr[i].value;
                count++;
            }
        }
    }
    if (count < chbArr.length - 1) {
        $(".chb_main").attr("checked", false);
    }
    else {
        $(".chb_main").attr("checked", true);
    }
    $("#hidden_chbIDs").attr("value", chbIds);
}

//取消选择
function CancelCheck() {
    var chbArr = $("input[type='checkbox']");
    var chbIds = "";
    if ($(".chb_main").attr("checked") == true) {
        for (var i = 0; i < chbArr.length; i++) {
            chbArr[i].checked = false;
        }
    }
    $("#hidden_chbIDs").attr("value", chbIds);
}

//单选事件
function radcheckItem() {
    var radchbArr = $("input[type='radio']");
    var flag = true;
    var chbIds = "";
    if (radchbArr.className != "chb_main" && radchbArr.className != "chb_main nor") {
        if (radchbArr.checked == flag) {
            chbIds = radchbArr.value;
        }
    }
    $("#hidden_chbIDs").attr("value", chbIds);
}


// JScript 文件
var http_request = false;
function init_request(){//初始化函数
	http_request = false;
	//开始初始化XMLHttpRequest对象
	if(window.XMLHttpRequest) { //Mozilla 浏览器
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {//设置MiME类别
			http_request.overrideMimeType("text/xml");
		}
	}
	else if (window.ActiveXObject) { // IE浏览器
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
	if (!http_request) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
}
function get_request( url, myProcess ){
        init_request();        
        http_request.onreadystatechange = myProcess;
        http_request.open("GET", url, true);
        http_request.send(null);
    }
    
    function get_request1( url){
    init_request();        
    http_request.open("GET", url, true);
    http_request.send(null);
}
//this function gave the user too much free to write his method
function post_request( url, sinfo, myProcess ) {
    init_request();
    http_request.onreadystatechange = myProcess;

    http_request.open("POST", url, true);  
    http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http_request.send(sinfo);
}


var c;
function fOver(obj)
{
    c= obj.style.backgroundColor;
    obj.style.backgroundColor="#cad3e4";
}

function fOut(obj)
{
    obj.style.backgroundColor=c;
}
///弹出框
function ShowModalDialog(url, width, height) {
    url += url.indexOf("?") > -1 ? "&" : "?";
    url += "r=" + Math.random();
    var returnValue = window.showModalDialog(url, this, 'status:no;resizable:no;help:no;scroll:yes;dialogHeight:' + height + 'px;dialogWidth:' + width + 'px;');
    return returnValue;
}