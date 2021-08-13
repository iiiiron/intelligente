<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link href="favicon.ico" rel="icon" type="image/x-icon" />
<link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
<script src="style/js/jquery-3.2.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="style/css/base.css">
<link rel="stylesheet" type="text/css" href="style/css/home.css">
<link rel="stylesheet" type="text/css" href="style/css/nav.css">
<script type="text/javascript" src="style/js/banner.js"></script>
<script type="text/javascript" src="style/js/nav.js"></script>
<script type="text/javascript" src="style/js/ad.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
body {
	background-color: #f5f5f5;
	padding-left: 0px;
}

#contents {
	background-color: #FFF;
	padding-left: 20px;
}
</style>
</head>
<%@include file="head.jsp"%>
<div class="container" style="margin-top: 5%">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="left-nav">
						<div class="item">
							<div class="titlediv">
								<a href="#"  class="title">Java</a>
							</div>
							<a target="_blank" href="#" class="itema">JavaSE</a>
							<a target="_blank" href="#" class="itema">SpringBoot</a>
							<a target="_blank" href="#" class="itema">SpringMVC</a>
							<a target="_blank" href="#" class="itema">MyBatis</a>
						</div>
						<div class="item">
							<div class="titlediv">
								<a href="#"  class="title">H5前端</a>
							</div>
							<a target="_blank" href="#" class="itema">HTML+CSS</a>
							<a target="_blank" href="#" class="itema">NodeJS</a>
							<a target="_blank" href="#" class="itema">MongoDB</a>
							<a target="_blank" href="#" class="itema">Shell</a>
						</div>
						<div class="item">
							<div class="titlediv">
								<a href="#"  class="title">大数据</a>
							</div>
							<p>
							<a target="_blank" href="#" class="itema">Hadoop</a>
							<a target="_blank" href="#" class="itema">Hive</a>
							<a target="_blank" href="#" class="itema">Zookeeper</a>
							<a target="_blank" href="#" class="itema">MySQL核心</a>
							</p>
						</div>
						<div class="item">
							<div class="titlediv">
								<a href="#"  class="title">Android</a>
							</div>
							<a target="_blank" href="#" class="itema">核心技术</a>
							<a target="_blank" href="#" class="itema">高级开发</a>
							<a target="_blank" href="#" class="itema">项目实战</a>
							<a target="_blank" href="#" class="itema">前沿框架</a>
						</div>
						<div class="item">
							<div class="titlediv">
								<a href="#"  class="title">工具相关</a>
							</div>
							<a target="_blank" href="#" class="itema">IDEA</a>
							<a target="_blank" href="#" class="itema">Git&GitHub</a>
							<a target="_blank" href="#" class="itema">SVN</a>
							<a target="_blank" href="#" class="itema">Maven</a>
						</div>
					</nav>

					<div class="banner_container">
						<!-- 6张图片 -->
						<ul class="img_box">
							<li><img src="../style/image/index/1.png" alt=""></li>
							<li><img src="../style/image/index/2.jpeg" alt=""></li>
							<li><img src="../style/image/index/3.jpeg" alt=""></li>
							<li><img src="../style/image/index/4.jpeg" alt=""></li>
							<li><img src="../style/image/index/1.png" alt=""></li>
							<li><img src="../style/image/index/4.jpeg" alt=""></li>
						</ul>

						<!-- 中间圆点 -->
						<ul class="sel_box">
							<!-- 自定义属性 -->
							<li data-index="0"></li>
							<li data-index="1"></li>
							<li data-index="2"></li>
							<li data-index="3"></li>
						</ul>

						<!-- 左箭头 -->
						<div class="left_btn">&lt;</div>
						<!-- 右箭头 -->
						<div class="right_btn">&gt;</div>
					</div>


				</div>
			</div>

		</div>
	</div>
</div>

</body>


</html>