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
<script type="text/javascript" src="../../sui/js/jquery.form.js"></script>

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
				<th>添加时间</th>
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
						<td><a href="apiDel.do?id=<c:out value="${r.rId}"></c:out>">删除</a>
						</td>
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
		class="sui-modal hide fade">
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

					<img id="viewImg" alt="" src="">

					<form id="formToUpdate" method="post" action="#"
						enctype="multipart/form-data"
						class="sui-form form-horizontal sui-validate">

						<div class="control-group">
							<label for="inputEmail" class="control-label">上传图片：</label>
							<div class="controls">
								<input type="file" name="ficon" class="sui-btn btn-default" data-rules="required">
							</div>
						</div>
						<div style="text-align: center;">
							<button id="ajaxSubmit" type="button" class="sui-btn btn-default">上传</button>
						</div>
					</form>

				</div>
			</div>
		</div>

		<script type="text/javascript" language="javascript">
			$(function() {
				//异步提交表单
				$("#ajaxSubmit").on(
						"click",
						function() {
							console.log($(this));
							$("#formToUpdate").ajaxSubmit(
									{
										type : 'post',
										url : '../../api/attach/upload2.do',
										success : function(data) {
											console.log(data);
											if (data.success == 0) {
												//alert(data.data.url);
												$("#viewImg").attr("src",
														data.data.url);
												alert('上传成功');
											}
										},
										error : function(XmlHttpRequest,
												textStatus, errorThrown) {
											console.log(XmlHttpRequest);
											console.log(textStatus);
											console.log(errorThrown);
										}
									});
						});
			});
		</script>
</body>
</html>