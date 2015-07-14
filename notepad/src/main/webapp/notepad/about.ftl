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
    <!-- 日历 -->
    <link href="${request.contextPath}/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

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
        <h1>关于本站</h1>
        <p>1、本站非盈利，非商业性网站。</p>
        <p>2、本站意在让更多人拥有自己的个性网站，降低拥有网站的门槛。</p>
        <p>3、本站所有模板均有来自网络，欢迎大家投递模板。</p>
        <p>4、所有在本站生成的网页均不得涉及攻击性，违法性言论。</p>
        <p>5、所有会员资料均属于隐私，本站不会泄露任何会员资料。</p>
        <p>6、联系站长:<code>chinazhoudong@gmail.com</code>。</p>
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
    	$(function(){
    		$("#home").removeClass("active");
    		$("#about").addClass("active");
    	})
    </script>
  </body>
</html>
