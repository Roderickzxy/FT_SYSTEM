<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助信息列表</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script src="<%=basePath%>layer-v1.9.3/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4/jquery.easyui.min.js"></script>
<style type="text/css">
body{width:80%;height:100%;background-color: #FFFFFF;text-align: left;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px; font-size: 13px;}
.info td{text-align:left;}
tr{margin-bottom:5px;}
</style>

<script>
/* function getLng(){
var address = $("#propertyAddr").val(); */
/* if(address!=null){
$.ajax({
	type:'post', 
	url: "getAddressJWJSON.html?address='"+address+"'",
	dataType: 'json',
	async : false, //默认为true 异步
	//data: data,
	success: function(data){
	 var longitude = data[0].lng;
	 var latitude = data[0].lat;
	 $("#longitude").val(longitude);
	 $("#latitude").val(latitude);
	  }
	});	
	}
}; */
</script>
</head>
<body>
	<form  action="/dgzf/personalhelpinfo/save.html" name="" id="" target="result" method="post" onsubmit="">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head" align="center">
			<th>序号</th>
			<th>标题</th>
			<th>内容</th>
		</tr>
		<c:choose>
			<c:when test="${not empty assinfoList}">
				<c:forEach items="${assinfoList}" var="assinfo" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td>
				<td><a href="javascript:showAssinfo2(${assinfo.id});" >${assinfo.title}</a></td>
				<td>${assinfo.content }</td>
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
</form>
    
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			
		});
		
		function showAssinfo(assinfoid){
					var dg = new $.dialog({
				title:'信息详情',
				id:'assinfo_detail',
				width:500,
				height:200,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'personalhelpinfo/edit.html?id='+assinfoid
				});
    		dg.ShowDialog();
		}
		
	
		
		function showAssinfo2(assinfoid){
			var msg_edit = layer.open({
    		    type: 2,
    		    title :'信息详情',
    		    content: 'personalhelpinfo/edit.html?id='+assinfoid,
    		    area: ['100%', '100%'],//最大化
    		    maxmin: false,
    		    btn: ['关闭'],
				yes: function(index, layero){
					 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象
			         var flag = true;//执行iframe页的方法  
			         if(flag){
				    	 layer.close(index); //执行关闭
						 //重新加载列表页
					     location.href = "personalhelpinfo.html";
				     }
    		    },
    		    cancel: function(index){
    		    	layer.close(index); //执行关闭
    		    	//重新加载列表页
			        location.href = "personalhelpinfo.html";
    		    }
    		});
    		layer.full(msg_edit);
		}
		
		
		  function ww4(date){  
            var y = date.getFullYear();  
            var m = date.getMonth()+1;  
            var d = date.getDate();  
            return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+'';  
              
        } 
        function w4(s){  
            var reg=/[\u4e00-\u9fa5]/  //利用正则表达式分隔 
            var ss1 = s.replace("[","").replace("]","");
            var ss = (ss1.split("-"));  
            var y = parseInt(ss[0],10);  
            var m = parseInt(ss[1],10);  
            var d = parseInt(ss[2],10);   
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)){  
                return new Date(y,m-1,d);  
            } else {  
                return new Date();  
            }  
        }  
		
		function checkInfo(){
			if($("#name").val()==""){
				alert("请输入姓名!");
				$("#name").focus();
				return false;
			}
			if($("#password").val()==""){//新增
				alert("请输入密码!");
				$("#password").focus();
				return false;
			}
			
			if($("#password").val()!=$("#chkpwd").val()){
				alert("请确认密码!");
				$("#password").focus();
				return false;
			}
			
			var options=$("#sex option:selected");
			if($("#sex").val()==""){
				alert("请选择性别!");
				$("#sex").focus();
				return false;
			}
			
			return true;
		}
		
		function success(){
			if(dg.curWin.document.forms[0]){
				dg.curWin.document.forms[0].action = dg.curWin.location+"";
				dg.curWin.document.forms[0].submit();
			}else{
				dg.curWin.location.reload();
			}
			dg.cancel();
		};
		
		function failed(){
			alert("保存失败！");
		}
	</script>
</body>
</html>