<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>开口示爱-表白，浪漫之家</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- 日历 -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/bootstrap/css/carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  	<!-- 头信息 -->
  	<#include "template/head.ftl">
  
    <hr class="featurette-divider">
	<!-- 包裹层start -->
	<form action="" class="form-horizontal"  role="form" id="f">
	<input type="hidden" id="userId" name="userId" value="${user.userId!''}">
	<input type="hidden" id="userCode" name="userCode" value="${user.userCode!''}">
	
	
	
	<div style="width:95%;">
      <div class="row featurette">
      	<!-- 导航start -->
      	<div class="col-md-7 col-md-push-5">
	      	<div class="btn-group" style="width:100%">
			  <button type="button" class="btn btn-default active" style="width:50%" onclick="cutTag(this,0);">生成网址管理</button>
			  <button type="button" class="btn btn-default" style="width:50%"  onclick="cutTag(this,1);">个人资料修改</button>
			</div>
      	</div>
      	<!-- 导航end -->
      	
      	<!-- 用户中心主模板 -->
      	<#include "template/userHomeTemplate.ftl">
      	
      	<!-- 左侧start -->
        <div class="col-md-5 col-md-pull-7">
          <h2>欢迎您：<span class="text-muted">${user.userCode!''}</span></h2>
          <h3>您可以在此管理您生成的网址和个人资料</h3>
        </div>
        <!-- 左侧end -->
      </div>
	</div>
	</form>
	<!-- 包裹层end -->
      <hr class="featurette-divider">
      <!-- /END THE FEATURETTES -->


      <!-- 地脚信息 -->
  	  <#include "template/foot.ftl">

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    
    <script>
    	//删除模板
    	function deleteWeb(id){
    		if(confirm("您确认删除该网站吗？删除后无法恢复。")){
    			$.post("../../template/deleteTemp",{
    				"id":id
    			},function(data){
    				if(data.respCode == 0){
    					window.location.reload(true);
    				}else{
    					alert("网络繁忙，请稍后重试");
    				}
    			})
    		}
    	}
    	//切换标签
    	function cutTag(obj,flag){
    		if(flag == 1){
    			$(obj).parent().find("button").removeClass("active");
    			$(obj).addClass("active");
    			
    			$("#created").hide();
    			$("#updateUser").fadeIn(800);
    		}else{
    			$(obj).parent().find("button").removeClass("active");
    			$(obj).addClass("active");
    			
    			$("#updateUser").hide();
    			$("#created").fadeIn(800);
    		}
    	}
    	//验证旧密码是否正确
    	function checkOldPassword(obj){
    		$(obj).parent().removeClass("has-error");
    	
    		var oldPassword = $(obj).val();
    		var realPassword = '${user.password!""}';
    		
    		if(oldPassword != realPassword){
    			$(obj).parent().addClass("has-error");
    			return;
    		}
    	}
    	//修改资料
    	function updateUser(){
    		var password = $("#password").val();
    		var pass = $("#password1").val();
    		
    		$("#password").parent().removeClass("has-error");
    		$("#password1").parent().removeClass("has-error");
    		
    		if(pass != password){
    			$("#password").parent().addClass("has-error");
    			$("#password1").parent().addClass("has-error");
    			return;
    		}
    		if(password.length<6){
    			alert("密码不能少于6位。");
    			return;
    		}
    		
    		$.post("${request.contextPath}/user/update",{
    			"userId":$("#userId").val(),
    			"password":password
    		},function(data){
    			if(data.respCode == 0){
    				alert("修改成功,下次登陆生效。");
    				window.location.reload(true);
    			}else{
    				alert("网络繁忙，请稍后重试。");
    			}
    		});
    	}
    </script>
  </body>
</html>
