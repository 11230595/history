var i = 3;
var flag = true;
function addLine(){
	var line = '<p class="lead"><input type="text" name="content" class="form-control" placeholder="第'+i+'行文字"></p>';
	
	$("#content").append(line);
	i++;
}

$('.form_date').datetimepicker({
    language:  'zh-CN',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0
});

/**
 * 验证二级域名是否可用
 */
function checkWebCode(){
	if($.trim($("#webCode").val()) == ''){
		return;
	}
	$("#hint").hide();
	$("#webCode").parent("div").removeClass("has-error");
	$.post("../template/checkWebCode",{
		"webCode":$("#webCode").val()
	},function(data){
		if(data.respCode == 1){
			$("#hint").show();
			$("#webCode").parent("div").addClass("has-error");
			flag = false;
		}else{
			flag = true;
		}
	})
}
/**
 * 验证表单
 */
function checkForm(i){
	
	var webCode = $("#webCode").val();
	var uName = $("#uName").val();
	var mName = $("#mName").val();
	var content1 = $("#content1").val();
	var content2 = $("#content2").val();
	var date = $("#dtp_input2").val();
	
	if(!flag){
		$("#webCode").parent("div").addClass("has-error");
		$(window).scrollTop(100);
		return;
	}
	if($.trim(webCode) == ""){
		$("#webCode").parent("div").addClass("has-error");
		$(window).scrollTop(100);
		return;
	}
	if($.trim(uName) == ""){
		$("#uName").parent("div").addClass("has-error");
		$(window).scrollTop(100);
		return;
	}
	if($.trim(mName) == ""){
		$("#mName").parent("div").addClass("has-error");
		$(window).scrollTop(100);
		return;
	}
	if(content1 == "" || content2 == ""){
		alert("请您填入对ta想说的话，至少两句");
		return;
	}
	if(date == "" ){
		$("#dtp_input2").parent("div").addClass("has-error");
		return;
	}
	
	if(i == 0){ //预览
		viewTemplate();
		return;
	}
	saveTemplate();
}
//检测域名是否可以用
function checkName(obj){
	if($.trim($(obj).val()) == ""){
		$(obj).parent("div").addClass("has-error");
	}else{
		$(obj).parent("div").removeClass("has-error");
	}
}
//预览
function viewTemplate(){
	window.open("../view?" + $("#f").serialize())
}
//保存
function saveTemplate(){
	$.post("../template/saveTemp",$("#f").serialize(),function(data){
		if(data.respCode == 0){
			if(confirm("保存成功，您的访问地址为:" + data.url + "  您可以在您的个人中心中管理，是否跳转到个人中心查看？")){
				window.location.href = data.userHome;
			}else{
				window.location.reload(true);
			}
		}
	});
}