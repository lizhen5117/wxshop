<%@ page contentType="text/html;charset=UTF-8" %><%@ include file="/jsp/common/taglibs.jsp"%><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title><%=Property.SYSTEM_NAME %></title>
<%@ include file="/jsp/common/meta.jsp"%>
</head>
<body style="overflow:none;">


<div class="hudu-index" id="hudu-index">
  <img src="pics/20140227095141_7803.jpg" />
  <ul class=="animate">
    <li><a href="#">热销专区</a></li>
    <li><a href="#">新品专区</a></li>
    <li><a href="#">限时特惠</a></li>
    <li><a href="#">男裤标准</a></li>
  </ul>
</div>

<div class="hudu-bom">
  <a class="home" href="${base }"></a>
  <ul class="clear">
    <li class="telephone"><a href="#">咨询电话</a></li>
    <li class="dividing"></li>
    <li class="service"><a href="#">客服2</a></li>
    <li class="dividing"></li>
    <li class="service"><a href="#">客服1</a></li>
  </ul>
</div>

<script type="text/javascript">
$(function(){
	var $Hudu_Top = $('#HuduTop');
	var $Hudu_IdxHei =  $(window).height()-$Hudu_Top.height()-70;
	$('#hudu-index').height($Hudu_IdxHei);
	$('#hudu-index img').height($Hudu_IdxHei);	
});
</script>

</body>
</html>