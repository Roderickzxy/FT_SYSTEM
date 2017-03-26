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
<title>修改密码</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
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
	<form  action="/dgzf/customerpassword/save.html" name="customerForm" id="customerForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${accountinfo.id }"/>
		<input type="hidden" name="orginzjpwd" id="orginzjpwd" value="${accountinfo.zjpassword }"/>
		<input type="hidden" name="orginjypwd" id="orginjypwd" value="${accountinfo.jypassword }"/>
<table width="700" border="0" cellpadding="10px">
  <tbody>
     <tr><td></td><td align="left" style="color: red">设置6位新密码，只允许输入0-9</td></tr>
     <tr>
      <td align="right" valign="middle">密码类型</td>
      <td align="left" valign="middle">
      <select name="pwdtype" id="pwdtype" onchange="javascript:cleardata()" >
							<option value="">请选择</option>
							<option value="资金密码">资金密码</option>
							<option value="交易密码">交易密码</option>
						</select></td>
    </tr>
     <tr>
      <td align="right" valign="middle">原密码</td>
      <td  align="left" valign="middle">
      <input type="password" name="orginpassword" id="orginpassword"  value="" onblur=""/>
      </td>
     </tr>
     <tr>
      <td align="right" valign="middle">新密码</td>
      <td  align="left" valign="middle">
      <input type="password" name="password" id="password"  value="" onblur=""/>
      </td>
     </tr>
    <tr>
      <td align="right" valign="middle">确认密码</td>
      <td  align="left" valign="middle">
      <input type="password" name="chkpwd" id="chkpwd"  value="" onblur=""/>
      </td>
    </tr>
    <tr>
    <td></td>
    <td align="left"><input type="button" name="savebtn" id="savebtn" value="保存" onclick="javascript:saveaction()"/></td>
    </tr>
  </tbody>
</table>
</form>
    
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			/* dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#customerForm").submit();
			}); */			
		});
		
		function cleardata(){
		   $("#orginpassword").val("");
		   $("#password").val("");
		   $("#chkpwd").val("");
		}
		
		function saveaction(){
		   $("#customerForm").submit();
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
		  var options=$("#pwdtype option:selected");
			if($("#pwdtype").val()==""){
				alert("请选择密码类型!");
				$("#pwdtype").focus();
				return false;
			}
			if($("#orginpassword").val()==""){//新增
				alert("请输入原密码!");
				$("#orginpassword").focus();
				return false;
			}
			
			if($("#orginpassword").val()!=""){
			   var pwdtype = $("#pwdtype").val();
			   if("资金密码" == pwdtype){
			      if($("#orginzjpwd").val()!=$("#orginpassword").val()){
				   alert("原密码错误!");
				   $("#orginpassword").focus();
				   return false;
			        } 
			   }
			   
			     if("交易密码" == pwdtype){
			      if($("#orginjypwd").val()!=$("#orginpassword").val()){
				   alert("原密码错误!");
				   $("#orginpassword").focus();
				   return false;
			        } 
			   } 
			}else{
				alert("请输入原密码!");
				$("#orginpassword").focus();
				return false;
			}
			
			if($("#password").val()==""){//新增
				alert("请输入密码!");
				$("#password").focus();
				return false;
			}
			
			if($("#password").val()!=$("#chkpwd").val()){
				alert("请确认新密码!");
				$("#password").focus();
				return false;
			}
		    alert("保存成功");
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