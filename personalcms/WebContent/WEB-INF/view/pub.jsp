<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>

    <title>个人内容管理系统</title>
    <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
    
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor/themes/default/default.css" /><!-- kindeditor -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor/plugins/code/prettify.css" /><!-- kindeditor -->
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor/kindeditor.js"></script><!-- kindeditor -->
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor/lang/zh_CN.js"></script><!-- kindeditor -->
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor/plugins/code/prettify.js"></script><!-- kindeditor -->
	<script>
		$(function(){
			$("#pub").parent().removeClass("active");
			$("#pub").addClass("active");
		})
		
		var BASE = "<%=request.getContextPath()%>";
		
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : BASE + '/js/kindeditor/plugins/code/prettify.css',
				uploadJson : BASE + '/upload_json.jsp',
				fileManagerJson : BASE + '/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		
		//提交
		function doSubmit(){
			$.post(BASE + "/content/add.do",$("#f").serialize(),function(data){
				alert(data.respCode);
				if(data.respCode == 0){
					alert("保存成功");
					window.location.reload(true);
				}else{
					alert("保存出错");
				}
			});
		}
	</script>
  </head>

  <body>
    <%@ include  file="template/nav.jsp"%><!-- 顶部导航 -->

    <div class="container-fluid">
      <div class="row">
		<%@ include  file="template/left-nav.jsp"%><!-- 左侧导航 -->
		
		<!-- 内容start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">发布内容</h2>
          <div class="table-responsive">
			<form name="f" id="f" method="post" action="demo.jsp">
				<input type="hidden" name="userId" value="1234">
				<p>
					<input type="text" name="title" id="inputUserCode" class="form-control" placeholder="标题" required style="width:80%;">
				</p>
				<textarea name="content" id="content1" cols="100" rows="8" style="width:80%;height:600px;visibility:hidden;"></textarea>
				<br />
				<input type="button" name="button" value="提交内容" class="btn btn-primary" onclick="doSubmit();"/> (提交快捷键: Ctrl + Enter)
			</form>
          </div>
        </div>
		<!-- 内容end -->
      </div>
    </div>
  </body>
</html>
