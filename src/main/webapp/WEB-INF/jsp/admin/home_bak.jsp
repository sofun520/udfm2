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
	float: left;
	padding: 0px;
}

.main_content {
	width: 870px;
	padding: 10px 10px 0 10px;
	float: left;
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
	width: 870px;
	height: 50px;
	margin-top: 10px;
	float: left;
	margin-left: 20px;
}

.top_menu li {
	float: left;
	list-style: none;
	width: 100px;
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
</style>
</head>
<body>
	<div style="border-bottom: 1px solid #d9d9d9;">
		<div class="top">
			<div class="logo">
				<p style="font-size: 24px; color: #238efa">
					<i class="sui-icon icon-tb-homefill"></i>测试系统
				</p>
			</div>
			<div class="top_menu">
				<ul id="pMenu">
					
				</ul>
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
				<table class="sui-table table-bordered">
					<thead>
						<tr>
							<th>＃</th>
							<th>待付款</th>
							<th>宝宝数量</th>
							<th>交易金额</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>所有交易</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>待付款</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>已发货</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>已成功</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
					</tbody>
				</table>
				<table class="sui-table table-nobordered">
					<thead>
						<tr>
							<th>＃</th>
							<th>待付款</th>
							<th>宝宝数量</th>
							<th>交易金额</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>所有交易</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>待付款</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>已发货</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
						<tr>
							<td>已成功</td>
							<td>9999.00</td>
							<td>999</td>
							<td>99999.00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {

			getPMenu();

		});

		function getPMenu() {
			$.get("../api/menu/query.do?mType=1", function(data) {
				//$.alert(JSON.stringify(data));

				var ht = '';
				$.each(data.data, function(i, value) {
					ht+='<li><a href="javascript:void()" onclick="getSubMenu(\''+value.mId+'\')">'+value.mName+'</a></li>';
				})
				$("#pMenu").html(ht);
			});
		}

		function getSubMenu(id) {
			$.get("../api/menu/query.do?mType=1&mParent="+id,function(data){
				$.alert(JSON.stringify(data));
				var ht='';
				$.each(data.data,function(i,value){
					ht+='<li><a href="javascript:void(0)" onclick="fram(\''+value.mUrl+'\')"><i class="sui-icon icon-tb-cascades"></i>'+value.mName+'</a></li>';					
				});
				$("#subMenu").html(ht);
			});
		}
		
		function fram(url){
			$.alert(url);
		}
	</script>
</body>
</html>