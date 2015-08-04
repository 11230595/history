<!-- 收藏夹管理 -->
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="favoriteHome" style="display:none;">
  <h2 class="sub-header">新增收藏夹：</h2>
  <div class="table-responsive">
  	<!-- table start -->
    <form class="form-horizontal" role="form" id="favoriteForm" style="width:80%;">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">收藏夹名称：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputFavoriteName" name="name"
	          placeholder="我的收藏夹">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label class="col-sm-2 control-label">收藏夹描述：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputFavoriteDesc" name="favoriteDesc"
	          placeholder="非必填">
	    </div>
	  </div>
	  
	  <div style="width:100%;text-align:center;">
	  	<button type="button" class="btn btn-info" onclick="saveFavorit();">添&nbsp;加</button>
	  </div>
	</form>
    <!-- table end -->
  </div>
  
  <h2 class="sub-header">已存在收藏夹：</h2>
  <div class="table-responsive">
  	<!-- table start -->
    <table class="table table-striped" id="favroiteTable">
      <thead>
        <tr>
          <th>名称</th>
          <th>描述</th>
          <th>创建日期</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>默认收藏夹</td>
          <td>初始化收藏夹</td>
          <td>2015-08-04 00:00:00</td>
          <td><a href="javascript:void(0);">删除</a></td>
        </tr>
      </tbody>
    </table>
    <!-- table end -->
  </div>
</div>