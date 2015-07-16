<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${request.contextPath}/ico/favicon.ico">

    <title>网址收藏夹</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${request.contextPath}/bootstrap/css/dashboard.css" rel="stylesheet">
    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>
	<script src="${request.contextPath}/baseproject/js/index.js"></script>
  </head>

  <body>
	<#include "template/template.ftl">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">网址收藏夹</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">登录</a></li>
            <li><a href="http://www.dovip.top/">开口示爱</a></li>
            <li><a href="http://dazhe.dovip.top/">九块九包邮</a></li>
            <li><a href="${request.contextPath}/about">关于</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">已收藏网址 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">新加网址</a></li>	
            <li><a href="#">发现</a></li>
            <li><a href="#">随心看</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		  <h2 class="sub-header">保存</h2>
		  <form id="f">
			  <table class="table">
	              <tbody>
	                <tr>
	                  <td>编码</td>
	                  <td><input type="text" id="code" name="code"></td>
	                </tr>
	                <tr>
	                  <td>名称</td>
	                  <td><input type="text" id="name" name="name"></td>
	                </tr>
	                <tr>
	                  <td colspan=2 style="align:center;"><input type="button"  class="btn btn-default" value="保存" onclick="save();"></td>
	                </tr>
			  	  </tbody>
			  </table>
		  </form>
		  
          <h2 class="sub-header">预览</h2>
          <p>
          	<input type="button"  class="btn btn-success" value="加载全部" onclick="getAll();">
          	<input type="text" placeholder="加载全部" disabled>
          <p>
          <p>
          	<input type="button"  class="btn btn-primary" value="加载单个" onclick="getById();">
          	<input type="text" placeholder="请输入code" id="findCode">
          <p>
          <p>
          	<input type="button"  class="btn btn-info" value="分页加载" onclick="getByPage();">
          	<input type="text" id="pageNo" placeholder="当前页">
          	<input type="text" id="pageSize" placeholder="每页显示的数据条数">
          <p>
          <div class="table-responsive" id="bodyDiv">
          	<!-- table start -->
            <table class="table table-striped" id="resultTable" style="display:none;">
		      <thead>
		        <tr>
		          <th>编码</th>
		          <th>名称</th>
		        </tr>
		      </thead>
		      <tbody>
		      	
		      </tbody>
    		</table>
            <!-- table end -->
          </div>
        </div>
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
