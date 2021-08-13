<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/css/amazeui.min.css">
<link rel="stylesheet" href="style/css/course.css">
<link rel="stylesheet" href="style/css/admin.css">
<link rel="stylesheet" href="style/css/login.css">
<link rel="stylesheet" href="style/css/iconfont/iconfont.css">
<link rel="stylesheet" href="style/css/header.css">
<script src="style/js/login.js"></script>
<script src="style/js/loginandregist.js"></script>
<!-- <script src="style/js/jquery-3.2.1.min.js"></script> -->
 <script src="style/js/amazeui.min.js"></script> 
<link rel="stylesheet" href="style/css/bootstrap.min.css">
<script src="style/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/css/course.css">
</head>
<body>
<body>
<div id="dengluinput"
	 style="position: fixed; background: rgb(255, 255, 255) none repeat scroll 0% 0%; z-index: 100000; left: 50%; top: 50%; margin: -220px 0px 0px -220px; box-shadow: 0px 0px 3px rgba(0, 0, 0, 0.25); display: none;">
	<div style="height: 16px;margin-top: 2px;padding-right: 10px"><span style="float: right; cursor: pointer;font-size: 16px"
																		onclick="guanbi()"> X </span></div>
	<div
			style="font-size: 16px; line-height: 49px; height: 49px; color: #787d82; ">
			<span id="denglu" onclick="denglu()"
				  style="border-bottom:1px solid #EC5039; margin-top:4px; color: black; float: left; width: 50%; text-align: center; height: 49px; line-height: 49px; cursor: pointer; padding: 0 20px;">登录</span>

		<span id="zhuce" onclick="zhuce()"
			  style="border-bottom: 1px solid #d0d6d9; color: black; float: left; width: 50%; text-align: center; height: 49px; line-height: 49px; cursor: pointer; padding: 0 20px;">注册</span>
	</div>
		<div style="padding: 30px 30px;">
			<form id="form1" action="login" method="post">
				<label for="username">用&emsp;户&emsp;名:</label> <input class="denglu-input"
					id="username" type="text" name="username" style="width: 430px;margin-bottom: 10px;"><br> <label
					for="password">密&emsp;&emsp;&emsp;码:</label> <input class="denglu-input" id="password"
					type="password" name="password" style="width: 430px;margin-bottom: 10px;"><br> <label
					id="labelrpw" for="password"><br></label> <br />
					<%--<label
					for="varcode">验证码</label> <br><input class="denglu-input" id="varcode"
					type="text" name="varcode" style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="changevarcode()" id="varcodeimg" alt="验证码" src="changevarcode"> <br>--%>
				<span id="tishi"></span><br>
			</form>
			<button id="tijiao" onclick="quickpasswordchat()" type="button"
				style="color: white; margin-top: 20px;  width: 100%; height: 50px; background: #3BB149;">登录</button>
			<div style="margin: 10px 0px;font-size: 16px;text-align: center">
				<a href="#">找回密码</a>
			</div>
			<div class="social-login" style="margin-top:20px;
	text-align: center;">
					<span class="iconfont icon-qq" style="padding:0 20px;
	line-height: 22px;"></span>
					<span class="iconfont icon-weibo" style="padding:0 20px;
	line-height: 22px;"></span>
					<span class="iconfont icon-weixin" style="padding:0 20px;
	line-height: 22px;"></span>
			</div>
		</div>
	</div>

	<nav class="header"
		role="navigation">
	<div class="h-con relative">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="course">课程 </a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath }/index">首页</a></li>
				<%--<li><a href="showvip">会员中心</a></li>--%>
			</ul>
			<form class="navbar-form navbar-left" action="coursesearch"
				method="post">

				<input type="text" name="search" class="form-control header-search"
					placeholder="课程">
				<button type="submit" class="btn header-searchbtn">查找</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${loginUser != null }">
					<%--<li><a href="mylearn">我的学习 </a></li>--%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><c:if
								test="${loginUser.nickname !=null}">
								[${loginUser.nickname }]
								</c:if>
							<c:if test="${loginUser.nickname ==null}">
								[${loginUser.username }]
								</c:if><strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="info" class="glyphicon glyphicon-inbox">个人设置</a></li>
							<li><a href="logout" class="glyphicon glyphicon-inbox">
									退出帐号</a></li>

						</ul></li>


				</c:if>
				<c:if test="${loginUser == null }">
					<li><a href="#" onclick="showdenglu()"><span
							class="glyphicon glyphicon-log-in"></span> 登录</a></li>
					<li><a href="#" onclick="showdenglu()"><span
							class="glyphicon glyphicon-user"></span> 注册 </a></li>
				</c:if>

			</ul>
		</div>
	</div>
	</nav>
</body>
</html>