<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户交易流水</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
	<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="transactionflow.html" method="post" name="customerForm" id="customerForm">
	<div class="search_div">
	        查询日期：<input type="text"
				name="startTradate"
				value="<fmt:formatDate value="${transactionflow.startTradate}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker()"  style="width:70px;" />
			- <input type="text" name="endTradate"
				value="<fmt:formatDate value="${transactionflow.endTradate}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker()" style="width:70px;" />
		<%-- 客户名：<input type="text" name="name" value="${customer.name }"/>--%>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a> 
		<a href="javascript:addTransactionFlow();" class="myBtn"><em>转账</em></a>
		<a href="javascript:exportTransactionFlow();" class="myBtn"><em>导出交易流水</em></a>
		<!--<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>-->
	</div> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllHouseHirer()"/></th>
			<th>序号</th>
			<th>日期</th>
			<th>成交时间</th>
			<th>银行名称</th>
			<th>操作</th>
			<th>货币单位</th>
			<th>发生金额</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty transactionflowList}">
				<c:forEach items="${transactionflowList}" var="transactionflow" varStatus="vs">
				<tr class="main_info">
				<td><input type="checkbox" name="transactionflowIds" id="transactionflowIds${transactionflow.id }" value="${transactionflow.id }"/></td>
				<td>${vs.index+1}</td>
				<td><fmt:formatDate value="${transactionflow.tradate}" pattern="yyyyMMdd"/></td>
				<td><fmt:formatDate value="${transactionflow.tratime}" pattern="HH:mm:ss"/></td>
				<td>${transactionflow.bankname }</td>
				<td>${transactionflow.operate}</td>
				<td>${transactionflow.curtype}</td>
				<td>${transactionflow.amount}</td>
				<td>${transactionflow.status}</td>
				<td><%-- <a href="javascript:editTransactionflow(${transactionflow.id });">查看</a> | --%> <a href="javascript:delTransactionflow(${transactionflow.id });">删除</a></td>
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
		
		function addTransactionFlow(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'转账',
				id:'transactionflow_new',
				width:360,
				height:360,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'transactionflow/add.html'
				});
    		dg.ShowDialog();
		}
		
		function editCustomer(customerId){
			var dg = new $.dialog({
				title:'修改客户',
				id:'customer_edit',
				width:360,
				height:560,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'customer/edit.html?id='+customerId
				});
    		dg.ShowDialog();
		}
		
		function delTransactionflow(transactionflowId){
			if(confirm("确定要删除该记录？")){
				var url = "transactionflow/delete.html?id="+transactionflowId;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
			
		function search(){
			$("#customerForm").submit();
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