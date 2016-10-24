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

</head>
<body>
	<div style="margin-bottom: 10px;">
		<button data-toggle="modal" data-target="#myModal"
			data-keyboard="false" data-backdrop="false"
			class="sui-btn btn-primary btn-lg">添加接口</button>
	</div>
	<div class="sui-msg msg-block msg-default msg-tips">
		<div class="msg-con">接口列表</div>
		<s class="msg-icon"></s>
	</div>
	<table class="sui-table table-bordered">
		<thead>
			<tr>
				<th>＃</th>
				<th>接口名称</th>
				<th>接口url</th>
				<th>请求类型</th>
				<th>请求参数</th>
				<th>请求计数</th>
				<th>接口描述</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(list)<=0}">
				<tr>
					<td colspan="9" align="center">没有数据</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(list)>0}">
				<c:forEach var="a" items="${list}" varStatus="x">
					<tr>
						<td><c:out value="${x.count}"></c:out></td>
						<td><c:out value="${a.aName}"></c:out></td>
						<td><c:out value="${a.aUrl}"></c:out></td>
						<td><c:out value="${a.aRequestType}"></c:out></td>
						<td><c:out value="${a.aParam}"></c:out></td>
						<td><c:out value="${a.aCount}"></c:out></td>
						<td><c:out value="${a.aDescription}"></c:out></td>
						<td><fmt:formatDate value="${a.aDate}" type="date"
								pattern="yyyy-MM-dd" /></td>
						<td><a href="apiDel.do?id=<c:out value="${a.aId}"></c:out>">删除</a>
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
		class="sui-modal hide">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="sui-close">×</button>
					<h4 id="myModalLabel" class="modal-title">添加接口信息</h4>
				</div>
				<div class="modal-body">
					<div class="sui-msg msg-block msg-default msg-tips">
						<div class="msg-con">填写接口信息属性</div>
						<s class="msg-icon"></s>
					</div>
					<form class="sui-form form-horizontal sui-validate" action="apiAdd.do"
						method="post">
						<div class="control-group">
							<label for="inputEmail" class="control-label">接口名称：</label>
							<div class="controls">
								<input type="text" id="inputEmail" name="aName" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">接口url：</label>
							<div class="controls">
								<input type="text" id="inputEmail" name="aUrl" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">请求类型：</label>
							<div class="controls">
								<select name="aRequestType" data-rules="required" style="width: 155px;">
									<option value="1">GET</option>
									<option value="2">POST</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">请求参数：</label>
							<div class="controls">
								<input type="text" id="inputEmail" name="aParam" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">接口描述：</label>
							<div class="controls">
								<textarea rows="" cols="30" name="aDescription" data-rules="required"></textarea>
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


</body>
</html>