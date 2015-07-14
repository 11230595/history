var flag = true;
/**
 * 验证二级域名是否可用
 */
function checkWebCode(){
	if($.trim($("#webCode").val()) == ''){
		return;
	}
	$("#hint").hide();
	$("#webCode").parent("div").removeClass("has-error");
	$.post(ROOT + "/template/checkWebCode",{
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
		alert("请在第一行输入Ta的昵称。")
		$(window).scrollTop(100);
		return;
	}
	if($.trim(mName) == ""){
		alert("请在第最后一行输入你的昵称。")
		$(window).scrollTop(100);
		return;
	}
	if(content1 == "" || content2 == ""){
		alert("请您填入对ta想说的话，至少两句");
		return;
	}

	if(i == 0){ //预览
		viewTemplate();
		return;
	}
	saveTemplate();
}

//预览
function viewTemplate(){
	window.open(ROOT + "/view?" + $("#f").serialize())
}
//保存
function saveTemplate(){
	$.post(ROOT + "/template/saveTemp",$("#f").serialize(),function(data){
		if(data.respCode == 0){
			if(confirm("保存成功，您的访问地址为:" + data.url + "  您可以在您的个人中心中管理，是否跳转到个人中心查看？")){
				window.location.href = data.userHome;
			}else{
				window.location.reload(true);
			}
		}
	});
}