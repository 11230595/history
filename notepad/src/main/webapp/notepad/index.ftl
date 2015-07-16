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
    <script src="${request.contextPath}/bootstrap/js/ie-emulation-modes-warning.js"></script>

  </head>

  <body>

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

          <h2 class="sub-header">已收藏网址预览</h2>
          <div class="table-responsive">
          	<!-- table start -->
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>名称</th>
                  <th>网址</th>
                  <th>用户名</th>
                  <th>密码</th>
                  <th>备注</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td><a href="https://www.baidu.com/">百度一下，你就知道</a></td>
                  <td><a href="https://www.baidu.com/">https://www.baidu.com/</a></td>
                  <td>qq11230595</td>
                  <td></td>
                  <td>搜索网站</td>
                  <td><a href="javascript:void(0);">删除</a></td>
                </tr>
                <tr>
                  <td><a href="http://www.dovip.top/">开口示爱</a></td>
                  <td><a href="http://www.dovip.top/">http://www.dovip.top/<a></td>
                  <td>qq11230595</td>
                  <td></td>
                  <td>开口示爱</td>
                  <td><a href="javascript:void(0);">删除</a></td>
                </tr>
                <tr>
                  <td><a href="http://dazhe.dovip.top/">九块九包邮</a></td>
                  <td><a href="http://dazhe.dovip.top/">http://dazhe.dovip.top/<a></td>
                  <td>qq11230595</td>
                  <td></td>
                  <td>打折购物</td>
                  <td><a href="javascript:void(0);">删除</a></td>
                </tr>
                <tr>
                  <td><a href="http://www.taobao.com/">淘宝</a></td>
                  <td><a href="http://www.taobao.com/">http://www.taobao.com/<a></td>
                  <td>qq11230595</td>
                  <td></td>
                  <td>购物</td>
                  <td><a href="javascript:void(0);">删除</a></td>
                </tr>
              </tbody>
            </table>
            <!-- table end -->
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${request.contextPath}/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${request.contextPath}/bootstrap/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
