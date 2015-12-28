<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>个人内容管理系统</title>
   <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
    
    <script>
    	$(function(){
    		$("#recom").parent().removeClass("active");
    		$("#recom").addClass("active");
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
          <h2 class="sub-header">推荐的内容</h2>
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
                <c:choose>
	              	<c:when test="${empty contents}">
	              		<tr>
	              			<td>暂无数据....</td>
	              		</tr>
	              	</c:when>
	              	<c:otherwise>
		              	<c:forEach var="content" items="${contents}">
			                <tr>
			                  <td><a target="_blank" href="<%=request.getContextPath()%>/content/detail.do?id=${content.ID}">${content.TITLE }</a></td>
			                  <td><a target="_blank" href="<%=request.getContextPath()%>/content/detail.do?id=${content.ID}">${fn:substring(content.CONTENT, 0, 50)}</a></td>
			                  <td style="color:#c6c6c6;">${content.CREATE_TIME }</td>
			                  <td><code>阅读</code><span style="color:#c6c6c6;">(
			                  	<c:choose>
			                  		<c:when test="${empty content.count}">
			                  		0
			                  		</c:when>
									<c:otherwise>
										${content.count}
									</c:otherwise>
			                  	</c:choose>
			                  	
			                  )</span></td>
			                </tr>
		                </c:forEach>
		           </c:otherwise>
	             </c:choose>
              </tbody>
            </table>
          </div>
        </div>
		<!-- 内容end -->
      </div>
    </div>
  </body>
</html>
