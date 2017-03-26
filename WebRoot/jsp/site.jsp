<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统设置</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="layer-v1.9.3/layer/layer.js"></script>
</head>
<body>
	<div class="search_div">
		<a href="javascript:addSite();" class="myBtn"><em>新增</em></a>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>域名</th>
			<th>背景图</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty siteList}">
				<c:forEach items="${siteList}" var="site" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td>
				<td id="domainTd${site.id}">${site.domain}</td>
				<td id="backimgTd${site.id}"><img src="${site.backimg}" width="60" height="60"></td>
				<td><a href="javascript:editSite(${site.id});">修改</a> | <a href="javascript:delSite(${site.id});">删除</a></td>
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
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addSite(){
    		var pic_new = layer.open({
    		    type: 2,
    		    title :'新增',
    		    content: 'site/add.html',
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
				     var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
				     var flag = iframeWin.saveInfo();//执行iframe页的方法  
				     if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "site.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "site.html";
    		    }
    		});
    		layer.full(site_new);
		}
		
		function editSite(id){
    		var msg_edit = layer.open({
    		    type: 2,
    		    title :'修改',
    		    content: 'site/edit.html?id='+id,
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['保存', '取消'],
				yes: function(index, layero){
					 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
			         var flag = iframeWin.saveInfo();//执行iframe页的方法  
			         if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "site.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "site.html";
    		    }
    		});
    		layer.full(site_edit);
		}
		
		function delSite(id){
			if(confirm("确定要删除该记录？")){
				var url = "site/delete.html?id="+id;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
	</script>
</body>
</html>