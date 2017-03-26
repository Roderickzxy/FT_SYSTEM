<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务信息管理</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
	<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="fitment.html" method="post" name="fitmentForm" id="fitmentForm">
	<div class="search_div">
	      <%--   查询日期：<input type="text"
				name="startTradate"
				value="<fmt:formatDate value="${transactionflow.startTradate}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker()"  style="width:70px;" />
			- <input type="text" name="endTradate"
				value="<fmt:formatDate value="${transactionflow.endTradate}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker()" style="width:70px;" />
		客户名：<input type="text" name="name" value="${customer.name }"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a> --%>
		<a href="javascript:addfitment();" class="myBtn"><em>新增</em></a>
	<!-- 	<a href="javascript:exportTransactionFlow();" class="myBtn"><em>导出交易流水</em></a>
		<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>  -->
	</div> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllHouseHirer()"/></th>
			<th>序号</th>
			<th>类别</th>
			<th>编码</th>
			<th>名称</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty fitmentList}">
				<c:forEach items="${fitmentList}" var="fitment" varStatus="vs">
				<tr class="main_info">
				<td><input type="checkbox" name="fitmentIds" id="fitmentIds${fitment.id }" value="${fitment.id }"/></td>
				<td>${vs.index+1}</td>
				<td>${fitment.fittype }</td>
				<td>${fitment.code}</td>
				<td>${fitment.name}</td>
					<td> <a href="javascript:editfitment(${fitment.id });">修改</a> | <a href="javascript:delfitment(${fitment.id });">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		${househirer.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lhgdialog/lhgdialog.min.js?self=false&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function sltAllHouseHirer(){
			if($("#sltAll").attr("checked")){
				$("input[name='houseHirerIds']").attr("checked",true);
			}else{
				$("input[name='houseHirerIds']").attr("checked",false);
			}
		}
		
		function exportTransactionFlow(){
				if(confirm("确定导出交易流水？")){
				var url = "transactionflow/export.html?id=0";
				$.get(url,function(data){
					if(data=="success"){
						alert("导出成功");
					}
				});
		}
		}
		
		function addfitment(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增',
				id:'afitment_new',
				width:360,
				height:360,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'fitment/add.html'
				});
    		dg.ShowDialog();
		}
		
		function editfitment(fitmentid){
			var dg = new $.dialog({
				title:'修改',
				id:'fitment_edit',
				width:360,
				height:360,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'fitment/edit.html?id='+fitmentid
				});
    		dg.ShowDialog();
		}
		
		function delfitment(fitmentId){
			if(confirm("确定要删除该记录？")){
				var url = "fitment/delete.html?id="+fitmentId;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
			
		function search(){
			$("#fitmentForm").submit();
		}
		
		function editRights(userId){
			var dg = new $.dialog({
				title:'用户授权',
				id:'auth',
				width:280,
				height:370,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'user/auth.html?userId='+userId
				});
    		dg.ShowDialog();
		}
	
		
		function exportUser(){
			document.location = "user/excel.html";
		}
	</script>
</body>
</html>