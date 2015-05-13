<%@ page contentType="text/html;charset=UTF-8" %><%@ include file="/jsp/common/taglibs.jsp"%><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title><%=Property.SYSTEM_NAME %></title>
<%@ include file="/jsp/common/meta.jsp"%>
</head>

<body>
<%@ include file="/jsp/common/top.jsp"%>

<div class="product-imglist swiper-scroll-container">
  <div class="swiper-wrapper">
    <div class="swiper-slide" style="width:1800px;padding:20px 0;">
      <ul class="clear" style="">
        <li><img src="pics/20140224144040_8372.jpg" /></li>
        <li><img src="pics/20140224144044_9668.jpg" /></li>
        <li><img src="pics/20140224144059_7588.jpg" /></li>
        <li><img src="pics/20140224144100_6064.jpg" /></li>
      </ul>
    </div> 
  </div>
</div>

<div class="product-name product-padd">
  <h1>双褶西裤 SFBA1175A</h1>
  <span>现价：</span>
  <strong>￥188.00</strong>
  <del>￥398.00 </del>
</div>

<hr class="product-hr" />

<div class="product-info product-padd">
  <dl class="clear">
    <dt class="color">颜色：</dt>
    <dd class="color" skuname="颜色">
      <span data-value="颜色:黑色">黑色</span>
    </dd>
  </dl>
  <dl class="clear">
    <dt>规格：</dt>
    <dd class="speci" skuname="规格">
      <span>76/2.28尺/29.5</span>
      <span>78/2.34尺/30.5</span>
      <span>80/2.4尺/31</span>
      <span>82/2.46尺/31.5</span>
      <span>84/2.52尺/32</span>
      <span>86/2.58尺/33</span>
      <span>88/2.64尺/33.5</span>
      <span>90/2.7尺/34</span>
      <span>92/2.76尺/34.5</span>
      <span>94/2.82尺/35</span>
      <span>96/2.88尺/36</span>
      <span>100/3.0尺/37</span>
    </dd>
  </dl>
  <dl class="clear">
    <dt>数量：</dt>
    <dd class="number" skuname="数量">
      <span class="reduce"></span>
      <input type="tel" value="1">
      <span class="increase"></span>
      <span class="srplus">剩余300件</span>
    </dd>
  </dl>
</div>

<hr class="product-hr" />

<div class="product-botton product-padd clear">
  <a href="##" class="add" id="ShoppingAdd">加入购物车</a>
  <a href="##" class="buy" id="ShoppingBuy">立即购买</a>
  <!--alert-->
  <div class="shopping-alert" id="ShoppingAlert">请选择规格</div>
  <!--alert end-->
</div>
<script type="text/javascript">
  
</script>

<div class="product-dtailed product-padd">
  <h1>商品详情</h1>
  <dl class=""cont>
    商品文字介绍
  </dl>
</div>

<!--弹出框-->

<div class="shopping-layer" id="ShoppingLayer">
  <div class="thebox">
    <h1>添加成功！</h1>
    <ul class="clear">
     <a href="##" class="sroll">再逛逛</a>
     <a href="##" class="shopbuy">去购物车结算</a>
   </ul>
</div>
</div>
<!--弹出框end-->

<script type="text/javascript">
$('#ShoppingBuy').click(function() {
  $('#ShoppingAlert').fadeIn(500).delay(1000).fadeOut(500);
});

$('#ShoppingAdd').click(function() {
  $('#ShoppingLayer').fadeIn(500);
  $('#ShoppingLayer').height($(document).height());
});
$('#ShoppingLayer a').click(function() {
  $('#ShoppingLayer').fadeOut(500);
});

</script>

<%@ include file="/jsp/common/bottom.jsp"%>
</body>
</html>
