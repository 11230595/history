<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>网址收藏夹</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${request.contextPath}/bootstrap/css/dashboard.css" rel="stylesheet">
        <!-- Placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>
    <script src="${request.contextPath}/notepad/js/index.js"></script>
    <script src="${request.contextPath}/notepad/js/favorite.js"></script>

  </head>

  <body>
  	<#if user??>
	  	<input type="hidden" value="${user.userId!''}" id="userId">
  	</#if>
  
	<#include "template/head.ftl"><!-- 头信息 -->
	<#include "template/foot.ftl"><!-- 脚信息 -->
	<#include "template/myUrl.ftl"><!-- 已收藏 -->
	<#include "template/addUrl.ftl"><!-- 新加 -->
	<#include "template/favoriteHome.ftl"><!-- 管理收藏夹 -->

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="javascript:void(0);" onclick="myUrl(this);">已收藏网址 <span class="sr-only">(current)</span></a></li>
            <li><a href="javascript:void(0);" onclick="goAdd(this);">新加网址</a></li>
            <li><a href="javascript:void(0);" onclick="favoriteHome(this)">收藏夹管理</a></li>	
            <li><a href="javascript:void(0);">发现</a></li>
            <li><a href="javascript:void(0);">随心看</a></li>
            <li><a href="javascript:void(0);">记事本</a></li>
            <li><a href="javascript:void(0);">简历托管</a></li>
          </ul>
        </div>
        <!-- 主内容区start -->
        <div id="main">
        	
        </div>
        <!-- 主内容区end -->
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
