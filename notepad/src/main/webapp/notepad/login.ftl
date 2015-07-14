<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="author" content="">
    <meta name="keywords" content="表白，表白网站，网站生成，创意表白网站,dovip.top" />
	<meta name="description" content="dovip.top是一个专门生成表白类网站的网站" />
    
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>dovip.top-用户登陆</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>


    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/signin.css" rel="stylesheet">
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" style="min-height:500px;">
        <h2 class="form-signin-heading">请登陆</h2>
        <label for="inputEmail" class="sr-only">邮箱/用户名</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱/用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="alert alert-danger" id="hint" style="display:none;">用户名或密码错误</div>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login();" id="signin">登陆</button>
        <button class="btn btn-lg btn-danger btn-block" type="button" onclick="window.location.href='${request.contextPath}/user/zc'">注册</button>
      	
      	<!-- 合作网站登陆start -->
      	<p>&nbsp;</p>
      	<!--
      	<p>
	      	<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101223876" data-redirecturi="http://dovip.aliapp.com/login/qqLogin.jsp" charset="utf-8" ></script>

			<span id="qqLoginBtn" ></span>
			
			<script type="text/javascript">
			 QC.Login({
			  btnId : "qqLoginBtn",//插入按钮的html标签id
			  size : "B_M",//按钮尺寸
			  scope : "get_user_info",//展示授权，全部可用授权可填 all
			  display : "pc"//应用场景，可选
			 });
			</script>
		</p> 腾讯登陆-->
		<!-- 
		<p>
    		<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=81516774&debug=true" type="text/javascript" charset="utf-8"></script>
			<div id="wb_connect_btn"></div>
			<script>
				WB2.anyWhere(function (W) {
				    W.widget.connectButton({
				        id: "wb_connect_btn",
				        type: '5,2',
				        callback: {
				            login: function (o) { //登录后的回调函数
				                alert("login: " + o.screen_name)
				            },
				            logout: function () { //退出后的回调函数
				                alert('logout');
				            }
				        }
				    });
				});
			</script>
		</p>微博登陆 -->
		<!-- 合作网站登陆end -->
      </form>

	 <!-- 地脚信息 -->
  	 <#include "template/foot.ftl">
    </div> <!-- /container -->
    
    <script type="text/javascript" src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
  
<script>
//绑定回车事件
$(function(){
    document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	         login();
	    }
	} 
});

//登陆
function login(){
	$("#hint").hide(); //隐藏提示框
	var userCode = $("#inputEmail").val();
	var password = $("#inputPassword").val();
	if(userCode == ""){
		alert("请您输入用户名");
		return;
	}
	if(password == ""){
		alert("请您输入密码");
		return;
	}
	
	$.post("../user/signin",{
		"userCode":userCode,
		"password":password,
		"returnUrl":"${returnUrl!''}"
	},function(data){
		if(data.respCode == 0){
			window.location.href=data.returnUrl;
		}else{
			$("#hint").show();
		}
	});
}

</script>
</html>
