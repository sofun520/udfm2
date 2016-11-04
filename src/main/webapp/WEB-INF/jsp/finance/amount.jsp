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
			class="sui-btn btn-primary btn-lg">新增消费</button>
	</div>
	<div class="sui-msg msg-block msg-default msg-tips">
		<div class="msg-con">系统角色列表</div>
		<s class="msg-icon"></s>
	</div>
	<table class="sui-table table-bordered">
		<thead>
			<tr>
				<th>＃</th>
				<th>类型</th>
				<th>总计(&yen;)</th>
				<th>支付方式</th>
				<th>卡号</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(list)<=0}">
				<tr>
					<td colspan="7" align="center">没有数据</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(list)>0}">
				<c:forEach var="r" items="${list}" varStatus="x">
					<tr>
						<td><c:out value="${x.count}"></c:out></td>
						<td><c:if test="${r.aType==1}">收入</c:if> <c:if
								test="${r.aType==2}">支出</c:if></td>
						<td><div align="right">
								<c:out value="${r.aSum}"></c:out>
							</div></td>
						<td><c:if test="${r.aWays==1}">现金</c:if> <c:if
								test="${r.aWays==2}">银行卡</c:if> <c:if test="${r.aWays==3}">信用卡</c:if>
						</td>
						<td><c:out value="${r.cNo}"></c:out></td>
						<td><fmt:formatDate value="${r.aDate}" type="date"
								pattern="yyyy-MM-dd" /></td>
						<td><a
							href="amountDel.do?id=<c:out value="${r.aId}"></c:out>">删除</a></td>
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

					<form class="sui-form form-horizontal sui-validate"
						action="amountInsert.do" method="post">
						<div class="control-group">
							<label for="inputEmail" class="control-label">支付类型：</label>
							<div class="controls">
								<select name="aType" style="width: 156px;">
									<c:forEach var="p" items="${enumList }">
										<option value="<c:out value="${p.eKey}"></c:out>"><c:out
												value="${p.eValue}"></c:out></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">总计：</label>
							<div class="controls">
								<input type="text" id="eCode" name="aSum" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">支付方式：</label>
							<div class="controls">
								<select id="aWays" name="aWays" style="width: 156px;"
									onchange="gradeChange()">
									<c:forEach var="p" items="${enumList2 }">
										<option value="<c:out value="${p.eKey}"></c:out>"><c:out
												value="${p.eValue}"></c:out></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="control-group" id="cardShow">
							<label for="inputEmail" class="control-label">卡号：</label>
							<div class="controls">
								<select name="aCardId" style="width: 156px;" id="aCardId">

								</select>
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">票据：</label>
							<div class="controls">
								<input type="text" id="eCode" name="aImg" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div style="text-align: center;">
							<button type="submit" class="sui-btn btn-primary">提交</button>
							<button type="reset" class="sui-btn">重置</button>
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

	<script type="text/javascript">
		$(function() {
			$("#cardShow").hide();
		});

		function gradeChange() {
			var id = $("#aWays").val();
			if (id == 1) {
				$("#aCardId").html('');
				$("#cardShow").hide();
			} else if (id == 2) {
				$.get('../../api/finance/query.do?cType=1', function(data) {
					var html = '';
					$.each(data.data, function(i, m) {
						html += '<option value="'+m.cId+'">' + m.cNo
								+ '</option>';
					});
					$("#aCardId").html(html);
				});
				$("#cardShow").show();
			} else if (id == 3) {
				$.get('../../api/finance/query.do?cType=2', function(data) {
					var html = '';
					$.each(data.data, function(i, m) {
						html += '<option value="'+m.cId+'">' + m.cNo
								+ '</option>';
					});
					$("#aCardId").html(html);
				});
				$("#cardShow").show();
			}
		}
	</script>
</body>
</html>