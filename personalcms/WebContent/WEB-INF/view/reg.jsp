<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>注册</title>
	<%@ include  file="template/head.jsp"%>
	<link href="<%=request.getContextPath()%>/bootstrap/css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" id="f">
        <h2 class="form-signin-heading">请注册</h2>
        <p>
		<label for="inputEmail" class="sr-only">用户名</label>
        <input name="userCode" type="text" id="inputUserCode" class="form-control" placeholder="用户名" required autofocus>
		</p>
		 <p>
		<label for="inputEmail" class="sr-only">邮箱</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
		</p>
		<p>
		<label for="inputEmail" class="sr-only">手机号</label>
        <input name="phone" type="number" id="inputPhone" class="form-control" placeholder="手机号">
        </p>
		<p>
		<label for="inputPassword" class="sr-only">密码</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
		</p>
		<p>
		<label for="inputPassword" class="sr-only">确认密码</label>
        <input type="password" id="inputNewPassword" class="form-control" placeholder="确认密码" required>
        </p>
		<button class="btn btn-lg btn-primary btn-block" type="button" onclick="reg();">注册</button>
      </form>
    </div> <!-- /container -->
  </body>
  
  <script type="text/javascript">
  	//注册
  	function reg(){
  		if($("#inputPassword").val() != $("#inputNewPassword").val()){
  			alert("两次输入的密码不一致，请重新输入");
  			return;
  		}
  		
  		$.post("<%=request.getContextPath()%>/user/saveUser.do",$("#f").serialize(),function(data){
			if(data.respCode == 0){
				alert("保存成功");
				window.location.href = "<%=request.getContextPath()%>/user/login.do";
			}else{
				alert("保存出错");
			}
		});
  	}
  </script>
</html>
