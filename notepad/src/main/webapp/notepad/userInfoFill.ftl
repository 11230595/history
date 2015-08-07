<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>开口示爱-表白，浪漫之家</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/navbar.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  	<!-- 头信息 -->
  	<#include "template/head.ftl">
    <div class="container">
      <!-- 内容 -->
      <div class="jumbotron">
        <h3>亲爱的${userCode!'用户'}您好：您的用户名已经有人使用，请您重新输入用户名：</h3>
        <br>
        <p>
        	<div class="form-group">
			<label class="col-md-1 control-label" for="dtp_input1">用户名</label>
				<div class="col-xs-3">
					<input id="userCode" class="form-control" type="text" size="30">
				</div>
			<br>
			</div>
        </p>
        <br>
        <p><input type="button" value="完成注册" class="btn btn-info" onclick="save();"/></p>
      </div>
      <!-- 地脚信息 -->
  	  <#include "template/foot.ftl">

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
     <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    <script>
		function v_name(){
			var name = $("#userCode").val();
			if(name.length==0) {
				alert("用户名不得为空");
				return;
			}else{
				if(name.length>32) {
					alert("必须少于32个字符"); 
					return;
				}
			}
			
			$.post("${request.contextPath}/user/isCode",{
				"userCode":$("#userCode").val()
			},function(data){
				if(!data.respMsg){
					alert("该用户名已经注册");
					return; 
				}else{
					window.location.href = "${request.contextPath}/user/otherSignin?userCode="+name+"&openId=${openId!''}&accessToken=${accessToken!''}";
				}
			})
		}
		//保存
		function save(){
			v_name();
		}
    </script>
  </body>
</html>
