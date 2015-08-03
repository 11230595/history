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