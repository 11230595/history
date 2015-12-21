//保存
function save(){
	$.post("save",$("#f").serialize(),function(data){
		if(data.respCode == 0){
			alert(data.respMsg)
			window.location.reload(true);
		}else{
			alert(data.respMsg);
		}
	})
}

//加载全部
function getAll(){
	$.post("getAll",function(data){
		$("#resultTable").find("tbody").empty();
		$.each(data.result,function(i,result){
			var template = $("#template").clone();
			template.find("#t_code").text(result.code);
			template.find("#t_name").text(result.name);
			$("#resultTable").find("tbody").append(template.find("tr").show());
		})
		$("#resultTable").show();
	})
}

//加载单个
function getById(){
	$.post("get/" + $("#findCode").val(),function(data){
		$("#resultTable").find("tbody").empty();
		var template = $("#template").clone();
		template.find("#t_code").text(data.result.code);
		template.find("#t_name").text(data.result.name);
		$("#resultTable").find("tbody").append(template.find("tr").show());
		$("#resultTable").show();
	})
}

//加载分页
function getByPage(){
	$.post("getByPage/" + $("#pageNo").val() + "/" + $("#pageSize").val(),function(data){
		$("#resultTable").find("tbody").empty();
		$.each(data.result.result,function(i,result){
			var template = $("#template").clone();
			template.find("#t_code").text(result.code);
			template.find("#t_name").text(result.name);
			$("#resultTable").find("tbody").append(template.find("tr").show());
		})
		$("#resultTable").show();
	})
}