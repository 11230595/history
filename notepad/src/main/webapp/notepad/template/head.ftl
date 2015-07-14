<div class="navbar-wrapper">
  <div class="container">

    <!--<nav class="navbar navbar-inverse navbar-static-top">-->
    <nav class="${style!'navbar navbar-inverse navbar-fixed-top'}">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${request.contextPath}">网址收藏夹</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active" id="home"><a href="${url!'http://dovip.top'}">首页</a></li>
            <li id="about"><a href="${request.contextPath}/about">关于</a></li>
            <li><a href="http://dazhe.dovip.top/"  target="_blank">九块九包邮</a></li>
            <!--<li><a href="http://datetime.jd-app.com/"  target="_blank">日期测算</a></li>-->
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<#if user??>
	            <li class="active">
	            	<a href="${request.contextPath}/user/home/${user.userId!''}"  target="_blank">${user.userCode!''} &raquo;个人中心</a>
	            </li>
	            <li>
	            	<a href="javascript:void(0);" onclick="loginOut();">退出</a>
	            </li>
	        <#else>
	        	<li>
	            	<a href="${request.contextPath}/user/login">我的个人中心</a>
	            </li>
			</#if>
            <li>
            	<a>&nbsp;</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

  </div>
</div>
<script>
function loginOut(){
	$.post("${request.contextPath}/user/loginOut",function(data){
		if(data.respCode == 0){
			window.location.href = data.baseUrl;
		}
	});
}
</script>