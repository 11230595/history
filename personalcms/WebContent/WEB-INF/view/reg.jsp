<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>注册</title>
	<%@ include  file="/template/head.jsp"%>
	<link href="<%=request.getContextPath()%>/bootstrap/css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form class="form-signin">
        <h2 class="form-signin-heading">请注册</h2>
        <p>
		<label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputUserCode" class="form-control" placeholder="用户名" required autofocus>
		</p>
		 <p>
		<label for="inputEmail" class="sr-only">邮箱</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
		</p>
		<p>
		<label for="inputEmail" class="sr-only">手机号</label>
        <input type="number" id="inputPhone" class="form-control" placeholder="手机号">
        </p>
		<p>
		<label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
		</p>
		<p>
		<label for="inputPassword" class="sr-only">确认密码</label>
        <input type="password" id="inputNewPassword" class="form-control" placeholder="确认密码" required>
        </p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>
    </div> <!-- /container -->
  </body>
</html>
