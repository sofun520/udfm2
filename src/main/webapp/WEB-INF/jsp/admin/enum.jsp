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


</head>
<body>
	<div style="margin-bottom: 10px;">
		<button onclick="add()" data-keyboard="false" data-backdrop="false"
			class="sui-btn btn-primary btn-lg">新增枚举</button>
	</div>
	<div class="sui-msg msg-block msg-default msg-tips">
		<div class="msg-con">系统角色列表</div>
		<s class="msg-icon"></s>
	</div>
	<table class="sui-table table-bordered">
		<thead>
			<tr>
				<th>＃</th>
				<th>枚举描述</th>
				<th>枚举CODE</th>
				<th>枚举KEY</th>
				<th>枚举VALUE</th>
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
				<c:forEach var="e" items="${list}" varStatus="x">
					<tr>
						<td><c:out value="${x.count}"></c:out></td>
						<td><c:out value="${e.eDescription}"></c:out></td>
						<td><c:out value="${e.eCode}"></c:out></td>
						<td><c:out value="${e.eKey}"></c:out></td>
						<td><c:out value="${e.eValue}"></c:out></td>
						<td><fmt:formatDate value="${e.eDate}" type="date"
								pattern="yyyy-MM-dd" /></td>
						<td><a href="javascript:void(0)"
							onclick="del(<c:out value="${e.eId}"></c:out>)">删除</a> <a
							href="javascript:void(0)"
							onclick="edit(<c:out value="${e.eId}"></c:out>)">修改</a></td>
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


	<div id="myModal2" tabindex="-1" role="dialog" data-hasfoot="false"
		class="sui-modal hide" style="">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="sui-close">×</button>
					<h4 id="myModalLabel" class="modal-title">配置参数</h4>
				</div>
				<div class="modal-body">
					<form id="myform" class="sui-form form-horizontal sui-validate"
						action="enumAdd.do" method="post">
						<div class="control-group">
							<label for="inputEmail" class="control-label">枚举描述：</label>
							<div class="controls">
								<input type="hidden" id="eId" name="eId"> <input
									type="text" id="eDescription" name="eDescription"
									placeholder="" data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">枚举CODE：</label>
							<div class="controls">
								<input type="text" id="eCode" name="eCode" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">枚举KEY：</label>
							<div class="controls">
								<input type="text" id="eKey" name="eKey" placeholder=""
									data-rules="required">
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">枚举VALUE：</label>
							<div class="controls">
								<textarea id="eValue" name="eValue" rows="3" cols="40"
									data-rules="required"></textarea>
							</div>
						</div>
						<div style="text-align: center">
							<button type="submit" class="sui-btn btn-primary">提交</button>
							<button type="button" data-dismiss="modal"
								class="sui-btn btn-default">取消</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function(){
			$("#myModal2").modal({backdrop:false,show:false});
			$("#myModal2").modal('hide');
		});
	
		function edit(id){
			$.get('../api/enum/find.do?id='+id,function(data){
				//alert(JSON.stringify(data));
				$("#eId").val(data.data.eId);
				$("#eCode").val(data.data.eCode);
				$("#eKey").val(data.data.eKey);
				$("#eValue").val(data.data.eValue);
				$("#eDescription").val(data.data.eDescription);
			});
			$("#myModal2").modal('show');
		}
		
		function add(){
			$('#myform')[0].reset();
			$("#eId").val("");
			//$("#eCode").val("SMS");
			//$('#eCode').attr("disabled",true);
			$('#eKey').attr("disabled",false);
			$("#myModal2").modal('show');
		}
		
		function del(id){
			return $.confirm({
			      title: '确认',
			      body: '是否删除该数据？',
			      backdrop: false,
			      okHide: function() {
			    	window.location.href='enumDel.do?id='+id;
			        return true;
			      }
			    });
		}
	</script>
</body>
</html>