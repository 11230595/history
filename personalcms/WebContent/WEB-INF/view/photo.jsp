<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="comm/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>

    <title>个人内容管理系统</title>
    <%@ include  file="template/head.jsp"%><!-- 公用的头信息 -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/dashboard.css" rel="stylesheet">
    
    <!-- uploadify start -->
	<link href="<%=request.getContextPath()%>/js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.js"></script>  
	<!-- uploadify end -->
	
	<script>
	$(function(){
		$("#upload_photo").parent().find("li").removeClass("active");
		$("#upload_photo").addClass("active");
	})
	
	
	//uploadify  start
	var maxFileSize = 10 * 1024 * 1024;  
	/** 
	 * @title 上传图片 
	 * @author zhoudong 
	 */  
	$(function(){    
	    $("#uploadify").uploadify({    
	        'debug'     : false, //开启调试    
	        'auto'      :true,  //是否自动上传    
	        'buttonText':'',  //按钮上的文字  
	        'swf'       : "<%=request.getContextPath()%>/js/uploadify/uploadify.swf",//flash      
	        'queueID'   :'uploadfileQueue',  //文件选择后的容器ID    
	        'uploader'  :'<%=request.getContextPath()%>/upload/photo.do',  //后台action  
	        'width'     :'144',  //按钮宽度  
	        'height'    :'65',  //按钮高度  
	        'multi'     :false,  //是否支持多文件上传，默认就是true  
	        'fileObjName':'photo',//后台接收的参数，如：使用struts2上传时，后台有get,set方法的接收参数  
	        'fileTypeDesc':'支持的格式：',//  可选择文件类型说明  
	        'fileTypeExts':'*.jpg;*.jpge;*.gif;*.png',  //允许上传文件的类型  
	        'fileSizeLimit': maxFileSize,  //文件上传的最大大小  
	        //返回一个错误，选择文件的时候触发    
	        'onSelectError':function(file, errorCode, errorMsg){    
	            switch(errorCode) {    
	                case -100:    
	                    alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");    
	                    break;    
	                case -110:    
	                    alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");    
	                    break;    
	                case -120:    
	                    alert("文件 ["+file.name+"] 大小异常！");    
	                    break;    
	                case -130:    
	                    alert("文件 ["+file.name+"] 类型不正确！");    
	                    break;    
	            }    
	        },    
	        //上传到服务器，服务器返回相应信息到data里    
	        'onUploadSuccess':function(file, data, response){    
	            var json = eval("(" + data + ")");  
	            //如需上传后生成预览，可在此操作  
	            
	            $("#viewPhoto").attr("src",json.fileURL);
	        }
	    });    
	});    
	</script>
  </head>

  <body>
    <%@ include  file="template/nav.jsp"%><!-- 顶部导航 -->

    <div class="container-fluid">
      <div class="row">
		<%@ include  file="template/left-nav.jsp"%><!-- 左侧导航 -->
		
		<!-- 内容start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">上传图片</h2>
          <div class="table-responsive">
			<form>
				<input type="file" id="uploadify" name="photo"><!-- 上传按钮 -->
				<img alt="" src="" id="viewPhoto">
			</form>
          </div>
        </div>
		<!-- 内容end -->
      </div>
    </div>
  </body>
</html>
