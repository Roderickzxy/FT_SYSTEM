<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务信息</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:95px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="save.html" name="customerpropertyForm" id="customerpropertyForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${customerproperty.id }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>参数:</th>
			<td>
			<input type="text" name="fittype" id="fittype" class="input_txt" value="${customerproperty.fittype }"/>
			</td>
		</tr>
		<!-- <tr class="info">
			<th></th>
			<td> --><input type="hidden" name="code" id="code" class="input_txt" value="${customerproperty.code }"/><!-- </td>
		</tr> -->
		<tr class="info">
			<th>设置值:</th>
			<td>	<select name="name" id="name" class="input_txt">
				<option value="">请选择</option>
				<c:choose>
					<c:when test="${customerproperty.fittype =='成本价类型'}">
					<option value="摊薄持仓成本">摊薄持仓成本</option>
				<option value="买入均价">买入均价</option>
				<option value="持仓成本">持仓成本</option>
				<option value="保本价">保本价</option>
					</c:when>
					<c:otherwise>
					 <option value="接收">接收</option>
				       <option value="不接收">不接收</option>
				   </c:otherwise>
					</c:choose>
				
			</select>
           </td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			$("#fittype").attr("readonly","readonly");
			$("#fittype").css("color","gray");
			dg.addBtn('ok','保存',function(){
				$("#customerpropertyForm").submit();
			});
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
		
		function checkInfo(){
			var options=$("#name option:selected");
			if($("#name").val()==""){
				alert("请选择设置值!");
				$("#name").focus();
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
		}
		
		/*
		function failed(){
			alert("新增失败，该用户名已存在！");
			$("#loginname").select();
			$("#loginname").focus();
		}
		*/
	</script>
</body>
</html>