<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户信息管理</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="accountinfo.html" method="post" name="accountinfoForm" id="accountinfoForm">
	<div class="search_div">
		客户编号/客户姓名：<input type="text" name="name" value="${accountinfo.customer.name }"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
		<a href="javascript:addAccountinfo();" class="myBtn"><em>新增</em></a>
		<!--<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>-->
	</div> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllHouseHirer()"/></th>
			<th>序号</th>
			<th>客户编号</th>
			<th>姓名</th>
			<th>转入</th>
			<th>转出</th>
			<th>总资产</th>
			<th>客户佣金</th>
			<th>三方存管</th>
			<th>发生日期</th>
			<th>开发人员</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty accountinfoList}">
				<c:forEach items="${accountinfoList}" var="accountinfo" varStatus="vs">
				<tr class="main_info">
				<td><input type="checkbox" name="accountinfoIds" id="accountinfoIds${accountinfo.id }" value="${accountinfo.id }"/></td>
				<td>${vs.index+1}</td>
				<td>${accountinfo.customer.account}</td>
				<td>${accountinfo.customer.name }</td>
				<td>${accountinfo.train}</td>
				<td>${accountinfo.traout}</td>
				<td>${accountinfo.traowner}</td>
				<td>${accountinfo.khyj}</td>
				<td>${accountinfo.sfck}</td>
				<td><fmt:formatDate value="${accountinfo.operatedate}" pattern="yyyyMMdd"/></td>
				<td>${accountinfo.user.username}</td>
				<td><a href="javascript:editAccountinfo(${accountinfo.id });">修改</a> | <a href="javascript:delAccountinfo(${accountinfo.id });">删除</a></td>
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
		
		function addAccountinfo(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'账户管理',
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
		
		function delAccountinfo(accountinfoId){
			if(confirm("确定要删除该记录？")){
				var url = "accountinfo/delete.html?id="+accountinfoId;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
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