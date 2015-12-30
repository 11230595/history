<%@page import="com.hexun.personalcms.entity.TsUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
   <div class="container-fluid">
     <div class="navbar-header">
       <a class="navbar-brand" href="<%=request.getContextPath()%>">个人内容管理系统</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-right">
         <li><a href="<%=request.getContextPath()%>/user/login.do">
         		<%
         			TsUser user = (TsUser)session.getAttribute("ts_user");
         			if(user == null){
         		%>
         		注册/登录
         		<%
         			}else{
         		%>
         			欢迎您：${ts_user.userCode }
         		<%	
         			}
         		%>
         	 </a>
         </li>
         <li><a href="#">个人中心</a></li>
         <li><a href="javascript:void(0);" onclick="alert('这里是帮助~~~~');">帮助</a></li>
         <li><a href="<%=request.getContextPath()%>/user/page.do?pageSize=5&pageNo=1">分页</a></li>
       </ul>
       <form class="navbar-form navbar-right">
         <input type="text" class="form-control" placeholder="关键字...">
			<button type="button" class="btn btn-danger">搜索</button>
       </form>
     </div>
   </div>
 </nav>