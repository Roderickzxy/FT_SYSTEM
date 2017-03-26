<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务设置</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
	<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="customerproperty.html" method="post" name="customerpropertyForm" id="customerpropertyForm">
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
		<!-- <a href="javascript:addfitment();" class="myBtn"><em>新增</em></a> -->
	<!-- 	<a href="javascript:exportTransactionFlow();" class="myBtn"><em>导出交易流水</em></a>
		<a href="javascript:exportUser();" class="myBtn"><em>导出</em></a>  -->
	</div> 
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllHouseHirer()"/></th>
			<th>序号</th>
			<th>编码</th>
			<th>参数</th>
			<th>设置值</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty customerpropertyList}">
				<c:forEach items="${customerpropertyList}" var="customerproperty" varStatus="vs">
				<tr class="main_info">
				<td><input type="checkbox" name="customerpropertyIds" id="customerpropertyIds${customerproperty.id }" value="${customerproperty.id }"/></td>
				<td>${vs.index+1}</td>
				<td>${customerproperty.code }</td>
				<td>${customerproperty.fittype}</td>
				<td id="tdqxstatus${customerproperty.id}">${customerproperty.name}</td>
					<td> <a id="qxstatus${customerproperty.id}" href="javascript:editcustomerproperty(${customerproperty.id},'${customerproperty.name}');">
					<c:choose>
					<c:when test="${customerproperty.name =='已开通'}">
					关闭权限
					</c:when>
					<c:otherwise>
					开通权限
					</c:otherwise>
					</c:choose>
					</a> <%-- | <a href="javascript:delcustomerproperty(${customerproperty.id });">删除</a> --%></td>
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
		
		function editcustomerproperty(customerpropertyid,customerpropertyname){
		if("已开通" == customerpropertyname){//关闭权限	
		if(confirm("确定要关闭该权限？")){
				var url = "customerqxproperty/edit.html?id="+customerpropertyid+"&name=已关闭";
				$.get(url,function(data){
					if(data=="success"){
						
						
					}
				});
				alert("关闭权限成功");
				$("#qxstatus"+customerpropertyid).html("开通权限");
				$("#tdqxstatus"+customerpropertyid).html("已关闭");
			}
		}else{//开通权限
		if(confirm("确定要开通该权限？")){
				var url = "customerqxproperty/edit.html?id="+customerpropertyid+"&name=已开通";
				$.get(url,function(data){
					if(data=="success"){
					
					}
				});
					alert("开通权限成功");
					$("#qxstatus"+customerpropertyid).html("关闭权限");
					$("#tdqxstatus"+customerpropertyid).html ("已开通");
			}
		
		}
		
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
	</script>
</body>
</html>