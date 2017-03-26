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
   <center><h1>${assinfo.title}</h1></center>
   <h5>${assinfo.content}</h5>
    
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			
		});
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
	</script>
</body>
</html>