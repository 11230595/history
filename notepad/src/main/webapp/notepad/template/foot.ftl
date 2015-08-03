<!-- FOOTER -->
<style>
footer{
    clear: both;
    display: block;
    position: absolute;
    bottom: 100px;
}
footer{
    clear: both;
    display: block;
    text-align: center;    
    margin: 0px auto;
    position: absolute;
    bottom: 100px;
    width:100%;
}
</style>
<!--动态改变footer的width值，实现文字居中效果。-->
<script>
        var w=window.innerWidth
        || document.documentElement.clientWidth
        || document.body.clientWidth;
 
        var h=window.innerHeight
        || document.documentElement.clientHeight
        || document.body.clientHeight;
        document.getElementById("footer").style.width=w + "px";
</script>
<footer>
	<p style="text-align:center;">&copy; 2015 Company, Inc. 鲁ICP备15020019号-1 &middot; <a href="#">一周科技荣誉出品</a> &middot; <a href="#">Terms</a></p>
</footer>