<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 左侧导航start -->
<div class="col-sm-3 col-md-2 sidebar">
  <ul class="nav nav-sidebar">
    <li class="active" id="index"><a href="<%=request.getContextPath()%>">全部内容</a></li>
    <li id="pub"><a href="<%=request.getContextPath()%>/content/pub.do">发布内容</a></li>
    <li id="recom"><a href="#">推荐的内容</a></li>
    <li id="i_index"><a href="#">我发布的内容</a></li>
    <li id="i_recom"><a href="#">我推荐的内容</a></li>
  </ul>
</div>
<!-- 左侧导航end -->