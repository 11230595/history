$(function(){
	goAdd();
})

/**
 * 切换到新增网址
 */
function goAdd(){
	$("#showUrl").remove();
	var template = $("#addUrl").clone();
	template.attr("id","showUrl");
	$("#main").append(template.show());
}
/**
 * 已收藏
 */
function goAdd(){
	var template = $("#myUrl").clone();
	template.attr("id","showUrl");
	$("#main").append(template.show());
}