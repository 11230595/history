<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>分页</title>
    <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
  	
  	<!-- 分页css start -->
  	<style>
	*{ margin:0; padding:0; list-style:none;}
	a{ text-decoration:none;}
	a:hover{ text-decoration:none;}
	.tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;}
	.tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 4px;vertical-align: middle;}
	.tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
	.tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
	.tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
	</style>
	<!-- 分页css end -->
	<!-- 分页调用js -->
	<script src="<%=request.getContextPath()%>/js/jquery.page.js"></script>
  </head>

  <body>
    <%@ include  file="template/nav.jsp"%><!-- 顶部导航 -->

    <div class="container">
      <div class="jumbotron">
      	
      	<!-- 搜索 -->
      	<div class="col-lg-6">
            <div class="input-group">
               <input type="text" id="keyword" class="form-control" placeholder="用户名" value="${keyword }">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="button" onclick="search();">
                  	搜索用户名
                  </button>
               </span>
            </div>
         </div>
      	<!-- 搜索end -->
      
      	<!-- 存放数据table -->
      	<table class="table table-bordered">
		   <caption>数据</caption>
		   <thead>
		      <tr>
		         <th>ID</th>
		         <th>用户名</th>
		         <th>手机号</th>
		      </tr>
		   </thead>
		   <tbody>
		   	<!-- 循环数据start -->
		   	<c:choose>
              	<c:when test="${empty users}">
              		<tr>
              			<td>暂无数据....</td>
              		</tr>
              	</c:when>
              	<c:otherwise>
	              	<c:forEach var="user" items="${users.list}">
				      <tr>
				         <td>${user.id }</td>
				         <td>${user.userCode }</td>
				         <td>${user.phone }</td>
				      </tr>
	     		 	</c:forEach>
	           </c:otherwise>
	       </c:choose>
	       <!-- 循环数据end -->
		   </tbody>
		</table>
      	
      	<!-- 分页start -->
      	<div class="tcdPageCode"></div>
      	<!-- 分页end -->
      </div>
    </div>
  </body>
  	<!-- 分页触发js -->
	<script>
	$(function(){
		pages(); //初始化jquery分页组件
	})
	
	//分页方法
	function pages(){
		var totalPage = ${users.totalPage};
		var pageNo = ${users.pageNo};
		
	    $(".tcdPageCode").createPage({
	        pageCount:totalPage,
	        current:pageNo,
	        backFn:function(p){
	        	window.location.href = "<%=request.getContextPath()%>/user/page.do?pageSize=5&pageNo=" + p + searchUrl();
	        }
	    });
	}
	
	//搜索
	function search(){
		window.location.href = "<%=request.getContextPath()%>/user/page.do?pageSize=5&pageNo=1" + searchUrl();
	}
	
	//组装搜索条件
	function searchUrl(){
		//搜索start
		var searchKeyWrodUrl = "";
		var keyword = $("#keyword").val();
		if($.trim(keyword) != ''){
			searchKeyWrodUrl = "&userCode=" + keyword;		
		}
		//搜索end
		return searchKeyWrodUrl;
	}
		
	</script>
</html>