<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影像分类管理</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<div class="search_div">
		<a href="javascript:addmsgType();" class="myBtn"><em>新增</em></a>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th style="width:50%;">名称</th>
			<th>代号</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty msgTypeList}">
				<c:forEach items="${msgTypeList}" var="msgType" varStatus="vs">
				<tr class="main_info" id="tr${msgType.id }">
				<td>${vs.index+1}</td>
				<td>${msgType.name }</td>
				<td>${msgType.code }</td>
				<td><a href="###" onclick="openClose(${msgType.id },this,${vs.index })">展开</a> | 
				<a href="###" onclick="editmsgType(${msgType.id })">修改</a> | 
				<a href="###" onclick="delmsgType(${msgType.id },true)">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
				<td colspan="4">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	
	<div class="page_and_btn">
	</div>
	
	<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addmsgType(){
			var dg = new $.dialog({
				title:'新增影像分类',
				id:'msgType_new',
				width:330,
				height:220,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'msgType/add.html'
				});
    		dg.ShowDialog();
		}
		
		function editmsgType(id){
			var dg = new $.dialog({
				title:'修改影像分类',
				id:'msgType_edit',
				width:330,
				height:220,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'msgType/edit.html?id='+id
				});
    		dg.ShowDialog();
		}
		
		function delmsgType(id,isParent){
			var flag = false;
			if(isParent){
				if(confirm("确定要删除该影像分类吗？其下子影像分类将一并删除！")){
					flag = true;
				}
			}else{
				if(confirm("确定要删除该影像分类吗？")){
					flag = true;
				}
			}
			if(flag){
				var url = "msgType/del.html?id="+id;
				$.get(url,function(data){
					document.location.reload();
				});
			}
		}
		
		function openClose(id,curObj,trIndex){
			var txt = $(curObj).text();
			if(txt=="展开"){
				$(curObj).text("折叠");
				$("#tr"+id).after("<tr class='main_info' id='tempTr"+id+"'><td colspan='4'>数据载入中</td></tr>");
				if(trIndex%2==0){
					$("#tempTr"+id).addClass("main_table_even");
				}
				var url = "msgType/sub.html?id="+id;
				$.get(url,function(data){
					//alert(data);
					if(data.length>0){
						var html = "";
						$.each(data,function(i){
							html = "<tr style='height:24px;line-height:24px;' name='subTr"+id+"'>";
							html += "<td></td>";
							html += "<td><span style='width:80px;display:inline-block;'></span>";
							if(i==data.length-1)
								html += "<img src='images/joinbottom.gif' style='vertical-align: middle;'/>";
							else
								html += "<img src='images/join.gif' style='vertical-align: middle;'/>";
							html += "<span style='width:100px;text-align:left;display:inline-block;'>"+this.name+"</span>";
							html += "</td>";
							html += "<td>"+this.code+"</td>";
							html += "<td><a href='###' onclick='editmsgType("+this.id+")'>修改</a> | <a href='###' onclick='delmsgType("+this.id+",false)'>删除</a></td>";
							html += "</tr>";
							$("#tempTr"+id).before(html);
						});
						$("#tempTr"+id).remove();
						if(trIndex%2==0){
							$("tr[name='subTr"+id+"']").addClass("main_table_even");
						}
						//alert($(".main_table").html());
					}else{
						$("#tempTr"+id+" > td").html("没有相关数据");
					}
				},"json");
			}else{
				$("#tempTr"+id).remove();
				$("tr[name='subTr"+id+"']").remove();
				$(curObj).text("展开");
			}
		}
</script>	
</body>
</html>