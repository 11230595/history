<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
   <div class="container-fluid">
     <div class="navbar-header">
       <a class="navbar-brand" href="#">个人内容管理系统</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-right">
         <li><a href="#">注册/登录</a></li>
         <li><a href="#">个人中心</a></li>
         <li><a href="javascript:void(0);" onclick="alert('这里是帮助~~~~');">帮助</a></li>
       </ul>
       <form class="navbar-form navbar-right">
         <input type="text" class="form-control" placeholder="关键字...">
			<button type="button" class="btn btn-danger">搜索</button>
       </form>
     </div>
   </div>
 </nav>