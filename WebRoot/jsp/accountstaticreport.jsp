<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简单统计</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="accountinfo.html" method="post" name="accountinfoForm" id="accountinfoForm">
	<div class="search_div">
	<%--         ${reporttype}统计标准：<select name="reporttype" id="reporttype" class="input_txt" onchange="javascript:changeReortType()">
				<option value="">请选择</option>
				<option value="1">按总资产</option>
				<option value="2">按风险等级</option>
				</select> --%>
		<!-- <a href="javascript:search();" class="myBtn"><em>查询</em></a>
		<a href="javascript:addAccountinfo();" class="myBtn"><em>新增</em></a>
		 --><!--<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>-->
	</div> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>统计标准</th>
			<th>编号</th>
			<th>姓名</th>
			<th>总资产</th>
			<th>风险等级</th>
		</tr>
		<c:choose>
		<c:when test="${reporttype == '1'}">
	<%-- 	  <c:choose>
		   <c:when> --%>
			<c:if test="${not empty normalAccountList}">
			    <tr class="main_info">
				<td rowspan="${normalAccountListSize}">普通用户</td>			
			  	<c:forEach items="${normalAccountList}" var="normalaccountinfo" varStatus="vs">
				<td>${normalaccountinfo.customer.account}</td>
				<td>${normalaccountinfo.customer.name }</td>
				<td>${normalaccountinfo.traowner}</td>
				<td>${normalaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${not empty hjAccountList}">
			    <tr class="main_info">
				<td rowspan="${hjAccountListSize}" >黄金用户</td>			
			  	<c:forEach items="${hjAccountList}" var="hjaccountinfo" varStatus="vs">
				<td>${hjaccountinfo.customer.account}</td>
				<td>${hjaccountinfo.customer.name }</td>
				<td>${hjaccountinfo.traowner}</td>
				<td>${hjaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${not empty bjAccountList}">
				<tr class="main_info">
				<td rowspan="${bjAccountListSize}">白金用户</td>			
			  	<c:forEach items="${bjAccountList}" var="bjaccountinfo" varStatus="vs">
				<td>${bjaccountinfo.customer.account}</td>
				<td>${bjaccountinfo.customer.name }</td>
				<td>${bjaccountinfo.traowner}</td>
				<td>${bjaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${not empty bzAccountList}">
				<tr class="main_info">
				<td rowspan="${bzAccountListSize}">白钻用户</td>			
			  	<c:forEach items="${bzAccountList}" var="bzaccountinfo" varStatus="vs">
				<td>${bzaccountinfo.customer.account}</td>
				<td>${bzaccountinfo.customer.name }</td>
				<td>${bzaccountinfo.traowner}</td>
				<td>${bzaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
<%-- 			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		 </c:choose>	 --%> 		  
		</c:when>
	   <c:otherwise>
		<%-- <c:when test="${reporttype=='风险等级'}"> --%>
		   <c:if test="${not empty wjAccountList}">
			    <tr class="main_info">
				<td rowspan="${wjAccountListSize}">稳健型</td>			
			  	<c:forEach items="${wjAccountList}" var="wjaccountinfo" varStatus="vs">
				<td>${wjaccountinfo.customer.account}</td>
				<td>${wjaccountinfo.customer.name }</td>
				<td>${wjaccountinfo.traowner}</td>
				<td>${wjaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${not empty bsAccountList}">
			    <tr class="main_info">
				<td rowspan="${bsAccountListSize}" >保守型</td>			
			  	<c:forEach items="${bsAccountList}" var="bsaccountinfo" varStatus="vs">
				<td>${bsaccountinfo.customer.account}</td>
				<td>${bsaccountinfo.customer.name }</td>
				<td>${bsaccountinfo.traowner}</td>
				<td>${bsaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${not empty jqAccountList}">
				<tr class="main_info">
				<td rowspan="${jqAccountListSize}">进取型</td>			
			  	<c:forEach items="${jqAccountList}" var="jqaccountinfo" varStatus="vs">
				<td>${jqaccountinfo.customer.account}</td>
				<td>${jqaccountinfo.customer.name }</td>
				<td>${jqaccountinfo.traowner}</td>
				<td>${jqaccountinfo.customer.fxlever}</td>
				</tr>
				</c:forEach>
			</c:if>
<%-- 		</c:when> --%>
	
		${reporttype}
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
		
		function addAccountinfo(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'开户',
				id:'transactionflow_new',
				width:360,
				height:360,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'accountinfo/add.html'
				});
    		dg.ShowDialog();
		}
		
		function editAccountinfo(accountinfoId){
			var dg = new $.dialog({
				title:'修改信息',
				id:'accountinfo_edit',
				width:360,
				height:560,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'accountinfo/edit.html?id='+accountinfoId
				});
    		dg.ShowDialog();
		}
		
		function changeReortType(){
			var reporttype = $("#reporttype").val();
			var	url = "accountstaticreport.html";
			if("2" == reporttype){
				url ="accountstaticreport/list2.html";
			}
			$.get(url,function(data){
				});
			}
		
		
			
		function search(){
			$("#accountinfoForm").submit();
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