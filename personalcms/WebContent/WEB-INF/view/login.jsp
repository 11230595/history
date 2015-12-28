<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>登录</title>
    <%@ include  file="template/head.jsp"%>
    <link href="<%=request.getContextPath()%>/bootstrap/css/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" id="f">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input name="userCode" type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">记住状态
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="doLogin();">登录</button>
		<a class="btn btn-lg btn-danger btn-block" href="<%=request.getContextPath()%>/user/reg.do">注册</a>
      </form>
		
    </div> <!-- /container -->
  </body>
  <script type="text/javascript">
  	function doLogin(){
  		$.post("<%=request.getContextPath()%>/user/in.do",$("#f").serialize(),function(data){
			if(data.respCode == 0){
				window.location.href = "<%=request.getContextPath()%>";
			}else{
				alert("登录失败");
			}
		});
  	}
  </script>
</html>
