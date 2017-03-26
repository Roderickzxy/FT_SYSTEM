<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目导航</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="layer-v1.9.3/layer/layer.js"></script>
</head>
<body>
	<div class="search_div">
		<a href="javascript:addNavigation();" class="myBtn"><em>新增</em></a>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>名称</th>
			<th>代号</th>
			<th>链接</th>
			<th>背景图</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty navigationList}">
				<c:forEach items="${navigationList}" var="navigation" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td>
				<td id="nameTd${navigation.id}">${navigation.name}</td>
				<td id="codeTd${navigation.id}">${navigation.code}</td>
				<td id="urlTd${navigation.id}">${navigation.url}</td>
				<td id="picTd${navigation.id}"><img src="${navigation.pic}" width="60" height="60"></td>
				<td><a href="javascript:editNavigation(${navigation.id});">修改</a> | <a href="javascript:delNavigation(${navigation.id});">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
				<td colspan="5">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addNavigation(){
    		var navigation_new = layer.open({
    		    type: 2,
    		    title :'新增',
    		    content: 'navigation/add.html',
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
				     var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
				     var flag = iframeWin.saveInfo();//执行iframe页的方法  
				     if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "navigation.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "navigation.html";
    		    }
    		});
    		layer.full(navigation_new);
		}
		
		function editNavigation(id){
    		var navigation_edit = layer.open({
    		    type: 2,
    		    title :'修改',
    		    content: 'navigation/edit.html?id='+id,
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
					 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
			         var flag = iframeWin.saveInfo();//执行iframe页的方法  
			         if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "navigation.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "navigation.html";
    		    }
    		});
    		layer.full(navigation_edit);
		}
		
		function delNavigation(id){
			if(confirm("确定要删除该记录？")){
				var url = "navigation/delete.html?id="+id;
				$.get(url,function(data){
					data=$.trim(data);//去除空格
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
	</script>
</body>
</html>