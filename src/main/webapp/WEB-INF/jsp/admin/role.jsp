<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<!-- <link href="../sui/css/sui.css" rel="stylesheet">
<script type="text/javascript"
	src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="../sui/js/sui.min.js"></script> -->


<link rel="stylesheet" href="../ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="../ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../ztree/js/jquery.ztree.core.js"></script>
<script src="../ztree/js/jquery.ztree.all.js"></script>


</head>
<body>
	<div style="margin-bottom: 10px;">
		<button data-toggle="modal" data-target="#myModal"
			data-keyboard="false" data-backdrop="false"
			class="sui-btn btn-primary btn-lg">添加角色</button>
	</div>
	<div class="sui-msg msg-block msg-default msg-tips">
		<div class="msg-con">系统角色列表</div>
		<s class="msg-icon"></s>
	</div>
	<table class="sui-table table-bordered">
		<thead>
			<tr>
				<th>＃</th>
				<th>角色名称</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(list)<=0}">
				<tr>
					<td colspan="4" align="center">没有数据</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(list)>0}">
				<c:forEach var="r" items="${list}" varStatus="x">
					<tr>
						<td><c:out value="${x.count}"></c:out></td>
						<td><c:out value="${r.rName}"></c:out></td>
						<td><fmt:formatDate value="${r.rDate}" type="date"
								pattern="yyyy-MM-dd" /></td>
						<td><a href="roleDel.do?id=<c:out value="${r.rId}"></c:out>"
							class="sui-btn btn-small">删除</a> <a href="#" data-toggle="modal"
							onclick="openDialog('${r.rId}','${r.rName}')"
							data-target="#myModal2" data-keyboard="false"
							data-backdrop="false" class="sui-btn btn-small">配置菜单</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

	<div class="sui-msg msg-block msg-default msg-tips">
		<div class="msg-con">以下为供销平台上已经获得小二授权经营您的品牌但还未被您进行收编的供应商</div>
		<s class="msg-icon"></s>
	</div>
	<table class="sui-table table-bordered-simple">
		<thead>
			<tr>
				<th>供应商昵称</th>
				<th>公司名称</th>
				<th>供应商类型</th>
				<th>分销商数量</th>
				<th>授权品牌</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><span>only淘宝商城官方旗舰店</span></td>
				<td><span>九牧官方旗舰店</span></td>
				<td><span>企业</span></td>
				<td><span class="distributor-num">432</span></td>
				<td>
					<ul class="authorize-brand">
						<li>海尔</li>
						<li>统帅</li>
					</ul>
				</td>
				<td data-supplierid="111">
					<button class="sui-btn btn-small J_addOneSupplier">添加</button>
				</td>
			</tr>
		</tbody>
	</table>

	<!-- Modal-->
	<div id="myModal" tabindex="-1" role="dialog" data-hasfoot="false"
		class="sui-modal hide">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="sui-close">×</button>
					<h4 id="myModalLabel" class="modal-title">添加角色</h4>
				</div>
				<div class="modal-body">
					<div class="sui-msg msg-block msg-default msg-tips">
						<div class="msg-con">填写系统角色属性</div>
						<s class="msg-icon"></s>
					</div>
					<form class="sui-form form-horizontal sui-validate"
						action="roleAdd.do" method="post">
						<div class="control-group">
							<label for="inputEmail" class="control-label">角色名称：</label>
							<div class="controls">
								<input type="text" id="inputEmail" name="rName" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div style="text-align: center;">
							<button type="submit" class="sui-btn btn-primary">提交</button>
							<button type="button" data-dismiss="modal"
								class="sui-btn btn-default">取消</button>
						</div>
					</form>

				</div>
				<!-- <div class="modal-footer">
				</div> -->
			</div>
		</div>
	</div>

	<div id="myModal2" tabindex="-1" role="dialog" data-hasfoot="false"
		class="sui-modal hide" style="">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="sui-close">×</button>
					<h4 id="myModalLabel" class="modal-title">配置菜单</h4>
				</div>
				<div class="modal-body">
					<div class="sui-msg msg-block msg-default msg-tips">
						<div class="msg-con">
							为角色[<span id="roleName"></span>]配置菜单(角色ID：<span id="roleId"></span>)
						</div>
						<s class="msg-icon"></s>
					</div>
					<div class="content_wrap">
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="sui-btn btn-primary"
						onclick="regist()">提交</button>
					<button type="button" data-dismiss="modal"
						class="sui-btn btn-default">取消</button>
				</div>
			</div>
		</div>
	</div>


	<SCRIPT type="text/javascript">
		var setting = {
			check : {
				enable : true
			},
			data : {
				simpleData : {
					enable : true
				}
			}
		};

		var myModal2=$("#myModal2");
		var treeObj;
		function openDialog(id, name) {
			$("#roleName").html(name);
			$("#roleId").html(id);
			$.get('roleMenu.do?roleId=' + id, function(data) {
				treeObj = $.fn.zTree.init($("#treeDemo"), setting, data.data);
				treeObj.expandAll(true);
			});
			
			//myModal2.show();
		}

		function regist() {
			var roleId = $("#roleId").html();
			var menuId = '';
			nodes = treeObj.getCheckedNodes(true);
			for (var i = 0; i < nodes.length; i++) {
				if (i == nodes.length - 1) {
					menuId += nodes[i].id;
				} else {
					menuId += nodes[i].id + ',';
				}
			}
			
			$.post('addRoleMenu.do',{roleId:roleId,rmMenuIds:menuId},function(data){
				if(data.success=='0'){
					alert('配制成功');
					$.alert('配制成功');
				}else{
					alert('配置失败');
					$.alert('配置失败');
				}
			});
			
			myModal2.hide();
		}
	</SCRIPT>
</body>
</html>