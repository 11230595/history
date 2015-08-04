$(function(){
	myUrl();
})

/**
 * 切换到新增网址
 */
function goAdd(obj){
	if(obj != undefined){
		$("li").removeClass();
		$(obj).parent("li").addClass("active");
	}
	
	$("#main").empty();
	$("#showUrl").remove();
	var template = $("#addUrl").clone();
	
	//已有收藏夹
	$.post("favorite/list/" + $("#userId").val(),function(data){
		template.find("#favroiteId").empty();
		
		//如果没有收藏夹，初始化一个
		if(data.result.length == 0){
			$.post("favorite/save",{
				"name":"默认收藏夹",
				"favoriteDesc":"系统自动初始化收藏夹"
			},function(data){
				if(data.respCode == 0){
					var html = '<option value="'+result.id+'">'+ result.name +'</option>';
					template.find("#favroiteId").append(html);
				}else{
					alert("网络异常，请稍后重试");
				}
			});
		}else{//存在收藏夹
			$.each(data.result,function(i,result){
				var html = '<option value="'+result.id+'">'+ result.name +'</option>';
				template.find("#favroiteId").append(html);
			});
		}
	});
	
	template.attr("id","showUrl");
	$("#main").append(template.show());
}
/**
 * 已收藏
 */
function myUrl(obj){
	if(obj != undefined){
		$("li").removeClass();
		$(obj).parent("li").addClass("active");	
	}
	
	$("#main").empty();
	var template = $("#myUrl").clone();
	template.attr("id","showUrl");
	$("#main").append(template.show());
}

/**
 * 切换到收藏夹管理
 */
function favoriteHome(obj){
	if(obj != 0 && obj != undefined){
		$("li").removeClass();
		$(obj).parent("li").addClass("active");
	}
	
	$("#main").empty();
	$("#showUrl").remove();
	var template = $("#favoriteHome").clone();
	template.attr("id","showUrl");
	template.find("#favroiteTable").find("tbody").empty();
	
	//已有收藏夹
	$.post("favorite/list/" + $("#userId").val(),function(data){
		
		$.each(data.result,function(i,result){
			var html = '<tr><td>'+ result.name +'</td> 		\
      		<td>'+ result.favoriteDesc +'</td>		\
      		<td>'+ result.createTime +'</td>	\
      		<td><a href="javascript:void(0);" onclick="deleteFavroite(\''+ result.id +'\')">删除</a></td></tr>';
			
			template.find("#favroiteTable").find("tbody").append(html);
		});
		
	});
	
	$("#main").append(template.show());
}
/**
 * 删除收藏夹
 */
function deleteFavroite(id){
	$.post("favorite/delete/" + id,function(data){
		if(data.respCode == 0){
			alert("删除成功");
			favoriteHome(0);
		}else{
			alert("网络异常，请稍后重试");
		}
	})
}