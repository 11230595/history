/**
 * 保存收藏夹
 */
function saveFavorit(){
	if($.trim($("#showUrl #inputFavoriteName").val()) == ""){
		alert("收藏夹名称不能为空");
		return;
	}
	
	$.post("favorite/save",$("#showUrl #favoriteForm").serialize(),function(data){
		if(data.respCode == 0){
			alert(data.respMsg);
			favoriteHome(0);
		}else{
			alert("网络异常，请稍后重试");
		}
	});
}