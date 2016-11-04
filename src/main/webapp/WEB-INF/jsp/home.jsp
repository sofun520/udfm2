<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
<style type="text/css">
body {
	background-color: #f5f5f5;
}

.top {
	width: 1100px;
	height: 60px;
	margin: auto;
	padding: 2px 0 2px 0;
}

.center {
	width: 1100px;
	margin: auto;
}

.left_menu {
	width: 200px;
	min-height: 500px;
	border-left: 1px solid #efefef;
	border-right: 1px solid #efefef;
	border-bottom: 1px solid #efefef;
	float: left;
	padding: 0px;
	background-color: #eaedf4;
}

.main_content {
	width: 870px;
	padding: 10px 10px 0 10px;
	float: left;
	background-color: #ffffff;
}

#toccnt {
	
}

#toccnt li {
	margin: 0;
	height: 30px;
	list-style: none;
	border-bottom: 1px solid #e6e6e6;
	width: 200px;
	background-color: #f7f7f7 /*&:hover{color:$color_blue_0;}*/;
	width: 200px;
	border-bottom: 1px solid #e6e6e6;
	list-style: none;
}

#toccnt li a {
	width: 180px;
	display: block;
	text-decoration: none;
	height: 25px;
	padding-top: 5px;
	padding-left: 10px;
	padding-right: 10px;
	color: #666;
}

#toccnt li a:hover {
	width: 180px;
	display: block;
	text-decoration: none;
	height: 25px;
	padding-top: 5px;
	padding-left: 10px;
	padding-right: 10px;
	background-color: #ffffff;
	padding-right: 10px;
	color: #666;
}

#toccnt li.active a {
	color: #238efa;
	background-color: #fff;
}

.logo {
	width: 200px;
	height: 50px;
	margin-top: 10px;
	float: left;
}

.top_menu {
	width: 770px;
	height: 50px;
	margin-top: 10px;
	float: left;
	margin-left: 20px;
}

.top_menu li {
	float: left;
	list-style: none;
	width: 110px;
	height: 35px;
	font-size: 14px;
	margin-top: 15px;
	margin-left: 10px;
	text-align: center;
}

.top_menu li a {
	text-decoration: none;
}

i {
	margin-right: 10px;
}

.top_menu_right {
	width: 100px;
	float: left;
	margin-top: 30px;
}
</style>
</head>
<body>
	<div
		style="border-bottom: 1px solid #d9d9d9; background-color: #f6f6f6">
		<div class="top">
			<div class="logo">
				<img alt="" src="../images/logo.gif">
			</div>
			<div class="top_menu">
				<ul id="pMenu">

				</ul>
			</div>
			<div class="top_menu_right">
				${authUser.username}&nbsp;&nbsp;<a href="../logout.do?url=login.do">注销</a>
			</div>
		</div>
	</div>
	<div class="center">
		<div class="left_menu">
			<div id="toccnt">
				<ul id="subMenu">
					<!-- <li><a href="#"><i class="sui-icon icon-tb-cascades"></i>二级菜单1</a></li>
					<li class="active"><a href="#">二级菜单2</a></li>
					<li><a href="#">二级菜单3</a></li>
					<li><a href="#">二级菜单4</a></li>
					<li><a href="#">二级菜单5</a></li>
					<li><a href="#">二级菜单6</a></li> -->
				</ul>
			</div>
		</div>
		<div class="main_content">
			<div class="sui-content">
				<iframe id="subFrame" style="width: 100%; border: 0px;"> </iframe>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			$("#subFrame").css('height',
					document.documentElement.clientHeight - 80);
			$(".left_menu").css('height',
					document.documentElement.clientHeight - 70);
			getPMenu();
		});

		function getPMenu() {
			$
					.get(
							"../api/roleMenu/query.do?roleId=${authUser.roleId}&mType=2",
							function(data) {
								var ht = '';
								var menuId = '';
								$
										.each(
												data.data,
												function(i, value) {
													if (i == 0) {
														menuId = value.mId;
													}
													ht += '<li><a href="javascript:void()"  onclick="getSubMenu(\''
															+ value.mId
															+ '\')">'
															+ value.mName
															+ '</a></li>';
												})
								$("#pMenu").html(ht);
								getSubMenu(menuId);
							});
		}

		function getSubMenu(id) {
			$
					.get(
							"../api/roleMenu/query.do?roleId=${authUser.roleId}&mType=2&mParent="
									+ id,
							function(data) {
								var ht = '';
								var murl = '';
								var index;
								var len;
								$
										.each(
												data.data,
												function(i, value) {
													if (i == 0) {
														murl = value.mUrl;
														index = i;
														len = data.data.length;
													}
													/* ht += '<li id="li'+i+'"><a href="javascript:void(0)" onclick="loadFrame(\''
															+ value.mUrl
															+ '\')"><i class="sui-icon icon-tb-cascades"></i>'
															+ value.mName
															+ '</a></li>'; */
													ht += '<li id="li'+i+'"><a href="javascript:void(0)" onclick="loadFrame(\''
													+ value.mUrl
													+ '\',\''
													+ i
													+ '\',\''
													+ data.data.length
													+ '\')"><i class="sui-icon icon-tb-cascades"></i><span>'
													+ value.mName
													+ '</span></a></li>';
												});
								$("#subMenu").html(ht);
								loadFrame(murl, index, len);
							});
		}

		function loadFrame(url, i, len) {
			cancleLiActive(len);
			var obj = document.getElementById("li" + i);
			obj.setAttribute("class", "active");
			$("#subFrame").attr('src', url);
		}
		
		function cancleLiActive(len) {
			for (var i = 0; i < len; i++) {
				var obj = document.getElementById("li" + i);
				obj.removeAttribute("class");
			}
		}
	</script>
</body>
</html>