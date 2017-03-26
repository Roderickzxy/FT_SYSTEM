<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="customer.html" method="post" name="customerForm" id="customerForm">
	<div class="search_div">
		客户编号/客户姓名：<input type="text" name="name" value="${customer.name }"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
		<a href="javascript:addCustomer();" class="myBtn"><em>新增</em></a>
		<!--<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>-->
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllHouseHirer()"/></th>
			<th>序号</th>
			<th>客户编号</th>
			<th>名字</th>
			<th>开户日期</th>
			<th>沪股东代码</th>
			<th>深股东代码</th>
			<th>风险等级</th>
			<th>工作人员</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty customerList}">
				<c:forEach items="${customerList}" var="customer" varStatus="vs">
				<tr class="main_info">
				<td><input type="checkbox" name="customerIds" id="customerIds${customer.id }" value="${customer.id }"/></td>
				<td>${vs.index+1}</td>
				<td>${customer.account }</td>
				<td>${customer.name }</td>
				<td><fmt:formatDate value="${customer.opendate}" pattern="yyyy-MM-dd"/></td>
				<td>${customer.hucode}</td>
				<td>${customer.shencode}</td>
				<td>${customer.fxlever}</td>
				<td>${customer.user.username}</td>
				<td><a href="javascript:editCustomer(${customer.id });">修改</a> | <a href="javascript:delCustomer(${customer.id });">删除</a></td>
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
		
		function addCustomer(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增客户',
				id:'customer_new',
				width:360,
				height:560,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'customer/add.html'
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
		
		function delCustomer(customerId){
			if(confirm("确定要删除该记录？")){
				var url = "customer/delete.html?id="+customerId;
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