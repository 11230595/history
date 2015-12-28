<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="/comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>个人内容管理系统</title>
   <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
    
    <script>
    	$(function(){
    		$("#i_index").parent().removeClass("active");
    		$("#i_index").addClass("active");
    	})
    </script>
  </head>

  <body>
    <%@ include  file="template/nav.jsp"%><!-- 顶部导航 -->

    <div class="container-fluid">
      <div class="row">
		<%@ include  file="template/left-nav.jsp"%><!-- 左侧导航 -->
		<!-- 内容start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">我发布的内容</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th width="20%">标题</th>
                  <th width="50%">内容</th>
                  <th width="20%">创建时间</th>
                  <th width="10%">阅读量</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td><a href="javascript:void(0);">测试发布</a></td>
                  <td><a href="javascript:void(0);">测试测试测试</a></td>
                  <td style="color:#c6c6c6;">2015-12-27 00:00:00</td>
                  <td><code>阅读</code><span style="color:#c6c6c6;">(99)</span></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
		<!-- 内容end -->
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.js"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
