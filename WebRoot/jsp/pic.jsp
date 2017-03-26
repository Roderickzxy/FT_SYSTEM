<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片列表</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="layer-v1.9.3/layer/layer.js"></script>
</head>
<body>
	<form action="pic.html" method="post" name="picForm" id="picForm">
	<div class="search_div">
		标题：<input type="text" name="title" value="${pic.title }"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
		<a href="javascript:addPic();" class="myBtn"><em>新增</em></a>
	</div>
	</form>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>分类</th>
			<th>标题</th>
			<th>图片</th>
			<th>状态</th>
			<th>优先级</th>
			<th>是否形像图</th>
			<th>操作</th>
		</tr>

		<c:choose>
			<c:when test="${not empty picList}">
				<c:forEach items="${picList}" var="pic" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td>
				<td id="picTypeIdTd${pic.id }">${pic.picType.name }</td>
				<td id="titleTd${pic.id }">${pic.title }</td>
				<td id="picTd${pic.id }"><img src="${pic.pic}" width="60" height="60"></td>
				<td id="statusTd${pic.id }">${pic.status }</td>
				<td id="priorityTd${pic.id }">${pic.priority }</td>
				<td id="figureTd${pic.id }">
					<c:choose>
					<c:when test="${pic.figure==1}">
					是
					</c:when>
					<c:when test="${pic.figure==0}">
					否
					</c:when>
					<c:otherwise>
					否
					</c:otherwise>
					</c:choose>
				</td>
				<td><a href="javascript:editPic(${pic.id});">修改</a> | <a href="javascript:delPic(${pic.id});">删除</a></td>
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
		${pic.page.pageStr }
	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addPic(){
    		var pic_new = layer.open({
    		    type: 2,
    		    title :'新增',
    		    content: 'pic/add.html',
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
				     var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
				     var flag = iframeWin.saveInfo();//执行iframe页的方法  
				     if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "pic.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "pic.html";
    		    }
    		});
    		layer.full(pic_new);
		}
		
		function editPic(id){
    		var msg_edit = layer.open({
    		    type: 2,
    		    title :'修改',
    		    content: 'pic/edit.html?id='+id,
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
					 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
			         var flag = iframeWin.saveInfo();//执行iframe页的方法  
			         if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "pic.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "pic.html";
    		    }
    		});
    		layer.full(msg_edit);
		}
		
		function delPic(id){
			if(confirm("确定要删除该记录？")){
				var url = "pic/delete.html?id="+id;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
		function search(){
			$("#picForm").submit();
		}
	</script>
</body>
</html>