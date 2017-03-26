<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>辅助信息管理</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="layer-v1.9.3/layer/layer.js"></script>
</head>
<body>
	<form action="assinfo.html" method="post" name="assinfoForm" id="assinfoForm">
	<div class="search_div">
		标题：<input type="text" name="title" value="${assinfo.title }"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>&nbsp;&nbsp;
		<a href="javascript:addAssinfo();" class="myBtn"><em>新增</em></a>
	</div>
	</form>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>分类</th>
			<th>标题</th>
			<th>内容</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty assinfoList}">
				<c:forEach items="${assinfoList}" var="assinfo" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td>
				<td>${assinfo.msgType}</td>
				<td>${assinfo.title }</td>
				<td>${assinfo.content }</td>
				<td>${assinfo.status}</td>
				<td><a href="javascript:editAssinfo(${assinfo.id});">修改</a> | <a href="javascript:delAssinfo(${assinfo.id});">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
				<td colspan="10">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		${assinfo.page.pageStr }
	</div>
	
	<script type="text/javascript">
 		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});

		function addAssinfo(){
    		var msg_new = layer.open({
    		    type: 2,
    		    title :'新增',
    		    content: 'assinfo/add.html',
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
				     var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
				     var flag = iframeWin.saveInfo();//执行iframe页的方法  
				     if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "assinfo.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "assinfo.html";
    		    }
    		});
    		layer.full(msg_new);
		}
		
		function editAssinfo(assinfoid){
			var msg_edit = layer.open({
    		    type: 2,
    		    title :'修改',
    		    content: 'assinfo/edit.html?id='+assinfoid,
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
					 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
			         var flag = iframeWin.saveInfo();//执行iframe页的方法  
			         if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "assinfo.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "assinfo.html";
    		    }
    		});
    		layer.full(msg_edit);
		}
		
		function delAssinfo(assinfoId){
			if(confirm("确定要删除该记录？")){
				var url = "assinfo/delete.html?id="+assinfoId;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
		function search(){
			$("#assinfoForm").submit();
		}
	</script>
</body>
</html>