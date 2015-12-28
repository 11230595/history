<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>个人内容管理系统</title>
    <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
  </head>

  <body>
    <%@ include  file="template/nav.jsp"%><!-- 顶部导航 -->

    <div class="container">
      <div class="jumbotron">
      	<p>
      		<h2>${content.title }</h2><br>
      	</p>
		${content.content }
      </div>
    </div>
  </body>
</html>
